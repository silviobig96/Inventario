<%@page import="modelo.Usuario"%>
<%@page import="modelo.Enfermedad"%>
<%@page import="modelo.Raza"%>
<%@page import="modelo.Finca"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registro de Equipos</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_registro_equipos.css">

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
			<h1 style="color:  white">Registro de Equipos</h1>
			  <p class="lead">Esta opcion del sistema le permite Registrar los datos de los equipos de su unidad.</p>
		</div>
			
	</div>
	
	
        <div class="card" style="max-width: 100%;">
            <h3 class="card-header" align = "center" >Registro de Equipos</h3>
            <form action="Controlador_Equipos" method="post">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-1">
                        <label for="nombre">Descripcion:</label>
                    </div>
                    <div class="col-md-6">
                        <input type="text" class="form-control" required name="nombre" id="nombre"  placeholder="Descripcion del Equipo">
                    </div>

                    <div class="col-md-1">
                        <label for="precio">Modelo:</label>
                    </div>
                    <div class="col-md-4">
                        <input type="text" class="form-control" required name="nombre" id="nombre"  placeholder="Modelo del Equipo que en la etiqueta">
                    </div>
                    <div class="col-md-1">
                        <label for="raza">Seleccione la marca:</label>
                    </div>
                    <div class="col-md-6">
                        <select class="form-control" name="raza" id="raza">
                            <option selected>Apple</option>
                        <%
                            ArrayList lista_raza = (ArrayList)request.getAttribute("razas");
                            for(int i =0;i<lista_raza.size();i++){	
                            Raza raza = (Raza) lista_raza.get(i);
                        %>
                                            <option name ="<%=raza.getNombre() %>" ><%=raza.getNombre()%></option>
                        <%          
                            }//fin del for	
                        %>
                        </select>
                    </div>
                    </div>
                </div>
                <div class="row">
                   <div class="form-group">
                   <div class="centrar">
                       <button type="submit" name="accion" value="Aceptar" onclick=" alert('Equipo Registrado con exito!')" class="btn btn-primary">Aceptar</button>
                   </div>
                   </div>
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