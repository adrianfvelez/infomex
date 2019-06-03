/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author avelez
 */

@Entity
@Table(catalog = "infomex", schema = "public", name = "comentarista")
public class Comentarista {
    
    @Id
    @Column(name = "correo_com")
    private String correo_com;
    
    @Column(name = "usuario_com")
    private String usuario_com;
    
    @Column(name = "contrasenia_com")
    private String contrasenia_com;
    
    public String getCorreo_com() {
        return correo_com;
    }

    public void setCorreo_com(String correo_com) {
        this.correo_com = correo_com;
    }

    public String getUsuario_com() {
        return usuario_com;
    }

    public void setUsuario_com(String usuario_com) {
        this.usuario_com = usuario_com;
    }

    public String getContrasenia_com() {
        return contrasenia_com;
    }

    public void setContrasenia_com(String contrasenia_com) {
        this.contrasenia_com = contrasenia_com;
    }
    
}
