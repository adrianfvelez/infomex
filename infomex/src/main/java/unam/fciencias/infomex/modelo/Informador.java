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
 * @author avelez
 */
@Entity
@Table(catalog = "infomex", schema = "public", name = "informador")
public class Informador {
    
    @Id
    @Column(name = "correo_inf")
    private String correo_inf;

    @Column(name = "usuario_inf")
    private String usuario_inf;
    
    @Column(name = "contrasenia_inf")
    private String contrasenia_inf;

    public String getCorreo_inf() {
        return correo_inf;
    }

    public void setCorreo_inf(String correo_inf) {
        this.correo_inf = correo_inf;
    }

    public String getUsuario_inf() {
        return usuario_inf;
    }

    public void setUsuario_inf(String usuario_inf) {
        this.usuario_inf = usuario_inf;
    }

    public String getContrasenia_inf() {
        return contrasenia_inf;
    }

    public void setContrasenia_inf(String contrasenia_inf) {
        this.contrasenia_inf = contrasenia_inf;
    }
}
