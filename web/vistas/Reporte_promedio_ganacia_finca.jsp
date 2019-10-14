<%@page import="modelo.Usuario"%>
<%@page import="modelo.Finca"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Promedio de Produccion de la finca</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilosReportes.css">
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
		<div class="container">
			<h1 class="titulo">Promedio de Produccion.</h1>
	 	 	<p class="lead">Esta opcion del sistema le permite ver cuanto es la produccion promedio de la finca.</p> 
		</div>
	</div>
	<div class="card">
		<form action="Controlador_reportes" method="post">
			<div class="row">
				<div class="col-md-8">
				 	<label for="tipoR">Seleccione la finca:</label>
		    		
                                        <select class="form-control" name="finca" id="finca">
                                        <%
                                            ArrayList lista_fincas = (ArrayList)request.getAttribute("fincas");
                                            for(int i =0;i<lista_fincas.size();i++){	
                                            Finca finca = (Finca) lista_fincas.get(i);
                                        %>
                                            <option name ="<%=finca.getNombre()%>" ><%=finca.getNombre()%></option>
                                        <%          
                                            }//fin del for	
                                        %>
                                        </select>
				</div>	
	     	</div>
			 <div class="row">
		 		<div class="centrar">
			     	<button type="submit" value="consultar_prom_finca" name="accion" class="btn btn-primary">Consultar</button>
	    			<button type="button" class="btn btn-primary">Imprimir</button>
		     	</div>
			 </div> 
                    <br><br><br>
		</form>
			<br><br>
                        <%
                            Finca finca = (Finca)request.getAttribute("objfinca");
                        %>
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
				  <th scope="col">Finca</th>
				  <th scope="col">Promedio Total en ltrs de leche</th>
				  <th scope="col">Promedio Total en Bs</th>
				</tr>
			</thead>
			<tbody>
                            <% if(finca!=null){     %>
				<tr class="table-primary text-center">
				  <th scope="row"><%= finca.getNombre() %></th>
				  <td><%= finca.getPromedio_diario() %></td>
				  <td><%= finca.getPromedio_mensual() %></td>  
				</tr>
                            <%  }    %>
			</tbody>
	   </table> 
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