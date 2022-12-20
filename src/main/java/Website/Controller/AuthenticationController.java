package Website.Controller;

import java.io.IOException;
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

@WebServlet(urlPatterns = { "/login", "/logout", "/register" })
public class AuthenticationController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 479409262732048659L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String servletPath = req.getServletPath();
		
		switch (servletPath) {
		case "/login":
			Login(req, resp);
			break;
		case "/register":
			Register(req, resp);
			break;
		case "/logout":
			logout(req, resp);
			break;
	
		default:
			break;
		}
	}
	public void Login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		AccountDao aDao = new AccountDao();
		String Email = req.getParameter("email");//Lấy email từ iput email
		String Password = req.getParameter("password");//Lấy pass từ iput pass
		Account acc = aDao.CheckExitsLogin(Email, Password);
		
	
		
		if(acc != null) {
			User user = new UserDao().findUserbyIdAcc(acc.getId());
			Cart cart = new CartDao().findCart(user.getId());
			
			
			HttpSession session = req.getSession(false);
			session.setAttribute("accID", acc.getId());
			session.setAttribute("userID", user.getId());
			session.setAttribute("cartID", cart.getId());
			resp.sendRedirect("index");
		}else if(acc.isIs_delete() == true) {
			req.setAttribute("error", "Không tìm thấy tài khoản");
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		}else {
			req.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		}
	}
	public void Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idAccc = autoId();
		String idUser = autoId();
		String Email = req.getParameter("email");
		String Password = req.getParameter("password");
		String FullName = req.getParameter("fullname");
		String Phone = req.getParameter("phone");
		String Address = req.getParameter("address");
		if(Email == null|| FullName==null|| Phone ==null|| Address==null) {
			req.setAttribute("error", "Đăng ký tài khoản không được bỏ trống");
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		}else if(new AccountDao().CheckExitsRegister(Email)) {
			req.setAttribute("error", "Email này đã được đăng ký");
			req.getRequestDispatcher("/views/web/body/shop-login.jsp").forward(req, resp);
		}else {
			Account acc= new Account(idAccc, Email, Password, false, false);
			User user = new User(idUser, FullName, Address, Email, Phone, acc.getId(), false);
			Cart cart = new Cart(autoId(), user.getId());
			new AccountDao().Register(acc);
			new UserDao().insert(user);
			new CartDao().createCart(cart);
			resp.sendRedirect("login");
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null) {
			session.removeAttribute("accID");
			session.removeAttribute("userID");
			session.removeAttribute("cartID");

	
		}
		
		req.getRequestDispatcher("/views/web/body/shop-index.jsp").forward(req, resp);

	}
	public String autoId() {
		String uuid = UUID.randomUUID().toString();
       
		return uuid;
	}
}
