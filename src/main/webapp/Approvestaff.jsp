<%@page import="Dto.Staff"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Staff</title>
<style>
	body{
		margin:0;
        padding:0;
        font-family: sans-serif;
		background: linear-gradient(to right,#141e30, #243b55);
        /* background-image: url("C:/Users/Rocky/Downloads/hacker-3342696.jpg"); */
		background-repeat: no-repeat;
		background-size: 1600px 870px;
		background-position: center;
	}
</style>
</head>
<body>
	<%
		List<Staff> list = (List<Staff>) request.getAttribute("list");
	%>
<center>
	<table border="2px" cellpadding="5px" cellspacing="2px"
		style='background: linear-gradient(to right, pink, cyan);'>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MOBILE</th>
			<th>GMAIL</th>
			<th>AGE</th>
			<th>GENDER</th>
			<th>STATUS</th>
			<th>CHANGE STATUS</th>
		</tr>
		
		<%
				for (Staff lst : list) {
			%>
			<tr>
			<td><%=lst.getID()%></td>
			<td><%=lst.getNAME()%></td>
			<td><%=lst.getMOBILE()%></td>
			<td><%=lst.getGMAIL()%></td>
			<td><%=lst.getAGE()%></td>
			<td><%=lst.getGENDER()%></td>
			<td><%=lst.isSTATUS() %></td>
			<td><a href="changestaffstatus?id=<%=lst.getID()%>"><button>CHANGE STATUS</button></a></td>
			</tr>	
			<%
				}
			%>
			<tr><a href="Login.html"><button>Home</button></a></tr>
		
    </table>
</center>    
</body>
</html>