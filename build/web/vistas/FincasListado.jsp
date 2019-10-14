<%-- 
    Document   : FincasListado
    Created on : 12/02/2019, 11:43:06 AM
    Author     : Enderson
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Fincas</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
</head>
<body background="vistas/Imagenes/VacasFondos.jpg" style="background-repeat: no-repeat; background-position: center center;">
	
            <%@include file="menuNav.jsp" %>
        
	<div class="jumbotron"  style="background-image:url('vistas/Imagenes/vacas2.jpg' )">
            <div class="container">
                <h1>Listado de Fincas Registradas</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Fincas asi como las opciones de Edicion y Eliminacion.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="row">
        <div class="col-md-8"> 
            <form class="">
                <input class="form-control " type="text" name="txtBuscar" placeholder="Buscar fincas">
                <div class="col-md-1">
                    <button class="btn btn-primary my-6 my-sm-0" type="submit">Buscar</button>
                </div>
            <br>
            </form>
        </div>
     
        <br>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Fincas</h3>
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_Animal?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Cant Hect</th>
                    <th scope="col">Promedio diario</th>
                    <th scope="col">Promedio mensual</th>                
		</tr>
                <%
                    //Dao_animal dao_animal = new Dao_animal();
                    //List<Animal>list=dao_animal.listar();
                    ArrayList listadoFincas = (ArrayList)request.getAttribute("fincas");
                    if (listadoFincas != null)
			{
			 if (listadoFincas.size() > 0)
			 {	 
				for (int i = 0; i < listadoFincas.size(); i++) 
				{
					Finca finca = (Finca) listadoFincas.get(i);
                   //Iterator<Animal>iter=list.iterator();
                   // Animal animal=null;
                   // while(iter.hasNext()){
                   //animal = iter.next();        
		 %>
            </thead>
            <tbody>
            <tr class="table-primary">
                <th scope="row"><%= finca.getId_finca()%></th>
                <td><%= finca.getNombre() %></td>
                <td><%= finca.getDireccion() %></td>
                <td><%= finca.getCant_hect() %></td>
                <td><%= finca.getPromedio_diario() %></td>
                <td><%= finca.getPromedio_mensual() %></td>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="Editar" href="Controlador_Animal?accion=editar&id=<%= finca.getId_finca()%>"><img src="vistas/Imagenes/editar2.png" alt="x" /> </a>
                 <a class="btn btn-danger" title="Eliminar" href="Controlador_Animal?accion=eliminar&id=<%= finca.getId_finca()%>"><img src="vistas/Imagenes/Eliminar.png" alt="x" /></a></td>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Fincas Registradas" />
		<%
			}
		}//if (listaArticulos != null)	
		%>
            </tbody>
        </table>
 
	<%@include file="footer.jsp" %>
    </div>

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>
