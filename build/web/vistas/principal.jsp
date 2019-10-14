<%-- 
    Document   : principal
    Created on : 17/01/2019, 07:49:10 AM
    Author     : Silvio Bigotto
--%>

<%@page import="modelo.Finca"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Bienvenido</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estiloUsuario.css">
</head>
<body>
	<header>
            <%@include file="menuNav.jsp" %>
	</header>
        <div class="jumbotron">
            <div class="container">
                <h1 class="h-1" style="color: white" align="center" >Bienvenido</h1>
                <br>
                <br>
            </div>
        </div>
            <%@include file="footer.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>	
</body>
</html>
