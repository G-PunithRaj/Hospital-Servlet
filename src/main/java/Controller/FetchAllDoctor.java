package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Doctor;

@WebServlet("/Approvedoctor")
public class FetchAllDoctor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyDao dao = new MyDao();
		List<Doctor> list = dao.fetchallDoctor();
		if (list.isEmpty()) {
			resp.getWriter().print("<html><head><body><h6 style='color:red'>Doctor Has Not Signed Up Yet</h6><center></center></body></head></html>");
			req.getRequestDispatcher("AdminHome.html").include(req, resp);
		} else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("Approvedoctor.jsp").forward(req, resp);
		}
	}
}
