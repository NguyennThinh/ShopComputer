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
import Model.CartDetail;
import Model.Category;
import Model.JoinCartDeatil;
import Model.Product;
import Model.ProductDetail;
import Model.Supplier;

@WebServlet(urlPatterns = {"/list-product", "/add-cart"})
public class ProductController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6818017900741758170L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/list-product":
			try {
				getProductbyID(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/add-cart":
			try {
				addCart(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
	}
	//Thêm product vao giỏ hàng
	public void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		HttpSession session = req.getSession();
		String cartID = (String) session.getAttribute("cartID");
		int pid = Integer.parseInt(req.getParameter("pid"));
		int soluong = Integer.parseInt(req.getParameter("soluong"));

		Product p = new ProductDao().findProductbyID(pid);
		
		if(cartID ==null) {
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);

		}else if(soluong > p.getQuantily()) {
			req.setAttribute("error", "Số lượng trong kho chỉ còn: " + p.getQuantily() +" sản phẩm");
			redirect(req, resp);

		}	else {
			long total =  (long) formatter.parse(p.getTotal());
			double money = soluong * total;
			CartDetail cd = new CartDetail(autoId(), cartID, pid, p.getTotal(), soluong, formatter.format(money));
			new CartDao().addtoCart(cd);
			resp.sendRedirect("index");
		}
	}
	
	
	public void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException{
		String id = req.getParameter("pid");
		

		Product p = new ProductDao().findProductbyID(Integer.parseInt(id));
		ProductDetail pDetail = new ProductDao().getDetailbyId(p.getIdProductDetail());

		req.setAttribute("p", p);
		req.setAttribute("pdetail", pDetail);
		getCartDetail(req, resp);
		getCategory_Supplier(req, resp);
		req.getRequestDispatcher("/views/web/body/shop-item.jsp").forward(req, resp);
	}
	public void getProductbyID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		String cID = req.getParameter("category-id");

		ProductDao pDao = new ProductDao();

		//////Gui so trang san pham
		int total = pDao.totalProduct();
		int totalPage = total/9;
		if(total %9 !=0) {
			totalPage++;
		}
		req.setAttribute("totalPage", totalPage);
		String indexPage = req.getParameter("page");
		System.out.println(indexPage);
		System.out.println(cID);
		if(indexPage == null) {
			indexPage = "1";
		}
		int page = Integer.parseInt(indexPage);

		
		//Láy ds sản phẩm theo category
		List<Product> arrProduct = new ProductDao().getAllProductbyCategory(page, cID);
		req.setAttribute("cProduct", arrProduct);
		req.setAttribute("id", cID);
		getCartDetail(req, resp);
		getCategory_Supplier(req, resp);
		req.getRequestDispatcher("/views/web/body/shop-product-list.jsp").forward(req, resp);
	}
	//View cart tại header
		public void getCartDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
			DecimalFormat formatter = new DecimalFormat("###,###,###");
			HttpSession session = req.getSession();
			String cartID = (String) session.getAttribute("cartID");
			long total = 0;
				List<JoinCartDeatil> listCart = new CartDao().getCartDetail(cartID);
				for (JoinCartDeatil j : listCart) {
					

					total += (long) formatter.parse(j.getTotal());
				}
			
				double billmoney = total ;
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
		public String autoId() {
			String uuid = UUID.randomUUID().toString();
	       
			return uuid;
		}
}
