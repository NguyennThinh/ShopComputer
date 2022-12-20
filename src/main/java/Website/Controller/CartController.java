package Website.Controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
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
import Model.BillDetail;
import Model.CartDetail;
import Model.Category;
import Model.JoinCartDeatil;
import Model.Product;
import Model.ProductDetail;
import Model.Supplier;

@WebServlet(urlPatterns = {"/cart","/delete-cart"})
public class CartController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 528069676188540175L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/cart":
			try {
				getCartDetail(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete-cart":
			delete(req, resp);
			break;
			
		default:
			break;
		}
		
	}
	

	
	//Laays danh sacsh giỏ hàng
	public void getCartDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		HttpSession session = req.getSession();
		String cartID = (String) session.getAttribute("cartID");
		long price =0;
		long sale = 0;
		long total= 0;
		if(cartID ==null) {
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		}else {
			List<JoinCartDeatil> listCart = new CartDao().getCartDetail(cartID);
			for(JoinCartDeatil j : listCart) {
				price += (long) formatter.parse(j.getPrice());
			
				total += (long)formatter.parse(j.getTotal());
			}
			sale = price-total;
		double VAT = total*10/100;
		double billmoney = total+VAT+50000;
			req.setAttribute("price", formatter.format(price));
			req.setAttribute("sale", formatter.format(sale));
			req.setAttribute("total", formatter.format(total));
			req.setAttribute("ship", formatter.format(50000));
			req.setAttribute("VAT", formatter.format(VAT));
			req.setAttribute("bill", formatter.format(billmoney));
			req.setAttribute("listCart", listCart);
			req.setAttribute("cartsize", listCart.size());
			req.setAttribute("bill", formatter.format(billmoney));
			req.setAttribute("CartHeader", listCart);
			getCategory_Supplier(req, resp);
			req.getRequestDispatcher("/views/web/body/shop-cart.jsp").forward(req, resp);
		}
	}
	
//Xóa cart
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		new CartDao().deleteone(cid);
		req.getRequestDispatcher("/views/web/body/shop-cart.jsp").forward(req, resp);
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
		
		
	
	public String autoId() {
		String uuid = UUID.randomUUID().toString();
       
		return uuid;
	}
}
