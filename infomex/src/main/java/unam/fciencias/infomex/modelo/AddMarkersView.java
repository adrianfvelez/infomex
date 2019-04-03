package unam.fciencias.infomex.modelo;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class AddMarkersView implements Serializable {
     
    private MapModel emptyModel;
    
    private int id_mar;
    
    private int id_tema;

    private String correo_inf;

    private String nombre_mar;

    private String descripcion_mar;

    private double longitud;

    private double latitud;
      
    private String title;
      
    private double lat;
      
    private double lng;
  
    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }
      
    public MapModel getEmptyModel() {
        return emptyModel;
    }
    
    
    
    public String getTitle() {
        return title;
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
  
    public double getLat() {
        return lat;
    }
  
    public void setLat(double lat) {
        this.lat = lat;
    }
  
    public double getLng() {
        return lng;
    }
  
    public void setLng(double lng) {
        this.lng = lng;
    }
    
    public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marcador añadido", "Lat:" + lat + ", Lng:" + lng));
    }
}