<?php
session_start();

if (isset($_SESSION['email'])) {
  $conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
  $sql = "SELECT imagen FROM Usuario WHERE email = '" . $_SESSION['email'] . "' LIMIT 1";
  $resultado = $conexion->query($sql);
  $userImage = $resultado->fetch_array(MYSQLI_ASSOC);
}
?>

<link rel=”Shortcut Icon” href=”favicon.ico” type=”image/x-icon” />

<header id="header">
  <div class="container">
    <nav id="nav-menu-container">
      <ul class="nav-menu">
        <?php
        if (isset($_SESSION['nombre'])) { ?>
          <li>
            <div class="col-sm-2" style="padding-top: 0px;">
              <a href="perfil.php" class="profile-picture" style="margin-bottom: 0%; padding-bottom: 0%;">
                <?php
                if ($userImage['imagen'] !== null) { ?>
                  <img id='fotoPerfil' <?php echo 'src = "data:image/png;base64,' . base64_encode($userImage['imagen']) . '"' ?> style="height: 50px;display: block;" class="img-responsive img-circle"  alt="Imagen perfil"/></a>
                <?php } else { ?>
                  <img src="img/perfil.jpg" class="img-responsive img-circle" style="height: 50px;display: block;"> </a>
                <?php } ?>
            </div>
          </li>
        <?php } ?>
        <li class="menu-active"> <a href="index.php" style="font-size: 23px;"><strong>TIEMPO</strong> MAYA</a></li>
        <li><a href="LineaDeTiempo.php">Linea del Tiempo</a></li>
        <li><a href="CalendarioHaab.php">Calendario Haab</a></li>
        <li><a href="CalendarioCholqij.php">Calendario Cholquij</a></li>
        <li><a href="ruedaCalendarica.php">Rueda Calendarica</a></li>
        <li><a href="nahuales.php">Nahuales</a></li>
        <?php
        if (isset($_SESSION['nombre'])) {
          echo '<li><a href="cerrarSesion.php">Cerrar Sesion</a></li>';
        } else {
          echo '<li><a href="iniciarSesion.php">Iniciar Sesion</a></li>
            <li><a href="Registro.php">Registrarse</a></li>';
        }
        ?>
      </ul>
    </nav>
  </div>
</header>