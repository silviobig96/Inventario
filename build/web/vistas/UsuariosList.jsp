<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.*,java.util.*"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>Listado de Usuarios</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_lista_usuarios.css">
</head>
<body>
	
            <%@include file="menuser.jsp" %>
        
	<div class="jumbotron">
            <div class="container">
                <h1 style="color:  white">Listado de Usuarios Registrados</h1>
                <p class="lead">Esta opcion del sistema le permite visualizar el listado de Usuarios asi como las opciones de Edicion y Eliminacion.</p>

            </div>
        </div>
	 
         
         
    <div class="card" style="max-width: 100%;">
    <div class="row">
       
     
        <br>
        </div>
        <br>
	<h3 class="card-header"  align = "center" >Listado de Usuarios</h3>
        <a style=" margin-left: 16px" class="btn btn-success" href="Controlador_usuario?accion=registrar">Registrar</a>
        <table class="table table-bordered">
            <thead>
		<tr class="text-center">
                    <th scope="col">Codigo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Telefono</th>   
                    <th scope="col">Decanato</th> 
                    <th scope="col">Unidad</th> 
                    <th scope="col">Tipo</th> 
                    <th scope="col">Estado</th>
		</tr>
                <%
                    //Dao_animal dao_animal = new Dao_animal();
                    //List<Animal>list=dao_animal.listar();
                    ArrayList listadoUsuarios = (ArrayList)request.getAttribute("usuarios");
                    if (listadoUsuarios != null)
			{
			 if (listadoUsuarios.size() > 0)
			 {	 
				for (int i = 0; i < listadoUsuarios.size(); i++) 
				{
					Usuario usuario = (Usuario) listadoUsuarios.get(i);
                   //Iterator<Animal>iter=list.iterator();
                   // Animal animal=null;
                   // while(iter.hasNext()){
                   //animal = iter.next();        
		 %>
            </thead>
            <tbody>
            <tr class="table-primary" align="center">
                <th scope="row"><%= usuario.getId_usuario()%></th>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getCorreo() %></td>
                <td><%= usuario.getContraseña() %></td>
                <td><%= usuario.getTelefono() %></td>
                <td><%= usuario.getTelefono() %></td>
                <td><%= usuario.getTelefono() %></td>
                <td><%= usuario.getTipo() %></td>
                <td><%= usuario.getEstado() %></td>
                <% if(usuario.getEstado().equals("activo")){
                    %>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="editar" href="Controlador_usuario?accion=editar&nombre=<%= usuario.getNombre() %>"><img src="vistas/Imagenes/editar.png" alt="x" /> </a>
                 <a class="btn btn-danger" title="Eliminar" onclick="return confirm('Seguro que desea Eliminar a <%= usuario.getNombre() %>?')" href="Controlador_usuario?accion=eliminar&id=<%= usuario.getId_usuario()%>"><img src="vistas/Imagenes/eliminar2.png" alt="x" /></a></td>
                <% }else{
                %>
                <td style=" padding-left: 2px; padding-right: 2px;"> <a class="btn btn-primary" title="reactivar" onclick="return confirm('Seguro que desea Reactivar a <%= usuario.getNombre() %>?')" href="Controlador_usuario?accion=reactivar&id=<%= usuario.getId_usuario() %>"> Reactivar </a></td>
                <% }
                %>
            </tr>
            <%
				}//for
			  }	//if (listaArticulos.size()>0)
			else
			{	
		%>
			<!--si no hay mensajes se envía al usuario a la página mensajes.jsp-->
			<jsp:forward page="paginamensaje.jsp?mensaje=No existen Usuarios Registrados" />
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
