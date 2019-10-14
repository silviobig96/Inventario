<%@page import="modelo.Usuario"%>
<%@page import="modelo.Animal"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Reporte de promedio de ganacia por vaca</title>
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
			<h1 class="titulo">Promedio de ganancia por vaca.</h1>
	 	 	<p class="lead">Este reporte le permite ingresar el codigo de la vaca y ver cual es el promedio de produccion en litros de leche ademas de imprimir en formato pdf.</p> 
		</div>
	</div>
	<div class="card">
		<form action="Controlador_reportes" method="post">
			<div class="row">
					<div class="col-md-2">
                                            <label>Seleccione el codigo de la vaca:</label>
                                        </div>
                                        <div class="col-md-4">
                                            <select class="form-control" name="vaca" id="finca">
                                            <%
                                                ArrayList lista_vacas = (ArrayList)request.getAttribute("vacas");
                                                for(int i =0;i<lista_vacas.size();i++){	
                                                Animal animal = (Animal) lista_vacas.get(i);
                                            %>
                                                                <option name ="<%=animal.getId_animal()%>" ><%=animal.getId_animal()%></option>
                                            <%          
                                                }//fin del for	
                                            %>
                                            </select>
                                        </div>
				</div>
			 <div class="row">
		 		<div class="centrar">
			     	<button type="submit" value="consultar_prom_vaca" name="accion" class="btn btn-primary">Consultar</button>
	    			<button type="button" class="btn btn-primary">Imprimir</button>
		     	</div>
			 </div> 
                    <br><br>
		</form>
			<br><br>
                        <%
                            Animal animal = (Animal)request.getAttribute("txtidVaca");
                        %>
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
				  <th scope="col">Codigo</th>
				  <th scope="col">Nombre</th>
				  <th scope="col">Promedio en ltrs</th>
				</tr>
			</thead>
			<tbody>
                            <% if(animal!=null){     %>
				<tr class="table-primary text-center">
				  <th scope="row"><%= animal.getId_animal() %></th>
				  <td><%= animal.getNombre() %></td>
				  <td><%= animal.getPromedio() %></td>  
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