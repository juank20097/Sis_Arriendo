package arriendo.beans.sitios;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import arriendo.entidades.GEN_Estado;
import arriendo.entidades.GEN_Institucion;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author jestevez
 *
 */
@SessionScoped
@ManagedBean
public class EstadoBean {

	// Atributos de la Clase
	private SitiosDAO manager;

	 private Integer est_id;
	 private String est_tipo;
	 private String est_descripcion;
	 private Boolean edicion;

	public EstadoBean() {
		manager = new SitiosDAO();
		edicion = false;
	}

	/**
	 * @return the est_id
	 */
	public Integer getEst_id() {
		return est_id;
	}

	/**
	 * @param est_id the est_id to set
	 */
	public void setEst_id(Integer est_id) {
		this.est_id = est_id;
	}

	/**
	 * @return the est_tipo
	 */
	public String getEst_tipo() {
		return est_tipo;
	}

	/**
	 * @param est_tipo the est_tipo to set
	 */
	public void setEst_tipo(String est_tipo) {
		this.est_tipo = est_tipo;
	}

	/**
	 * @return the est_descripcion
	 */
	public String getEst_descripcion() {
		return est_descripcion;
	}

	/**
	 * @param est_descripcion the est_descripcion to set
	 */
	public void setEst_descripcion(String est_descripcion) {
		this.est_descripcion = est_descripcion;
	}

	public List<GEN_Estado> getListEstado() {
		return manager.findAllEstado();
	}

	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevoEstado() {
		edicion = false;
		return "nestado?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de una bicicleta
	 * 
	 * @return
	 */
	public String crearEstado() {
		String r="";
		try {
			if (edicion) {
				manager.editarEstado(est_id, est_tipo, est_descripcion);
				Mensaje.crearMensajeINFO("Actualizado - Estado Modificada");
			} else {
				manager.insertarEstado(est_tipo, est_descripcion);
				Mensaje.crearMensajeINFO("Registrado - Estado Creada");
			}
			r = "estado?faces-redirect=true";
			//limpiar datos
			est_id = 0;
			est_tipo = "";
			est_descripcion = "";
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
	public String cargarEstado(GEN_Estado t) {
		est_id = t.getEst_id();
		est_tipo = t.getEst_tipo();
		est_descripcion = t.getEst_descripcion();
		edicion = true;
		return "nestado?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear Institucion
	 * @return
	 */
	public String cancelar(){
		//limpiar datos
		est_id = 0;
		est_tipo = "";
		est_descripcion = "";
		edicion = false;
		return "estado?faces-redirect=true";
	}

}
