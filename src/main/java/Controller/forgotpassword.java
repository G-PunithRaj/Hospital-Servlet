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

@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyDao dao = new MyDao();
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		String phnmail = req.getParameter("phnmail");
		System.out.println(phnmail);
		String Createpassword = req.getParameter("createpassword");
		System.out.println(Createpassword);

		Doctor doctor = dao.fetchdoctor(id);
		Staff staff = dao.fetchstaff(id);
		if (staff != null) {
			try {
				long mobile = Long.parseLong(phnmail);
				staff = dao.fetchstaff(mobile);
				System.out.println(staff);
				if (staff.getID() == id && staff.getMOBILE() == mobile) {
					staff.setPASSWORD(Createpassword);
					dao.update(staff);
					resp.getWriter().print(
							"<html><body><center><h3 style='color:green'>Password Changed Successfully</h3></center></html></body>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				} else {
					resp.getWriter().print(
							"<html><body><center><h3 style='color:red'>Invalid Details</center></h3></html></body>");
					req.getRequestDispatcher("Forgotpassword.html").include(req, resp);
				}
			} catch (NumberFormatException e) {
				staff = dao.fetchstaff(phnmail);
				System.out.println(staff);
				staff.setPASSWORD(Createpassword);
				dao.update(staff);
			}
		} else {
			if (doctor != null) {
				try {
					long mobile = Long.parseLong(phnmail);
					doctor = dao.fetchdoctor(mobile);
					System.out.println(doctor);
					if (doctor.getID() == id && doctor.getMOBILE() == mobile) {
						doctor.setPASSWORD(Createpassword);
						dao.update(doctor);
						resp.getWriter().print(
								"<html><body><center><h3 style='color:green'>Password Changed Successfully</h3></center></html></body>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					} else {
						resp.getWriter().print(
								"<html><body><center><h3 style='color:red'>Invalid Details</center></h3></html></body>");
						req.getRequestDispatcher("Forgotpassword.html").include(req, resp);
					}
				} catch (NumberFormatException e) {
					doctor = dao.fetchdoctor(phnmail);
					System.out.println(doctor);
					doctor.setPASSWORD(Createpassword);
					dao.update(doctor);
				}
			}
		}
	}
}
