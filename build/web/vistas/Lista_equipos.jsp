
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Equipos</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_lista_equipos.css">
</head>
<body>
	
            <%@include file="menuNav.jsp" %>
        
	<div class="jumbotron">
            <div class="container">
                <h1>Listado de Equipos registrados</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Equipos de esta Unidad asi como las opciones de Edicion y Eliminacion.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="form-group">
    <div class="row">
        <div class="col-md-4"> 
        <form action="Controlador_Equipos" method="post">
                <input class="form-control" type="text" name="txtBuscar" placeholder="Buscar Equipos (Por nombre y por estado)">
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
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_Equipos?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Marca</th>
                    <th scope="col">Estado</th>
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
                <td><%= animal.get_raza().getNombre() %></td>
                <td><%= animal.getEstado() %></td>
                <td style=" padding-left: 2px; padding-right: 2px;"> 
                    <a class="btn btn-primary" title="editar" href="Controlador_Equipos?accion=editar&id=<%= animal.getId_animal()%>"><img src="vistas/Imagenes/editar.png" alt="x" /> </a>
                    <a class="btn btn-danger" title="Eliminar" onclick="return confirm('Seguro que desea colocar a <%= animal.getNombre()%> como equipo dañado?')"href="Controlador_Equipos?accion=eliminar&id=<%= animal.getId_animal() %>"><img src="vistas/Imagenes/dañado.png" alt="x" /></a>
                </td>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Equipos Registrados" />
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