/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author jose_
 */
public class HechoHistorico {
    
    private int id;
    private Date fechaInicio, fechaFinalizacion;
    private String titulo, descripcion;
    private Image imagen;

    public HechoHistorico() {
    }

    public HechoHistorico(int id, Date fechaInicio, Date fechaFinalizacion, String titulo, String descripcion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public HechoHistorico(int id, Date fechaInicio, Date fechaFinalizacion, String titulo, String descripcion, Image image) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
