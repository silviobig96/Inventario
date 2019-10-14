<%@page import="modelo.Animal"%>
<%@page import="modelo.Finca"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Solicitud de desincorporación de equipos dañados</title>
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="vistas/css/bootstrap.min.css">
    <link rel="stylesheet" href="vistas/css/estilos_desincorporacion.css">
</head>
<body>
	<%@include file="menuNav.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h1 style="color: white">Solicitud de desincorporación de equipos dañados</h1>
			  <p class="lead">En esta opcion del sistema le permite realizar una solicitud para desincorporar los equipos que estan dañado.</p>
		</div>
	</div>
	<section>
		<div class="card">
		<form action="Controlador_produccion" method="post">
			<div class="form-group">
				<div class="row">
					<div class="col-md-2">
                                            <label>Seleccione el equipo dañado que desea desincorporar:</label>
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
			</div>
	    	<div class="row">
			 	<div class="form-group">
			 		<div class="centrar">
				     	<button type="submit" name="accion" value="Aceptar" onclick=" alert('Produccion Registrada con exito!')" class="btn btn-lg btn-primary">Aceptar</button>
			     	</div>
			 	</div>
			 </div>
	
		</form>
	</div>
	</section>
	<%@include file="footer.jsp" %>
	<script src="vistas/js/jquery.js" ></script>
	<script src="vistas/js/bootstrap.min.js"></script>
</body>
</html>