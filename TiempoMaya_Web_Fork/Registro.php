<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Registrarse</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link href="css/estiloRegistro.css" rel="stylesheet">
  <title>Registrarse</title>
</head>

<body>
  <?php include "BarradeNavegacion.php" ?>
  <section id="inicio">
    <div class="inicio-container">
      <div class="main-container">
        <div class="tab-content">
          <div id="signup">
            <h1>Registrate</h1>

            <form method="POST" action="./backend/Registrar.php">

              <div id="login-box">
                <div class="left">
                  <input type="text" name="nombres" placeholder="Nombres" required />
                  <input type="text" name="apellidos" placeholder="Apellidos" required />
                  <input type="text" name="usuario" placeholder="Nombre de Usuario" required />
                  <input type="text" name="email" placeholder="E-mail" required />
                  <div class="input-group">
                    <input type="password" id="pass" name="password" placeholder="Escribe un Password" class="form-control" required />
                    <span class="input-group-addon"></span>
                    <div style="width: 20%; height: 80%;">
                    <input type="button" onclick="verPassword()" class="btn btn-primary btn-sm" value="👁">
                    </div>
                  </div>

                  Fecha de Nacimiento
                  <input type="date" name="fechaNacimiento" id="fechaFin" class="form-control" value="<?php echo $hecho['fechaFinal']; ?>">
                  <input type="submit" name="signup_submit" value="Registrarme" required />
                </div>

                <div class="right">
                  <span class="loginwith">Descubre mas Sobre<br />el Maravilloso
                    <bt /> Mundo Maya</span>
                </div>
                <div class="or">➤</div>
              </div>
            </form>

          </div>
          </form>
        </div>
      </div>
  </section>
</body>
<script>
  function verPassword() {
    var x = document.getElementById("pass");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }
</script>