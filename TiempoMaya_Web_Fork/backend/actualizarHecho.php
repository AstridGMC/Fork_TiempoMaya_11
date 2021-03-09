<?php
session_start();
$ir_a = "../LineaDeTiempo.php"; 
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
$miImagen = base64_encode(file_get_contents($_FILES['imagen']['tmp_name']));
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}
$id = $_POST['idHecho'];
//guarda hecho historico
$sql1 = "UPDATE HechoHistorico SET 
    fechaInicio = '".$_POST['fechaInicio'] ."', 
    fechaFinal= '". $_POST['fechaFin']."', 
    titulo= '".$_POST['titulo'] ."', 
    descripcion= '" . $_POST['decripcion'] . "' 
    WHERE idHechoHistorico = '".$_POST['idHecho']."'" ;

if (!$conexion->query($sql1)) {
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}




?>