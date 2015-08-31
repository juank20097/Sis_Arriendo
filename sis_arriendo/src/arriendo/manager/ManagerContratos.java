package arriendo.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import arriendo.entidades.ARR_Contratos_Cab;
import arriendo.entidades.ARR_ContratoClausulas_Det;
import arriendo.entidades.GEN_Contadores;
import arriendo.entidades.GEN_ContratoPlantillas_Cab;
import arriendo.entidades.GEN_ContratoPlantillaClausulas_Det;
import arriendo.entidades.GEN_Estados;
import arriendo.entidades.GEN_Personas;


public class ManagerContratos {
	private HibernateDAO mngDao;
	private GEN_ContratoPlantillas_Cab contPlanTemp;
	private ARR_Contratos_Cab contTemp;
	
	public ManagerContratos() {
		mngDao = new HibernateDAO();
	}
	
	/******************************CREAR PLANTILLAS*******************************/
	/**
	 * Devuelve un listado de todas las clausulas de la plantilla de un contrato
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_ContratoPlantillaClausulas_Det> findAllPlanClauDet(){
		return mngDao.findAll(GEN_ContratoPlantillaClausulas_Det.class);
	}
	
	/**
	 * Busca una clausula plantilla por ID
	 * @param id identificador
	 * @return
	 * @throws Exception
	 */
	public GEN_ContratoPlantillaClausulas_Det findPlanClauDetByID(Integer id) throws Exception{
		return (GEN_ContratoPlantillaClausulas_Det)
				mngDao.findById(GEN_ContratoPlantillaClausulas_Det.class, id);
	}
	
	public GEN_ContratoPlantillas_Cab findPlanCabByID(Integer id) throws Exception{
		return (GEN_ContratoPlantillas_Cab)
				mngDao.findById(GEN_ContratoPlantillas_Cab.class, id);
	}
	
	/**
	 * Devueve un HasMap de tipos de contratos con su clave valor
	 * @return
	 */
	public HashMap<String,String> getMatrizTipoContrato(){
		HashMap<String,String> mtc=new HashMap<String,String>();
		mtc.put("Bicicletas", "GenBicicleta");
		return mtc;
	}
	
	/**
	 * Devuelve un listado de todas las plantilla de un contrato
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_ContratoPlantillas_Cab> findAllContPlanCab(){
		return mngDao.findAll(GEN_ContratoPlantillas_Cab.class);
	}
	
	/**
	 * Crea una plantilla de contrato temporal
	 * @param nombre
	 * @param tipoContrato
	 * @param descripcion
	 * @return PreContratoplantillaCab
	 */
	public GEN_ContratoPlantillas_Cab crearPantillaContratoTmp(String nombre,String tipoContrato, String descripcion) throws Exception{
		contPlanTemp=new GEN_ContratoPlantillas_Cab();
		contPlanTemp.setCpc_estado('A');
	    contPlanTemp.setCpc_nombre(nombre);
	    contPlanTemp.setCpc_tipo(tipoContrato);
	    contPlanTemp.setCpc_descripcion(descripcion);
		contPlanTemp.setCon_p_d(new ArrayList<GEN_ContratoPlantillaClausulas_Det>());
		return contPlanTemp;
	}
	
	/**
	 * Permite agregar una cláusula a la plantilla de copntrato temporal
	 * @param codigo numeración de la cláusula
	 * @param clausula texto de la clausula
	 * @throws Exception
	 */
	public void addClausulaPlantillaContrato(Integer codigo, String clausula) throws Exception{
		GEN_ContratoPlantillaClausulas_Det det;
		
		if(contPlanTemp==null)
			throw new Exception("Error!, se debe crear primero una plantilla de contrato.");
		
		det = new GEN_ContratoPlantillaClausulas_Det();
		det.setCpd_numero(codigo);
		det.setCpp_clausula(clausula);
		det.setCpd_estado('A');
		
		contPlanTemp.getCon_p_d().add(det);
	}
	
	/**
	 * Remueve una clausula en el contrato temporal
	 * @param d clausula temporal
	 */
	public void removeClausulaPlantillaTmp(GEN_ContratoPlantillaClausulas_Det d){
		contPlanTemp.removeCon_p_d(d);
	}
	
