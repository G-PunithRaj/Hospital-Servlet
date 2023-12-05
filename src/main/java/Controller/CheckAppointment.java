package Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.MyDao;
import Dto.Appointment;

@WebServlet("/checkappointment")
public class CheckAppointment extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
        MyDao dao=new MyDao();
        Appointment appointment=dao.fetchappointment(id);
        appointment.setTime(LocalDateTime.now());
        dao.UpdateAppointment(appointment);
	}
}
