package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Doctor;

@WebServlet("/changedoctorstatus")
public class changedoctorstatus extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MyDao dao = new MyDao();
		Doctor doctor = dao.fetchdoctor(id);
		if (doctor.isSTATUS()) {
			doctor.setSTATUS(false);
		} else {
			doctor.setSTATUS(true);
		}
		dao.update(doctor);
		resp.getWriter().print("<h1><center>Status Updated</center></h1>");
		req.setAttribute("list", dao.fetchallDoctor());
		req.getRequestDispatcher("Approvedoctor.jsp").include(req, resp);
	}
}
