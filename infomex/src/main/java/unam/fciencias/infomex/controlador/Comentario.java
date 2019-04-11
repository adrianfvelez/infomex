/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

/**
 *
 * @author a-valderrama
 * 
 * Clase que modela los atributos del comentarios definidos
 * en la base de datos.
 * Esta abstracción de comentario no es la que establece las
 * llaves, ni las relaciones de llaves "dependientes, de las
 * tablas de comentario (.sql); más bien es necesaria para el 
 * controlador.
 */
public class Comentario {
    
    private int id_comentario;
            
    private int id_mar;

    private int id_tema;

    private String correo_com;

    private String descripcion;

    private int calificacion;
    
    /**
     * Setter del id del comentario
     * @param id_comentario id del comentario
     */
    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }
    /**
     * Getter del id del comentario
     * @return id_comentario id del comentario
     */
    public int getId_comentario() {
        return id_comentario;
    }
    
    /**
     * Getter del id del marcador asociado al comentario
     * @return id_mar id del marcador
     */
    public int getId_mar() {
        return id_mar;
    }
    /**
     * Setter del id del marcador asociado al comentario
     * @param id_mar del marcador
     */
    public void setId_mar(int id_mar) {
        this.id_mar = id_mar;
    }

    /**
     * Getter del id del tema asociado al comentario
     * @return id_tema del tema
     */
    public int getId_tema() {
        return id_tema;
    }
    /**
     * Setter del id del tema asociado al comentario
     * @return id_tema id del tema
     */
    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }
    
    /**
     * Getter del correo del comentarista que ha creado 
     * el comentario
     * @return correo_com correo del comentarista
     */
    public String getCorreo_com() {
        return correo_com;
    }
    /**
     * Setter del del correo del comentarista que ha creado 
     * el comentario
     * @param correo_com correo del comentarista
     */
    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }
    
    /**
     * Getter de la descripción del comentario
     * @return descripcion del comentario
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
     * Getter de la calificación del comentario
     * @return calificacion calififación del comentario
     */
    public int getCalificacion() {
        return calificacion;
    }
    /**
     * Setter de la calificación del comentario
     * @param calificacion calififación del comentario
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}