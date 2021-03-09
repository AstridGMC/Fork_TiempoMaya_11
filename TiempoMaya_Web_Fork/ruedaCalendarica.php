<?php
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$sql = "CALL mostrarRuedaCalendarica";
$resultadoRueda = $conexion->query($sql);
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <title>Rueda calendarica</title>
</head>

<body style="padding-top: 90px;">
    <style>
        #header {
            background: rgba(0, 0, 0, 0.40);
            color: white;
        }

        .nav-menu>li>a {
            color: rgb(196, 196, 199);
        }

        @media screen and (max-width: 700px) {
            .content-wheel {
                grid-template-areas:
                    "navbar navbar navbar"
                    "image image image"
                    "mainText mainText mainText"
                    "textExtra textExtra textExtra";
            }
        }
    </style>


    <body>
        <header id=header>
            <?php include "BarradeNavegacion.php" ?>
        </header>

        <section id="inicio">
            <div class="inicio-container">

                <h1>Rueda Calendarica</h1>
                <a href="#information" class="btn-get-started">Descripcion</a>
                <a href="#verFecha" class="btn-get-started">Fecha segun Calendarios Mayas</a>

            </div>

        </section>

        <section id="information">
            <div class="container">
                <div class="section-header">
                    <h3 class="section-title">Rueda Calendarica</h3>
                </div>

                <?php foreach ($resultadoRueda as $info) : ?>
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
                                <img <?php echo 'src = "data:image/png;base64,' . base64_encode($info['imagen']) . '"' ?> width="80%" alt="Imagen rueda Calendarica" style="margin-left: 150px;">
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
        <section id="verFecha" style="padding-left: 20%; padding-right: 20%;">
            <div class="container">
                <div class="row about-container">
                    <div class="col-lg-12 ">
                        <div class="section-header">
                            <h3 class="section-title" style="  color: #2dc997;">¿Que fecha es?</h3>
                        </div>
                        <div class="container">
                                <div class="form-group mb-2">
                                    <label for="staticEmail2" class="sr-only text-dark">Ingresar fecha</label>
                                    <input type="date" class="form-control-plaintext text-dark border border-success" id="fecha" name="date" required>
                                </div>
                                <div class="form-group mb-2">
                                    <button type="submit" class="btn btn-outline-success btn-lg btn-block mb-2"  onclick="convertidor()">Buscar</button>
                                </div>
                        </div>
                        <hr>
                        <h2><strong>La fecha es: </strong></h2>
                        <div>
                            <h3 style="display: inline;"> En el calendario Cholq'ij: </h3>
                            <h3 style="display: inline;" id="calCholquij"> </h3>
                        </div>
                        <br>
                        <div>
                            <h3 style="display: inline;"> En el calendario Haab: </h3>
                            <h3 style="display: inline;" id="calHaab"> </h3>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
        </section>
        </div>

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
        <script src="js/ConversorFechas.js"></script>

    </body>


    

</html>