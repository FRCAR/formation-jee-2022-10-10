<%@ page language="java" contentType="text/html"%>
<%@ page import="java.text.*,java.util.*" %>
<html>
<head>
<title>Date JSP</title>
</head>
<% String message = "hello"; %>
<body>
<h1>Le nom du restaurant est  <%= MonDaoSingleton.getInstance().getRestaurant().getName() %> </h1>
</body>
</html>