package Admin.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StatisticalDao;
import Model.StatisticalCustomer;
import Model.StatisticalProduct;
import Model.StatisticalUser;

@WebServlet(urlPatterns = { "/admin-index", "/admin-statistical", "/top-10-customer-month","/top-10-product-month" })
public class aIndexController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4883952135948776929L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String servletPath = req.getServletPath();
		switch (servletPath) {
		case "/admin-index":
			HttpSession session = req.getSession();
			String admin = (String) session.getAttribute("admin");
				if(admin == null) {
					req.getRequestDispatcher("/views/admin/body/AdminLogin.jsp").forward(req, resp);
				}else {
					req.getRequestDispatcher("/views/admin/body/AdminStatistical.jsp").forward(req, resp);
				}
			

			break;
		case "/admin-statistical":
			getTopCustomer(req, resp);
			getTopProduct(req, resp);
			getUsersBuy(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminStatistical.jsp").forward(req, resp);
			break;
		case "/top-10-customer-month":

			getTopCustomer(req, resp);
			getTopProduct(req, resp);
			getUsersBuy(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminStatistical.jsp").forward(req, resp);

			break;
		case "/top-10-product-month":

			getTopProduct(req, resp);
			getTopCustomer(req, resp);
			getUsersBuy(req, resp);
			req.getRequestDispatcher("/views/admin/body/AdminStatistical.jsp").forward(req, resp);
			break;
		}
	}

	public void getTopCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String month = req.getParameter("month-customer");	
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		if (month == null) {
			month = sdf.format(date);
		}
		List<StatisticalCustomer> arrStatistical = new ArrayList<StatisticalCustomer>();
		arrStatistical = new StatisticalDao().getCustomerinMonth(month);
		req.setAttribute("customer", arrStatistical);
		req.setAttribute("monthcustomer", month);

	}
	
	public void getTopProduct (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String month = req.getParameter("month-product");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		
		if (month == null) {
			month = sdf.format(date);
		}
	
		List<StatisticalProduct> arrStatistical = new ArrayList<StatisticalProduct>();
		arrStatistical = new StatisticalDao().getProductinMonth(month);
		req.setAttribute("product", arrStatistical);
		req.setAttribute("monthproduct", month);
	
	
	}
	public void getUsersBuy (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StatisticalUser> arrStatistical = new StatisticalDao().getUsersbuy();
		req.setAttribute("arrUsers", arrStatistical);
	}
	
}
