var fechaPivote2 = '2020-11-15';
var fechaPivote = '2001-01-01'; 
function printqq(){
    console.log('Has pinchado con el ratón');
}

function convertidor(){
var nombreMesHaab = ['Pop','Uo','Zip','Zotz', 'Tzec','Xul','Yaxkin','Mol','Chen','Yax','Zac','Ceh','Mac','Kankin','Muan','Pax','Kayab','Cumku', 'Uayeb'];
    hour = min = sec = 0;
    var fecha = document.getElementById("fecha").value;
    var numeroDias2= diasFecha2( fecha);
    console.log(numeroDias2+'ddddddd');
    var miFecha = fecha.split('-');
    console.log(miFecha[0], miFecha[1], miFecha[2]);
    var j =  gregorian_to_jd( new Number(miFecha[0]),new Number(miFecha[1]), new Number(miFecha[2]))+
    (Math.floor(sec + 60 * (min + 60 * hour) + 0.5) / 86400.0);
    console.log(j+"jjjj");
    var haab= jd_to_mayan_haab(j);
    document.getElementById("calCholquij").innerHTML =  ConvertirCholquij( numeroDias2);
    document.getElementById("calHaab").innerHTML =  haab[1]+" "+nombreMesHaab[haab[0] - 1];
}

function convertidorInicio(){
    hour = min = sec = 0;
    var f = new Date();
    var fecha =    f.getFullYear()+ "-" + (f.getMonth() +1) + "-" +f.getDate();
    console.log(fecha);
    var numeroDias2= diasFecha2( fecha);
    document.getElementById("fechaCholquij").innerHTML =  ConvertirCholquij( numeroDias2);
    var miFecha = fecha.split('-');
    console.log(miFecha[0], miFecha[1], miFecha[2]);
    var j =  gregorian_to_jd(miFecha[0], miFecha[1], miFecha[2])+
    (Math.floor(sec + 60 * (min + 60 * hour) + 0.5) / 86400.0);
    var haab= jd_to_mayan_haab(j, miFecha[2]);
    var nombreMesHaab = ['Pop','Uo','Zip','Zotz', 'Tzec','Xul','Yaxkin','Mol','Chen','Yax','Zac','Ceh','Mac','Kankin','Muan','Pax','Kayab','Cumku', 'Uayeb'];
    document.getElementById("fechaHaab").innerHTML =  haab[1]+" "+nombreMesHaab[haab[0] - 1];
}

function ConvertirCholquij(dias){
    var nombreMes = ['Imox','Iq\'', 'Aq\'ab\'al','K\'at','Kan'     , 'Kame','Kej'  ,'Q\'anil','Toj'   , 'Tz\'i','B\'atz\'','E' ,'Aj'  ,'I\'x','Tz\'ikin','Ijmaq','No\'j','Tijax','Kawoq','Ajpu\'']
    var dia = nivel(dias);
    var mes = nombreMes[nahual( dias)-1];
    return dia +" "+ mes;
}

var GREGORIAN_EPOCH = 1721425.5;

function gregorian_to_jd (año, mes, día)
{
    console.log(año+" a;o  "+ mes+" mes  "+día+" dia  " );
    var resultado = (GREGORIAN_EPOCH - 1) +
    (365 * (año - 1)) +
    Math.floor ((año - 1) / 4) +
    (-Math.floor ((año - 1) / 100)) +
    Math.floor ((año - 1) / 400) +
    Math.floor ((((367 * mes) - 362) / 12) +
    ((mes <= 2)? 0:
                        (leap_gregorian (año)? -1: -2)
    ) +
    día);
    return resultado;
}

// LEAP_GREGORIAN - ¿Es un año determinado en el calendario gregoriano un año bisiesto?

function leap_gregorian (año)
{
    return ((año% 4) == 0) &&
            (! (((año% 100) == 0) && ((año% 400)!= 0)));
}



var MAYAN_COUNT_EPOCH = 584282.5;

function jd_to_mayan_haab (jd)
{
    var lcount, día;

    jd = Math.floor (jd) + 0.5;
    lcount = jd - MAYAN_COUNT_EPOCH;
    var premod= lcount + 8 + ((18 - 1) * 20);
    día = premod % 365;
    var diafinal= día%20;
    var mesfinal= Math.floor (día / 20) + 1;
    return new Array (mesfinal, diafinal);
}

//verifica que nahual cae en cada fecha del calendario cholquij
function nahual( cont){
    var contador = cont;
    var contadorNahual = 6;
    if (contador < 0) {
        while (contador != 0) {
            if (contadorNahual == 20) {
                contadorNahual = 1;
            } else {
                contadorNahual++;
            } contador++;
        } return contadorNahual;
    }
    while (contador != 0) {
        if (contadorNahual == 1) {
            contadorNahual = 20;
        } else {
            contadorNahual--;
        } contador--;
    } return contadorNahual;
    
}

function nivel( cont){
    var contador = cont;
    var contadorNahual = 4;
    if (contador < 0) {
        while (contador != 0) {
            if (contadorNahual == 13) {
                contadorNahual = 1;
            } else {
                contadorNahual++;
            } contador++;
        } return contadorNahual;
    }
    while (contador != 0) {
        if (contadorNahual == 1) {
            contadorNahual = 13;
        } else {
            contadorNahual--;
        } contador--;
    } return contadorNahual;
    
}

function diasFecha2( fechaIngresada){
    var f1 = new Date(fechaPivote2); 
    var f2 = new Date(fechaIngresada); 
    console.log(f1.getTime());
    console.log(f2.getTime());
    var tiempo = f1.getTime()- f2.getTime();
    var dias = Math.floor(tiempo / (1000 * 60 * 60 * 24)); 
    console.log(dias+"diasFecha");            
    return dias;          
}