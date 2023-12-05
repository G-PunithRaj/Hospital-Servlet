package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectrole")
public class selectrole extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Role = req.getParameter("role");
		if (Role.equals("staff")) {
			System.out.println("Yess Im staff");
			req.getRequestDispatcher("Staffsignup.html").forward(req, resp);
		} else {
			System.out.println("Yess im doctor");
			req.getRequestDispatcher("Doctorsignup.html").forward(req, resp);
		}
	}
}
