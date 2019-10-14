<%-- 
    Document   : EditarFinca
    Created on : 12/02/2019, 10:55:21 AM
    Author     : Enderson
--%>

<%@page import="modelo.Enfermedad"%>
<%@page import="modelo.Raza"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Finca"%>
<%@page import="modelo.Dao_finca"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de Enfermedad</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilosEditar.css">
    </head>
    <body>
       <%@include file="menuser.jsp" %>
	<div class="jumbotron">
            <div class="conatiner">
                <h1 style="color:  white">Actualizacion de Enfermedad</h1>
                <p class="lead">Esta opcion del sistema le permite Actualizar los datos de las Enfermedades.</p>
            </div>		
	</div>
	
	
        <div class="card" style="max-width: 100%;">
        <%
            Enfermedad enf = (Enfermedad)request.getAttribute("enfermedad");
        %>
            <h3 class="card-header" align = "center" >Actualizacion de Enfermedades</h3>
            <form action="Controlador_enf" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-1">
                        <label for="nombre">Nombre</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" class="form-control" required name="nombre" id="descripcion" value="<%= enf.getNombre() %>"  placeholder="Nombre de la raza">
                        </div>
                        
                        <hr>                        		  
                        <input type="hidden" name="txtid" value="<%= enf.getId_enf() %>" >
                    </div>
                </div>
                <div class="row">
                    <div class="centrar">
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary">Actualizar</button>
                        
                    </div>
                </div>
            </form>

    </div>
	<%@include file="footer_admin.jsp" %>
	

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
    </body>
</html>
