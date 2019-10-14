<%-- 
    Document   : EditarFinca
    Created on : 12/02/2019, 10:55:21 AM
    Author     : Enderson
--%>

<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Finca"%>
<%@page import="modelo.Dao_finca"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de Fincas</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilosEditar.css">
    </head>
    <body>
       <% 
       Usuario u = (Usuario)request.getAttribute("usuario"); 
            if(u.getTipo().equals("administrador")){
       %>
       <%@include file="menuser.jsp" %>
       <% 
            }else{
       %>
       <%@include file="menuNav.jsp" %>
       <% 
            }
       %>
	<div class="jumbotron">
            <div class="conatiner">
                <h1 style="color:  white">Actualizacion de Finca</h1>
                <p class="lead">Esta opcion del sistema le permite Actualizar los datos de las Fincas.</p>
            </div>		
	</div>
	
	
        <div class="card" style="max-width: 100%;">
        <%
            Finca finca = (Finca)request.getAttribute("txtidfinca");
        %>
            <h3 class="card-header" align = "center" >Actualizacion de Fincas</h3>
            <form action="Controlador_finca" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-1">
                            <label for="nombre">Nombre:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="nombre" id="nombre" 
                            value="<%= finca.getNombre() %>" aria-describedby="emailHelp" 
                            placeholder="Nuevo nombre de la finca">
                        </div>    
                        <div class="col-md-1">
                            <label for="direccion">Direccion:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="text" class="form-control" required name="direccion" id="direccion" value="<%= finca.getDireccion() %>" aria-describedby="emailHelp" placeholder="Nueva direccion" >
                        </div>
                        <div class="col-md-1">
                            <label for="cant_hect">Cantidad de Hectareas:</label>
                        </div>
                        <div class="col-md-5">
                            <input type="number" class="form-control" required name="cant_hect" id="cant_hect" value="<%= finca.getCant_hect() %>" aria-describedby="emailHelp" placeholder="Hectareas">			    
                        </div>
                        <div class="col-md-1">
                            <label for="promedio_diario">Usuario Dueño:</label>
                        </div>
                        <div class="col-md-5">
                        <select class="form-control" name="nombre_usuario" id="nombre_usuario" disabled=true>
                                <option name ="<%=finca.getNombre_usuario().getNombre() %>" ><%=finca.getNombre_usuario().getNombre()%></option>
                        </select>			    
                    </div>
                        
                        <hr>                        		  
                        <input type="hidden" name="txtid" value="<%= finca.getId_finca() %>" >
                    </div>
                </div>
                <div class="row">
                    <div class="centrar">
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary">Actualizar</button>
                        
                    </div>
                </div>
            </form>

    </div>
       <% 
            if(u.getTipo().equals("administrador")){
       %>
            <%@include file="footer_admin.jsp" %>
       <% 
            }else{
       %>
            <%@include file="footer.jsp" %>
       <% 
            }
       %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
    </body>
</html>
