package arriendo.beans.sitios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Instituciones;
import arriendo.entidades.GEN_Sectores;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author Juan Carlos Estévez Hidalgo
 *
 */
@SessionScoped
@ManagedBean
public class SectorBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;

	private Integer sec_id;
	private String sec_nombre;
	private String sec_direccion;
	private char sec_estado;
	private String sec_ubicacion;
	private Integer institucion;
	private boolean edicion;
	
	//Datos de Mapas
	private MapModel geoModel;
	private String centerGeoMap = "-1.7864639,-78.1368874";
	private Marker marca;
	
	private GEN_Sectores sele;
	

	public SectorBean() {
		manager = new SitiosDAO();
		edicion = false;
		geoModel = new DefaultMapModel();
		
		//Adicion de latitud y longitud del mapa de inicio
        LatLng coord1 = new LatLng(-0.198157, -78.489996);
        LatLng coord2 = new LatLng(0.410685, -78.176388);
          
        //Marcadores basicos de los puntos definidos
        geoModel.addOverlay(new Marker(coord1, "Yachay Empresa Publica"));
        geoModel.addOverlay(new Marker(coord2, "Yachay Ciudad del Conocimiento"));
	}

	/**
	 * @return the sele
	 */
	public GEN_Sectores getSele() {
		return sele;
	}

	/**
	 * @param sele the sele to set
	 */
	public void setSele(GEN_Sectores sele) {
		this.sele = sele;
	}

	/**
	 * @return the sms
	 */
	public Mensaje getSms() {
		return sms;
	}

	/**
	 * @param sms
	 *            the sms to set
	 */
	public void setSms(Mensaje sms) {
		this.sms = sms;
	}

	/**
	 * @return the edicion
	 */
	public boolean isEdicion() {
		return edicion;
	}

	/**
	 * @param edicion
	 *            the edicion to set
	 */
	public void setEdicion(boolean edicion) {
		this.edicion = edicion;
	}

	/**
	 * @return the sec_id
	 */
	public Integer getSec_id() {
		return sec_id;
	}

	/**
	 * @param sec_id
	 *            the sec_id to set
	 */
	public void setSec_id(Integer sec_id) {
		this.sec_id = sec_id;
	}

	/**
	 * @return the sec_nombre
	 */
	public String getSec_nombre() {
		return sec_nombre;
	}

	/**
	 * @param sec_nombre
	 *            the sec_nombre to set
	 */
	public void setSec_nombre(String sec_nombre) {
		this.sec_nombre = sec_nombre;
	}

	/**
	 * @return the institucion
	 */
	public Integer getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion the institucion to set
	 */
	public void setInstitucion(Integer institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return the sec_direccion
	 */
	public String getSec_direccion() {
		return sec_direccion;
	}

	/**
	 * @param sec_direccion
	 *            the sec_direccion to set
	 */
	public void setSec_direccion(String sec_direccion) {
		this.sec_direccion = sec_direccion;
	}

	/**
	 * @return the sec_estado
	 */
	public char getSec_estado() {
		return sec_estado;
	}

	/**
	 * @param sec_estado
	 *            the sec_estado to set
	 */
	public void setSec_estado(char sec_estado) {
		this.sec_estado = sec_estado;
	}

	/**
	 * @return the sec_ubicacion
	 */
	public String getSec_ubicacion() {
		return sec_ubicacion;
	}

	/**
	 * @param sec_ubicacion
	 *            the sec_ubicacion to set
	 */
	public void setSec_ubicacion(String sec_ubicacion) {
		this.sec_ubicacion = sec_ubicacion;
	}

	/**
	 * @return the geoModel
	 */
	public MapModel getGeoModel() {
		return geoModel;
	}

	/**
	 * @param geoModel the geoModel to set
	 */
	public void setGeoModel(MapModel geoModel) {
		this.geoModel = geoModel;
	}

	/**
	 * @return the centerGeoMap
	 */
	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	/**
	 * @param centerGeoMap the centerGeoMap to set
	 */
	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}

	public List<GEN_Sectores> getListSector() {
		return manager.findAllSector();
	}

	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevoSector() {
		edicion = false;
		return "nsector?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de un sector
	 * 
	 * @return
	 */
	public String crearSector() {
		String r = "";
		try {
			if (edicion) {
				if (institucion==-1){
					Mensaje.crearMensajeERROR("Seleccione una Institución");
					r="nsector?faces-redirect=true";
				} else{
				manager.editarSector(sec_id, sec_nombre, sec_direccion,
						sec_ubicacion, institucion, sec_estado);
				Mensaje.crearMensajeINFO("Actualizado - Insitucion Modificada");
				r = "sector?faces-redirect=true";}
			} else {
				if (institucion==-1 || institucion ==null){
					Mensaje.crearMensajeERROR("Seleccione una Institución");
					r="nsector?faces-redirect=true";
				} else{
				manager.insertarSector(sec_nombre, sec_direccion, sec_ubicacion, institucion);
				Mensaje.crearMensajeINFO("Registrado - Insitucion Creada");
				r = "sector?faces-redirect=true";}
			}
			// limpiar datos
			sec_id = 0;
			sec_nombre = "";
			sec_direccion = "";
			sec_ubicacion = "";
			sec_estado = 'A';
			institucion = 0;
			edicion = false;
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
		return r;
	}

	/**
	 * Metodo para cargar la entidad
	 * 
	 * @param t
	 * @return
	 */
	public String cargarSector(GEN_Sectores t) {
		sec_id = t.getSec_id();
		sec_nombre = t.getSec_nombre();
		sec_ubicacion = t.getSec_ubicacion();
		sec_direccion = t.getSec_direccion();
		sec_estado = t.getSec_estado();
		institucion = t.getIns().getIns_id();
		edicion = true;
		return "nsector?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear sector
	 * 
	 * @return
	 */
	public String cancelar() {
		// limpiar datos
		sec_id = 0;
		sec_nombre = "";
		sec_direccion = "";
		sec_ubicacion = "";
		sec_estado = 'A';
		institucion = 0;
		edicion = false;
		return "sector?faces-redirect=true";
	}

	/**
	 * Lista de estados /////////////////////metodo a repetir//////////////////////////////
	 * 
	 * @return lista de todos los estados
	 */
	public List<SelectItem> getlistEstados() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Estados> completo = manager.findAllEstados();
		for (GEN_Estados est : completo) {
			lista.add(new SelectItem(est.getEst_id(), est.getEst_id() + " : "
					+ est.getEst_nombre()));
		}
		return lista;
	}
	/**
	 * Lista de instituciones
	 * 
	 * @return lista de todos las instituciones
	 */
	public List<SelectItem> getlistInstitucion() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Instituciones> completo = manager.findAllInstituciones();
		for (GEN_Instituciones s : completo) {
			if (s.getIns_estado()=='A'){
			lista.add(new SelectItem(s.getIns_id(), s.getIns_nombre()));
		}
		}
		return lista;
	}

	 /**
	  * metodo para asignar un punto de geolocalización a sec_ubicacion
	 * @param event
	 */
	public void onMarca(OverlaySelectEvent event) {
	        marca = (Marker) event.getOverlay();
	        setSec_ubicacion(marca.getLatlng().getLat()+","+marca.getLatlng().getLng());
	        System.out.println(getSec_ubicacion());
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Punto Seleccionado:",marca.getTitle()));
	    }
	
	/**
	  * metodo para asignar un punto de geolocalización a sec_ubicacion
	 * @param event
	 */
	 public void onMarca2(PointSelectEvent event) {
		 	LatLng latlng = event.getLatLng();
	        setSec_ubicacion(latlng.getLat()+","+latlng.getLng());
	        System.out.println(getSec_ubicacion());
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Punto Seleccionado:","Lugar asignado"));
	    }
	 
	 /**
	  * metodo para mostrar los mapas y sus puntos
	 * @param se
	 */
	 public void Mapa (GEN_Sectores se){
		 setSele(se);
		 RequestContext.getCurrentInstance().execute("PF('dlg').show()");
		 System.out.println(sele.getSec_ubicacion());
	 }

}
