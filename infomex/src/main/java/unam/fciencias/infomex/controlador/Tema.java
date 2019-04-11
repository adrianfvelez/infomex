/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author oscar
 */
public class Tema {
    
    private int id_tema;
    
    /**
     * Método que regresa un entero.
     * @return Un entero
     */
    public int getId_tema() {
        return id_tema;
    }
    
    /**
     * Método que asigna un entero.
     * @param id_tema 
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }
    
    private String nombre_tema;
    
    /**
     * Método que recibe una cadena.
     * @param nombre_tema 
     */
    public void setNombre_tema(String nombre_tema) {
        this.nombre_tema = nombre_tema;
    }
    
    /**
     * Método que obtiene un a cadena.
     * @return Una cadena
     */
    public String getNombre_tema() {
        return nombre_tema;
    }
    
    private String correo_inf;
    
    /**
     * Método que obtiene una cadena.
     * @return Una cadena.
     */
    public String getCorreo_inf() {
        return correo_inf;
    }
    
    /**
     * Método que asigna una cadena.
     * @param correo_inf 
     */
    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }
}
