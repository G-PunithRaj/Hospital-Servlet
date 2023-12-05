package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Appointment;
import Dto.Doctor;
import Dto.Patient;

@WebServlet("/bookappointment")
public class bookappointment extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
		int did = Integer.parseInt(req.getParameter("doctor"));
		String problem = req.getParameter("problem");
		MyDao dao = new MyDao();
		Doctor doctor = dao.fetchdoctor(did);
		Patient patient = dao.fetchPatient(pid);

		Appointment appointment = new Appointment();
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointment.setProblem(problem);

		List<Appointment> list1 = patient.getAppointments();
		if (list1 == null) {
			list1 = new ArrayList<Appointment>();
		}
		list1.add(appointment);
		patient.setAppointments(list1);

		List<Appointment> list2 = doctor.getAppointments();
		if (list2 == null) {
			list2 = new ArrayList<Appointment>();
		}

		list2.add(appointment);
		doctor.setAppointments(list2);
		
		
		dao.saveappointement(appointment);
        
		resp.getWriter().print("<h1>Appointment of " + patient.getNAME() + " is booked with " + doctor.getNAME()
				+ " for " + problem + "</h1>");
		req.getRequestDispatcher("StaffHome.html").include(req, resp);

	}
}
