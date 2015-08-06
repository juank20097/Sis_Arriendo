package arriendo.manager;

import java.util.List;

import arriendo.entidades.GEN_Area;
import arriendo.entidades.GEN_Articulos;
import arriendo.entidades.GEN_Estado;
import arriendo.entidades.GEN_Institucion;
import arriendo.entidades.GEN_Sector;
import arriendo.entidades.GEN_Sitios;

/**
 * Clase SitiosDAO permite manejar el HibernateDAO en conveniencia a la gestion
 * de sitios y articulos
 * 
 * @author Juan Carlos Estévez Hidalgo
 * @version 1.0
 *
 */

public class SitiosDAO {

	// Campos de la clase
	private HibernateDAO manager;

	// Campos de asignacion (Sitios)
	private GEN_Area area;
	// Campos de asignacion (Articulos)
	private GEN_Sitios sitio;
	// Campos de asignacion (Sector)
	private GEN_Institucion institucion;

	/**
	 * Constructor para la utilizacion de metodos de la clase HibernateDAO
	 * 
	 * @param manager
	 *            El parametro manager inicializa la utilizacion de la clase
	 *            HIbernateDAO y todos sus metodos
	 */
	public SitiosDAO() {
		manager = new HibernateDAO();
	}// Cierre del Constructor

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Area
	 * 
	 */

