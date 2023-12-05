package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Doctor;
@WebServlet("/changeavailable")
public class ChangeDoctorAvailablity extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Doctor doctor = (Doctor) req.getSession().getAttribute("doctor");
		Doctor doc=(Doctor)req.getSession().getAttribute("doctor");
		System.out.println(doc);
		MyDao dao = new MyDao();
		if (doc == null) {
			resp.getWriter().print("<h1><center>Null </center></h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (doc.isAVAILABLITY()) {
				doc.setAVAILABLITY(false);
				dao.update(doc);
				req.getSession().setAttribute("doctor", doc);
				resp.getWriter().print("<h1><center>Changed to Not Available </center></h1>");
				req.getRequestDispatcher("Doctorpage.html").include(req, resp);
			}else{
				doc.setAVAILABLITY(true);
				dao.update(doc);
				req.getSession().setAttribute("doctor", doc);
				resp.getWriter().print("<h1><center>Changed to Available </center></h1>");
				req.getRequestDispatcher("Doctorpage.html").include(req, resp);
			}
		}
	}
}
