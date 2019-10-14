<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Marcas</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_lista_marcas.css">
</head>
<body>
	
            <%@include file="menuser.jsp" %>
        
	<div class="jumbotron">
            <div class="container">
                <h1 style="color:  white">Listado de Marcas</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Marcas asi como las opciones de Edicion y Registro de Marcas.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="row">
        
     
        <br>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Marcas</h3>
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_marca?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
		</tr>
                <%
                    ArrayList listadoEnf = (ArrayList)request.getAttribute("enfermedades");
                    if (listadoEnf != null)
			{
			 if (listadoEnf.size() > 0)
			 {	 
				for (int i = 1; i < listadoEnf.size(); i++) 
				{
					Enfermedad enf = (Enfermedad) listadoEnf.get(i);    
		 %>
            </thead>
            <tbody>
            <tr class="table-primary" align="center">
                <th scope="row"><%= enf.getId_enf() %></th>
                <td><%= enf.getNombre() %></td>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="editar" href="Controlador_marca?accion=editar&id=<%= enf.getId_enf()%>"><img src="vistas/Imagenes/editar.png" alt="x" /> </a></td>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Enfermedad registradas" />
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
