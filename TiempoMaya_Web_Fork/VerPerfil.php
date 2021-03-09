<?php
    session_start();
    if (!isset($_SESSION['nombre'])) {
        $ir_a = "iniciarSesion.php";
        header("location: ".$ir_a);
    }
?>

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
  <title>Mi Perfil</title>
</head>

<body>
<?php include "BarradeNavegacion.php" ?>
  <section id="inicio">

  </section>
</body>