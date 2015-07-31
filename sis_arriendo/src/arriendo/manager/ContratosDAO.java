package arriendo.manager;

import java.util.Date;
import java.util.List;

import arriendo.entidades.ARR_Clausulas;
import arriendo.entidades.ARR_Contrato_Cab;
import arriendo.entidades.ARR_Contrato_Det;
import arriendo.entidades.ARR_Inter_Cla;
import arriendo.entidades.ARR_Items;

/**
 * Clase ContratosDAO permite manejar el HibernateDAO en conveniencia a la
 * gestion de contratos de los sitios
 * 
 * @author Juan Carlos Estévez Hidalgo
 * @version 1.0
 *
 */

public class ContratosDAO {

	// Campos de la clase
	private HibernateDAO manager;
	// Campos de asignacion (Contrato_Det y Inter_Cla)
	private ARR_Contrato_Cab contrato_cab;
	// Campos de asignacion (Inter_Cla y Items)
	private ARR_Clausulas clausulas;

	/**
	 * Constructor para la utilizacion de metodos de la clase HibernateDAO
	 * 
	 * @param manager
	 *            El parametro manager inicializa la utilizacion de la clase
	 *            HibernateDAO y todos sus metodos
	 */
	public ContratosDAO() {
		manager = new HibernateDAO();
	}// Cierre del Constructor

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ARR_Contrato_Cab
	 * 
	 */

