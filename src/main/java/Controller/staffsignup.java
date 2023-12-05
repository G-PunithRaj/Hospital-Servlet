package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Staff;

@WebServlet("/staffsignup")
public class staffsignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MyDao dao=new MyDao();
		
		String name = req.getParameter("name");
		long mobile =Long.parseLong(req.getParameter("mobile"));
		String gmail = req.getParameter("gmail");
		String password = req.getParameter("password");
		Date dob = Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		
		 int age=LocalDate.now().getYear()-dob.toLocalDate().getYear(); //method 1, to overcome the drawback we go for second method 
//		 int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears(); //method 2 inbuilt method called "Period" 

		if(dao.fetchstaff(mobile)==null && dao.fetchstaff(gmail)==null && dao.fetchdoctor(mobile) == null && dao.fetchdoctor(gmail) == null){
			Staff staff = new Staff();
			staff.setNAME(name);
			staff.setMOBILE(mobile);
			staff.setGMAIL(gmail);
			staff.setPASSWORD(password);
			staff.setDOB(dob);
			staff.setGENDER(gender);
			staff.setAGE(age);
			
			dao.Savestaff(staff);
			
			resp.getWriter().print("<html><head><center><h3 style='color:green'>Staff Account Created Successfully</h3></center></head></html>");
			resp.getWriter().print("<html><head><center><h3 style='color:Blue'>Wait For Admin Approval</h3></center></head></html>");
			resp.getWriter().print("<html><head><center><h3 style='color:White'>Your Staff ID : " +staff.getID()+"</h3></center></head></html>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}else{
			resp.getWriter().print("<html><head><center><h6 style='color:Red'>Mobile Number / Gmail Already Exist</h6></center></head></html>");
			req.getRequestDispatcher("Staffsignup.html").include(req, resp);
		}
		
	}
}