	/**
	 * Guardar la plantilla de contrato
	 * @param contraPlanTmp plantilla de contrato temporal
	 * @throws Exception
	 */
	public void saveContratoPlantillaTmp(GEN_ContratoPlantillas_Cab contraPlanTmp) throws Exception{
		if(contraPlanTmp==null)
			throw new Exception("Debe crear primero una plantilla de contrato.");
		if(contraPlanTmp.getCon_p_d()== null || 
				contraPlanTmp.getCon_p_d().size() == 0)
			throw new Exception("debe ingresar claúsulas al contrato");
		System.out.println("entra2");
		//Seteo de cláusulas
		for (GEN_ContratoPlantillaClausulas_Det d: contraPlanTmp.getCon_p_d()) {
			System.out.println("entra 1 23 4");
			d.setCon_p_c(contraPlanTmp);
		}
		System.out.println("ya mismo");
		//guardamos la plantilla de contrato
		mngDao.insertar(contraPlanTmp);
		contraPlanTmp=null;
		contPlanTemp=null;
	}
	
	/**
	 * Verifica la existencia de un mismo contrato para no crearlo nuevamente
	 * @param tipoContrato
	 * @return
	 */
	public boolean existePlantillaContratoActiva(String tipoContrato){
		List<GEN_ContratoPlantillas_Cab> todos = findAllContPlanCab();
		for (GEN_ContratoPlantillas_Cab cont : todos) {
			if(cont.getCpc_tipo().toLowerCase().equals(tipoContrato.toLowerCase()) && 
					cont.getCpc_estado()=='A'){
				return true;
			}
		}
		return false;
	}
	
	/******************************EDITAR PLANTILLAS******************************/
	/**
	 * Busca las clausulas por id de contrato
	 * @param contId identificador de plantilla contrato cabecera
	 * @return List<PreContratoplantillaclausulasDet>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_ContratoPlantillaClausulas_Det> findAllClauPlanByContID(Integer contId){
		List<GEN_ContratoPlantillaClausulas_Det> resp = new ArrayList<GEN_ContratoPlantillaClausulas_Det>();
		List<GEN_ContratoPlantillaClausulas_Det> todos = mngDao.findAll(GEN_ContratoPlantillaClausulas_Det.class);
		for (GEN_ContratoPlantillaClausulas_Det p : todos) {
			if(p.getCon_p_c().getCpc_id()==contId){
				resp.add(p);
			}
		}
		return resp;
	}
	
	/**
	 * Busca una clausula por id
	 * @param idClau identificador
	 * @return
	 * @throws Exception
	 */
	public GEN_ContratoPlantillaClausulas_Det findClausulaPLantillaDetByID(Integer idClau) throws Exception{
		return (GEN_ContratoPlantillaClausulas_Det) mngDao.findById(GEN_ContratoPlantillaClausulas_Det.class, idClau);
	}
	
	/**
	 * Añade clausula a una plantilla de contrato
	 * @param codigo
	 * @param clausula
	 * @param plantilla
	 * @throws Exception
	 */
	public void sumClausulaPlantillaContrato(Integer codigo, String clausula, 
			GEN_ContratoPlantillas_Cab plantilla) throws Exception{
		GEN_ContratoPlantillaClausulas_Det clau = new GEN_ContratoPlantillaClausulas_Det();
		clau.setCpd_numero(codigo);clau.setCpp_clausula(clausula);clau.setCon_p_c(plantilla);
		clau.setCpd_estado('A');
		mngDao.insertar(clau);
	}
	
	/**
	 * Edita el contenido de una clausula 
	 * @param idClau
	 * @param clausula
	 * @throws Exception
	 */
	public void editClausulaPlantillaContrato(Integer idClau, String clausula)throws Exception{
		GEN_ContratoPlantillaClausulas_Det clau = findClausulaPLantillaDetByID(idClau);
		clau.setCpp_clausula(clausula);
		mngDao.actualizar(clau);
	}
	
	/**
	 * Activa o desactiva una clausula perteneciente a una plantilla
	 * @param idClau
	 * @throws Exception
	 */
	public void cambioEstadoClausulaPlantillaContrato(Integer idClau)throws Exception{
		GEN_ContratoPlantillaClausulas_Det clau = findClausulaPLantillaDetByID(idClau);
		if(clau.getCpd_estado()==('A')){
			clau.setCpd_estado('I');
		}else{
			clau.setCpd_estado('A');
		}
		mngDao.actualizar(clau);
	}
	
