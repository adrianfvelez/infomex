/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;


/**
 *
 * @author manuel
 */
public class Marcador {

    private int id_mar;

    private int id_tema;

    private String correo_inf;

    private String nombre_mar;

    private String descripcion_mar;

    private double longitud;

    private double latitud;

    /**
     *Regresa el id del marcador
     * @return id marcador
     */
    public int getId_mar() {
        return id_mar;
    }

    /**
     *Asigna el id al marcador
     * @param id_mar
     */
    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    /**
     *Regresa el id del tema
     * @return id tema
     */
    public int getId_tema() {
        return id_tema;
    }

    /**
     *Asigna el id del tema
     * @param id_tema
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    /**
     *Regresa el correo de la persona que asigno el marcador
     * @return correo marcador
     */
    public String getCorreo_inf() {
        return correo_inf;
    }

    /**
     *Asigna el correo al marcador
     * @param correo_inf
     */
    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }

    /**
     *Regresa el nombre del marcador
     * @return nombre marcador
     */
    public String getNombre_mar() {
        return nombre_mar;
    }

    /**
     *Asigna nombre del marcador
     * @param nombre_mar
     */
    public void setNombre_mar(String nombre_mar) {
        this.nombre_mar = nombre_mar;
    }

    /**
     *Regresa la descripcion del marcador
     * @return Descripcion del marcador
     */
    public String getDescripcion_mar() {
        return descripcion_mar;
    }

    /**
     *Asigna la descripcion del marcador
     * @param descripcion_mar
     */
    public void setDescripcion_mar(String descripcion_mar) {
        this.descripcion_mar = descripcion_mar;
    }   
    
    /**
     *Regresa la longitud del marcador
     * @return longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     *Asigna la longitud al marcador
     * @param longitud
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }   

    /**
     *Regresa la latitud del marcador
     * @return latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     *Asigna la latitud del marcador
     * @param latitud
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }   
}
