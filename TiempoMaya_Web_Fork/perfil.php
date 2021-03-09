<?php
session_start();

if (isset($_SESSION['email'])) {
  $conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
  $sql = "SELECT * FROM Usuario WHERE email = '" . $_SESSION['email'] . "' LIMIT 1";
  $resultado = $conexion->query($sql);
  $usuario = $resultado->fetch_array(MYSQLI_ASSOC);
} else {
  header("location: index.php");
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Mi Perfil</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/Perfil.css" rel="stylesheet">
    <link href="css/estiloPerfil2.css" rel="stylesheet">

</head>

<body>
    <?php include "BarradeNavegacion.php" ?>
    <section id="inicio">
        <div class="inicio-container">

            <div class="container" style="margin-top:150px; ">
                <div class="profile-env" style="background: rgba(0, 0, 0, 0.3);">
                    <header class="row">
                        <div class="col-sm-2" style="height: 150px; width:50px">
                            <?php
                            if ($usuario['imagen'] !== null) { ?>
                                    <a href="#" class="profile-picture" style="height: 150px;">
                                    <img <?php echo 'src = "data:image/png;base64,' . base64_encode($usuario['imagen']) . '"' ?>  class="img-responsive img-circle" style="height: 100%;"></a>
                            
                            <?php } else {
                            ?>
                                <a href="#" class="profile-picture">
                                    <img src="img/perfil.jpg" class="img-responsive img-circle"> </a>

                            <?php } ?>
                        </div>
                        <div class="col-sm-7">
                            <ul class="profile-info-sections">
                                <li>
                                    <div class="profile-name">
                                        <strong>
                                            <a href="#"><?php echo $usuario['username']; ?></a>
                                            <a href="#" class="user-status is-online tooltip-primary" data-toggle="tooltip" data-placement="top" data-original-title="Online"></a>
                                        </strong>
                                        <span>
                                            <a href="#">Nahual Noj</a>
                                        </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="profile-stat">
                                        <h3 style="color: white;">643</h3>
                                        <span>
                                            <a href="#">Publicaciones</a>
                                        </span>
                                    </div>
                                </li>
                                <li>
                                    <div class="profile-stat">
                                        <h3 style="color: white;">108</h3>
                                        <span>
                                            <a href="#">Me gusta</a>
                                        </span>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </header>
                    <section class="profile-info-tabs">
                        <div class="row">
                            <div class="col-sm-offset-2 col-sm-10">
                                <ul class="user-details">
                                    <li>
                                        <i class="entypo-location"></i>
                                        <strong> <?php echo $usuario['email']; ?></strong>
                                    </li>
                                    <li>
                                        <i class="entypo-location"></i>
                                        <strong>Telefono: </strong><?php echo $usuario['telefono']; ?>
                                    </li>
                                    <li>
                                        <i class="entypo-location"></i>
                                        <span style="color: black;"><?php echo  $_SESSION['rol']; ?></span>
                                    </li>
                                    <li>
                                    </li>
                                </ul>
                                <ul class="nav nav-tabs">
                                    <li>
                                        <a style="background-color: #2dc997; font-size: 1rem; color: white;" href="editarPerfil.php">Editar Perfil</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </section>

                </div>
            </div>
            <a href="#Comentarios" class="btn-get-started">Ver Comentarios</a>
        </div>


    </section>

    <section id=Comentarios class="profile-feed  ">
        <div class="container">
            <hr>
            <h1>Comentarios</h1>


            <div class="profile-stories " style="background:  rgb(255,255,255);">
                <article class="story wow fadeInUp ">
                    <aside class="user-thumb">
                        <a href="#">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" width="44" alt="" class="img-circle"> </a>
                    </aside>
                    <div class="story-content">
                        <header>
                            <div class="publisher">
                                <a href="#">Daniel Fernandez</a> posteo un comentario
                            </div>
                            <div class="story-type">
                                <i class="entypo-feather"></i>
                            </div>
                        </header>
                        <div class="story-main-content">
                            <p>Las publicaciones que haces son muy interesantes</p>
                        </div>
                        <footer>
                            <a href="#" class="liked">
                                <i class="entypo-heart"></i>
                                Me gusta
                                <span>(8)</span>
                            </a>
                        </footer>

                        <hr>
                    </div>
                </article>
                <article class="story wow fadeInUp">
                    <aside class="user-thumb">
                        <a href="#">
                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" width="44" alt="" class="img-circle"> </a>
                    </aside>
                    <div class="story-content">
                        <header>
                            <div class="publisher">
                                <a href="#">Ericksson Hernandez</a> posteo un comentario
                            </div>
                            <div class="story-type">
                                <i class="entypo-feather"></i>
                            </div>
                        </header>
                        <div class="story-main-content">
                            <p>Interesantes puntos de vista acerca del Tiempo Maya</p>
                        </div>
                        <footer>
                            <a href="#" class="liked">
                                <i class="entypo-heart"></i>
                                Me gusta
                                <span>(3)</span>
                            </a>
                        </footer>

                        <hr>
                    </div>
                </article>
                <article class="story wow fadeInUp">
                    <aside class="user-thumb">
                        <a href="#">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" width="44" alt="" class="img-circle"> </a>
                    </aside>
                    <div class="story-content">
                        <header>
                            <div class="publisher">
                                <a href="#">Sebastian Sum </a> posteo un comentario
                            </div>
                            <div class="story-type">
                                <i class="entypo-feather"></i>
                            </div>
                        </header>
                        <div class="story-main-content">
                            <p>La publicacion acerca del Calendario Haab esta muy interesante</p>
                        </div>
                        <footer>
                            <a href="#" class="liked">
                                <i class="entypo-heart"></i>
                                Me gusta
                                <span>(8)</span>
                            </a>
                        </footer>

                        <hr>
                    </div>
                </article>

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

    <script>
        const file = document.querySelector('#file1');
        file.addEventListener('change', (e) => {
            // Get the selected file
            const [file] = e.target.files;
            // Get the file name and size
            const {
                name: fileName,
                size
            } = file;
            // Convert size in bytes to kilo bytes
            const fileSize = (size / 1000).toFixed(2);
            // Set the text content
            const fileNameAndSize = `${fileName} - ${fileSize}KB`;
            document.querySelector('.file-name').textContent = fileNameAndSize;
        });
    </script>


</body>

</html>