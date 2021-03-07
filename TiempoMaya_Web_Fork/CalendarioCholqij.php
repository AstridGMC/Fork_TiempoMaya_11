<?php
session_start();
if (isset($_POST['date'])) {
  $nivel;
  $query;
  include_once 'buscar/conseguir_nahual.php';
  include_once 'buscar/conseguir_energia.php';
  header("location: CalendarioCholqij.php" . "?nahual=" . $query . "&nivel=" . $nivel . "#" . $query);
}

//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sqlNahuales = "CALL mostrarNahuales";
$resultadoNahual = $conexion->query($sqlNahuales);
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sqlInfo = "CALL mostrarCalendarioCholquij";
$resultadoInfo = $conexion->query($sqlInfo);
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Tiempo Maya</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/Calendarios.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">


</head>

<body>
  <section id="inicio">
    <div class="inicio-container">

      <h1>Calendario Cholqij</h1>
      <a href="#information" class="btn-get-started">Descripcion</a>
      <a href="#sabernahual" class="btn-get-started">¿Que nahual cae en esta fecha?</a>
      <a href="#nahuales" class="btn-get-started">Nahuales</a>
      <a href="#portafolio" class="btn-get-started">Imagenes</a>

    </div>

  </section>

  <section id="information">

    <div class="container">
      <div class="section-header">
        <h3 class="section-title">Calendario Cholq'ij</h3>
      </div>
      <br>
      <?php
      foreach ($resultadoInfo as $info) : ?>
        <h3 class="section-title" style="  color: #2dc997;"><?php echo $info['titulo']; ?></h3>        
        <?php if ($info['imagen'] != null) { ?>
          <div class="row about-container">
          <div class="col-lg-6 content order-lg-1 order-2">
            <?php echo $info['descripcion']; ?>
          </div>
        <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight">
              <br>
              <img <?php echo 'src = "data:image/png;base64,' . base64_encode($info['imagen']) . '"' ?> width="80%" alt="Imagen del calendario habb" style="margin-left: 150px;">
            </div>
        <?php } else {?>
          <div class="row about-container">
          <?php echo $info['descripcion']; ?>
        <?php }?>
        </div>
       

      <?php endforeach; ?>

    <div>
      <h3 class="section-title" style="  color: #2dc997;">Nahuales</h3>
      <hr>
      <ul>
        <?php foreach ($resultadoNahual as $nahual) : ?>
          <li> <?php echo $nahual['nombre']; ?></li>
        <?php endforeach; ?>
      </ul>
      <p>Estos nahuales tienen <strong>13</strong> niveles de energía, por las 13 articulaciones que tiene el ser humano: </p>
    </div>
    <div class="wow fadeInLeft" style="text-align:center;">
      <br>
      <img src="img/articulacionesCholqij.png" width="40%" alt="Imagen de la interaccion del calendario habb y tzolkin">
    </div>
    </div>
  </section>
  <hr>
  <section id="sabernahual" style="padding-left: 20%; padding-right: 20%;">
    <div class="container">
      <div class="row about-container">
        <div class="col-lg-12 ">
          <div class="section-header">
            <h3 class="section-title" style="  color: #2dc997;">¿Que nahual caé en esta fecha?</h3>
          </div>
          <div class="container">
            <form method="POST" action="CalendarioCholqij.php">
              <div class="form-group mb-2">
                <label for="staticEmail2" class="sr-only text-dark">Ingresar fecha</label>
                <input type="date" class="form-control-plaintext text-dark border border-success" id="staticEmail2" name="date" required>
              </div>
              <div class="form-group mb-2">
                <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2">Buscar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <hr>
    <hr>
  </section>
  <section id="nahuales">
    <div class="container">
      <div class="row about-container">
        <div class="col-lg-12 ">
          <div class="section-header">
            <h3 class="section-title" style="  color: #2dc997;">NAHUALES</h3>
          </div>
          <?php include_once "nahuales.php" ?>
        </div>
      </div>
    </div>
  </section>
  <section id="portafolio">
    <div class="container wow fadeInUp">
      <div class="section-header">
        <h3 class="section-title">Imagenes</h3>
        <p class="section-description">Distintas imagenes de la representacion del calendario Haab</p>
      </div>
      <div class="row">

        <div class="col-lg-12">
          <ul id="portafolio-flters">
            <li data-filter=".filter-calendario, .filter-dias, .filter-meses" class="filter-active">Todos</li>
            <li data-filter=".filter-calendario">Calendario</li>
            <li data-filter=".filter-dias">Dias</li>
            <li data-filter=".filter-meses">Meses</li>
          </ul>
        </div>
      </div>

      <div class="row" id="portafolio-wrapper">
        <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
          <a href="img/calendarioHaabGrande.jpg" target="_blank">
            <img src="img/calendarioHaabGrande.jpg" width="100%" alt="">
            <div class="details">
              <h4>Calendario</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
          <a href="img/calendarioTzolkinHaab.jpg" target="_blank">
            <img src="img/calendarioTzolkinHaab.jpg" width="100%" height=" 100%" alt="">
            <div class="details">
              <h4>Calendario</h4>
              <span>Interaccion entre el Calendario Tzolkin y Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-calendario">
          <a href="img/CalendarioHaab1.jpg" target="_blank">
            <img src="img/CalendarioHaab1.jpg" width="150%" alt="">
            <div class="details">
              <h4>Calendario </h4>
              <span>Representacion del calendario Haab en piedra</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-dias">
          <a href="img/DiasMayas.png" target="_blank">
            <img src="img/DiasMayas.png" width="150%" alt="">
            <div class="details">
              <h4>Representacion de los dias mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-dias">
          <a href="img/DiasMayas1.png" target="_blank">
            <img src="img/DiasMayas1.png" width="150%" alt="">
            <div class="details">
              <h4>Representacion de los dias mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-meses">
          <a href="img/geroglificosUinal.gif" target="_blank">
            <img src="img/geroglificosUinal.gif" width="100%" alt="">
            <div class="details">
              <h4>Representacion de los meses mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>
        <div class="col-lg-3 col-md-6 portafolio-item filter-meses">
          <a href="img/JeroglificosUinal.png" target="_blank">
            <img src="img/JeroglificosUinal.png" width="150%" alt="">
            <div class="details">
              <h4>Representacion de los meses mayas</h4>
              <span>Calendario Haab</span>
            </div>
          </a>
        </div>

      </div>
  </section>

  <footer id="footer">

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong>Teoria de Sistemas</strong>. Derechos Reservados
      </div>
    </div>
  </footer>
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/jquery/jquery-migrate.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="lib/easing/easing.min.js"></script>
  <script src="lib/wow/wow.min.js"></script>
  <script src="lib/waypoints/waypoints.min.js"></script>
  <script src="lib/counterup/counterup.min.js"></script>
  <script src="lib/superfish/hoverIntent.js"></script>
  <script src="lib/superfish/superfish.min.js"></script>
  <script src="js/main.js"></script>




</body>

</html>