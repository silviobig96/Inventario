<%-- 
    Document   : login
    Created on : 17/01/2019, 07:47:02 AM
    Author     : Silvio Bigotto
--%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/estilosLogin.css">
  
</head>

<body id="LoginForm">
    <div class="container">
    <h1 class="form-heading">Formulario de ingreso</h1>
    <div class="login-form">
    <div class="main-div">
        <div class="panel">
       <h2> Login</h2>
       <p>Por favor introduce tu Usuario y contrasena</p>
       </div>
        <form id="Login" action="Controlador?operacion=login" method="post">

            <div class="form-group">
                <input type="text" class="form-control" id="inputEmail" placeholder="Usuario" name="Usuario">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" id="inputPassword" placeholder="Contrasena" name="Contrasena">
            </div>
            <div class="forgot">
              <a href="reset.html">Ha olvidado su contrasena?</a>
            </div>
            <button type="submit" class="btn btn-primary" name="btn_entrar" value="Enviar">Entrar</button>

        </form>
        </div>
    <p class="botto-text"> Designed by Sunil Rajput</p>
    </div>
    </div>
    </body>
</html>