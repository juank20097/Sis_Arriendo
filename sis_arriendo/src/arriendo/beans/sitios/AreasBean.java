package arriendo.beans.sitios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import arriendo.entidades.GEN_Areas;
import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Sectores;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author Juan Carlos Estévez Hidalgo
 *
 */
@SessionScoped
@ManagedBean
public class AreasBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;

	private Integer are_id;
	private String are_nombre;
	private String are_descripcion;
	private char are_estado;
	private Integer sector;
	private boolean edicion;

	public AreasBean() {
		manager = new SitiosDAO();
		edicion = false;
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
	 * @return the are_id
	 */
	public Integer getAre_id() {
		return are_id;
	}

	/**
	 * @param are_id
	 *            the are_id to set
	 */
	public void setAre_id(Integer are_id) {
		this.are_id = are_id;
	}

	/**
	 * @return the are_nombre
	 */
	public String getAre_nombre() {
		return are_nombre;
	}

	/**
	 * @param are_nombre
	 *            the are_nombre to set
	 */
	public void setAre_nombre(String are_nombre) {
		this.are_nombre = are_nombre;
	}

	/**
	 * @return the are_descripcion
	 */
	public String getAre_descripcion() {
		return are_descripcion;
	}

	/**
	 * @param are_descripcion
	 *            the are_descripcion to set
	 */
	public void setAre_descripcion(String are_descripcion) {
		this.are_descripcion = are_descripcion;
	}

	/**
	 * @return the are_estado
	 */
	public char getAre_estado() {
		return are_estado;
	}

	/**
	 * @param are_estado
	 *            the are_estado to set
	 */
	public void setAre_estado(char are_estado) {
		this.are_estado = are_estado;
	}

	/**
	 * @return the sector
	 */
	public Integer getSector() {
		return sector;
	}

	/**
	 * @param sector
	 *            the sector to set
	 */
	public void setSector(Integer sector) {
		this.sector = sector;
	}

	/**
	 * @return the edicion
	 */
	public boolean isEdicion() {
		return edicion;
	}

	/**
	 * @param edicion the edicion to set
	 */
	public void setEdicion(boolean edicion) {
		this.edicion = edicion;
	}

	public List<GEN_Areas> getListAreas() {
		return manager.findAllAreas();
	}

	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevaArea() {
		edicion = false;
		return "narea?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de un sector
	 * 
	 * @return
	 */
	public String crearArea() {
		String r = "";
		try {
			if (edicion) {
				manager.editarArea(are_id, are_nombre, are_descripcion,
						are_estado, sector);
				Mensaje.crearMensajeINFO("Actualizado - Area Modificada");
			} else {
				manager.insertarArea(are_nombre, are_descripcion, sector);
				Mensaje.crearMensajeINFO("Registrado - Area Creada");
			}
			r = "area?faces-redirect=true";
			// limpiar datos
			are_id = 0;
			are_nombre = "";
			are_descripcion = "";
			are_estado = 'A';
			sector = 0;
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
	public String cargarArea(GEN_Areas t) {
		are_id = t.getAre_id();
		are_nombre = t.getAre_nombre();
		are_descripcion = t.getAre_descripcion();
		are_estado = t.getAre_estado();
		sector = t.getSec().getSec_id();
		edicion = true;
		return "narea?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear area
	 * 
	 * @return
	 */
	public String cancelar() {
		// limpiar datos
		are_id = 0;
		are_nombre = "";
		are_descripcion = "";
		are_estado = 'A';
		sector = 0;
		edicion = false;
		return "area?faces-redirect=true";
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
	 * Lista de instituciones
	 * 
	 * @return lista de todos las instituciones
	 */
	public List<SelectItem> getlistSectores() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Sectores> completo = manager.findAllSector();
		for (GEN_Sectores s : completo) {
			lista.add(new SelectItem(s.getSec_id(), s.getSec_nombre()));
		}
		return lista;
	}
}
