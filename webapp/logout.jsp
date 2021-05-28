<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	session.removeAttribute("valiedUser");
	session.invalidate();
	RequestDispatcher dispatcher = request.getRequestDispatcher("/");
	dispatcher.include(request, response);
	
	
	%>

</body>
</html>