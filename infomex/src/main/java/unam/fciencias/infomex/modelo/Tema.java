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
 * @author oscar
 */

@Entity
@Table(catalog = "infomex", schema = "public", name = "tema")
public class Tema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "id_tema")
    private int id_tema;
    
    @Column(name = "nombre_tema")
    private String nombre_tema;
    
    @Column(name = "correo_inf")
    private String correo_inf;
    
    /**
     * Método que obtiene el correro como cadena del infomador que creo el Tema
     * @return Una cadena
     */
    public String getCorreo_inf() {
        return correo_inf;
    }
    
    /**
     * Método que vuelve cadena el correo del infomador que creo el Tema
     * @param correo_inf 
     */
    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }
    
    /**
     * Método que obtiene como entero el ID del Tema
     * @return Un entero
     */
    public int getId_tema() {
        return id_tema;
    }

    /**
     * Método que asigna un ID al tema 
     * @param id_tema 
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }
    
    /**
     * Método que obtiene como cadena el nombre del Tema
     * @return Una cadena
     */
    public String getNombre_tema() {
        return nombre_tema;
    }
    
    /**
     * Método que asigna como cadena el nombre del Tema
     * @param nombre_tema 
     */
    public void setNombre_tema(String nombre_tema) {
        this.nombre_tema = nombre_tema;
    }
        
}
