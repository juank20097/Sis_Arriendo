package arriendo.manager;

import java.util.List;

import arriendo.entidades.ARR_SitiosArticulos;
import arriendo.entidades.GEN_Areas;
import arriendo.entidades.GEN_Articulos;
import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Instituciones;
import arriendo.entidades.GEN_Sectores;
import arriendo.entidades.GEN_Sitios;
import arriendo.entidades.GEN_TipoSitios;

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
	private GEN_Areas area;
	private GEN_TipoSitios tipositio;
	// Campos de asignacion (Sectores)
	private GEN_Instituciones institucion;
	// Campos de asignacion (Areas)
	private GEN_Sectores sector;
	

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
	 * Creación de metodos para el manejo de la tabla GEN_Areas
	 * 
	 */

	/**
	 * Metodo para listar todas las Areas existentes
	 * 
	 * @return La lista de todas las Areas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Areas> findAllAreas() {
		return manager.findAll(GEN_Areas.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Area mediante un ID
	 * 
	 * @param id_area
	 *            Tipo integer de busqueda
	 * @return El objeto Area encontrado mediante el ID
	 */
	public GEN_Areas AreaByID(Integer id_area) throws Exception {
		return (GEN_Areas) manager.findById(GEN_Areas.class, id_area);
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
	public void insertarArea(String nombre, String descripcion, Integer sec)
			throws Exception {
		try {
			sector = SectorByID(sec);
			GEN_Areas p = new GEN_Areas();
			p.setAre_nombre(nombre);
			p.setAre_descripcion(descripcion);
			p.setAre_estado('A');
			p.setSec(sector);
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
	public void editarArea(Integer id_area, String nombre, String descripcion,
			char estado, Integer sec) throws Exception {
		try {
			sector = SectorByID(sec);
			GEN_Areas r = this.AreaByID(id_area);
			r.setAre_id(id_area);
			r.setAre_nombre(nombre);
			r.setAre_descripcion(descripcion);
			r.setAre_estado(estado);
			r.setSec(sector);
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
			manager.eliminar(GEN_Areas.class, id_area);
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
			if (sitio.getSit_nombre().equals(nombre)) {
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
	public void insertarSitio(String nombre, Float costo,
			Integer capacidad, Integer a, Integer ts) throws Exception {
		try {
			tipositio = TipoSitiosByID(ts);
			area = AreaByID(a);
			GEN_Sitios p = new GEN_Sitios();
			p.setSit_nombre(nombre);
			p.setSit_costo_arriendo(costo);
			p.setSit_capacidad(capacidad);
			p.setSit_estado('A');
			p.setAre(area);
			p.setTsi(tipositio);
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
	 * @param nombre
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
	public void editarSitio(Integer id, String nombre, Float costo,
			Integer capacidad, char estado, Integer a, Integer ts) throws Exception {
		try {
			tipositio = TipoSitiosByID(ts);
			area = AreaByID(a);
			GEN_Sitios r = this.SitioByID(id);
			r.setSit_id(id);
			r.setSit_nombre(nombre);
			r.setSit_costo_arriendo(costo);
			r.setSit_capacidad(capacidad);
			r.setSit_estado(estado);
			r.setAre(area);
			r.setTsi(tipositio);
			manager.actualizar(r);
			System.out.println("bien_mod_sitio");
		} catch (Exception e) {
			System.out.println("Error_mod_sitio");
			e.printStackTrace();
		}
	}// Cierre del metodo
	
	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**
		 * Creación de metodos para el manejo de la tabla GEN_TipoSitios
		 * 
		 */

		/**
		 * Metodo para listar todos los Sitios existentes
		 * 
		 * @return La lista de todos los Sitios encontradas
		 */
		@SuppressWarnings("unchecked")
		public List<GEN_TipoSitios> findAllTipoSitios() {
			return manager.findAll(GEN_TipoSitios.class);
		}// Cierre del metodo

		/**
		 * Metodo para obetener el Sitio mediante un ID
		 * 
		 * @param id_sitio
		 *            Tipo integer de busqueda
		 * @return El objeto Sitio encontrado mediante el ID
		 */
		public GEN_TipoSitios TipoSitiosByID(Integer id) throws Exception {
			return (GEN_TipoSitios) manager.findById(GEN_TipoSitios.class, id);
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
		public void insertarTipoSitios(String nombre, String descripcion) throws Exception {
			try {
				GEN_TipoSitios p = new GEN_TipoSitios();
				p.setTsi_nombre(nombre);
				p.setTsi_descripcion(descripcion);
				p.setTsi_estado('A');
				manager.insertar(p);
				System.out.println("Bien_insertar_tsitio");
			} catch (Exception e) {
				System.out.println("Error_insertar_tsitio");
				e.printStackTrace();
			}

		}// Cierre del metodo

		/**
		 * Metodo para editar un Sitio a la base de datos
		 * 
		 * @param nombre
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
		public void editarTipoSitios(Integer id, String nombre, String descripcion, char estado) throws Exception {
			try {
				GEN_TipoSitios r = this.TipoSitiosByID(id);
				r.setTsi_id(id);
				r.setTsi_nombre(nombre);
				r.setTsi_descripcion(descripcion);
				r.setTsi_estado(estado);
				manager.actualizar(r);
				System.out.println("bien_mod_tsitio");
			} catch (Exception e) {
				System.out.println("Error_mod_tsitio");
				e.printStackTrace();
			}
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
	public List<GEN_Instituciones> findAllInstituciones() {
		return manager.findAll(GEN_Instituciones.class);
	}// Cierre del metodo

	/**
	 * Metodo para obetener Institucion mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Institucion encontrado mediante el ID
	 */
	public GEN_Instituciones institucionByID(Integer id) throws Exception {
		return (GEN_Instituciones) manager
				.findById(GEN_Instituciones.class, id);
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
	public void insertarInstitucion(String nombre, String descripcion)
			throws Exception {
		try {
			GEN_Instituciones p = new GEN_Instituciones();
			p.setIns_nombre(nombre);
			p.setIns_descripcion(descripcion);
			p.setIns_estado('A');
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
			String descripcion, char estado) throws Exception {
		try {
			GEN_Instituciones p = this.institucionByID(id);
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
	public List<GEN_Sectores> findAllSector() {
		return manager.findAll(GEN_Sectores.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Entidad mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto de la Entidad encontrado mediante el ID
	 */
	public GEN_Sectores SectorByID(Integer id) throws Exception {
		return (GEN_Sectores) manager.findById(GEN_Sectores.class, id);
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
			String ubicacion, Integer institu) throws Exception {
		try {
			institucion = institucionByID(institu);
			GEN_Sectores p = new GEN_Sectores();
			p.setSec_nombre(nombre);
			p.setSec_direccion(direccion);
			p.setSec_estado('A');
			p.setSec_ubicacion(ubicacion);
			p.setIns(institucion);
			manager.insertar(p);
			System.out.println("Bien_insertar_sector");
			institucion = new GEN_Instituciones();
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
			String ubicacion, Integer institu, char estado) throws Exception {
		try {
			institucion = institucionByID(institu);
			GEN_Sectores p = SectorByID(id);
			p.setSec_id(id);
			p.setSec_nombre(nombre);
			p.setSec_direccion(direccion);
			p.setSec_estado(estado);
			p.setSec_ubicacion(ubicacion);
			p.setIns(institucion);
			manager.actualizar(p);
			System.out.println("Bien_editar_sector");
		} catch (Exception e) {
			System.out.println("Error_editar_sector");
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
		public List<GEN_Articulos> findAllArticulos() {
			return manager.findAll(GEN_Articulos.class);
		}// Cierre del metodo

		/**
		 * Metodo para obtener Entidad mediante un ID
		 * 
		 * @param id
		 *            Tipo integer de busqueda
		 * @return El objeto de la Entidad encontrado mediante el ID
		 */
		public GEN_Articulos ArticulosByID(Integer id) throws Exception {
			return (GEN_Articulos) manager.findById(GEN_Articulos.class, id);
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
		public void insertarArticulos(String nombre, String descripcion,
				String serial, Float valor_referencial, String imagen) throws Exception {
			try {
				GEN_Articulos p = new GEN_Articulos();
				p.setArt_nombre(nombre);
				p.setArt_descripcion(descripcion);
				p.setArt_serial(serial);
				p.setArt_valor_referenciado(valor_referencial);
				p.setArt_imagen(imagen);
				p.setArt_estado('A');
				manager.insertar(p);
				System.out.println("Bien_insertar_articulo");
				institucion = new GEN_Instituciones();
			} catch (Exception e) {
				System.out.println("Error_insertar_articulo");
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
		public void editarArticulo(Integer id, String nombre, String descripcion,
				String serial, Float valor_referencial, String imagen, char estado) throws Exception {
			try {
				GEN_Articulos p = ArticulosByID(id);
				p.setArt_id(id);
				p.setArt_nombre(nombre);
				p.setArt_descripcion(descripcion);
				p.setArt_serial(serial);
				p.setArt_valor_referenciado(valor_referencial);
				p.setArt_imagen(imagen);
				p.setArt_estado(estado);
				manager.actualizar(p);
				System.out.println("Bien_editar_articulo");
			} catch (Exception e) {
				System.out.println("Error_editar_articulo");
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
				public List<ARR_SitiosArticulos> findAllSitiosArticulos() {
					return manager.findAll(ARR_SitiosArticulos.class);
				}// Cierre del metodo

				/**
				 * Metodo para obtener Entidad mediante un ID
				 * 
				 * @param id
				 *            Tipo integer de busqueda
				 * @return El objeto de la Entidad encontrado mediante el ID
				 */
				public ARR_SitiosArticulos SArticulosByID(Integer id) throws Exception {
					return (ARR_SitiosArticulos) manager.findById(ARR_SitiosArticulos.class, id);
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
				public void insertarSArticulos(Integer art_id, Integer sit_id) throws Exception {
					try {
						GEN_Sitios s=SitioByID(sit_id);
						ARR_SitiosArticulos p = new ARR_SitiosArticulos();
						p.setArt_id(art_id);
						p.setSit(s);
						manager.insertar(p);
						System.out.println("Bien_insertar_sarticulo");
					} catch (Exception e) {
						System.out.println("Error_insertar_sarticulo");
						e.printStackTrace();
					}

				}// Cierre del metodo

				/**
				 * Metodo para eliminar un Area en la base de datos
				 * 
				 * @param id_area
				 *            Tipo Integer el cual sirve para su eliminacion
				 */
				public void eliminarSArticulo(Integer id) {
					try {
						manager.eliminar(ARR_SitiosArticulos.class, id);
						System.out.println("Eliminar_sarticulo_correcto");
					} catch (Exception e) {
						System.out.println("Eliminar_sarticulo_incorrecto");
						e.printStackTrace();
					}
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
	public List<GEN_Estados> findAllEstados() {
		return manager.findAll(GEN_Estados.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Entidad mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto de la Entidad encontrado mediante el ID
	 */
	public GEN_Estados EstadoByID(char id) throws Exception {
		return (GEN_Estados) manager.findById(GEN_Estados.class, id);
	}// Cierre del metodo

}
