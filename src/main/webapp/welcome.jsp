<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<link rel="stylesheet" type="text/css" href="indexStyle.css">

</head>
<body>
<%
	HttpSession session1 = request.getSession(false);
	if(session1 != null && session1.getAttribute("username")!=null){
		String username = (String) session1.getAttribute("username");
	
%>
<div class="container">
	<h1>Welcome,<%= username %></h1>
	<h2>Hello, !!! </h2>
<h3>This project is to understand the concept pf JDBC along with servlet and Dynamic Web project</h3>
<p>Explore Learn and connect with like-minded peaople <p>
<p>Feel free to Login <span style="font-size:15px">&#128640;</span> or Register <span style="font-size:20px">&#128641;</span><p>
<p><a href="LogoutServlet">LOGOUT</a> securely.</p>
</div>
<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>