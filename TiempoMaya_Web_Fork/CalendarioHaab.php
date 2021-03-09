<?php
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sql = "CALL mostrarCalendarioHaab";
$resultadoCalendario = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Calendario Haab</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/Calendarios.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">


</head>
<?php include "BarradeNavegacion.php" ?>

<body>
  <section id="inicio">
    <div class="inicio-container">

      <h1>Calendario Haab</h1>
      <a href="#information" class="btn-get-started">Descripcion</a>
      <a href="#Elementos" class="btn-get-started">Elementos</a>
      <a href="#portafolio" class="btn-get-started">Imagenes</a>
    </div>
  </section>

  <section id="information">
    <div class="container">
      <div class="section-header">
        <h3 class="section-title">Calendario Haab</h3>
      </div>

      <?php foreach ($resultadoCalendario as $info) : ?>
        <?php if (!strlen(strstr($info['titulo'], 'segundaParte')) > 0) { ?>
          <h3 class="section-title" style="  color: #2dc997;"><?php echo $info['titulo']; ?></h3>
        <?php } ?>
        <?php if ($info['imagen'] != null) { ?>
          <div class="row about-container">
            <div class="col-lg-6 content order-lg-1 order-2">
              <?php echo $info['descripcion']; ?>
            </div>
            <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight">
              <br>
              <img <?php echo 'src = "data:image/png;base64,' . base64_encode($info['imagen']) . '"' ?> width="80%" alt="Imagen del calendario habb" style="margin-left: 150px;">
            </div>
          </div>
        <?php } else { ?>
          <div class="">
            <?php echo $info['descripcion']; ?>
          </div>
        <?php } ?>
      <?php endforeach; ?>
  </section>
  <hr>
  <div class="section-header">
    <h3 class="section-title" style="  color: #2dc997;">Elementos</h3>
  </div>
  
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