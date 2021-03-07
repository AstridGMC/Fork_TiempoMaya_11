<?php
session_start();
$ir_a = "../perfil.php"; 
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}

//guarda hecho historico
$sql1 = "UPDATE Usuario SET 
    nombre = '".$_POST['nombre'] ."', 
    apellido= '". $_POST['apellido']."', 
    telefono= '".$_POST['telefono'] ."', 
    username= '" . $_POST['usuario'] . "' 
    WHERE email ='".$_POST['correo']."'"  ;
    if (!$conexion->query($sql1)) {
        $ir_a = "../error.php";
        echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
    }else{
        header("location: ".$ir_a);
    }



?>