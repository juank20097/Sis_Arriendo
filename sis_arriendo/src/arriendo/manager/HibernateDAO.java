package arriendo.manager;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * 
 * @author Juan Carlos Estévez
 * @author Luis Alberto Cisneros
 *
 */

public class HibernateDAO {
	private static SessionFactory sessionFactory;
	private static Session session;

	public HibernateDAO() {
		if (sessionFactory == null)
			sessionFactory = buildSessionFactory();
		if (session == null)
			session = sessionFactory.openSession();
	}

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

	    /*private void manejaExcepcion(HibernateException he) throws HibernateException 
	    { 
	        tx.rollback(); 
	        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 
	    } 
*/

}
