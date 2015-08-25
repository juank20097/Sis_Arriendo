package arriendo.beans.sitios;


import java.util.ArrayList;
import java.util.List;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;





import arriendo.entidades.ARR_SitiosArticulos;
import arriendo.entidades.GEN_Articulos;
import arriendo.entidades.GEN_Sitios;
import arriendo.generico.Mensaje;
import arriendo.manager.SitiosDAO;

/**
 * @author jestevez
 *
 */
@SessionScoped
@ManagedBean
public class AsignacionBean {

	// Atributos de la Clase
	private SitiosDAO manager;
	private Mensaje sms;
	
	//asigancion de articulos a sitios
	private Integer saId;
	private Integer sel_sitio;
	private Integer sel_articulo;
	
	private List<ARR_SitiosArticulos> sa;
	
	public AsignacionBean() {
		manager = new SitiosDAO();
		sa = new ArrayList<ARR_SitiosArticulos>();
	}

	/**
	 * @return the sa
	 */
	public List<ARR_SitiosArticulos> getSa() {
		return sa;
	}

	/**
	 * @param sa the sa to set
	 */
	public void setSa(List<ARR_SitiosArticulos> sa) {
		this.sa = sa;
	}

	/**
	 * @return the saId
	 */
	public Integer getSaId() {
		return saId;
	}

	/**
	 * @param saId the saId to set
	 */
	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	/**
	 * @return the sel_sitio
	 */
	public Integer getSel_sitio() {
		return sel_sitio;
	}

	/**
	 * @param sel_sitio the sel_sitio to set
	 */
	public void setSel_sitio(Integer sel_sitio) {
		this.sel_sitio = sel_sitio;
	}

	/**
	 * @return the sel_articulo
	 */
	public Integer getSel_articulo() {
		return sel_articulo;
	}

	/**
	 * @param sel_articulo the sel_articulo to set
	 */
	public void setSel_articulo(Integer sel_articulo) {
		this.sel_articulo = sel_articulo;
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



	public List<ARR_SitiosArticulos> getListSarticulos() {
		return manager.findAllSitiosArticulos();
	}


	/**
	 * Permite la creacion o modificacion de una bicicleta
	 * 
	 * @return
	 */
	public String crearSarticulo() {
		String r = "";
		Integer u=0;
		List<ARR_SitiosArticulos> asa= manager.findAllSitiosArticulos();
		try {
			System.out.println(sel_articulo);
			System.out.println(sel_sitio);
			if (asa.size()==0){
				manager.insertarSArticulos(sel_articulo, sel_sitio);
				Mensaje.crearMensajeINFO("Asignación Realizada");
			}else{
			for (ARR_SitiosArticulos t : asa) {
			if (t.getArt_id()==sel_articulo && t.getSit().getSit_id()==sel_sitio){
				u=10000;
			}else{
				u++;
			}
			}
			if (u==asa.size()){
				manager.insertarSArticulos(sel_articulo, sel_sitio);
				Mensaje.crearMensajeINFO("Asignación Realizada");
				System.out.println("asig_realizada");
			}else{
				Mensaje.crearMensajeERROR("El Sitio ya cuenta con ese Artículo");
			}
			}
			this.listadeUno();
			r = "articuloSitios";
			// limpiar datos
			saId=0;
			sel_articulo=0;
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
		return r;
	}
	
	
		
		/**
		 * Lista 
		 * 
		 * @return lista de todas
		 */
		public List<SelectItem> getlistArticulos2() {
			List<SelectItem> lista = new ArrayList<SelectItem>();
			List<GEN_Articulos> completo = manager.findAllArticulos();
			for (GEN_Articulos s : completo) {
				if (s.getArt_estado()=='A'){
				lista.add(new SelectItem(s.getArt_id(), s.getArt_nombre()));
				}
				}
			return lista;
		}
		
		/**
		 * Lista 
		 * 
		 * @return lista de todas
		 */
		public List<SelectItem> getlistSitios2() {
			List<SelectItem> lista = new ArrayList<SelectItem>();
			List<GEN_Sitios> completo = manager.findAllSitios();
			for (GEN_Sitios s : completo) {
				if (s.getSit_estado()=='A'){
				lista.add(new SelectItem(s.getSit_id(), s.getSit_nombre()));
				}
				}
			return lista;
		}

	public List<ARR_SitiosArticulos> listadeUno(){
		sa = new ArrayList<ARR_SitiosArticulos>();
		List<ARR_SitiosArticulos> sart = manager.findAllSitiosArticulos();
		for (ARR_SitiosArticulos arr : sart) {
			if (sel_sitio==arr.sit.getSit_id()){
				sa.add(arr);
			}
		}
		System.out.println(sel_sitio);
		return sa;
	}
	
	public void eliminar(ARR_SitiosArticulos a){
		manager.eliminarSArticulo(a.getSaId());
		this.listadeUno();
	}
	
	public String versitio(Integer id){
		GEN_Sitios s;
		String h="";
		try {
			s = manager.SitioByID(id);
			h=s.getSit_nombre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
		}
	
	public String verarticulo(Integer id){
		GEN_Articulos s;
		String h="";
		try {
			s = manager.ArticulosByID(id);
			h=s.getArt_nombre();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
		}
	
}
