package Admin.Controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AccountDao;
import Dao.CartDao;
import Dao.UserDao;
import Model.Account;
import Model.Cart;
import Model.User;

@WebServlet(urlPatterns = {"/admin-login","/admin-account","/delete-account","/add-new-user","/admin-logout"})
public class aAuthenticationController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433316083076123652L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String servlet = req.getServletPath();
			switch (servlet) {
			case "/admin-account":
				getListAccount(req, resp);
				req.getRequestDispatcher("/views/admin/body/AdminAccount.jsp").forward(req, resp);
				break;
			case "/delete-account":
				deleteAccount(req, resp);
				req.getRequestDispatcher("/views/admin/body/AdminAccount.jsp").forward(req, resp);
				break;
			case "/add-new-user":
				addNewUsers(req, resp);
				req.getRequestDispatcher("/views/admin/body/AdminAccount.jsp").forward(req, resp);
				break;
			case "/admin-logout":
				logout(req, resp);
				
				break;	
			default:
				break;
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servlet = req.getServletPath();
		switch (servlet) {
		case "/admin-login":
			AdminLogin(req, resp);

			break;
			
		default:
			break;
		}
	}
	private void AdminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		AccountDao dao = new AccountDao();
		Account a = dao.CheckExitsLogin(email, pass);
		if(a == null) {
			req.setAttribute("error", "Không tìm thấy tài khoản");
			req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
		}else if(!a.isIs_admin()) {
			req.setAttribute("error", "Bạn không có quyền truy cập vào đây");
			req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
		}else {
			HttpSession session = req.getSession(false);
			session.setAttribute("admin", a.getId());
			resp.sendRedirect("admin-index");
		}
	}

	private void getListAccount(HttpServletRequest req, HttpServletResponse resp) {
			List<Account> arrAccount = new AccountDao().GetAllAccount();
			req.setAttribute("listAccount", arrAccount);
		
	}
	private void deleteAccount(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("aid");
		User user = new UserDao().findUserbyIdAcc(id);
		if(new AccountDao().Delete(id, user.getId())) {
			req.setAttribute("succsess", "Xóa thành công");
			getListAccount(req, resp);
		}else {
			getListAccount(req, resp);
			req.setAttribute("error", "Xóa không thành công");
		}
	}
	private void addNewUsers(HttpServletRequest req, HttpServletResponse resp) {
		String accID = autoId();
		String fullName = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String admin = req.getParameter("isAdmin");
	
		String uID = autoId();
		if(admin.equals("1")) {
			new AccountDao().Register(new Account(accID, email, password, true, false));
			new UserDao().insert(new User(uID, fullName, address, email, phone, accID, false));
			getListAccount(req, resp);
		}else {
			User user = new User(uID, fullName, address, email, phone, accID, false);
			Cart cart = new Cart(autoId(), user.getId());
			new AccountDao().Register(new Account(accID, email, password, false, false));
			new UserDao().insert(user);
			new CartDao().createCart(cart);
	
			getListAccount(req, resp);
		}
		
	}
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null) {
			session.removeAttribute("admin");
			req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
		}

	}
	public String autoId() {
		String uuid = UUID.randomUUID().toString();

		return uuid;
	}

}
