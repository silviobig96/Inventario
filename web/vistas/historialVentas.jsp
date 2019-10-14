<%-- 
    Document   : historialVentas
    Created on : 17/01/2019, 07:48:58 AM
    Author     : Silvio Bigotto
--%>

<%@page import="modelo.Animal"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Historial de Ventas</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilosHistVentas.css">
</head>
<body>
	 <%@include file="menuNav.jsp" %>
	<div class="jumbotron">
			<div class="container">
				<h1 style="color:  white">Historial de Ventas de Vacas Realizadas</h1>
				  <p class="lead">Esta opcion del sistema le permite visualizar el historial de las Ventas de Vacas.</p>
				  
			</div>
		</div>
		<div class="card" style="max-width: 100%;">
			<h3 class="card-header" align = "center"  >Historial de Ventas</h3>
	<table class="table table-hover">
	<thead>
		<tr>
		  <th scope="col">Codigo</th>
                  <th scope="col">Finca</th>
		  <th scope="col">Fecha de Realizacion</th>
		  <th scope="col">Nombre de la Vaca</th>
		  <th scope="col">Raza</th>
		  <th scope="col">Precio</th>
		</tr>
	</thead>
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
	<tbody>
	<tr class="table-primary">
	  <th scope="row"><%= animal.getId_animal()%></th>
          <td><%= animal.getFinca().getNombre() %></td>
	  <td><%= animal.getFecha_venta()%></td>
	  <td><%= animal.getNombre()%></td>
	  <td><%= animal.get_raza().getNombre()%></td>
	  <td><%= animal.getPrecio()%></td>
	</tr>
        <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Vacas vendidas" />
		<%
			}
		}	
		%>
	</tbody>
</table> 
</div>
	<%@include file="footer.jsp" %>

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>