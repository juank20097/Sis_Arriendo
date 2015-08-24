package arriendo.beans.sitios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import arriendo.entidades.GEN_Articulos;
import arriendo.entidades.GEN_Estados;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author jestevez
 *
 */
@SessionScoped
@ManagedBean
public class ArticuloBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;

	private Integer art_id;
	private String art_nombre;
	private String art_descripcion;
	private String art_serial;
	private Float art_valor_referenciado;
	private char art_estado;
	private String art_imagen;
	private boolean edicion;
	
	private GEN_Articulos articulo;
	
	private UploadedFile file;
	private String g;

	public ArticuloBean() {
		manager = new SitiosDAO();
		edicion = false;
	}

	/**
	 * @return the articulo
	 */
	public GEN_Articulos getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(GEN_Articulos articulo) {
		this.articulo = articulo;
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
	 * @return the art_id
	 */
	public Integer getArt_id() {
		return art_id;
	}

	/**
	 * @param art_id
	 *            the art_id to set
	 */
	public void setArt_id(Integer art_id) {
		this.art_id = art_id;
	}

	/**
	 * @return the art_nombre
	 */
	public String getArt_nombre() {
		return art_nombre;
	}

	/**
	 * @param art_nombre
	 *            the art_nombre to set
	 */
	public void setArt_nombre(String art_nombre) {
		this.art_nombre = art_nombre;
	}

	/**
	 * @return the art_descripcion
	 */
	public String getArt_descripcion() {
		return art_descripcion;
	}

	/**
	 * @param art_descripcion
	 *            the art_descripcion to set
	 */
	public void setArt_descripcion(String art_descripcion) {
		this.art_descripcion = art_descripcion;
	}

	/**
	 * @return the art_serial
	 */
	public String getArt_serial() {
		return art_serial;
	}

	/**
	 * @param art_serial
	 *            the art_serial to set
	 */
	public void setArt_serial(String art_serial) {
		this.art_serial = art_serial;
	}

	/**
	 * @return the art_valor_referenciado
	 */
	public Float getArt_valor_referenciado() {
		return art_valor_referenciado;
	}

	/**
	 * @param art_valor_referenciado
	 *            the art_valor_referenciado to set
	 */
	public void setArt_valor_referenciado(Float art_valor_referenciado) {
		this.art_valor_referenciado = art_valor_referenciado;
	}

	/**
	 * @return the art_estado
	 */
	public char getArt_estado() {
		return art_estado;
	}

	/**
	 * @param art_estado
	 *            the art_estado to set
	 */
	public void setArt_estado(char art_estado) {
		this.art_estado = art_estado;
	}

	/**
	 * @return the art_imagen
	 */
	public String getArt_imagen() {
		return art_imagen;
	}

	/**
	 * @param art_imagen
	 *            the art_imagen to set
	 */
	public void setArt_imagen(String art_imagen) {
		this.art_imagen = art_imagen;
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

	public List<GEN_Articulos> getListArticulos() {
		return manager.findAllArticulos();
	}

	/**
	 * Redirecciona a la pagina de creacion de sitios
	 * 
	 * @return
	 */
	public String nuevoArticulo() {
		edicion = false;
		return "narticulo?faces-redirect=true";
	}

	/**
	 * Permite la creacion o modificacion de una bicicleta
	 * 
	 * @return
	 */
	public String crearArticulo() {
		String r = "";
		try {
			if (edicion) {
				manager.editarArticulo(art_id, art_nombre, art_descripcion, art_serial, art_valor_referenciado, art_imagen, art_estado);
				Mensaje.crearMensajeINFO("Actualizado - Insitucion Modificada");
			} else {
				if (art_imagen==null || art_imagen.isEmpty()){
					art_imagen="vacio.jpg";
				}
				manager.insertarArticulos(art_nombre, art_descripcion, art_serial, art_valor_referenciado, art_imagen);
				Mensaje.crearMensajeINFO("Registrado - Insitucion Creada");
			}
			r = "articulo?faces-redirect=true";
			// limpiar datos
			art_id = 0;
			art_nombre = "";
			art_descripcion = "";
			art_serial= "";
			art_valor_referenciado = (float) 0.0;
			art_imagen = "";
			art_estado = 'A';
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
	public String cargarArticulo(GEN_Articulos t) {
		art_id = t.getArt_id();
		art_nombre = t.getArt_nombre();
		art_descripcion = t.getArt_descripcion();
		art_serial = t.getArt_serial();
		art_valor_referenciado = t.getArt_valor_referenciado();
		art_imagen = t.getArt_imagen();
		if (art_imagen=="vacio.jpg"){
		art_imagen=t.getArt_nombre();
		}
		art_estado = t.getArt_estado();
		edicion = true;
		return "narticulo?faces-redirect=true";
	}

	/**
	 * Cancela la accion de modificar o crear Institucion
	 * 
	 * @return
	 */
	public String cancelar() {
		// limpiar datos
		art_id = 0;
		art_nombre = "";
		art_descripcion = "";
		art_serial= "";
		art_valor_referenciado = null;
		art_imagen = "";
		art_estado = 'A';
		edicion = false;
		return "articulo?faces-redirect=true";
	}

	/**
	 * Lista de estados
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
	
	// METODOS DE IMAGENES 
	
	// metodo para guardar la imagen en el servidor
		public void ImagenServ(FileUploadEvent event) throws IOException {
			file = event.getFile();
			InputStream inputStream = null;
			OutputStream outputStream = null;

			if (file != null) {
				try {
					// Tomar PAD REAL
					ServletContext servletContext = (ServletContext) FacesContext
							.getCurrentInstance().getExternalContext().getContext();
					String carpetaImagenes = (String) servletContext
							.getRealPath(File.separatorChar + "articulosImg");
					setArt_imagen(g);
					System.out.println("PAD------> " + carpetaImagenes);
					System.out.println("name------> " + getArt_imagen());
					outputStream = new FileOutputStream(new File(carpetaImagenes
							+ File.separatorChar + getArt_imagen()));
					inputStream = file.getInputstream();

					int read = 0;
					byte[] bytes = new byte[1024];

					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read);
					}

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Carga Correcta de Imagen", "Carga correcta"));

				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:",
									"no se pudo subir la imagen"));
					e.printStackTrace();
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}

					if (outputStream != null) {
						outputStream.close();
					}
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:",
								"no se pudo seleccionar la imagen"));
			}	
		}
		
		// metodo para poner el nombre a la imagen
		public void asignarNombreImagen() {
			if (getArt_nombre().trim().isEmpty()) {
				System.out.println("Vacio");
			} else {
				DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyyHHmm");
				g="img_"+getArt_nombre()+dateFormat.format(new Date())+".jpg";
				System.out.println(g);
			}

		}

}
