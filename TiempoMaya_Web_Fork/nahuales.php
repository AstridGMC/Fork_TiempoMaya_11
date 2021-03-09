<?php
session_start();

//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sql = "CALL mostrarNahuales";
$nahuales = $conexion->query($sql);
?>



<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="lib/animate/animate.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <title>Nahuales</title>
</head>

<style>
  @media (max-width: 768px) {
    #nav-menu-container {
      display: none;
    }
  }

  #header.header-fixed {
    background: rgba(52, 59, 64, 0.9);
    padding: 20px 0;
    height: 72px;
    transition: all 0.5s;
  }
</style>

<body>

  <div>
    <header id="header" style="background-color: rgba(52, 59, 64, 0.6);">
      <?php include 'BarradeNavegacion.php'; ?>
    </header>
  </div>

  <div style="padding-top: 100px; margin-left: 5%; margin-right: 5%;">

    <?php foreach ($nahuales as $nahual) : ?>
      <section id="<?php echo $nahual['nombre']; ?>">
        <div>
          <h3 class="section-title" style="  color: #2dc997;"> <strong><?php echo $nahual['nombre']; ?> </strong></h3>
          <h4><?php if (isset($_GET['nivel']) && $_GET['nahual'] == $nahual['nombre']) {
                echo "   Nivel " . $_GET['nivel'];
              } ?>
          </h4>
          <h4>Animal: <strong><?php echo $nahual['animal']; ?></strong></h4>
          <div class="row about-container">
            <div class="col-lg-6 content order-lg-1 order-2">
              <h5>Significado: <strong><?php echo $nahual['significado']; ?></strong></h5>
              <?php echo $nahual['descripcion']; ?>
            </div>
            <div class="col-lg-6 background order-lg-2 order-1 wow fadeInRight">
              <br>
              <img <?php echo 'src = "data:image/png;base64,' . base64_encode($nahual['imagen']) . '"' ?> width="80%" alt="Imagen del calendario habb" style="margin-left: 150px;">
            </div>
          </div>
        </div>
      </section>
      <hr>
    <?php endforeach; ?>

  </div>
</body>

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