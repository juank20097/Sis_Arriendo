package arriendo.beans.sitios;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Institucion;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author jestevez
 *
 */
@SessionScoped
@ManagedBean
public class InstitucionBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;

	private Integer ins_id;
	private String ins_nombre;
	private String ins_descripcion;
	private char ins_estado;
	private boolean edicion;

	public InstitucionBean() {
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
	 * @return the ins_id
	 */
	public Integer getIns_id() {
		return ins_id;
	}

	/**
	 * @param ins_id
	 *            the ins_id to set
	 */
	public void setIns_id(Integer ins_id) {
		this.ins_id = ins_id;
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

	/**
	 * @return the ins_nombre
	 */
	public String getIns_nombre() {
		return ins_nombre;
	}

	/**
	 * @param ins_nombre
	 *            the ins_nombre to set
	 */
	public void setIns_nombre(String ins_nombre) {
		this.ins_nombre = ins_nombre;
	}

	/**
	 * @return the ins_descripcion
	 */
	public String getIns_descripcion() {
		return ins_descripcion;
	}

	/**
	 * @param ins_descripcion
	 *            the ins_descripcion to set
	 */
	public void setIns_descripcion(String ins_descripcion) {
		this.ins_descripcion = ins_descripcion;
	}

	/**
	 * @return the ins_estado
	 */
	public char getIns_estado() {
		return ins_estado;
	}

	/**
	 * @param ins_estado
	 *            the ins_estado to set
	 */
	public void setIns_estado(char ins_estado) {
		this.ins_estado = ins_estado;
	}

	public List<GEN_Institucion> getListInstitucion() {
		return manager.findAllInstituciones();
	}

	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevaInstitucion() {
		edicion = false;
		return "ninstitucion?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de una bicicleta
	 * 
	 * @return
	 */
	public String crearInstitucion() {
		String r="";
		try {
			if (edicion) {
				manager.editarInstitucion(ins_id, ins_nombre, ins_descripcion,
						ins_estado);
				Mensaje.crearMensajeINFO("Actualizado - Insitucion Modificada");
			} else {
				manager.insertarInstitucion(ins_nombre, ins_descripcion);
				Mensaje.crearMensajeINFO("Registrado - Insitucion Creada");
			}
			r = "institucion?faces-redirect=true";
			//limpiar datos
			ins_id = 0;
			ins_nombre = "";
			ins_descripcion = "";
			ins_estado = 1;
			edicion = false;
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
		return r;
	}

	/**
	 * @param t
	 * @return
	 */
	public String cargarInstitucion(GEN_Institucion t) {
		ins_id = t.getIns_id();
		ins_nombre = t.getIns_nombre();
		ins_descripcion = t.getIns_descripcion();
		ins_estado = t.getIns_estado();
		edicion = true;
		return "ninstitucion?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear Institucion
	 * @return
	 */
	public String cancelar(){
		//limpiar datos
		ins_id = 0;
		ins_nombre = "";
		ins_descripcion = "";
		ins_estado = 'A';
		edicion = false;
		return "institucion?faces-redirect=true";
	}

	/**
	 * Lista de estados
	 */
	public List<SelectItem> getlistEstados(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Estados> completo = manager.findAllEstados();
		for (GEN_Estados est : completo) {
			lista.add(new SelectItem(est.getEst_id(), est.getEst_id()+" : "+est.getEst_nombre()));
		}
		return lista;
	}
	
	
}
