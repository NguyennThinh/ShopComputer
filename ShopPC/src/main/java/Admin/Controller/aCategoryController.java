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

@WebServlet(urlPatterns = { "/admin-category","/add-category","/delete-category"})
public class aCategoryController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6514070910619895610L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/admin-category":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					getAllCategory(req, resp);
					req.getRequestDispatcher("/views/admin/body/AdminCategory.jsp").forward(req, resp);
				}
			
			break;
		case "/add-category":
			addCategory(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminCategory.jsp").forward(req, resp);
			break;
		case "/delete-category":
			deleteCategory(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminCategory.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
	public void getAllCategory(HttpServletRequest req, HttpServletResponse resp) {
		List<Category> arrCategory = new Category_SuplierDao().getCategory();
		req.setAttribute("listCategory", arrCategory);
	
	}
	private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("cid");
		String name = req.getParameter("cname");
		if(new Category_SuplierDao().addCategory(new Category(id, name))) {
			req.setAttribute("succsess", "Thêm loại sản phẩm thành công");
			getAllCategory(req, resp);
		}else {
			req.setAttribute("error", "Thêm loại sản phẩm không thành công");
			getAllCategory(req, resp);
		}

	}
	private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("cid");
		if (new Category_SuplierDao().deleteCategory(id)) {
			req.setAttribute("succsess", "Xóa loại sản phẩm thành công");
			getAllCategory(req, resp);
		} else {
			req.setAttribute("error", "Xóa loại sản phẩm không thành công");
			getAllCategory(req, resp);
		}
	}

}
