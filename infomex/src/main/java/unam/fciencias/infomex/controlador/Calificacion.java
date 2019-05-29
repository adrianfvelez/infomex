/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author valde
 */
public class Calificacion {
    
    private int id_calificacion;
    private int id_comentario;
    private String correo_com;
    private String calificion;
    private double example = 3.5;

    public double getExample() {
        return example;
    }

    public void setExample(double example) {
        this.example = example;
    }
    
    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getCorreo_com() {
        return correo_com;
    }

    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }

    public String getCalificion() {
        return calificion;
    }

    public void setCalificion(String calificion) {
        this.calificion = calificion;
    }
}