	/**
	 * Metodo para listar todos los Contratos_Cab existentes
	 * 
	 * @return La lista de todos los Contratos_Cab encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Contrato_Cab> findAllContratos_Cab() {
		return manager.findAll(ARR_Contrato_Cab.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener el Contrato_Cab mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Contrato_cab encontrado mediante el ID
	 */
	public ARR_Contrato_Cab Contrato_CabByID(Integer id) throws Exception {
		return (ARR_Contrato_Cab) manager.findById(ARR_Contrato_Cab.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Contrato_cab a la base de datos
	 * 
	 * @param fecha
	 *            Tipo Date el cual almacena la fecha de realizacion del
	 *            Contrato_cab
	 * @param fechaini
	 *            Tipo Date el cual almacena la fecha de inicio del
	 *            Contratto_cab
	 * @param fechafin
	 *            Tipo Date el cual almacena la fecha fin del contrato_cab
	 * @param observacion
	 *            Tipo String el cual almacena la observacion del contrato_cab
	 * @param estado
	 *            Tipo char el cual almacena el estado del contrato
	 *            (Activado/Desactivado)
	 */
	public void insertarContrato_cab(Date fecha, Date fechaini, Date fechafin,
			String observacion, char estado) throws Exception {
		try {
			ARR_Contrato_Cab p = new ARR_Contrato_Cab();
			p.setCab_fecha(fecha);
			p.setCab_fechaini(fechaini);
			p.setCab_fechafin(fechafin);
			p.setCab_observacion(observacion);
			p.setCab_estado(estado);
			manager.insertar(p);
			System.out.println("Bien_insertar_contrato_cab");
		} catch (Exception e) {
			System.out.println("Error_insertar_contrato_cab");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Contrato_cab a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual permite la busqueda del Contrato_cab para
	 *            su modificacion
	 * @param fecha
	 *            Tipo Date el cual edita la fecha de realizacion del
	 *            Contrato_cab
	 * @param fechaini
	 *            Tipo Date el cual edita la fecha de inicio del Contratto_cab
	 * @param fechafin
	 *            Tipo Date el cual edita la fecha fin del contrato_cab
	 * @param observacion
	 *            Tipo String el cual edita la observacion del contrato_cab
	 * @param estado
	 *            Tipo char el cual edita el estado del contrato
	 *            (Activado/Desactivado)
	 */
	public void editarContrato_cab(Integer id, Date fecha, Date fechaini,
			Date fechafin, String observacion, char estado) throws Exception {
		try {
			ARR_Contrato_Cab p = this.Contrato_CabByID(id);
			p.setCab_id(id);
			p.setCab_fecha(fecha);
			p.setCab_fechaini(fechaini);
			p.setCab_fechafin(fechafin);
			p.setCab_observacion(observacion);
			p.setCab_estado(estado);
			manager.actualizar(p);
			System.out.println("Bien_insertar_contrato_cab");
		} catch (Exception e) {
			System.out.println("Error_insertar_contrato_cab");
			e.printStackTrace();
		}

	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ARR_Contrato_Det
	 * 
	 */

	/**
	 * Metodo para listar todos los Contrato_det existentes
	 * 
	 * @return La lista de todos los Contrato_det encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Contrato_Det> findAllContratos_Det() {
		return manager.findAll(ARR_Contrato_Det.class);
	}// Cierre del metodo

	/**
	 * Metodo para obetener Contrato_det mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Contrato_det encontrado mediante el ID
	 */
	public ARR_Contrato_Det Contrato_DetByID(Integer id) throws Exception {
		return (ARR_Contrato_Det) manager.findById(ARR_Contrato_Det.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar un Contrato_det a la base de datos
	 * 
	 * @param observacion
	 *            Tipo String el cual almacena la observacion del Contrato_det
	 * @param costo
	 *            Tipo Float el cual almacena el costo mensual del Contrato_det
	 * @param estado
	 *            Tipo String el cual almacena la ubicacion del Contrato_det
	 */
	public void insertarContrato_Det(String observacion, Float costo,
			char estado) throws Exception {
		try {
			ARR_Contrato_Det p = new ARR_Contrato_Det();
			p.setDet_observacion(observacion);
			p.setDet_costo(costo);
			p.setDet_estado(estado);
			p.setCon_cab(contrato_cab);
			manager.insertar(p);
			System.out.println("Bien_insertar_contratoDet");
			contrato_cab = new ARR_Contrato_Cab();
		} catch (Exception e) {
			System.out.println("Error_insertar_contratoDet");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar un Contrato_det a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual permite la busqueda de un Contrato_det
	 * @param observacion
	 *            Tipo String el cual edita la observacion del Contrato_det
	 * @param costo
	 *            Tipo Float el cual edita el costo mensual del Contrato_det
	 * @param estado
	 *            Tipo String el cual edita la ubicacion del Contrato_det
	 */
	public void editarContrato_Det(Integer id, String observacion, Float costo,
			char estado) throws Exception {
		try {
			ARR_Contrato_Det p = this.Contrato_DetByID(id);
			p.setDet_id(id);
			p.setDet_observacion(observacion);
			p.setDet_costo(costo);
			p.setDet_estado(estado);
			p.setCon_cab(contrato_cab);
			manager.insertar(p);
			System.out.println("Bien_editar_contratoDet");
			contrato_cab = new ARR_Contrato_Cab();
		} catch (Exception e) {
			System.out.println("Error_editar_contratoDet");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para asignar un Contrato_Cab a un Contrato_Det en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo Contrato_det con el dato correspondiente
	 */
	public ARR_Contrato_Cab asignarContrato_Cab(Integer id) throws Exception {
		try {
			contrato_cab = this.Contrato_CabByID(id);
			System.out.println("Bien_asignar_contrato_cab");
		} catch (Exception e) {
			System.out.println("Mal_asignar_contrato_cab");
			e.printStackTrace();
		}
		return contrato_cab;
	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ARR_Inter_Cla
	 */

	/**
	 * Metodo para listar todos los Inter_Clausulas existentes
	 * 
	 * @return La lista de todos los Inter_Clausulas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Inter_Cla> findAllInter_Cla() {
		return manager.findAll(ARR_Inter_Cla.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Inter_Clausulas mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Inter_Clausulas encontrado mediante el ID
	 */
	public ARR_Inter_Cla Inter_claByID(Integer id) throws Exception {
		return (ARR_Inter_Cla) manager.findById(ARR_Inter_Cla.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para asignar una Clausula a Inter_cla en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo Clausula con el dato correspondiente
	 */
	public ARR_Clausulas asignarClausulas(Integer id) throws Exception {
		try {
			clausulas = this.ClausulaByID(id);
			System.out.println("Bien_asignar_contrato_cab");
		} catch (Exception e) {
			System.out.println("Mal_asignar_contrato_cab");
			e.printStackTrace();
		}
		return clausulas;
	}// Cierre del metodo

	/**
	 * Metodo para insertar un Inter_cla en la base de datos
	 */
	public void insertarInter_cla() throws Exception {
		try {
			ARR_Inter_Cla r = new ARR_Inter_Cla();
			r.setCon_cab(contrato_cab);
			r.setCla(clausulas);
			manager.insertar(r);
			System.out.println("Bien_insertar_Inter_cla");
			contrato_cab = new ARR_Contrato_Cab();
			clausulas = new ARR_Clausulas();
		} catch (Exception e) {
			System.out.println("Mal_insertar_Inter_cla");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo 2 para insertar un Inter_cla en la base de datos con atributos
	 * dados
	 * 
	 * @param cla
	 *            Tipo {@link ARR_Clausulas} para poder almacenar en la base de
	 *            datos
	 * @param cc
	 *            Tipo {@link ARR_Contrato_Cab} para poder almacenar en la base
	 *            de datos
	 */
	public void insertarInter_cla(ARR_Clausulas cla, ARR_Contrato_Cab cc)
			throws Exception {
		try {
			ARR_Inter_Cla r = new ARR_Inter_Cla();
			r.setCon_cab(cc);
			r.setCla(cla);
			manager.insertar(r);
			System.out.println("Bien_insertar_Inter_cla");
		} catch (Exception e) {
			System.out.println("Mal_insertar_Inter_cla");
			e.printStackTrace();
		}
	}// Ciere del metodo

	/**
	 * Metodo para eliminar un dato de la tabla Inter_cla
	 * 
	 * @param id
	 *            Tipo Integer el cual me sirve para buscar el dato a eliminar
	 *            datos
	 */
	public void eliminarInter_cla(Integer id) throws Exception {
		try {
			manager.eliminar(ARR_Inter_Cla.class, id);
			System.out.println("Bien_eliminar_Inter_cla");
		} catch (Exception e) {
			System.out.println("Mal_eliminar_Inter_cla");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo 2 para eliminar un dato de la tabla Inter_cla
	 */
	public void eliminarInter_cla2() throws Exception {
		try {
			manager.eliminar(ARR_Inter_Cla.class, findbyidexterno()
					.getIntc_id());
			System.out.println("Bien_eliminar_Inter_cla");
		} catch (Exception e) {
			System.out.println("Mal_eliminar_Inter_cla");
			e.printStackTrace();
		}
	}// Cierre del metodo

	/**
	 * Metodo para buscar por {@link ARR_Clausulas} o por
	 * {@link ARR_Contrato_Cab} en la tabla {@link ARR_Inter_Cla}
	 */
	public ARR_Inter_Cla findbyidexterno() {
		List<ARR_Inter_Cla> s = findAllInter_Cla();
		ARR_Inter_Cla u = new ARR_Inter_Cla();
		for (ARR_Inter_Cla t : s) {
			if (t.getCon_cab().getCab_id() == contrato_cab.getCab_id()
					&& t.getCla().getCla_id() == clausulas.getCla_id()) {
				u = t;
			}
		}
		return u;
	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ARR_Clausulas
	 */

	/**
	 * Metodo para listar todos los Clausulas existentes
	 * 
	 * @return La lista de todos los Clausulas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Clausulas> findAllClausulas() {
		return manager.findAll(ARR_Clausulas.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Clausula mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Clausula encontrado mediante el ID
	 */
	public ARR_Clausulas ClausulaByID(Integer id) throws Exception {
		return (ARR_Clausulas) manager.findById(ARR_Clausulas.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Clausula a la base de datos
	 * 
	 * @param nombre
	 *            Tipo String el cual almacena la denotacion de Clausula
	 * @param descripcion
	 *            Tipo String el cual almacena la identificacion de Clausula
	 */
	public void insertarClausula(String nombre, String descripcion)
			throws Exception {
		try {
			ARR_Clausulas p = new ARR_Clausulas();
			p.setCla_nombre(nombre);
			p.setCla_descripcion(descripcion);
			manager.insertar(p);
			System.out.println("Bien_insertar_clausula");
		} catch (Exception e) {
			System.out.println("Error_insertar_clausula");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar la Clausula a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar el tipo a editar
	 * @param nombre
	 *            Tipo String el cual edita la denotacion de Clausula
	 * @param descripcion
	 *            Tipo String el cual edita la identificacion de Clausula
	 */
	public void editarClausula(Integer id, String nombre, String descripcion)
			throws Exception {
		try {
			ARR_Clausulas p = this.ClausulaByID(id);
			p.setCla_id(id);
			p.setCla_nombre(nombre);
			p.setCla_descripcion(descripcion);
			manager.actualizar(p);
			System.out.println("Bien_editar_clausula");
		} catch (Exception e) {
			System.out.println("Error_editar_clausula");
			e.printStackTrace();
		}

	}// Cierre del metodo

	// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla ARR_Items
	 */

	/**
	 * Metodo para listar todos los Items existentes
	 * 
	 * @return La lista de todos los Items encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Items> findAllItems() {
		return manager.findAll(ARR_Items.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Item mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Item encontrado mediante el ID
	 */
	public ARR_Items ItemByID(Integer id) throws Exception {
		return (ARR_Items) manager.findById(ARR_Items.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Items a la base de datos
	 * 
	 * @param descripcion
	 *            Tipo String el cual almacena la identificacion de Item
	 */
	public void insertarItem(String descripcion) throws Exception {
		try {
			ARR_Items p = new ARR_Items();
			p.setIte_descripcion(descripcion);
			p.setCla(clausulas);
			manager.insertar(p);
			System.out.println("Bien_insertar_items");
			clausulas = new ARR_Clausulas();
		} catch (Exception e) {
			System.out.println("Error_insertar_items");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar Items a la base de datos
	 *
	 * @param id
	 *            Tipo Integer mediante el cual se genera la busqueda
	 * @param descripcion
	 *            Tipo String el cual edita la identificacion de Item
	 */
	public void editarItem(Integer id, String descripcion) throws Exception {
		try {
			ARR_Items p = ItemByID(id);
			p.setIte_id(id);
			p.setIte_descripcion(descripcion);
			p.setCla(clausulas);
			manager.insertar(p);
			System.out.println("Bien_editar_items");
			clausulas = new ARR_Clausulas();
		} catch (Exception e) {
			System.out.println("Error_editar_items");
			e.printStackTrace();
		}

	}// Cierre del metodo

}
