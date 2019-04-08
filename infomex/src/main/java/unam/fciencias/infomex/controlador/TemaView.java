/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fciencias.infomex.controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author oscar
 */

@ManagedBean(name="dtTemaView")
@ViewScoped

public class TemaView {
    
    private List<Tema> temas;
    
    @ManagedProperty("#{eliminarTemas}")
    private EliminarTema tema;
    
    public List<Tema> getTemas(){
        return temas;
    }
    public void setTema(EliminarTema tema) {
        this.tema = tema;
    }
    
}
