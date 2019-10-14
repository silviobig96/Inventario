<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mensajes</title>
</head>
<body>
	<center>
		<h2>
			<%=request.getParameter("mensaje")%>
		</h2>
		<br />
		<br /> <a href="javascript:history.back()">Volver </a>
	</center>
</body>
</html>