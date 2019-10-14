<%@page import="modelo.Enfermedad"%>
<%@page import="modelo.Raza"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Animal"%>
<%@page import="modelo.Dao_animal"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion de Equipo</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
        <link rel="stylesheet" href="vistas/css/estilos_editar_equipo.css">
    </head>
    <body>
       <%@include file="menuNav.jsp" %>
	<div class="jumbotron">
            <div class="conatiner">
                <h1 style="color:  white">Actualizacion de Equipo</h1>
                <p class="lead">Esta opcion del sistema le permite Actualizar los datos de los equipos.</p>
            </div>		
	</div>
	
	
        <div class="card" style="max-width: 100%;">
        <%
            Animal animal = (Animal)request.getAttribute("txtidVaca");
        %>
            <h3 class="card-header" align = "center" >Actualizacion de Equipo</h3>
            <form action="Controlador_Equipos" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-1">
                            <label for="nombre">Descripcion:</label>
                        </div>
                        <div class="col-md-6">
                            <input type="text" required class="form-control" name="nombre" id="nombre" 
                            value="<%= animal.getNombre() %>" aria-describedby="emailHelp" 
                            placeholder="Descripcion del equipo">
                        </div>    
                        <div class="col-md-1">
                            <label for="precio">Modelo:</label>
                        </div>
                        <div class="col-md-4">
                            <input type="text" required class="form-control" name="Modelo del equipo" id="precio" value="<%= animal.getPrecio() %>" aria-describedby="emailHelp" placeholder="Precio de Venta" >
                        </div>
                        <div class="col-md-1">
                            <label for="raza">Seleccione la marca:</label>
                        </div>
                        <div class="col-md-6">
                            <select class="form-control" name="raza" id="raza">
                        <%
                            String seleccionado="";
                            ArrayList lista_raza = (ArrayList)request.getAttribute("razas");
                            for(int i =0;i<lista_raza.size();i++){	
                            Raza raza = (Raza) lista_raza.get(i);
                                if(animal.get_raza().getNombre().equals(raza.getNombre())){
                                    seleccionado="selected";
                                }else {
                                    seleccionado="";
                                }
                        %>
                                            <option name ="<%=raza.getNombre() %>" <%= seleccionado %>><%=raza.getNombre()%></option>
                        <%          
                            }//fin del for	
                        %>
                        </select>
                        </div>
                        </div>
                <div class="row">
                    <div class="centrar">
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-primary">Actualizar</button>
                        <a href="Controlador_Equipos?accion=listar"> <button type="button" class="btn btn-primary"  >Volver</button><a/>
                    </div>
                </div>
            </form>

    
	<%@include file="footer.jsp" %>
	

	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
    </body>
</html>
