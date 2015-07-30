package arriendo.manager;

import java.util.List;

import arriendo.entidades.GEN_Area;
import arriendo.entidades.GEN_Modo;
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
	private GEN_Modo modo;

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
	 *            Tipo char el cual almacena el dato si el Area es
	 *            Activado/Desactivado
	 * @return El objeto Area encontrado mediante el ID
	 */
	public void insertarArea(String nombre, String ubicacion,
			String descripcion, char estado) throws Exception {
		try {
			GEN_Area p = new GEN_Area();
			p.setAre_nombre(nombre);
			p.setAre_ubicacion(ubicacion);
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
	 *            Tipo char el cual almacena el dato si es Activado/Desactivado
	 */
	public void editarArea(Integer id_area, String nombre, String ubicacion,
			String descripcion, char estado) throws Exception {
		try {
			GEN_Area r = this.AreaByID(id_area);
			r.setAre_id(id_area);
			r.setAre_nombre(nombre);
			r.setAre_ubicacion(ubicacion);
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
	 *            Tipo char el cual almacena el dato si es Activado/Desactivado
	 */
	public void insertarSitio(String identificador, Double costo,
			String direccion, Integer capacidad, char estado) throws Exception {
		try {
			GEN_Sitios p = new GEN_Sitios();
			p.setSit_identificador(identificador);
			p.setSit_costo_arriendo(costo);
			p.setSit_direccion(direccion);
			p.setSit_capacidad(capacidad);
			p.setSit_estado(estado);
			p.setAre(area);
			p.setMod(modo);
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
	 *            Tipo char el cual cambia el dato si es Activado/Desactivado
	 */
	public void editarSitio(String identificador, Double costo,
			String direccion, Integer capacidad, char estado) throws Exception {
		try {
			GEN_Sitios r = this.SitiobyNombre(identificador);
			r.setSit_identificador(identificador);
			r.setSit_costo_arriendo(costo);
			r.setSit_direccion(direccion);
			r.setSit_capacidad(capacidad);
			r.setSit_estado(estado);
			r.setAre(area);
			r.setMod(modo);
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
	public GEN_Area asignarSitio(Integer id) {
		try {
			area = this.AreaByID(id);
			System.out.println("Bien_asignar_Area");
		} catch (Exception e) {
			System.out.println("Mal_asignar_Area");
			e.printStackTrace();
		}
		return area;
	}// Cierre del metodo

	/**
	 * Metodo para asignar un Modo a un Sitio en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo modo con el dato correspondiente
	 */
	public GEN_Modo asignarModo(Integer id) {
		try {
			modo = this.ModoByID(id);
			System.out.println("Bien_asignar_Modo");
		} catch (Exception e) {
			System.out.println("Mal_asignar_Modo");
			e.printStackTrace();
		}
		return modo;
	}// Cierre del metodo

	/**
	 * Creación de metodos para el manejo de la tabla GEN_Modo
	 */

	/**
	 * Metodo para listar todos los Modos existentes
	 * 
	 * @return La lista de todos los Modos encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Modo> findAllModos() {
		return manager.findAll(GEN_Modo.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Modo mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Modo encontrado mediante el ID
	 */
	public GEN_Modo ModoByID(Integer id) throws Exception {
		return (GEN_Modo) manager.findById(GEN_Modo.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Modo a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena el nombre para denotar el modo
	 * @param descripcion
	 *            Tipo String el cual almacena el enfoque para el modo
	 */
	public void insertarModo(String nombre, String descripcion) throws Exception {
		try {
			GEN_Modo p = new GEN_Modo();
			p.setMod_nombre(nombre);
			p.setMod_descripcion(descripcion);
			manager.insertar(p);
			System.out.println("Bien_insertar_modo");
		} catch (Exception e) {
			System.out.println("Error_insertar_modo");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Modo a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual permite la busqueda para editar
	 * @param nombre
	 *            Tipo String el cual edita el nombre para denotar el modo
	 * @param descripcion
	 *            Tipo String el cual edita el enfoque para el modo
	 */
	public void editarModo(Integer id,String nombre, String descripcion) throws Exception {
		try {
			GEN_Modo r = this.ModoByID(id);
			r.setMod_id(id);
			r.setMod_nombre(nombre);
			r.setMod_descripcion(descripcion);
			manager.actualizar(r);
			System.out.println("bien_mod_modo");
		} catch (Exception e) {
			System.out.println("Error_mod_modo");
			e.printStackTrace();
		}
	}// Cierre del metodo

}
