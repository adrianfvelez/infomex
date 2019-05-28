/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author valde
 */
@Entity
@Table(catalog = "infomex", schema = "public", name = "calificacion")
public class Calificacion {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "id_califiacion")
    private int id_calificacion;
    
    @Column(name = "id_comentario")
    private int id_comentario;
    
    @Column(name = "correo_com")
    private String correo_com;
    
    @Column(name = "calificacion")
    private String calificion;
    
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
