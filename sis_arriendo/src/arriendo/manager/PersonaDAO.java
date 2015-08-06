package arriendo.manager;

import java.util.List;

import arriendo.entidades.GEN_Persona;
import arriendo.entidades.GEN_Tipo;

/**
 * Clase ContratosDAO permite manejar el HibernateDAO en conveniencia a la
 * gestion de contratos de los sitios
 * 
 * @author Juan Carlos Estévez Hidalgo
 * @version 1.0
 *
 */

public class PersonaDAO {

	// Campos de la clase
	private HibernateDAO manager;
	// Campos de asignacion (Persona)
	private GEN_Tipo tipo;

	/**
	 * Constructor para la utilizacion de metodos de la clase HibernateDAO
	 * 
	 * @param manager
	 *            El parametro manager inicializa la utilizacion de la clase
	 *            HibernateDAO y todos sus metodos
	 */
	public PersonaDAO() {
		manager = new HibernateDAO();
	}// Cierre del metodo

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Persona
	 * 
	 */

	/**
	 * Metodo para listar Personas existentes
	 * 
	 * @return La lista de Personas encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Persona> findAllPersonas() {
		return manager.findAll(GEN_Persona.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Persona mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Persona encontrado mediante el ID
	 */
	public GEN_Persona PersonaByID(Integer id) throws Exception {
		return (GEN_Persona) manager.findById(GEN_Persona.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para obtener la Persona mediante un Nombre
	 * 
	 * @param nombre
	 *            Tipo String de busqueda
	 * @return El objeto Persona encontrado mediante el Nombre
	 */
	public GEN_Persona PersonabyNombre(String nombre) throws Exception {
		GEN_Persona s = null;
		List<GEN_Persona> li = findAllPersonas();
		for (GEN_Persona per : li) {
			if (per.getPer_id().equals(nombre)) {
				s = per;
			}
		}
		return s;
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Persona a la base de datos
	 * 
	 * @param tipo_id
	 *            Tipo String el cual almacena la el modo de identificacion
	 * @param nombre
	 *            Tipo String el cual almacena nombre de la Persona
	 * @param apellido
	 *            Tipo String el cual almacena el apellido de la Persona
	 * @param telefono
	 *            Tipo String el cual almacena el numero telefonico de la
	 *            Persona
	 * @param celular
	 *            Tipo String el cual almacena el numero celular de la Persona
	 * @param genero
	 *            Tipo char el cual almacena el dato de (Masculino/Femenino)
	 */
	public void insertarPersona(String tipo_id, String nombre, String apellido,
			String telefono, String celular, String genero) throws Exception {
		try {
			GEN_Persona p = new GEN_Persona();
			p.setPer_tipo_id(tipo_id);
			p.setPer_nombre(nombre);
			p.setPer_apellido(apellido);
			p.setPer_telefono(telefono);
			p.setPer_celular(celular);
			p.setPer_genero(genero);
			p.setTip(tipo);
			manager.insertar(p);
			System.out.println("Bien_insertar_persona");
			tipo = new GEN_Tipo();
		} catch (Exception e) {
			System.out.println("Error_insertar_persona");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para editar Persona a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar a la Persona a editar
	 * @param tipo_id
	 *            Tipo String el cual edita la el modo de identificacion
	 * @param nombre
	 *            Tipo String el cual edita nombre de la Persona
	 * @param apellido
	 *            Tipo String el cual edita el apellido de la Persona
	 * @param telefono
	 *            Tipo String el cual edita el numero telefonico de la Persona
	 * @param celular
	 *            Tipo String el cual edita el numero celular de la Persona
	 * @param genero
	 *            Tipo char el cual edita el dato de (Masculino/Femenino)
	 */
	public void editarPersona(String id, String tipo_id, String nombre,
			String apellido, String telefono, String celular, String genero)
			throws Exception {
		try {
			GEN_Persona p = this.PersonabyNombre(id);
			p.setPer_id(id);
			p.setPer_tipo_id(tipo_id);
			p.setPer_nombre(nombre);
			p.setPer_apellido(apellido);
			p.setPer_telefono(telefono);
			p.setPer_celular(celular);
			p.setPer_genero(genero);
			p.setTip(tipo);
			manager.actualizar(p);
			System.out.println("Bien_editar_persona");
			tipo = new GEN_Tipo();
		} catch (Exception e) {
			System.out.println("Error_editar_persona");
			e.printStackTrace();
		}

	}// Cierre del metodo

	/**
	 * Metodo para asignar Persona a un Tipo en la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual sirve para buscar un tipo
	 * @return El tipo Tipo con el dato correspondiente
	 */
	public GEN_Tipo asignarTipo(Integer id) throws Exception {
		try {
			tipo = this.TipoByID(id);
			System.out.println("Bien_asignar_tipo");
		} catch (Exception e) {
			System.out.println("Mal_asignar_tipo");
			e.printStackTrace();
		}
		return tipo;
	}// Cierre del metodo

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creación de metodos para el manejo de la tabla GEN_Tipo
	 * 
	 */

	/**
	 * Metodo para listar Tipo existentes
	 * 
	 * @return La lista de Tipo encontradas
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_Tipo> findAllTipos() {
		return manager.findAll(GEN_Tipo.class);
	}// Cierre del metodo

	/**
	 * Metodo para obtener Tipo mediante un ID
	 * 
	 * @param id
	 *            Tipo integer de busqueda
	 * @return El objeto Tipo encontrado mediante el ID
	 */
	public GEN_Tipo TipoByID(Integer id) throws Exception {
		return (GEN_Tipo) manager.findById(GEN_Tipo.class, id);
	}// Cierre del metodo

	/**
	 * Metodo para ingresar Tipo a la base de datos
	 * 
	 * @param tipo
	 *            Tipo String el cual almacena el tipo de identificacion
	 * @param descripcion
	 *            Tipo String el cual almacena descripcion del Tipo
	 */
	public void insertarTipo(String tipo, String descripcion) throws Exception {
		try {
			GEN_Tipo p = new GEN_Tipo();
			p.setTip_tipo(tipo);
			p.setTip_descripcion(descripcion);
			manager.insertar(p);
			System.out.println("Bien_insertar_tipo");
		} catch (Exception e) {
			System.out.println("Error_insertar_tipo");
			e.printStackTrace();
		}

	}// Cierre del metodo
	
	/**
	 * Metodo para editar Tipo a la base de datos
	 * 
	 * @param id
	 *            Tipo Integer el cual permite la busqueda del Tipo
	 * @param tipo
	 *            Tipo String el cual edita el tipo de identificacion
	 * @param descripcion
	 *            Tipo String el cual edita descripcion del Tipo
	 */
	public void editarTipo(Integer id, String tipo, String descripcion) throws Exception {
		try {
			GEN_Tipo p = this.TipoByID(id);
			p.setTip_tipo(tipo);
			p.setTip_descripcion(descripcion);
			manager.actualizar(p);
			System.out.println("Bien_insertar_tipo");
		} catch (Exception e) {
			System.out.println("Error_insertar_tipo");
			e.printStackTrace();
		}

	}// Cierre del metodo

}
