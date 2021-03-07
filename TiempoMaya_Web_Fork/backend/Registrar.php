<?php
session_start();
echo $_POST['rango'];
//$conexion = new mysqli("servidor","usuario","clave","bd")
$nombreServidor = "localhost";
$nombreUsuario = "labmia";
$passwordBaseDeDatos = "Astrid.19972020";
$nombreBaseDeDatos = "LineaTiempo";

// Crear conexión con la base de datos.
$conexion = new mysqli($nombreServidor, $nombreUsuario, $passwordBaseDeDatos, $nombreBaseDeDatos);
$nombre = $_POST['nombres'];
$apellido = $_POST['apellidos'];
$usuario = $_POST['usuario'];
$email = $_POST['email'];
$password = $_POST['password'];
$fecha =  $_POST['fechaNacimiento'];
$rol = 'Lector';
//GUARDANDO USUARIO 

$sql = "INSERT INTO Usuario (username, password, email, nombre, apellido, nacimiento, rol)
    VALUES ('" . $usuario . "','" . $password . "','" . $email . 
    "','" . $nombre . "','" . $apellido . "', '".$fecha."' , 2)";
    
if (!$conexion->query($sql)) {
    $ir_a = "error.php";
    echo "Falló CALL: (" . $conexion->errno . ") " . $conexion->error;
}else{
    $_SESSION['nombre'] = $usuario;
    $_SESSION['rol'] = $rol;
    $_SESSION['email'] = $email;
    $ir_a = "../index.php";
    echo $sql;
}
header("location: " . $ir_a);
?>
