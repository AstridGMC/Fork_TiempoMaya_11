<?php
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sql = "CALL mostrarInfoMaya";
$resultadoInfo = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Los Mayas</title>
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

            <h1>Los Mayas</h1>
            <a href="#information" class="btn-get-started">Descripcion</a>
            <a href="#Elementos" class="btn-get-started">Referencias</a>
        </div>
    </section>

    <section id="information">
        <div class="container">
            <div class="section-header">
                <h3 class="section-title">Los Mayas</h3>
            </div>

            <?php foreach ($resultadoInfo as $info) : ?>
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
    <section id="referencias">
        <div class="section-header">
            <h3 class="section-title" style="  color: #2dc997;">Referencias</h3>
        </div>
        <div class="container">
            <ul>
                <li> <a href="https://es.wikipedia.org/wiki/Cultura_maya"  target="_blank">Cultura Maya Wikipedia</a></li>
                <li> <a href="https://concepto.de/cultura-maya/"  target="_blank">Los Mayas</a></li>
            </ul>
        </div>
    </section>

    <footer id="footer">

            <div class="container">
                <div class="copyright">
                    &copy; Copyright <strong>Teoria de Sistemas</strong>. Derechos Reservados
                </div>

            </div>
        </footer>
</body>