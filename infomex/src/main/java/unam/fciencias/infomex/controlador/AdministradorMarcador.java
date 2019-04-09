package unam.fciencias.infomex.controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import java.util.Random;

import unam.fciencias.infomex.modelo.Marcador;
import unam.fciencias.infomex.modelo.UtilidadMarcador;

@ManagedBean
@ViewScoped
public class AdministradorMarcador implements Serializable {
    
    private Marcador user = new Marcador();
    private UtilidadMarcador u = new UtilidadMarcador();
    
    private int id_mar;
    
    private int id_tema;

    private String correo_inf;

    private String nombre_mar;

    private String descripcion_mar;

    private double longitud;

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
    
    
    
    
    
    private MapModel simpleModel;
    
    private Marker marker;
  
    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();
        
        List<Marcador> listaCompleta = u.getTodosMarcadores();
        
        if(listaCompleta!=null){
            for(Marcador marca : listaCompleta){
                LatLng coord = new LatLng(marca.getLatitud(), marca.getLongitud());
                simpleModel.addOverlay(new Marker(coord, marca.getNombre_mar(),marca));
            }
        }
        //Coordenadas del marcador inicial
        LatLng coord1 = new LatLng(19.432590, -99.131205);
          
        //Ponemos el marcador en el mapa
        simpleModel.addOverlay(new Marker(coord1, "Ciudad de Mexico"));
    }
  
    public void setSimpleModel(MapModel a){
        simpleModel = a;
    }
    
    
    public MapModel getSimpleModel() {
        return simpleModel;
    }
    
    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
      
    public Marker getMarker() {
        return marker;
    }
    
    
    
    
    
    
    
    public void eliminaMarcador() {
        u.delete( (Marcador) marker.getData());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Marcador eliminado"));
        
    }
    
    
    public String agregaMarcador() {
        Marker marke = new Marker(new LatLng(latitud, longitud), nombre_mar);
        simpleModel.addOverlay(marke);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marcador añadido", "Lat:" + latitud + ", Lng:" + longitud));
        
        Random rand = new Random();
        int randomNum = rand.nextInt((10000 - 1) + 1) + 1;
        
        //user.setId_mar(randomNum);
        user.setLatitud(latitud);
        user.setLongitud(longitud);
        user.setNombre_mar(nombre_mar);
        user.setDescripcion_mar(descripcion_mar);
        user.setCorreo_inf("admin");
        user.setId_tema(1);
        
        u.save(user);
        //user=null;
        return null;
    }
    
    
    
}