	/**
	 * Metodo para listar todas las Areas existentes
	 * 
	 * @return La lista de todas las Areas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Area> findAllAreas() {
		return manager.findAll(GEN_Area.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Area mediante un ID
	 * 
	 * @param id_area
	 *            Tipo integer de busqueda
	 * @return El objeto Area encontrado mediante el ID
	 */
	public GEN_Area AreaByID(Integer id_area) throws Exception {
		return (GEN_Area) manager.findById(GEN_Area.class, id_area);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Area a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena el nombre del Area
	 * @param ubicacion
	 *            Tipo String el cual almacena la ubicacion del Area
	 * @param descripcion
	 *            Tipo String el cual almacena la descripcion del lugar
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si el Area es
	 *            Activado/Desactivado
	 */
	public void insertarArea(String nombre, String ubicacion,
			String descripcion, String estado) throws Exception {
		try {
			GEN_Area p = new GEN_Area();
			p.setAre_nombre(nombre);
			p.setAre_descripcion(descripcion);
			p.setAre_estado(estado);
			manager.insertar(p);
			System.out.println("Bien_insertar_area");
		} catch (Exception e) {
			System.out.println("Error_insertar_area");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Area en la base de datos
	 * 
	 * @param id_area
	 *            Tipo Integer el cual sirve de busqueda
	 * @param nombre
	 *            Tipo String el cual almacena el nombre del Area
	 * @param ubicacion
	 *            Tipo String el cual almacena la ubicacion del Area
	 * @param descripcion
	 *            Tipo String el cual almacena la descripcion del lugar
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si es
	 *            Activado/Desactivado
	 */
	public void editarArea(Integer id_area, String nombre, String ubicacion,
			String descripcion, String estado) throws Exception {
		try {
			GEN_Area r = this.AreaByID(id_area);
			r.setAre_id(id_area);
			r.setAre_nombre(nombre);
			r.setAre_descripcion(descripcion);
			r.setAre_estado(estado);
			manager.actualizar(r);
			System.out.println("bien_mod_area");
		} catch (Exception e) {
			System.out.println("Error_mod_area");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo para eliminar un Area en la base de datos
	 * 
	 * @param id_area
	 *            Tipo Integer el cual sirve para su eliminacion
	 */
	public void eliminarArea(Integer id_area) {
		try {
			manager.eliminar(GEN_Area.class, id_area);
			System.out.println("Eliminar_area_correcto");
		} catch (Exception e) {
			System.out.println("Eliminar_area_incorrecto");
			e.printStackTrace();
		}
	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Sitios
	 * 
	 */

	/**
	 * Metodo para listar todos los Sitios existentes
	 * 
	 * @return La lista de todos los Sitios encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Sitios> findAllSitios() {
		return manager.findAll(GEN_Sitios.class);
	}// Cierre del metodo

	/**
	 * Metodo para obetener el Sitio mediante un ID
	 * 
	 * @param id_sitio
	 *            Tipo integer de busqueda
	 * @return El objeto Sitio encontrado mediante el ID
	 */
	public GEN_Sitios SitioByID(Integer id_sitio) throws Exception {
		return (GEN_Sitios) manager.findById(GEN_Sitios.class, id_sitio);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Sitio mediante un Nombre
	 * 
	 * @param nombre
	 *            Tipo String de busqueda
	 * @return El objeto Sitio encontrado mediante el Nombre
	 */
	public GEN_Sitios SitiobyNombre(String nombre) throws Exception {
		GEN_Sitios s = null;
		List<GEN_Sitios> li = findAllSitios();
		for (GEN_Sitios sitio : li) {
			if (sitio.getSit_identificador().equals(nombre)) {
				s = sitio;
			}
		}
		return s;
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Sitio a la base de datos
	 * 
	 * @param identificador
	 *            Tipo String el cual almacena el nombre para denotar el sitio
	 * @param costo
	 *            Tipo Double el cual almacena el costo mensual del sitio
	 * @param direccion
	 *            Tipo String el cual almacena la ubicacion del sitio
	 * @param capacidad
	 *            Tipo Integer el cual almacena el numero de personas permitidas
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si es
	 *            Activado/Desactivado
	 */
	public void insertarSitio(String identificador, Double costo,
			String direccion, Integer capacidad, Integer estado)
			throws Exception {
		try {
			GEN_Sitios p = new GEN_Sitios();
			p.setSit_identificador(identificador);
			p.setSit_costo_arriendo(costo);
			p.setSit_direccion(direccion);
			p.setSit_capacidad(capacidad);
			p.setSit_estado(estado);
			p.setAre(area);
			manager.insertar(p);
			System.out.println("Bien_insertar_area");
		} catch (Exception e) {
			System.out.println("Error_insertar_area");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Sitio a la base de datos
	 * 
	 * @param identificador
	 *            Tipo String el cual cambia el nombre para denotar el sitio
	 * @param costo
	 *            Tipo Double el cual cambia el costo mensual del sitio
	 * @param direccion
	 *            Tipo String el cual cambia la ubicacion del sitio
	 * @param capacidad
	 *            Tipo Integer el cual cambia el numero de personas permitidas
	 * @param estado
	 *            Tipo Integer el cual cambia el dato si es Activado/Desactivado
	 */
	public void editarSitio(String identificador, Double costo,
			String direccion, Integer capacidad, Integer estado)
			throws Exception {
		try {
			GEN_Sitios r = this.SitiobyNombre(identificador);
			r.setSit_identificador(identificador);
			r.setSit_costo_arriendo(costo);
			r.setSit_direccion(direccion);
			r.setSit_capacidad(capacidad);
			r.setSit_estado(estado);
			r.setAre(area);
			manager.actualizar(r);
			System.out.println("bien_mod_sitio");
		} catch (Exception e) {
			System.out.println("Error_mod_sitio");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo para asignar un Area a un Sitio en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo area con el dato correspondiente
	 */
	public GEN_Area asignarArea(Integer id) {
		try {
			area = this.AreaByID(id);
			System.out.println("Bien_asignar_Area");
		} catch (Exception e) {
			System.out.println("Mal_asignar_Area");
			e.printStackTrace();
		}
		return area;
	}// Cierre del metodo

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Creación de metodos para el manejo de la tabla GEN_Articulos
	 */

	/**
	 * Metodo para listar todos los Articulos existentes
	 * 
	 * @return La lista de todos los Articulos encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Articulos> findAllArticulos() {
		return manager.findAll(GEN_Articulos.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Articulo mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Articulo encontrado mediante el ID
	 */
	public GEN_Articulos ArticuloByID(Integer id) throws Exception {
		return (GEN_Articulos) manager.findById(GEN_Articulos.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Articulo a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena el nombre para denotar el
	 *            articulo
	 * @param descripcion
	 *            Tipo String el cual almacena el enfoque para el articulo
	 * @param serial
	 *            Tipo String el cual almacena el identificador del articulo
	 * @param valor
	 *            Tipo String el cual almacena el costo del articulo
	 * @param estado
	 *            Tipo Integer el cual almacena el estado del articulo
	 */
	public void insertarArticulo(String nombre, String descripcion,
			String serial, Float valor, Integer estado) throws Exception {
		try {
			GEN_Articulos p = new GEN_Articulos();
			p.setArt_nombre(nombre);
			p.setArt_descripcion(descripcion);
			p.setArt_serial(serial);
			p.setArt_valor_referenciado(valor);
			p.setArt_estado(estado);
			p.setSit(sitio);
			manager.insertar(p);
			System.out.println("Bien_insertar_articulo");
		} catch (Exception e) {
			System.out.println("Error_insertar_articulo");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Articulo a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual permite la busqueda del articulo
	 * @param nombre
	 *            Tipo String el cual edita el nombre para denotar el articulo
	 * @param descripcion
	 *            Tipo String el cual edita el enfoque para el articulo
	 * @param serial
	 *            Tipo String el cual edita el identificador del articulo
	 * @param valor
	 *            Tipo String el cual edita el costo del articulo
	 * @param estado
	 *            Tipo Integer el cual edita el estado del articulo
	 */
	public void editarArticulo(Integer id, String nombre, String descripcion,
			String serial, Float valor, Integer estado) throws Exception {
		try {
			GEN_Articulos r = this.ArticuloByID(id);
			r.setArt_nombre(nombre);
			r.setArt_descripcion(descripcion);
			r.setArt_serial(serial);
			r.setArt_valor_referenciado(valor);
			r.setArt_estado(estado);
			r.setSit(sitio);
			manager.actualizar(r);
			System.out.println("bien_mod_articulo");
		} catch (Exception e) {
			System.out.println("Error_mod_articulo");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo para asignar un Sitio a un Articulo en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo articulo con el dato correspondiente
	 */
	public GEN_Sitios asignarSitio(Integer id) {
		try {
			sitio = this.SitioByID(id);
			System.out.println("Bien_asignar_Sitio");
		} catch (Exception e) {
			System.out.println("Mal_asignar_Sitio");
			e.printStackTrace();
		}
		return sitio;
	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Institucion
	 * 
	 */

	/**
	 * Metodo para listar Institucion existentes
	 * 
	 * @return La lista de todas las Institucion encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Institucion> findAllInstituciones() {
		return manager.findAll(GEN_Institucion.class);
	}// Cierre del metodo

	/**
	 * Metodo para obetener Institucion mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Institucion encontrado mediante el ID
	 */
	public GEN_Institucion institucionByID(Integer id) throws Exception {
		return (GEN_Institucion) manager.findById(GEN_Institucion.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Entidad a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena el nombre para denotar la entidad
	 * @param descripcion
	 *            Tipo String el cual almacena descripcion de la entidad
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si es
	 *            (Activado/Descativado)
	 */
	public void insertarInstitucion(String nombre, String descripcion,
			Integer estado) throws Exception {
		try {
			GEN_Institucion p = new GEN_Institucion();
			p.setIns_nombre(nombre);
			p.setIns_descripcion(descripcion);
			p.setIns_estado(estado);
			manager.insertar(p);
			System.out.println("Bien_insertar_institucion");
		} catch (Exception e) {
			System.out.println("Error_insertar_institucion");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar Entidad a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el dato para buscar la entidad
	 * @param nombre
	 *            Tipo String el cual almacena el nombre para denotar la entidad
	 * @param descripcion
	 *            Tipo String el cual almacena descripcion de la entidad
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si es
	 *            (Activado/Descativado)
	 */
	public void editarInstitucion(Integer id, String nombre,
			String descripcion, Integer estado) throws Exception {
		try {
			GEN_Institucion p = this.institucionByID(id);
			p.setIns_id(id);
			p.setIns_nombre(nombre);
			p.setIns_descripcion(descripcion);
			p.setIns_estado(estado);
			manager.actualizar(p);
			System.out.println("Bien_editar_institucion");
		} catch (Exception e) {
			System.out.println("Error_editar_institucion");
			e.printStackTrace();
		}

	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Sector
	 * 
	 */

	/**
	 * Metodo para listar todos los datos de la entidad
	 * 
	 * @return La lista de todos los datos de la entidad encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Sector> findAllSector() {
		return manager.findAll(GEN_Sector.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Entidad mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto de la Entidad encontrado mediante el ID
	 */
	public GEN_Sector SectorByID(Integer id) throws Exception {
		return (GEN_Sector) manager.findById(GEN_Sector.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Entidad a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena el nombre para denotar la entidad
	 * @param direccion
	 *            Tipo String el cual almacena el lugar de la entidad
	 * @param estado
	 *            Tipo Integer el cual almacena el dato si es
	 *            (Activado/Descativado)
	 */
	public void insertarSector(String nombre, String direccion,
			String ubicacion, String estado) throws Exception {
		try {
			GEN_Sector p = new GEN_Sector();
			p.setSec_nombre(nombre);
			p.setSec_direccion(direccion);
			p.setSec_estado(estado);
			p.setSec_ubicacion(ubicacion);
			p.setIns(institucion);
			manager.insertar(p);
			System.out.println("Bien_insertar_sector");
			institucion = new GEN_Institucion();
		} catch (Exception e) {
			System.out.println("Error_insertar_sector");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar Entidad a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el dato para buscar la entidad
	 * @param nombre
	 *            Tipo String el cual edita el nombre para denotar la entidad
	 * @param direccion
	 *            Tipo String el cual edita el lugar de la entidad
	 * @param estado
	 *            Tipo Integer el cual edita el dato si es
	 *            (Activado/Descativado)
	 */
	public void editarSector(Integer id, String nombre, String direccion,
			String ubicacion,String estado) throws Exception {
		try {
			GEN_Sector p = new GEN_Sector();
			p.setSec_id(id);
			p.setSec_nombre(nombre);
			p.setSec_direccion(direccion);
			p.setSec_estado(estado);
			p.setSec_ubicacion(ubicacion);
			p.setIns(institucion);
			manager.insertar(p);
			System.out.println("Bien_editar_sector");
			institucion = new GEN_Institucion();
		} catch (Exception e) {
			System.out.println("Error_editar_sector");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para asignar una Entidad a otra en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un atributo
	 * @return El atributo con el dato correspondiente
	 */
	public GEN_Institucion asignarInstitucion(Integer id) {
		try {
			institucion = this.institucionByID(id);
			System.out.println("Bien_asignar_Institucion");
		} catch (Exception e) {
			System.out.println("Mal_asignar_Intitucion");
			e.printStackTrace();
		}
		return institucion;
	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Estado
	 * 
	 */

	/**
	 * Metodo para listar todos los datos de la entidad
	 * 
	 * @return La lista de todos los datos de la entidad encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Estado> findAllEstado() {
		return manager.findAll(GEN_Estado.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Entidad mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto de la Entidad encontrado mediante el ID
	 */
	public GEN_Estado EstadoByID(Integer id) throws Exception {
		return (GEN_Estado) manager.findById(GEN_Estado.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Entidad a la base de datos
	 * 
	 * @param tipo
	 *            Tipo String el cual almacena el tipo de la entidad
	 * @param descripcion
	 *            Tipo String el cual almacena la descripcion de la entidad
	 */
	public void insertarEstado(String tipo, String descripcion)
			throws Exception {
		try {
			GEN_Estado p = new GEN_Estado();
			p.setEst_tipo(tipo);
			p.setEst_descripcion(descripcion);
			manager.insertar(p);
			System.out.println("Bien_insertar_estado");
			institucion = new GEN_Institucion();
		} catch (Exception e) {
			System.out.println("Error_insertar_estado");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para ingresar Entidad a la base de datos
	 * 
	 * @param id
	 * @param tipo
	 *            Tipo String el cual almacena el tipo de la entidad
	 * @param descripcion
	 *            Tipo String el cual almacena la descripcion de la entidad
	 */
	public void editarEstado(Integer id, String tipo, String descripcion)
			throws Exception {
		try {
			GEN_Estado p = this.EstadoByID(id);
			p.setEst_id(id);
			p.setEst_tipo(tipo);
			p.setEst_descripcion(descripcion);
			manager.actualizar(p);
			System.out.println("Bien_editar_estado");
			institucion = new GEN_Institucion();
		} catch (Exception e) {
			System.out.println("Error_editar_estado");
			e.printStackTrace();
		}

	}// Cierre del metodo

}
