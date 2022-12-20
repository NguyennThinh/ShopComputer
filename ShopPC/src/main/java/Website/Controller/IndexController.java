package Website.Controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.Category_SuplierDao;
import Dao.ProductDao;
import Model.Category;
import Model.JoinCartDeatil;
import Model.Product;
import Model.ProductDetail;
import Model.Supplier;

@WebServlet(urlPatterns = { "/index", "/product","/search" })
public class IndexController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4349466209581609273L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/index":
			getProductSale(req, resp);

			break;
		case "/product":
			try {
				getProductByID(req, resp);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/search":
			Search(req, resp);
			break;
		default:
			break;
		}

	}

	// Lay top 10 san pham sale moi nhat hien thi len index
	public void getProductSale(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> arrProduct = new ProductDao().getProductSale();

		req.setAttribute("listProduct", arrProduct);
	
		getTop6Product(req, resp);
		getProductSell(req, resp);
		try {
			getCartDetail(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		getCategory_Supplier(req, resp);
		req.getRequestDispatcher("/views/web/body/shop-index.jsp").forward(req, resp);
	}

	// Lấy 6 sản phẩm mới nhát
	public void getTop6Product(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> arrProduct = new ProductDao().getTop6Product();

		req.setAttribute("list10Product", arrProduct);

	}

	// Laays 2 sản phẩm được bán nhiều nhất
	public void getProductSell(HttpServletRequest req, HttpServletResponse resp) {
		List<Product> arrProduct = new ProductDao().getProductSold();
		req.setAttribute("listSell", arrProduct);
	}

	// Chi tiet san pham
	public void getProductByID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		Product product = new ProductDao().findProductbyID(pid);
		ProductDetail pDetail = new ProductDao().getDetailbyId(product.getIdProductDetail());

		req.setAttribute("p", product);
		req.setAttribute("pdetail", pDetail);

		getCartDetail(req, resp);
		getCategory_Supplier(req, resp);
		req.getRequestDispatcher("/views/web/body/shop-item.jsp").forward(req, resp);
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

		
		double billmoney = total ;

		req.setAttribute("total", formatter.format(total));
		req.setAttribute("cartsize", listCart.size());
		req.setAttribute("bill", formatter.format(billmoney));
		req.setAttribute("listCart", listCart);
		req.setAttribute("CartHeader", listCart);
		

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
	//search sản phẩm
	public void Search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("search");
		ProductDao pDao = new ProductDao();
		List<Product> sProduct = pDao.searchProduct(fullName);
		req.setAttribute("cProduct", sProduct);
		
		getCategory_Supplier(req, resp);
		try {
			getCartDetail(req, resp);
		} catch ( ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/web/body/shop-product-list.jsp").forward(req, resp);
	}
}
