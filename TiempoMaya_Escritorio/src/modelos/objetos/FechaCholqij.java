/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose_
 */
public class FechaCholqij {
    
    private int id;
    private Nahual nahual;
    private Energia energia;
    private Date fecha;
    private String descripcion;

    public FechaCholqij() {
    }

    public FechaCholqij(int id, Nahual nahual, Energia energia, Date fecha, String descripcion) {
        this.id = id;
        this.nahual = nahual;
        this.energia = energia;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nahual getNahual() {
        return nahual;
    }

    public void setNahual(Nahual nahual) {
        this.nahual = nahual;
    }

    public Energia getEnergia() {
        return energia;
    }

    public void setEnergia(Energia energia) {
        this.energia = energia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String fechaEscritaCholquij(long date){
        String fecha="";
        String[] nombreMes = {"Imox","Iq\'", "Aq\'ab\'al","K\'at","Kan"     , "Kame","Kej"  ,"Q\'anil","Toj"   ,"Tz\'i","B\'atz\'","E" ,"Aj"  ,"I\'x","Tz\'ikin","Ijmaq","No\'j","Tijax","Kawoq","Ajpu\'"};
        fecha= String.valueOf(nivel(timeCholqij(date)));
        fecha = fecha +" "+ nombreMes[nahual(timeCholqij(date))-1];
        return fecha;
    }
    
    public int nahual(int cont){
        System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = 6;
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
    
    public int nivel(int cont){
        System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = 4;
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
    
    public int timeCholqij(long date){
        try {
            String string = "Nov 15, 2020 00:00:00 AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ROOT);
            Date datePivote = (Date) sdf.parse(string);
//            System.out.println("DATE PIVOTE " + datePivote);
            long regresar = TimeUnit.DAYS.convert(datePivote.getTime() - date, TimeUnit.MILLISECONDS);
            return (int) regresar;
        } catch (ParseException ex) {
        } return 1;
    }
    
}
