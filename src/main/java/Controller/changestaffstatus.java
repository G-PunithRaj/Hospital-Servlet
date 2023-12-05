package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Staff;

@WebServlet("/changestaffstatus")
public class changestaffstatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MyDao dao = new MyDao();
		Staff staff = dao.fetchstaff(id);
		if (staff.isSTATUS()) {
			staff.setSTATUS(false);
		} else {
			staff.setSTATUS(true);
		}
		dao.update(staff);
		resp.getWriter().print("<h1><center>Status Updated</center></h1>");
		req.setAttribute("list", dao.fetchallStaff());
		req.getRequestDispatcher("Approvestaff.jsp").include(req, resp);
	}
}
