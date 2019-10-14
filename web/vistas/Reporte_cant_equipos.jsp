<%-- 
    Document   : VacasListado
    Created on : 17/01/2019, 07:49:43 AM
    Author     : Silvio Bigotto
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Vacas</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_reporte_cant_equipos.css">
</head>
<body>
           <%@include file="menuser.jsp" %>
	<div class="jumbotron">
            <div class="container">
                <h1>Cantidad total de equipos</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de equipos por decanato y por unidad</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="form-group">
    <div class="row">
        <div class="col-md-4"> 
        <form action="Controlador_reportes" method="post">
                <input class="form-control" type="text" name="txtBuscar" placeholder="Buscar Equipos (Decanato o Unidad)">
        </div>  
        <div class="col-md-3">
            <button class="btn btn-primary my-6 my-sm-0" value="Buscar" name="accion" type="submit">Buscar</button>
        </div>
        </form>
        
        </div>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Equipos</h3>
        <br>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Decanato</th>
                    <th scope="col">Unidad</th>
                    <th scope="col">Cantidad de Equipos</th>
		</tr>
                <%
                    ArrayList listadoVacas = (ArrayList)request.getAttribute("vacas");
                    if (listadoVacas != null)
			{
			 if (listadoVacas.size() > 0)
			 {	 
				for (int i = 0; i < listadoVacas.size(); i++) 
				{
					Animal animal = (Animal) listadoVacas.get(i);     
		 %>
            </thead>
            <tbody>
            <tr class="table-primary" align="center">
                <th scope="row"><%= animal.getId_animal()%></th>
                <td><%= animal.getNombre() %></td>
                <td><%= animal.getPrecio() %></td>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Vacas Registradas" />
		<%
			}
		}	
		%>
            </tbody>
        </table>
        </div>
            <%@include file="footer_admin.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>