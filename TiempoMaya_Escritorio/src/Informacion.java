
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author astridmc
 */
public class Informacion {
    private String titulo;
    private String texto;
    private Image imagen;

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

    public Informacion(String titulo, String texto, Image imagen) {
        this.titulo = titulo;
        this.texto = texto;
        this.imagen = imagen;
    }

    
    
}
