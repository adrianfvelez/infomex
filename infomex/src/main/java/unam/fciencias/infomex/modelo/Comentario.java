
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
import javax.persistence.Transient;

/**
 *
 * @author a-valderrama
 */

@Entity
@Table(catalog = "infomex", schema = "public", name = "comentario")
public class Comentario{
    
    @Id
    @Column(name = "correo_com")
    private String correo_com;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "calificacion")
    private String calificacion;

    public String getCorreo_com() {
        return correo_com;
    }

    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calififcacion) {
        this.calificacion = calificacion;
    }    
}
