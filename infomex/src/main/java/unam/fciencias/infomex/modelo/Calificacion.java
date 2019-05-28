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
}
