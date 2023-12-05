package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Doctor;

@WebServlet("/doctorsignup")
public class doctorsignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyDao dao = new MyDao();
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		String gmail = req.getParameter("gmail");
		String password = req.getParameter("password");
		Date dob = Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String qualification = req.getParameter("qualification");
		String specialization = req.getParameter("specialization");

		int age = LocalDate.now().getYear() - dob.toLocalDate().getYear();

		if (dao.fetchdoctor(mobile) == null && dao.fetchdoctor(gmail) == null && dao.fetchstaff(mobile) == null
				&& dao.fetchstaff(gmail) == null) {
			Doctor doctor = new Doctor();
			doctor.setNAME(name);
			doctor.setMOBILE(mobile);
			doctor.setGMAIL(gmail);
			doctor.setPASSWORD(password);
			doctor.setDOB(dob);
			doctor.setGENDER(gender);
			doctor.setQUALIFICATION(qualification);
			doctor.setSPECIALIZATION(specialization);
			doctor.setAGE(age);
            
			dao.SaveDoc(doctor);
			
			resp.getWriter().print("<html><head><center><h3 style='color:green'>Doctor Account Created Successfully</h3></center></head></html>");
			resp.getWriter().print("<html><head><center><h3 style='color:Blue'>Wait For Admin Approval</h3></center></head></html>");
			resp.getWriter().print("<html><head><center><h3 style='color:White'>Your Doctor ID : " +doctor.getID()+"</h3></center></head></html>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}else{
			resp.getWriter().print("<html><head><center><h6 style='color:Red'>Mobile Number / Gmail Already Exist</h6></center></head></html>");
			req.getRequestDispatcher("Doctorsignup.html").include(req, resp);
		}

	}
}
