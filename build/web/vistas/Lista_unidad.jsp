<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Unidades</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_lista_unidad.css">
</head>
<body>
	
            <%@include file="menuser.jsp" %>
        
	<div class="jumbotron">
            <div class="container">
                <h1 style="color:  white">Listado de Unidades Registradas</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Unidades asi como las opciones de Edicion, Eliminacion y Registro de Unidad.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="row">
        
     
        <br>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Unidades</h3>
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_unidad?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre del Decanato</th>
                    <th scope="col">Nombre de la Unidad</th>
                    <th scope="col">Estado</th>
		</tr>
                <%
                    ArrayList listadoRazas = (ArrayList)request.getAttribute("razas");
                    if (listadoRazas != null)
			{
			 if (listadoRazas.size() > 0)
			 {	 
				for (int i = 0; i < listadoRazas.size(); i++) 
				{
					Raza raza = (Raza) listadoRazas.get(i);    
		 %>
            </thead>
            <tbody>
            <tr class="table-primary" align="center">
                <th scope="row"><%= raza.getId_raza()%></th>
                <td><%= raza.getNombre() %></td>
                <td><%= raza.getNombre() %></td>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="editar" href="Controlador_unidad?accion=editar&id=<%= raza.getId_raza()%>"><img src="vistas/Imagenes/editar.png" alt="x" /></a>
                <a class="btn btn-danger" title="Eliminar" href=""><img src="vistas/Imagenes/Eliminar.png" alt="x" /></a></td>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen razas registradas" />
		<%
			}
		}//if (listaArticulos != null)	
		%>
            </tbody>
        </table>
 
	<%@include file="footer_admin.jsp" %>
    </div>

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>
