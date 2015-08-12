package arriendo.beans.sitios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Instituciones;
import arriendo.entidades.GEN_Sectores;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author Juan Carlos Est�vez Hidalgo
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
	private boolean edicion;
	
	//mapa
	private MapModel geoModel;
	private String centerGeoMap = "-1.7864639,-78.1368874";
	

	public SectorBean() {
		manager = new SitiosDAO();
		edicion = false;
		geoModel = new DefaultMapModel();
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
				manager.editarSector(sec_id, sec_nombre, sec_direccion,
						sec_ubicacion, sec_estado);
				Mensaje.crearMensajeINFO("Actualizado - Insitucion Modificada");
			} else {
				manager.insertarSector(sec_nombre, sec_direccion, sec_ubicacion);
				Mensaje.crearMensajeINFO("Registrado - Insitucion Creada");
			}
			r = "sector?faces-redirect=true";
			// limpiar datos
			sec_id = 0;
			sec_nombre = "";
			sec_direccion = "";
			sec_ubicacion = "";
			sec_estado = 'A';
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
	 * @return lista de todos los estados
	 */
	public List<SelectItem> getlistInstitucion() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Instituciones> completo = manager.findAllInstituciones();
		for (GEN_Instituciones s : completo) {
			lista.add(new SelectItem(s.getIns_id(), s.getIns_nombre()));
		}
		return lista;
	}
	
	 public void onGeocode(GeocodeEvent event) {
	        List<GeocodeResult> results = event.getResults();
	         
	        if (results != null && !results.isEmpty()) {
	            LatLng center = results.get(0).getLatLng();
	            centerGeoMap = center.getLat() + "," + center.getLng();
	             
	            for (int i = 0; i < results.size(); i++) {
	                GeocodeResult result = results.get(i);
	                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
	            }
	        }
	    }

}
