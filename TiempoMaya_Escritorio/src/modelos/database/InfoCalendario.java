/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.awt.Image;

/**
 *
 * @author astridmc
 */
public class InfoCalendario {
     private String titulo;
    private String texto;
    private Image imagen;
    private byte[] imgData;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }
    
    

    public InfoCalendario(String titulo, String texto, Image imagen, byte[] img) {
        this.titulo = titulo;
        this.texto = texto;
        this.imagen = imagen;
        this.imgData = img;
    }
}
