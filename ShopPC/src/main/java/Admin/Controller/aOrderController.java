package Admin.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Dao.CartDao;
import Model.Order;

@WebServlet(urlPatterns = { "/admin-order-page","/update-order-status","/update-order-payment" })
public class aOrderController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3600147178443880990L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servlet = req.getServletPath();
		switch (servlet) {
		case "/admin-order-page":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					requestOrderPage(req, resp);
				}
			
			break;
		case "/update-order-status":
			updateOrder(req, resp);
			break;
		case "/update-order-payment":
			updateStatus(req, resp);
			break;
		default:
			break;
		}
	}





	private void requestOrderPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Order> arrOrder = new CartDao().getAllOrder();
		List<String> arrStatus = new ArrayList<String>();
		arrStatus.add("Chờ giao hàng");
		arrStatus.add("Đang giao hàng");
		arrStatus.add("Đã giao hàng");
		List<String> arrPayment = new ArrayList<String>();
		arrPayment.add("Thanh toán khi nhận hàng");
		arrPayment.add("Đã thanh toán");
		
		req.setAttribute("status", arrStatus);
		req.setAttribute("payment", arrPayment);
		req.setAttribute("listOrder", arrOrder);

		req.getRequestDispatcher("/views/admin/body/AdminOrder.jsp").forward(req, resp);

	}
	private void updateOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String status = req.getParameter("status");
		String id = req.getParameter("oid");
		new CartDao().updateBillStatus(id, status);
		requestOrderPage(req, resp);
	}

	private void updateStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String payment = req.getParameter("payment");
		String id = req.getParameter("oid");
		new CartDao().updateBillPayment(id, payment);
		requestOrderPage(req, resp);
	}

}
