/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author a-valderrama
 */
public class Comentario {
    
    private int id_comentario;
            
    private int id_mar;

    private int id_tema;

    private String correo_com;

    private String descripcion;
    
    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }
    
    public int getId_mar() {
        return id_mar;
    }
    
    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
}

    public String getCorreo_com() {
        return correo_com;
    }

    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}