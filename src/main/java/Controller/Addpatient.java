package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.MyDao;
import Dto.Patient;
@MultipartConfig
@WebServlet("/addpatient")
public class Addpatient extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Part picture = req.getPart("picture");
		byte[] image = new byte[picture.getInputStream().available()];
		picture.getInputStream().read(image);

		Patient patient = new Patient();
		patient.setNAME(name);
		patient.setMOBILE(mobile);
		patient.setDob(dob);
		patient.setAge(age);
		patient.setPicture(image);

		MyDao dao = new MyDao();
		dao.Savepatient(patient);
        req.getRequestDispatcher("Staffpage.html").forward(req, resp);
	}
}
