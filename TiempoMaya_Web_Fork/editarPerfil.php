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
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>editar Perfil</title>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
  <link rel="stylesheet" type="text/css" href="css/estiloPerfil2.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <script src="https://kit.fontawesome.com/e51fb510f5.js" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<?php include "BarradeNavegacion.php" ?>

<body>
  <section id="inicio">
    <div>
      <div class="container-fluid mt--7">
        <div class="row">
          <div class="col-xl-4 order-xl-1 mb-5 mb-xl-0" style="margin-top: 250px;margin-left: 10%;">
            <div class="card card-profile shadow">
              <div class="row justify-content-center">
                <div class="col-lg-3 order-lg-2">
                  <div class="card-profile-image">
                    <?php
                    if ($usuario['imagen'] !== null) { ?>
                      <a class="profile-picture">
                        <img id='foto' <?php echo 'src = "data:image/png;base64,' . base64_encode($usuario['imagen']) . '"' ?> class="rounded-circle" alt="Imagen perfil">
                      </a>
                    <?php } else { ?>
                      <a class="profile-picture">
                        <img id='foto' src="img/perfil.jpg" class="rounded-circle"> </a>
                    <?php } ?>
                  </div>
                </div>
              </div>
              <div>
                <form action='./backend/guardarImagenPerfil.php' method='post' enctype='multipart/form-data'>

                  <div class="file-input">
                    <input type="file" id="file11" class="file1" name='image' />
                    <label for="file11">
                      CambiarFoto
                      <p class="file-name"></p>
                    </label>
                  </div>
                  <input type="submit" class="btn btn-sm btn-primary" name="submit" value="GUARDAR" />
                </form>
              </div>
              <div class="card-body pt-0 pt-md-4" style="margin-top:50px;">
                <div class="row">
                  <div class="col">
                    <div class="card-profile-stats d-flex justify-content-center mt-md-5">
                      <div>
                        <span class="heading">643</span>
                        <span class="description">Publicaciones</span>
                      </div>
                      <div>
                        <span class="heading">108</span>
                        <span class="description">Me gusta</span>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="text-center">
                  <h3 style="font-size: 30px;">
                    <?php echo explode(" ", $usuario['nombre'])[0]; ?>
                    <span class="font-weight-light"> <br> <?php echo explode(" ", $usuario['apellido'])[0]; ?></span>
                  </h3>
                  <div class="h5 mt-4" style="font-size: 20;">
                    <i class="ni business_briefcase-24 mr-2"></i><?php echo  $_SESSION['rol']; ?>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-6 order-xl-2" style="margin-top: 250px;">
            <form action="./backend/actualizarUsuario.php" method="post">
              <input type="text" value="../perfil.php" name="direccion" hidden />
              <div class="card bg-secondary shadow">
                <div class="card-header bg-white border-0">
                  <div class="row align-items-center">
                    <div class="col-8">
                      <h3 class="mb-0">Mi cuenta</h3>
                    </div>
                    <div class="col-4 text-right">
                      <button type="submit" class="btn btn-sm btn-primary"><i class="fas fa-save"></i> Guardar</button>
                    </div>
                  </div>
                </div>
                <div class="card-body">
                  <h6 class="heading-small text-muted mb-4">Informacion de usuario</h6>
                  <div class="pl-lg-4">
                    <div class="row">
                      <div class="col-lg-6">
                        <div class="form-group focused">
                          <label class="form-control-label" for="input-username">Usuario</label>
                          <input type="text" name="usuarioAntiguo" hidden value="<?php echo $usuario['usuario']  ?>" />
                          <input type="text" name="usuario" class="form-control form-control-alternative" placeholder="Username" value="<?php echo $usuario['username'] ?>" />
                        </div>
                      </div>
                      <div class="col-lg-6">
                        <div class="form-group">
                          <label class="form-control-label" for="input-email">Correo</label>
                          <input type="email" name="correos" class="form-control form-control-alternative" placeholder="jesse@example.com" value=" <?php echo $usuario['email'] ?> " disabled />
                          <input type="email" name="correo" hidden placeholder="jesse@example.com" value=" <?php echo $usuario['email'] ?> " />
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-4">
                        <div class="form-group focused">
                          <label class="form-control-label" for="input-first-name">Nombre</label>
                          <input type="text" name="nombre" class="form-control form-control-alternative" placeholder="Nombre" value="<?php echo $usuario['nombre'] ?>" />
                        </div>
                      </div>
                      <div class="col-lg-4">
                        <div class="form-group focused">
                          <label class="form-control-label" for="input-last-name">Apellido</label>
                          <input type="text" name="apellido" class="form-control form-control-alternative" placeholder="Apellido" value="<?php echo $usuario['apellido'] ?>" />
                        </div>
                      </div>
                      <div class="col-lg-4">
                        <div class="form-group focused">
                          <label class="form-control-label" for="input-last-name">contraseña</label>
                          <input type="password" id="pass" name="password" class="form-control form-control-alternative" placeholder="contraseña" value="<?php echo $usuario['password']; ?>" />
                          <input type="checkbox" onclick="verPassword()" style="font-size: 5px;">👁 ver
                        </div>
                      </div>
                    </div>
                  </div>
                  <hr class="my-4">
                  <h6 class="heading-small text-muted mb-4">Informacion de contacto</h6>
                  <div class="pl-lg-4">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group focused">
                          <label class="form-control-label" for="input-address">Telefono</label>
                          <input id="numero" name="telefono" class="form-control form-control-alternative" placeholder="Telefono" value="<?php echo $usuario['telefono']; ?>" type="text" />
                        </div>
                      </div>
                    </div>
                  </div>
                  <hr class="my-4">
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
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
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery.easing.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/custom.js"></script>
</body>

</html>


<script>
  function verPassword() {
    var x = document.getElementById("pass");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

  var input = document.getElementById('numero');
  input.addEventListener('input', function() {
    if (this.value.length > 8)
      this.value = this.value.slice(0, 8);
  })

  document.getElementById("file11").onchange = function(e) {
    // Creamos el objeto de la clase FileReader
    let reader = new FileReader();

    // Leemos el archivo subido y se lo pasamos a nuestro fileReader
    reader.readAsDataURL(e.target.files[0]);

    // Le decimos que cuando este listo ejecute el código interno
    reader.onload = function() {
      let preview = document.getElementById('preview'),
        image = document.getElementById('foto');

      image.src = reader.result;

      preview.innerHTML = '';
      preview.append(image);
    };
  }
</script>