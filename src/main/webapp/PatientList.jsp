<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="Dto.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient-List&#183;CMI-HOSPITAL</title>
<style>
	*{
    margin: 0;
    padding: 0;
}
	body{
		background: linear-gradient(to left,#77037B, #243b55);
	}
	th{
		color: white;
	}
	button{
		background:transparent;
		height: 5rem;
		width: 10rem;
		font-family: Verdana, Geneva, Tahoma, sans-serif;
		color: white;
		font-size: 15px;
		cursor: pointer;
	}
	button:hover{
		background: green;
	}
</style>
</head>
<body>
	<%
		List<Patient> list = (List<Patient>) request.getAttribute("list");
	%>
	<table border="1px"  cellpadding="5px" cellspacing="2px" 
		style='background:transparent; color: white;'>
		<tr>
			<th>ID</th>
			<th>PICTURE</th>
			<th>NAME</th>
			<th>MOBILE</th>
			<th>AGE</th>
			<th>BOOK APPOINTMENT</th>
		</tr>
		<%
			for (Patient patient : list) {
		%>
		<tr>
            <th><%=patient.getID() %></th>
			<th><% String base64=Base64.encodeBase64String(patient.getPicture()); %>
			 <img alt="unknown" height="90px" width="70px" src="data:image/jpeg;base64,<%=base64 %>"> 
			</th>
			<th><%=patient.getNAME() %></th>
			<th><%=patient.getMOBILE() %></th>
			<th><%=patient.getAge() %></th>
			<th><a href="Book.jsp?id=<%=patient.getID() %>"><button>Book Appointment</button></a></th>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>