	/**
	 * Edita la cabecera de una plantilla
	 * @param cabecera
	 * @param nombre
	 * @param descripcion
	 * @throws Exception
	 */
	public void editarCabPlanContrato(GEN_ContratoPlantillas_Cab cabecera, String nombre, String descripcion, char estado)throws Exception{
		cabecera.setCpc_nombre(nombre);cabecera.setCpc_descripcion(descripcion);cabecera.setCpc_estado(estado);
		mngDao.actualizar(cabecera);
	}
		
	/******************************CREAR CONTRATOS*******************************/
	/**Metodo para listar todos los contratos cabecera
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_Contratos_Cab> findAllContratos_Cab(){
		return mngDao.findAll(ARR_Contratos_Cab.class);
	}
	
	/**
	 * Retorna el valor de un contador segun cu clave (nombre)
	 * @param clave
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GEN_Contadores findContadorByClave(String clave)throws Exception{
		GEN_Contadores cont = null;
		List<GEN_Contadores> lista = mngDao.findByParam(GEN_Contadores.class, "o.cntClave", clave, null);
		if(lista == null || lista.isEmpty())
			throw new Exception("La consulta no dió resultados");
		cont = lista.get(0);
		return cont;
	}
	
	public Integer lastValueCont(String clave) throws Exception{
		return findContadorByClave(clave).getCnt_valor();
	}
	
	public void plusLastValueCont(String clave) throws Exception{
		GEN_Contadores cont = findContadorByClave(clave);
		Integer val = cont.getCnt_valor();
		val++;
		cont.setCnt_valor(val);
		mngDao.actualizar(cont);
	}
	
	/**
	 * Retorna persona por numero de ci o ruc
	 * @return GenPersona
	 * @throws Exception
	 */
	public GEN_Personas findPersonaByID(String ciRuc) throws Exception{
		return (GEN_Personas) mngDao.findById(GEN_Personas.class, ciRuc);
	}
	
	@SuppressWarnings("unchecked")
	public List<GEN_Personas> findAllPersona(){
		return mngDao.findAll(GEN_Personas.class);
	}
	
	
	/**
	 * Busca Las plantillas de contrato según el tipo
	 * @param tipoContrato
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GEN_ContratoPlantillas_Cab> plantillasContratoPorContrato(String tipoContrato){
		List<GEN_ContratoPlantillas_Cab> listado = mngDao.findWhere(GEN_ContratoPlantillas_Cab.class, "o.cpc_tipo='"
				+tipoContrato+"' AND o.cpc_estado='A'", null);	
		return listado;
	}
	
	
	public GEN_ContratoPlantillas_Cab plantillaContratoByID(Integer cpcId) throws Exception{
		return (GEN_ContratoPlantillas_Cab) mngDao.findById(GEN_ContratoPlantillas_Cab.class, cpcId);
	}
	
	
	/**
	 * Devuelve una lista de Claúsulas según el tipo de contrato
	 * @param tipoContrato
	 * @return
	 */
	public List<ARR_ContratoClausulas_Det> cargarClausulasPorContrato(Integer cpId) throws Exception{
		GEN_ContratoPlantillas_Cab plantilla =  plantillaContratoByID(cpId);
		
		List<GEN_ContratoPlantillaClausulas_Det> todos = findAllClauPlanByContID(plantilla.getCpc_id());
		List<ARR_ContratoClausulas_Det> list = new ArrayList<ARR_ContratoClausulas_Det>();
		
		for (GEN_ContratoPlantillaClausulas_Det clau : todos) {
			if(clau.getCpd_estado()==('A')){
				ARR_ContratoClausulas_Det d = new ARR_ContratoClausulas_Det();
				d.setCcd_numero(clau.getCpd_numero());
				d.setCcd_clausula(clau.getCpp_clausula());
				d.setCcd_estado('A');
				list.add(d);
			}
		}
		
		return list;
	}
	
	/**
	 * Crea un contrato temporal
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param tipoContrato
	 * @return
	 */
	public ARR_Contratos_Cab crearContratoTmp(GEN_Personas persona, 
			Timestamp fechaInicio, Timestamp fechaFin, 
			Integer cpId, String tipoContrato) throws Exception{
		GEN_ContratoPlantillas_Cab plantilla =  plantillaContratoByID(cpId);
		contTemp = new ARR_Contratos_Cab();
		contTemp.setCab_numero("CNTA"+lastValueCont("contratoarriendo"));
		contTemp.setCab_fecha(new Timestamp(new Date().getTime()));
		//contTemp.set(persona);
		contTemp.setCab_fechaini(fechaInicio);
		contTemp.setCab_fechafin(fechaFin);
		contTemp.setCpc_tipo(tipoContrato);
		contTemp.setCab_observacion(plantilla.getCpc_descripcion());
		contTemp.setCab_estado('A');
		contTemp.setCon_cla_d(this.cargarClausulasPorContrato(cpId));
		return contTemp;
	}
	
