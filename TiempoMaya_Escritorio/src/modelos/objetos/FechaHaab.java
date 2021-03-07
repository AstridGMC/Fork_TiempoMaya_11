/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.sql.Date;

/**
 *
 * @author jose_
 */
public class FechaHaab {

    private int id;
    private Nahual nahual;
    private Winal winal;
    private String nombre, descripcion;
    private Date fecha;

    public FechaHaab() {
    }
    
    public String obtenerFecha(String fecha){
        String[] nombreMesHaab = {"Pop","Uo","Zip","Zotz", "Tzec","Xul","Yaxkin","Mol","Chen","Yax","Zac","Ceh","Mac","Kankin","Muan","Pax","Kayab","Cumku", "Uayeb"};
        int hour= 0;
        int sec=0;
        int min=0;
        String miFecha[] = fecha.split("-");
        //System.out.println(fecha);
        double j =  gregorian_to_jd( Integer.parseInt(miFecha[0]),Integer.parseInt(miFecha[1]), Integer.parseInt(miFecha[2]))+
        (Math.floor(sec + 60 * (min + 60 * hour) + 0.5) / 86400.0);
        int[] haab= jd_to_maya_haab(j);
        return String.valueOf(haab[1])+" "+ nombreMesHaab[haab[0]-1];
    }

    double GREGORIAN_EPOCH = 1721425.5;
    double MAYAN_COUNT_EPOCH = 584282.5;

    public boolean leap_gregorian(int año) {
        return ((año % 4) == 0)
                && (!(((año % 100) == 0) && ((año % 400) != 0)));
    }

    public int[] jd_to_maya_haab(double jd) {
        double lcount, día;

        jd = Math.floor(jd) + 0.5;
        lcount = jd - MAYAN_COUNT_EPOCH;
        double premod = lcount + 8 + ((18 - 1) * 20);
        día = premod % 365;
        double diafinal = día % 20;
        double mesfinal = Math.floor(día / 20) + 1;
        int[] mesDia = new int[2];
        mesDia[0] = (int) mesfinal;
        mesDia[1] = (int) diafinal;
        return mesDia;
    }

    public double gregorian_to_jd(int año, int mes, int día) {
        //System.out.println(año + " a;o  " + mes + " mes  " + día + " dia  ");
        double resultado = (GREGORIAN_EPOCH - 1)
                + (365 * (año - 1))
                + Math.floor((año - 1) / 4)
                + (-Math.floor((año - 1) / 100))
                + Math.floor((año - 1) / 400)
                + Math.floor((((367 * mes) - 362) / 12)
                        + ((mes <= 2) ? 0
                                : (leap_gregorian(año) ? -1 : -2))
                        + día);
        return resultado;
    }
}
