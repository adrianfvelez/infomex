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
 * @author manuel
 */
@Entity
@Table(catalog = "infomex", schema = "public", name = "marcador")
public class Marcador {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "id_mar")
    private int id_mar;

    @Column(name = "id_tema")
    private int id_tema;

    @Column(name = "correo_inf")
    private String correo_inf;

    @Column(name = "nombre_mar")
    private String nombre_mar;

    @Column(name = "descripcion_mar")
    private String descripcion_mar;

    @Column(name = "longitud")
    private double longitud;

    @Column(name = "latitud")
    private double latitud;

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

    public String getCorreo_inf() {
        return correo_inf;
    }

    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }

    public String getNombre_mar() {
        return nombre_mar;
    }

    public void setNombre_mar(String nombre_mar) {
        this.nombre_mar = nombre_mar;
    }

    public String getDescripcion_mar() {
        return descripcion_mar;
    }

    public void setDescripcion_mar(String descripcion_mar) {
        this.descripcion_mar = descripcion_mar;
    }   
    
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }   

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