	/**
	 * Edita la clausula de un contrato determinado
	 * @param clau
	 * @param contenidoClau
	 */
	public void editarClausulaContratoTmp(ARR_ContratoClausulas_Det clau, String contenidoClau){
		for (ARR_ContratoClausulas_Det c : contTemp.getCon_cla_d()) {
			if(c.getCcd_numero().compareTo(clau.getCcd_numero())==0){
				c.setCcd_clausula(contenidoClau);
			}
		}
	}
	
	/**
	 * Guardar contrato temporal
	 * @param contraTemp
	 * @throws Exception
	 */
	public String guardarContratoTmp(ARR_Contratos_Cab contraTemp) throws Exception{
		if(contraTemp==null)
			throw new Exception("Primero dede crear contrato");
		//Setear numero de contrato
		String nro = "CNTB"+lastValueCont("contratobicicleta");
		contraTemp.setCab_numero(nro);
		//Seteo de clausulas
		for(ARR_ContratoClausulas_Det det : contraTemp.getCon_cla_d()){
			det.setCon_cab(contraTemp);
		}
		//Ingreso de contrato
		mngDao.insertar(contraTemp);
		contraTemp = null;
		contTemp = null;
		//Ingreso de contador
		plusLastValueCont("contratobicicleta");
		
		return nro;
	}
	
	/**
	 * Busca contrato por nro de identificación
	 * @param nroContrato
	 * @return PreContratoCab
	 * @throws Exception
	 */
	public ARR_Contratos_Cab findContratoByID(String nroContrato) throws Exception{
		return (ARR_Contratos_Cab) mngDao.findById(ARR_Contratos_Cab.class, nroContrato);
	}
	
	/**
	 * Anula un contrato ya creado
	 * @param nroContrato
	 * @throws Exception
	 */
	public void anularContrato(String nroContrato) throws Exception{
		ARR_Contratos_Cab c = findContratoByID(nroContrato);
		c.setCab_estado('I');
		mngDao.actualizar(c);
	}
	
	/**
	 * Finaliza un contrato ya creado
	 * @param nroContrato
	 * @throws Exception
	 */
	public void finalizarContrato(String nroContrato) throws Exception{
		ARR_Contratos_Cab c = findContratoByID(nroContrato);
		c.setCab_estado('F');
		mngDao.actualizar(c);
	}
	
	/******************************EDITAR CONTRATOS******************************/
	
	/**
	 * Busca todas las cláusulas por nro de contrato
	 * @param nroCont
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ARR_ContratoClausulas_Det> findAllClauByNroCont(String nroCont){
		return mngDao.findWhere(ARR_ContratoClausulas_Det.class, "o.preContratoCab.conNumero='"+nroCont+"'", "o.ccdNumero ASC");
	}
	
	/**
	 * Edita la clausula de un contrato determinado
	 * @param clau
	 * @param contenidoClau
	 */
	public void editarClausulaContratoG(ARR_ContratoClausulas_Det clau, String contenidoClau) throws Exception{
		clau.setCcd_clausula(contenidoClau);
		mngDao.actualizar(clau);
	}
	
	/**
	 * Actualiza los datos de un contrato guardado
	 * @param nroContrato
	 * @param persona
	 * @param fechaInicio
	 * @param fechaFin
	 * @param descripcion
	 * @throws Exception
	 */
	public void editarContratoCabG(String nroContrato,GEN_Personas persona, Timestamp fechaInicio, 
			Timestamp fechaFin, String descripcion) throws Exception{
		ARR_Contratos_Cab cont = findContratoByID(nroContrato);
		cont.setCab_fechaini(fechaInicio);cont.setCab_fechafin(fechaFin);
		//cont.setGenPersona(persona);
		cont.setCab_observacion(descripcion);
		mngDao.actualizar(cont);
	}
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
		return mngDao.findAll(GEN_Estados.class);
	}// Cierre del metodo
		
}