package Admin.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;

@WebServlet(urlPatterns = {"/admin-users"})
public class aUsersController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9115989432331648648L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servlet = req.getServletPath();
		switch (servlet) {
		case "/admin-users":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					getAllUsers(req, resp);
					req.getRequestDispatcher("/views/admin/body/AdminUsers.jsp").forward(req, resp);
				}
			
			break;

		default:
			break;
		}
	}
	private void getAllUsers(HttpServletRequest req, HttpServletResponse resp) {
		List<User> arrUsers = new UserDao().getAllUsers();
		req.setAttribute("listUser", arrUsers);

	}
}
