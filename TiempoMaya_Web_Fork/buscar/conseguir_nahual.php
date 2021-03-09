<?php
	$formato = mktime(0, 0, 0, 1, 1, 1720)/(24*60*60);
	$fecha = date("U", strtotime($_POST['date']))/(24*60*60);
	$id = $fecha-$formato;
	$nahual = $id % 20;
  switch ($nahual){
		case 19:;
      $query = "IX"; // suponiendo que el id del IX es 0
			break;
		case 0: case -19:
      $query = "TZ'IKIN"; // suponiendo que el id del TZIKIN es 1
			break;
		case 1: case -18:
      $query = "AJMAQ"; // suponiendo que el id del AJMAQ es 2
			break;
		case 2: case -17:
      $query = "NO'J"; // suponiendo que el id del NOJ es 3
			break;
		case 3: case -16:
      $query = "TIJAX"; // suponiendo que el id del TIJAX es 4
			break;
		case 4: case -15:
      $query = "KAWOQ"; // suponiendo que el id del KAWOK es 5
			break;
		case 5: case -14:
      $query = "AJPU"; // suponiendo que el id del AJPU es 6
			break;
		case 6: case -13:
      $query = "IMOX"; // suponiendo que el id del IMOX es 7
			break;
		case 7: case -12:
      $query = "IQ'"; // suponiendo que el id del IQ es 8
			break;
		case 8: case -11:
      $query = "AK'AB'AL"; // suponiendo que el id del AKABAL es 9
			break;
		case 9: case -10:
      $query = "K'AT"; // suponiendo que el id del KAT es 10
			break;
		case 10: case -9:
      $query = "KAN"; // suponiendo que el id del KAN es 11
			break;
		case 11: case -8:
      $query = "KEME"; // suponiendo que el id del KEME es 12
			break;
		case 12: case -7:
      $query = "KEJ"; // suponiendo que el id del KIEJ es 13
			break;
		case 13: case -6:
      $query = "Q'ANIL"; // suponiendo que el id del QANIL es 14
			break;
		case 14: case -5:
      $query = "TOJ"; // suponiendo que el id del TOJ es 15
			break;
		case 15: case -4:
      $query = "TZ'I'"; // suponiendo que el id del TZI es 16
			break;
		case 16: case -3:
      $query = "B’ATZ"; // suponiendo que el id del BATZ es 17
			break;
		case 17: case -2:
      $query = "E"; // suponiendo que el id del E es 18
			break;
		case 18: case -1:
      $query = "AJ"; // suponiendo que el id del AJ es 19
			break;
	}
?>
