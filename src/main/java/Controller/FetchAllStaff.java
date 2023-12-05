package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Staff;

@WebServlet("/Approvestaff")
public class FetchAllStaff extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyDao dao = new MyDao();
		List<Staff> list = dao.fetchallStaff();
		if (list.isEmpty()) {
        resp.getWriter().print("<html><head><body><h6 style='color:red'>Staff Has Not Signed Up Yet</h6><center></center></body></head></html>");
        req.getRequestDispatcher("AdminHome.html").include(req, resp);
		}else{
			req.setAttribute("list", list);
			req.getRequestDispatcher("Approvestaff.jsp").forward(req, resp);
		}
	}
}
