package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Patient;

@WebServlet("/fetchallpatient")
public class FetchAllPatient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getSession().getAttribute("staff") == null) {
        req.getRequestDispatcher("Login.html").forward(req, res);
		}else{
			MyDao dao=new MyDao();
			List<Patient> list=dao.fetchallpatient();
			if(list.isEmpty()){
				res.getWriter().print("<h1 style='color:black'>No Patients Data Found</h1>");
				req.getRequestDispatcher("BookAppointment.jsp").include(req, res);
			}else{
				req.setAttribute("list", list);
				req.getRequestDispatcher("PatientList.jsp").forward(req, res);
			}
		}
	}
}
