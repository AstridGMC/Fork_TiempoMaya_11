<?php
session_start();
if(isset($_POST["submit"])){
    $ir_a = "../perfil.php"; 
    //$conexion = new mysqli("servidor","usuario","clave","bd")
    $conexion = new mysqli("localhost", "administrador", "Admin.123321", "LineaTiempo");
    if ($conexion->connect_error) {
        die("Connection failed: " . $conexion->connect_error);
    }
    $image = $_FILES['image']['tmp_name'];
    $imgContent = addslashes(file_get_contents($image));

    //guarda hecho historico
    $sql1 = "UPDATE Usuario SET 
        imagen = '" .$imgContent . "' 
        WHERE email ='".$_SESSION['email']."';" ;
        if (!$conexion->query($sql1)) {
            $ir_a = "../error.php";
            echo "Falló 3: (" . $conexion->errno . ") " . $conexion->error;
        }else{
            header("location: ".$ir_a);
        }

}
