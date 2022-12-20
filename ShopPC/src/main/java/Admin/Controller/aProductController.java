package Admin.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Dao.AccountDao;
import Dao.Category_SuplierDao;
import Dao.ProductDao;
import Model.Category;
import Model.Product;
import Model.ProductDetail;
import Model.Supplier;

@WebServlet(urlPatterns = { "/admin-product","/delete-product","/add-new-product","/product-detail"})
public class aProductController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3858692787050836773L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/admin-product":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					getListProduct(req, resp);
				}
			
			break;
		case "/delete-product":
			deleteProduct(req, resp);
			break;
		case "/add-new-product":
			addProduct(req, resp);
			break;
		case "/product-detail":
			getDetailProduct(req, resp);
			break;
		default:
			break;
		}
	}

	public void getListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> arrProduct = new ProductDao().getListProduct();
		List<Supplier> arrSuppliers = new Category_SuplierDao().getSupplier();
		List<Category> arrCategory = new Category_SuplierDao().getCategory();
		
		
		req.setAttribute("listProduct", arrProduct);
		req.setAttribute("listSupplier", arrSuppliers);
		req.setAttribute("listCategory", arrCategory);
		req.getRequestDispatcher("/views/admin/body/AdminProduct.jsp").forward(req, resp);

	}
	public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		int pid = Integer.parseInt(id);
		if(new ProductDao().deleteProduct(pid)) {
			req.setAttribute("succsess", "Xóa thành công");
			getListProduct(req, resp);
		}else {
		
			req.setAttribute("error", "Xóa không thành công");
			getListProduct(req, resp);
		}
	}
	private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = autoId();
		String pName = req.getParameter("nameproduct");
		String sale = req.getParameter("sale");
		String price = req.getParameter("price");
		String supplier = req.getParameter("supplier");
		String description = req.getParameter("description");
		String photo = req.getParameter("photo");
		int quantily = Integer.parseInt(req.getParameter("quantily"));
		String category = req.getParameter("category");
		String did = req.getParameter("did");
		String CPU = req.getParameter("CPU");
		String mainboard = req.getParameter("mainboard");
		String RAM = req.getParameter("RAM");
		String ROM = req.getParameter("ROM");
		String CARD = req.getParameter("CARD");
		String POWER = req.getParameter("POWER");
		String khung = req.getParameter("khung");
		String tannhiet = req.getParameter("tannhiet");
		ProductDetail pd = new ProductDetail(did, CPU, mainboard, RAM, ROM, CARD, POWER, khung, tannhiet);
		System.out.println(pd);
		if(new ProductDao().addDetail(pd)) {
			Product p = new Product( pName, sale, price, supplier, description, photo, quantily, 0, category,did, false);
			new ProductDao().addProduct(p);
	
			req.setAttribute("succsess", "Thêm sản phẩm thành công");
			getListProduct(req, resp);

		}else {
			req.setAttribute("error", "Thêm sản phẩm không thành công");
			getListProduct(req, resp);
		}
		
	}
	public void getDetailProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("idct");
		ProductDetail arrDetails = new ProductDao().getDetailbyId("PC GAMING HACOM LIAN-LI O11DX LIMITED");
		Gson gson = new Gson();
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(arrDetails));
	
	}
	public String autoId() {
		String uuid = UUID.randomUUID().toString();

		return uuid;
	}
}
