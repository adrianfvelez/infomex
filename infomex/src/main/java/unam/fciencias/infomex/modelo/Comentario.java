
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
 * 
 * Clase que representa a los comnetarios como están 
 * definidos en la base de datos (.sql).
 * Así que establecemos sus especificamos su nombre en la base,
 * bajo que nombre estará (infomex) y su "schema".
 * 
 * Como la llama principal (PK) del comentario es su id, 
 * entonces definimos este atributo como un númer "serial".
 */

@Entity
@Table(catalog = "infomex", schema = "public", name = "comentario")
public class Comentario{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name = "id_comentario")
    private int id_comentario;
    
    @Column(name = "id_tema")
    private int id_tema;
    
    @Column(name = "id_mar")
    private int id_mar;
    
    @Column(name = "correo_com")
    private String correo_com;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "calificacion")
    private int calificacion;
    
    /**
     * Getter del id del comentario
     * @return id_comentario del comentario
     */
    public int getId_comentario() {
        return id_comentario;
    }
    /**
     * Setter del id del comentario
     * @param id_comentario del comentario
     */
    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }
    
    /**
     * Getter del id del marcador
     * @return id_mar id del marcador
     */
    public int getId_mar() {
        return id_mar;
    }
    /**
     * Setter del id del marcador
     * @param id_mar id del marcador
     */
    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    /**
     * Getter del id del tema
     * @return id_tema id del tema
     */
    public int getId_tema() {
        return id_tema;
    }
    /**
     * Setter del id del tema
     * @param id_tema id del tema
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    /**
     * Getter del correo del comentarista que crea
     * el comentario
     * @return correo_com correo del comentarista
     */
    public String getCorreo_com() {
        return correo_com;
    }
    /**
     * Setter del correo del comentarista que crea
     * el comentario
     * @param correo_com correo del comentarista
     */
    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }
    
    /**
     * Getter de la descripción del comentario
     * @return descripcion descripción del comentario
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter de la descripción del comentario
     * @param descripcion descripción del comentario
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter de la califiación del comentario
     * @return calificacion califiación del comentario
     */
    public int getCalificacion() {
        return calificacion;
    }
    /**
     * Setter de la califiación del comentario
     * @param calificacion califiación del comentario
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }    
    
}
