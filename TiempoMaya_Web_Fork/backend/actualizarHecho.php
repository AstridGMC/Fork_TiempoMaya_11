<?php
session_start();
$ir_a = "../LineaDeTiempo.php"; 
//$conexion = new mysqli("servidor","usuario","clave","bd")
$conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
if ($conexion->connect_error) {
    die("Connection failed: " . $conexion->connect_error);
}
$image = $_FILES['imagen']['tmp_name'];
$imgContent = addslashes(file_get_contents($image));

$id = $_POST['idHecho'];
//guarda hecho historico
$sql1 = "UPDATE HechoHistorico SET 
    fechaInicio = '".$_POST['fechaInicio'] ."', 
    fechaFinal= '". $_POST['fechaFin']."', 
    titulo= '".$_POST['titulo'] ."', 
    descripcion= '" . $_POST['decripcion'] . "', 
    imagen = '" .$imgContent . "' 
    WHERE idHechoHistorico = '".$_POST['idHecho']."'" ;

if (!$conexion->query($sql1)) {
    echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
}else{
    header("location: ".$ir_a);
}




?>