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
        <link rel="stylesheet" href="vistas/css/estilosListadoVaca.css">
</head>
<body>
	
            <%@include file="menuNav.jsp" %>
        
	<div class="jumbotron">
            <div class="container">
                <h1>Listado de Vacas Registradas</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Vacas asi como las opciones de Edicion y Eliminacion.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="form-group">
    <div class="row">
        <div class="col-md-4"> 
        <form action="Controlador_Animal" method="post">
                <input class="form-control" type="text" name="txtBuscar" placeholder="Buscar vacas (Por nombre,por estado y raza)">
        </div>  
        <div class="col-md-3">
            <button class="btn btn-primary my-6 my-sm-0" value="Buscar" name="accion" type="submit">Buscar</button>
        </div>
        </form>
        
        </div>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Vacas</h3>
        <br>
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_Animal?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Promedio en Lts</th>
                    <th scope="col">Raza</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Finca</th>
                    <th scope="col">Accion</th>
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
                <td><%= animal.getPromedio() %></td>
                <td><%= animal.get_raza().getNombre() %></td>
                <td><%= animal.getEstado() %></td>
                <td><%= animal.getFinca().getNombre() %></td>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="editar" href="Controlador_Animal?accion=editar&id=<%= animal.getId_animal()%>"><img src="vistas/Imagenes/editar2.png" alt="x" /> </a>
                 <a class="btn btn-success" title="Vender" onclick="return confirm('Seguro que desea vender a <%= animal.getNombre()%> ?')" href="Controlador_Animal?accion=vender&id=<%= animal.getId_animal()%>"><img src="vistas/Imagenes/Vender.png" alt="x" /></a>
                 <a class="btn btn-danger" title="Eliminar" onclick="return confirm('Seguro que desea Eliminar a <%= animal.getNombre()%>?')"href="Controlador_Animal?accion=eliminar&id=<%= animal.getId_animal()%>"><img src="vistas/Imagenes/Eliminar.png" alt="x" /></a></td>
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
        <%@include file="footer.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>