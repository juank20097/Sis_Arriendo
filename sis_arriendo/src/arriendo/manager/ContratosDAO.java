package arriendo.manager;

import java.util.Date;
import java.util.List;


import arriendo.entidades.ARR_Contrato_Cab;
import arriendo.entidades.ARR_Contrato_Det;
import arriendo.entidades.ARR_Inter_Per;
import arriendo.entidades.GEN_Persona;

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
	private PersonaDAO personaDAO;
	// Campos de asignacion (Contrato_Det y Inter_Cla)
	private ARR_Contrato_Cab contrato_cab;
	// Campos de asignacion (Inter_Per)
	private GEN_Persona persona;
	

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
			manager.actualizar(p);
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
			 * Creación de metodos para el manejo de la tabla ARR_Inter_Per
			 */

			/**
			 * Metodo para listar todos los Inter_Persona existentes
			 * 
			 * @return La lista de todos los Inter_Persona encontradas
			 */
			@SuppressWarnings("unchecked")
			public List<ARR_Inter_Per> findAllInter_Per() {
				return manager.findAll(ARR_Inter_Per.class);
			}// Cierre del metodo

			/**
			 * Metodo para obtener Inter_Persona mediante un ID
			 * 
			 * @param id
			 *            Tipo integer de busqueda
			 * @return El objeto Inter_Persona encontrado mediante el ID
			 */
			public ARR_Inter_Per Inter_perByID(Integer id) throws Exception {
				return (ARR_Inter_Per) manager.findById(ARR_Inter_Per.class, id);
			}// Cierre del metodo

			/**
			 * Metodo para asignar una Persona a Inter_per en la base de datos
			 * 
			 * @param id
			 *            Tipo Integer el cual sirve para buscar un tipo
			 * @return El tipo Clausula con el dato correspondiente
			 */
			public GEN_Persona asignarPersona(Integer id) throws Exception {
				try {
					 persona = personaDAO.PersonaByID(id);
					System.out.println("Bien_asignar_persona");
				} catch (Exception e) {
					System.out.println("Mal_asignar_persona");
					e.printStackTrace();
				}
				return persona;
			}// Cierre del metodo

			/**
			 * Metodo para insertar un Inter_cla en la base de datos
			 */
			public void insertarInter_per() throws Exception {
				try {
					ARR_Inter_Per r = new ARR_Inter_Per();
					r.setCon_cab(contrato_cab);
					r.setPer(persona);
					manager.insertar(r);
					System.out.println("Bien_insertar_Inter_per");
					contrato_cab = new ARR_Contrato_Cab();
				} catch (Exception e) {
					System.out.println("Mal_insertar_Inter_per");
					e.printStackTrace();
				}
			}// Cierre del metodo

}
