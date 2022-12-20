package Website.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.Category_SuplierDao;
import Dao.ProductDao;
import Dao.UserDao;
import Model.BillDetail;
import Model.Category;
import Model.JoinCartDeatil;
import Model.Order;
import Model.Supplier;
import Model.User;

@WebServlet(urlPatterns = { "/checkout", "/checkout-page", "/order","/payment" })
public class CheckoutController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3011434260889684296L;
	List<JoinCartDeatil> arDetail = new ArrayList<JoinCartDeatil>();
	String[] idDetail = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/checkout-page":
			try {
				CheckoutPage(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/checkout":
			Checkout(req, resp);
			break;
		case "/order":
			try {
				getOrder(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		default:
			break;
		}

	}

	/**********************************
	 * Checkout Page
	 *****************************************/
	public void CheckoutPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {

		HttpSession session = req.getSession();
		String accid = (String) session.getAttribute("accID");
		User user = new UserDao().findUserbyIdAcc(accid);

		req.setAttribute("user", user);
	
		idDetail = req.getParameterValues("idDetail");
		try {
			getCartDetail(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (idDetail == null) {
			req.setAttribute("error", "Vui lòng chọn sản phẩm ");
			resp.sendRedirect("cart");

		} else {
			for (String s : idDetail) {

				JoinCartDeatil listCart = new CartDao().getListCheckout(s);
				arDetail.add(listCart);
				CreateBill(req, resp, s);

			}

			req.getRequestDispatcher("/views/web/body/shop-checkout.jsp").forward(req, resp);
		}

	}

	public void CreateBill(HttpServletRequest req, HttpServletResponse resp, String a) throws ParseException {
		DecimalFormat formatter = new DecimalFormat("###,###,###");

		long total = 0;

		for (JoinCartDeatil j : arDetail) {

			total += (long) formatter.parse(j.getTotal());
		}

		double ship = 50000;
		double VAT = total * 10 / 100;
		double money = total + ship + VAT;
		req.setAttribute("total", formatter.format(total));
		req.setAttribute("ship", formatter.format(ship));
		req.setAttribute("VAT", formatter.format(VAT));
		req.setAttribute("money", formatter.format(money));
		req.setAttribute("listDetail", arDetail);

	}

	/*******************************************
	 * Checkout
	 * 
	 * @throws IOException
	 ****************************************/
	public void Checkout(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		String accid = (String) session.getAttribute("accID");
		User user = new UserDao().findUserbyIdAcc(accid);
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = new Date();
		String address = req.getParameter("address");
		Timestamp timestamp = new Timestamp(date.getTime());
		List<BillDetail> arrOrder = new ArrayList<BillDetail>();
		String  payment = req.getParameter("payment");

		if (payment.equals("1")) {
			for (JoinCartDeatil j : arDetail) {

				arrOrder.add(new BillDetail(autoId(), j.getIdProduct(), j.getQuantily(), j.getTotal(), timestamp,
						"Chờ giao hàng", address, "Thanh toán khi nhận hàng", user.getId()));

			}
		} else {
			for (JoinCartDeatil j : arDetail) {

				arrOrder.add(new BillDetail(autoId(), j.getIdProduct(), j.getQuantily(), j.getTotal(), timestamp,
						"Chờ giao hàng", address, "Đã thanh toán", user.getId()));

			}
		}

		new CartDao().Checkout(arrOrder);
		new CartDao().delete(idDetail);
		new ProductDao().updateProductafterSale(arDetail);
		resp.sendRedirect("index");
	}

	/********************************
	 * Danh sach đơn hàng của user
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * @throws ParseException
	 ***************************************/
	public void getOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		DecimalFormat formatter = new DecimalFormat("###,###,###");

		HttpSession session = req.getSession();
		String uID = (String) session.getAttribute("userID");
		List<Order> arrOrder = new ArrayList<Order>();
		List<String> arrDate = new CartDao().getDateOrder(uID);

		for (String d : arrDate) {
			arrOrder = new CartDao().getOrder(uID, d);
		}
		getCartDetail(req, resp);
		getCategory_Supplier(req, resp);
		req.setAttribute("order", arrOrder);
		req.setAttribute("date", arrDate);
		req.getRequestDispatcher("/views/web/body/shop-order.jsp").forward(req, resp);
	}

	public String autoId() {
		String uuid = UUID.randomUUID().toString();

		return uuid;
	}

	// View cart tại header
	public void getCartDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, ParseException {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		HttpSession session = req.getSession();
		String cartID = (String) session.getAttribute("cartID");
		long total = 0;
		List<JoinCartDeatil> listCart = new CartDao().getCartDetail(cartID);
		for (JoinCartDeatil j : listCart) {

			total += (long) formatter.parse(j.getTotal());
		}
	
		double billmoney = total;
		req.setAttribute("CartHeader", listCart);
		req.setAttribute("cartsize", listCart.size());
		req.setAttribute("bill", formatter.format(billmoney));

	}
	//Lấy dữ liệu lên menubar
	public void getCategory_Supplier(HttpServletRequest req, HttpServletResponse resp) {
		List<Category> arrCategory = new Category_SuplierDao().getCategory();
		req.setAttribute("category", arrCategory);
		List<Supplier> arrSupplier = new Category_SuplierDao().getSupplier();
		req.setAttribute("supplier", arrSupplier);
		List<Category> listCategory = new Category_SuplierDao().getCategory();
		req.setAttribute("lcategory", listCategory);
		
	}

}
