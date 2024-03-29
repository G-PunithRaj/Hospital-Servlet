<%@page import="Dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Staff"%>
<%@page import="Dto.Patient"%>
<%@page import="Dao.MyDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book-Appointment</title>
</head>
<body>
	<%
		Staff staff = (Staff) session.getAttribute("staff");

		int pid = Integer.parseInt(request.getParameter("id"));
		MyDao dao = new MyDao();
		Patient patient = dao.fetchPatient(pid);
		if (patient == null) {
			response.getWriter().print("<h1 style='color:red'>Enter proper Patient Id</h1>");
			request.getRequestDispatcher("FetchByid.html").include(request, response);
		} else {
			List<Doctor> list = dao.fetchavailableDoctor();
			if (list.isEmpty()) {
				response.getWriter().print("<h1 style='color:red'>No Doctors are Available</h1>");
				request.getRequestDispatcher("StaffHome.html").include(request, response);
			} else {
	%>
	<form action="bookappointment" method="post">
		Patient Id: <input type="text" name="pid" value="<%=pid%>"
			readonly="readonly"><br> Patient Name: <input
			type="text" name="pname" value="<%=patient.getNAME()%>"
			readonly="readonly"><br> Staff Name: <input type="text"
			name="staffname" value="<%=staff.getNAME()%>" readonly="readonly"><br>
		Problem:<input type="text" name="problem"><br>
		SelectDoctor: <select name="doctor">
			<%
				for (Doctor doctor : list) {
			%>
			<option value="<%=doctor.getID()%>"><%=doctor.getNAME()%> (<%=doctor.getSPECIALIZATION()%>)
			</option>
			<%
				}
			%>
		</select> <br>
		<button>Fix Appointment</button>
		<button type="reset">Cancel</button>

	</form>
	<%
		}
	%>
	<a href="fetchallpatient"><button>Back</button></a>
	<%
		}
	%>
</body>
</html>