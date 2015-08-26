package arriendo.beans.sitios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import arriendo.entidades.GEN_Areas;
import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Sitios;
import arriendo.entidades.GEN_TipoSitios;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author Juan Carlos Estévez Hidalgo
 *
 */
@SessionScoped
@ManagedBean
public class SitiosBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;

	private Integer sit_id;
	private String sit_nombre;
	private Double sit_costo_arriendo;
	private Integer sit_capacidad;
	private char sit_estado;

	private Integer area;
	private Integer tipositio;
	private boolean edicion;

	public SitiosBean() {
		manager = new SitiosDAO();
		edicion = false;
	}

	/**
	 * @return the tipositio
	 */
	public Integer getTipositio() {
		return tipositio;
	}

	/**
	 * @param tipositio the tipositio to set
	 */
	public void setTipositio(Integer tipositio) {
		this.tipositio = tipositio;
	}

	/**
	 * @return the sms
	 */
	public Mensaje getSms() {
		return sms;
	}

	/**
	 * @param sms the sms to set
	 */
	public void setSms(Mensaje sms) {
		this.sms = sms;
	}

	/**
	 * @return the sit_id
	 */
	public Integer getSit_id() {
		return sit_id;
	}

	/**
	 * @param sit_id
	 *            the sit_id to set
	 */
	public void setSit_id(Integer sit_id) {
		this.sit_id = sit_id;
	}

	/**
	 * @return the sit_nombre
	 */
	public String getSit_nombre() {
		return sit_nombre;
	}

	/**
	 * @param sit_nombre
	 *            the sit_nombre to set
	 */
	public void setSit_nombre(String sit_nombre) {
		this.sit_nombre = sit_nombre;
	}

	/**
	 * @return the sit_costo_arriendo
	 */
	public Double getSit_costo_arriendo() {
		return sit_costo_arriendo;
	}

	/**
	 * @param sit_costo_arriendo
	 *            the sit_costo_arriendo to set
	 */
	public void setSit_costo_arriendo(Double sit_costo_arriendo) {
		this.sit_costo_arriendo = sit_costo_arriendo;
	}

	/**
	 * @return the sit_capacidad
	 */
	public Integer getSit_capacidad() {
		return sit_capacidad;
	}

	/**
	 * @param sit_capacidad
	 *            the sit_capacidad to set
	 */
	public void setSit_capacidad(Integer sit_capacidad) {
		this.sit_capacidad = sit_capacidad;
	}

	
	/**
	 * @return the sit_estado
	 */
	public char getSit_estado() {
		return sit_estado;
	}

	/**
	 * @param sit_estado the sit_estado to set
	 */
	public void setSit_estado(char sit_estado) {
		this.sit_estado = sit_estado;
	}

	/**
	 * @return the area
	 */
	public Integer getArea() {
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(Integer area) {
		this.area = area;
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

	public List<GEN_Sitios> getListSitios() {
		return manager.findAllSitios();
	}
	
	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevoSitio() {
		edicion = false;
		return "nsitio?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de un sector
	 * 
	 * @return
	 */
	public String crearSitio() {
		String r = "";
		try {
			if (edicion) {
				if (area==-1 || tipositio==-1){
					Mensaje.crearMensajeERROR("Seleccione un Area o un Tipo de Sitio");
					r="nsitio?faces-redirect=true";
				} else{
				manager.editarSitio(sit_id, sit_nombre, sit_costo_arriendo, sit_capacidad, sit_estado, area, tipositio);
				Mensaje.crearMensajeINFO("Actualizado - Sitio Modificado");
				r = "sitio?faces-redirect=true";}
			} else {
				if (area==null || area==-1 || tipositio==null || tipositio==-1){
					Mensaje.crearMensajeERROR("Seleccione un Area o un Tipo de Sitio");
					r="nsitio?faces-redirect=true";
				}else{
				manager.insertarSitio(sit_nombre, sit_costo_arriendo, sit_capacidad, area, tipositio);
				Mensaje.crearMensajeINFO("Registrado - Sitio Creado");
				r = "sitio?faces-redirect=true";
				}
			}
			// limpiar datos
			sit_id = 0;
			sit_nombre = "";
			sit_costo_arriendo = 0.0;
			sit_capacidad = 0;
			sit_estado = 'A';
			area = 0;
			tipositio=0;
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
	public String cargarSitio(GEN_Sitios t) {
		sit_id = t.getSit_id();
		sit_nombre = t.getSit_nombre();
		sit_costo_arriendo = t.getSit_costo_arriendo();
		sit_capacidad = t.getSit_capacidad();
		sit_estado = t.getSit_estado();
		area = t.getAre().getAre_id();
		tipositio = t.getTsi().getTsi_id();
		edicion = true;
		return "nsitio?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear area
	 * 
	 * @return
	 */
	public String cancelar() {
		// limpiar datos
		sit_id = 0;
		sit_nombre = "";
		sit_costo_arriendo = 0.0;
		sit_capacidad = 0;
		sit_estado = 'A';
		area = 0;
		tipositio=0;
		edicion = false;
		return "sitio?faces-redirect=true";
	}

	/**
	 * Lista de estados /////////////////////metodo a
	 * repetir//////////////////////////////
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
	 * Lista 
	 * 
	 * @return lista de todas
	 */
	public List<SelectItem> getlistAreas() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Areas> completo = manager.findAllAreas();
		for (GEN_Areas s : completo) {
			if (s.getAre_estado()=='A'){
			lista.add(new SelectItem(s.getAre_id(), s.getAre_nombre()));
			}
			}
		return lista;
	}
	
	/**
	 * Lista 
	 * 
	 * @return lista de todas
	 */
	public List<SelectItem> getlistTipoSitios() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_TipoSitios> completo = manager.findAllTipoSitios();
		for (GEN_TipoSitios s : completo) {
			if (s.getTsi_estado()=='A'){
			lista.add(new SelectItem(s.getTsi_id(), s.getTsi_nombre()));
		}
		}
		return lista;
	}
	
}
