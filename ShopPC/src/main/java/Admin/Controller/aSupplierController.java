package Admin.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Category_SuplierDao;
import Model.Category;
import Model.Supplier;

@WebServlet(urlPatterns = { "/admin-supplier", "/add-supplier", "/delete-supplier", "/update-supplier" })
public class aSupplierController extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = -8439385063746304049L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/admin-supplier":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					getAllSupplier(req, resp);
					req.getRequestDispatcher("/views/admin/body/AdminSupplier.jsp").forward(req, resp);
				}
			
		
			break;
		case "/add-supplier":
			addSupplier(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminSupplier.jsp").forward(req, resp);
			break;
		case "/delete-supplier":
			deleteSupplier(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminSupplier.jsp").forward(req, resp);
			break;
		case "/update-supplier":
			System.out.println(req.getParameter("sid"));
			req.getRequestDispatcher("/views/admin/body/AdminSupplier.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}

	public void getAllSupplier(HttpServletRequest req, HttpServletResponse resp) {
		List<Supplier> arrSupplier = new Category_SuplierDao().getSupplier();
		req.setAttribute("listSupplier", arrSupplier);

	}

	private void addSupplier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("sid");
		String name = req.getParameter("sname");

		if (new Category_SuplierDao().addSupplier(new Supplier(id, name))) {
			req.setAttribute("succsess", "Thêm nhà sản xuất thành công");
			getAllSupplier(req, resp);
		} else {
			req.setAttribute("error", "Thêm nhà sản xuất không thành công");
			getAllSupplier(req, resp);
		}

	}

	private void deleteSupplier(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("sid");
		if (new Category_SuplierDao().deleteSupplier(id)) {
			req.setAttribute("succsess", "Xóa nhà sản xuất thành công");
			getAllSupplier(req, resp);
		} else {
			req.setAttribute("error", "Xóa nhà sản xuất không thành công");
			getAllSupplier(req, resp);
		}
	}

}
