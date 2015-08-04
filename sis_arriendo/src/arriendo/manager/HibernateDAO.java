package arriendo.manager;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase HibernateDAO permite conectar a la BDD y generacion de metodos mediante transacciones a la misma
 * 
 * @author Juan Carlos Estévez Hidalgo
 * @version 1.0
 *
 */

public class HibernateDAO {
	// Campos de la clase
	private static SessionFactory sessionFactory;
	private static Session session;

	/**
	 * Constructor para la inicializacion de los campos
	 * 
	 * @param sessionFactory
	 *            El parametro sessionFactory ejecuta el metodo buildSessionFactory().
	 * @param session El parametro session me toma la {@link SessionFactory} y abre session. 
	 */
	public HibernateDAO() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		if (session == null)
			session = sessionFactory.openSession();
	}//Cierre del metodo

	
	/**
	 * Metodo para construir el sessionFactory del archivo hibernate.cfg.xml
	 * 
	 * @return {@link SessionFactory}
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Creacion fallida de Session Factory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Metodo Generico que devuelve todos las entidades de una tabla.
	 * 
	 * @param clase
	 *            La clase que se desea consultar.
	 * @param orderBy
	 *            Propiedad de la entidad por la que se desea ordenar la
	 *            consulta.
	 * @return Listado resultante.
	 */
	@SuppressWarnings("rawtypes")
	public List findAll (Class clase, String orderBy){
		List listado;
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		if (orderBy==null || orderBy.length()==0)
			listado = session.createQuery("FROM "+clase.getName()).list();
		else
			listado = session.createQuery("FROM "+clase.getName()+" o ORDER BY o."+orderBy).list();
		if (session.getTransaction().isActive()){
			session.getTransaction().commit();
		}
		return listado;
	}
	
	/**
	 * Meotod Generico que devuelve todos las entidades de una tabla.
	 * 
	 * @param clase
	 *            La clase que se desea consultar.
	 * @return Listado resultante.
	 */
	@SuppressWarnings("rawtypes")
	public List findAll(Class clase) {
		List listado;
		if (!session.getTransaction().isActive())
		session.getTransaction().begin();
		listado = session.createQuery("FROM "+clase.getName()).list();
		if (session.getTransaction().isActive()){
			session.getTransaction().commit();
		}
		return listado;
	}
	
	/**
	 * Metodo Generico que permite aplicar clausulas where y order by.
	 * 
	 * @param clase
	 *            La entidad sobre la que se desea consultar.
	 * @param whereClau
	 *            Clausula where de tipo HQL.
	 * @param orderBy
	 *            Clausula order by de tipo HQL. Puede ser null.
	 * @return Listado resultante.
	 */
	@SuppressWarnings("rawtypes")
	public List findWhere (Class clase,String whereClau ,String orderBy){
		List listado;
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		if (orderBy==null || orderBy.length()==0)
			listado = session.createQuery("FROM "+clase.getName()+" o WHERE o."+whereClau).list();
		else
			listado = session.createQuery("FROM "+clase.getName()+" o WHERE o."+whereClau+" ORDER BY o."+orderBy).list();
		if (session.getTransaction().isActive()){
			session.getTransaction().commit();
		}
		return listado;
	}
	
	/**
	 * Metodo Generico para buscar un objeto especifico.
	 * 
	 * @param clase
	 *            La clase sobre la que se desea consultar.
	 * @param id
	 *            Identificador que permitira la busqueda.
	 * @return El objeto solicitado (si existiera).
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Object findById (Class clase,Object id) throws Exception{
		Object obj;
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		if (id==null)
			throw new Exception("Debe especificar el codigo para buscar dato");
		try {
			obj=session.get(clase, (Serializable) id);
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception("Error no se encontro la informacion (findByID): "+e.getMessage());
		}
		session.getTransaction().commit();
		return obj;
	}
	
	/**
	 * Almacena un objeto en la persistencia.
	 * 
	 * @param object El objeto a insertar.
	 * @throws Exception
	 */
	public void insertar(Object object) throws Exception 
    { 
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		try {
			session.save(object);
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception("No se pudo insertar el objeto especificado (insertar): "+e.getMessage());
		}	
		session.getTransaction().commit(); 
    } 
	
	/**
	 * Elimina un objeto de la persistencia.
	 * 
	 * @param clase
	 *            La clase correspondiente al objeto que se desea eliminar.
	 * @param id
	 *            El identificador del objeto que se desea eliminar.
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public void eliminar(Class clase, Object id) throws Exception 
    { 
		if (id==null) 
			throw new Exception("Debe especificar un id para eliminar el dato");
		Object o = findById(clase,id);
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		try {
			session.delete(o);
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception("No se pudo eliminar el objeto (eliminar): "+e.getMessage());
		}	
		session.getTransaction().commit(); 
    } 
	
	/**
	 * Actualiza la informacion de un objeto en la persistencia.
	 * 
	 * @param object Objeto que contiene la informacion que se debe actualizar.
	 * @throws Exception
	 */
	public void actualizar(Object object) throws Exception 
    { 
		if (object==null)
			throw new Exception("No se puede actualizar un dato nulo");
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
		try {
			session.update(object);
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw new Exception("No se pudo insertar el objeto especificado (insertar): "+e.getMessage());
		}	
		session.getTransaction().commit(); 
    } 
	
	/**
     * Metodo Generico para buscar un objeto especifico por una columna
     * especificada.
     *
     * @param clase La clase sobre la que se desea consultar.
     * @param param columna de busqueda.
     * @param value valor de parametro de busqueda.
     * @param orderBy Expresion que indica la propiedad de la entidad por la que
     * se desea ordenar la consulta. Debe utilizar el alias "o" para nombrar a
     * la(s) propiedad(es) por la que se va a ordenar. Puede aceptar null o una
     * cadena vacia, en este caso no ordenara el resultado.
     * @return Lista de objetos solicitados (si existieran).
     * @throws Exception
     */
	@SuppressWarnings("rawtypes")
	public List findByParam (Class clase, String param, String value, String orderBy) throws Exception{
		List listado;
		String senteciaHQL;
		if (orderBy==null || orderBy.length()==0)
			senteciaHQL = "FROM "+clase.getName()+" o WHERE o."+param+"=:value1";
		else
			senteciaHQL = "FROM "+clase.getName()+" o WHERE o."+param+"=:value1 ORDER BY o."+orderBy;
		
		listado=session.createQuery(senteciaHQL).setParameter("value1", value).list();
		return listado;
	}
	
	/**
     * Finder generico para buscar un objeto especifico por una columna
     * especificada.
     *
     * @param clase La clase sobre la que se desea consultar.
     * @param param columna de busqueda.
     * @param value valor de parametro de busqueda.
     * @param orderBy Expresion que indica la propiedad de la entidad por la que
     * se desea ordenar la consulta. Debe utilizar el alias "o" para nombrar a
     * la(s) propiedad(es) por la que se va a ordenar. Puede aceptar null o una
     * cadena vacia, en este caso no ordenara el resultado.
     * @return Lista de objetos solicitados (si existieran).
     * @throws Exception
     */
	@SuppressWarnings("rawtypes")
	public List findByParam (Class clase, String param, Integer value, String orderBy) throws Exception{
		List listado;
		String senteciaHQL;
		if (orderBy==null || orderBy.length()==0)
			senteciaHQL = "FROM "+clase.getName()+" o WHERE o."+param+"=:value1";
		else
			senteciaHQL = "FROM "+clase.getName()+" o WHERE o."+param+"=:value1 ORDER BY o."+orderBy;
		
		listado=session.createQuery(senteciaHQL).setParameter("value1", value).list();
		return listado;
	}
	
	/**
	 * Metodo para comprobar el estado de la transaccion 
	 * 
	 * @return un Boolean con (True/False)
	 * @throws Exception
	 */
	public Boolean Activado (){
		Boolean r=null;
		if (!session.getTransaction().isActive())
			session.getTransaction().begin();
			r=session.getTransaction().isActive();
		if (session.getTransaction().isActive()){
			session.getTransaction().commit();
		}
		return r;
	}

}
