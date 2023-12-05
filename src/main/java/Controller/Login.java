package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Doctor;
import Dto.Staff;

@WebServlet("/loginpage")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		MyDao dao = new MyDao();
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		Staff staff = dao.fetchstaff(id);
		Doctor doctor = dao.fetchdoctor(id);

		if (staff == null && doctor == null && id != 999999) {
			res.getWriter().print("<h1 style='color:red'>Incorrect Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, res);
		} else {
			if (staff != null) {
				if (staff.getID() == id && staff.getPASSWORD().equals(password)) {
					if (staff.isSTATUS()) {
						req.getSession().setAttribute("staff", staff);
						res.getWriter().print(
								"<html><head><body><h3 style='color:green'>Login Successful</h3></body></head></html>");
						req.getRequestDispatcher("Staffpage.html").forward(req, res);
					} else {
						res.getWriter().print(
								"<html><head><body><center><h3 style='color:red'>Wait For Admin Approval</h3></center></body></head></html>");
						req.getRequestDispatcher("Login.html").include(req, res);
					}
				} else {
					res.getWriter().print(
							"<html><head><body><center><h3 style='color:red'>Invalid Password</h3></center></body></head></html>");
					req.getRequestDispatcher("Login.html").include(req, res);
				}
			}
			if (doctor != null) {
				if (doctor.getID() == id && doctor.getPASSWORD().equals(password)) {
					if (doctor.isSTATUS()) {
						req.getSession().setAttribute("doctor", doctor);
						res.getWriter().print(
								"<html><head><body><h3 style='color:green'>Login Successful</h3></body></head></html>");
						req.getRequestDispatcher("Doctorpage.html").forward(req, res);
					} else {
						res.getWriter().print(
								"<html><head><body><center><h3 style='color:red'>Wait For Admin Approval</h3></center></body></head></html>");
						req.getRequestDispatcher("Login.html").include(req, res);
					}
				} else {
					res.getWriter().print(
							"<html><head><body><center><h3 style='color:red'>Invalid Password</h3></center></body></head></html>");
					req.getRequestDispatcher("Login.html").include(req, res);
				}
			}
			if(id==999999){
				if("999999".equals(password))
				{
					req.getSession().setAttribute("admin", "admin");
//					res.getWriter().print("<h1 style='color:green'>Login Success</h1>");
					req.getRequestDispatcher("AdminHome.html").include(req, res);
				}else{
					res.getWriter().print("<h1 style='color:red'>Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, res);
				}
			}
		}
	}
}
