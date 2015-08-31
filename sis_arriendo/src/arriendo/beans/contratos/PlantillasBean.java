package arriendo.beans.contratos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import arriendo.entidades.GEN_ContratoPlantillas_Cab;
import arriendo.entidades.GEN_ContratoPlantillaClausulas_Det;
import arriendo.entidades.GEN_Estados;
import arriendo.generico.Mensaje;
import arriendo.manager.ManagerContratos;

@ManagedBean
@SessionScoped
public class PlantillasBean implements Serializable{
	private static final long serialVersionUID = -2629525039606674631L;
	
	private ManagerContratos mngCont;
	/************CABECERA************/
	private Integer idContPlan;
	private String nombre;
	private String descripcion;
	private char estado;
	private String tipoContrato;
	private GEN_ContratoPlantillas_Cab planCabTmp;
	/************DETALLE*************/
	private Integer idClauPlan;
	private Integer nroClausula;
	private String clausula;
	/************LISTADO*************/
	private List<GEN_ContratoPlantillas_Cab> listPlanCab; //USADA EN PAG PRINCIPAL
	private List<GEN_ContratoPlantillaClausulas_Det> listClauDet; //USADA EN EDICION
	
	public PlantillasBean() {
		mngCont = new ManagerContratos();
	}

	/**
	 * @return the idContPlan
	 */
	public Integer getIdContPlan() {
		return idContPlan;
	}

	/**
	 * @param idContPlan the idContPlan to set
	 */
	public void setIdContPlan(Integer idContPlan) {
		this.idContPlan = idContPlan;
	}

	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the estado
	 */
	public char getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(char estado) {
		this.estado = estado;
	}
	/**
	 * @return the tipoContrato
	 */
	public String getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	/**
	 * @return the nroClausula
	 */
	public Integer getNroClausula() {
		return nroClausula;
	}

	/**
	 * @param nroClausula the nroClausula to set
	 */
	public void setNroClausula(Integer nroClausula) {
		this.nroClausula = nroClausula;
	}

	/**
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
	}
	
	/**
	 * @return the idClauPlan
	 */
	public Integer getIdClauPlan() {
		return idClauPlan;
	}

	/**
	 * @param idClauPlan the idClauPlan to set
	 */
	public void setIdClauPlan(Integer idClauPlan) {
		this.idClauPlan = idClauPlan;
	}

	/**
	 * @return the planCabTmp
	 */
	public GEN_ContratoPlantillas_Cab getPlanCabTmp() {
		return planCabTmp;
	}

	/**
	 * @param planCabTmp the planCabTmp to set
	 */
	public void setPlanCabTmp(GEN_ContratoPlantillas_Cab planCabTmp) {
		this.planCabTmp = planCabTmp;
	}
		
	/**
	 * @return the listClauDet
	 */
	public List<GEN_ContratoPlantillaClausulas_Det> getListClauDet() {
		try
		{
			if(getIdContPlan()!=0L)
			listClauDet = mngCont.findAllClauPlanByContID(planCabTmp.getCpc_id());
		}
		catch(Exception e)
		{
			Mensaje.crearMensajeWARN(e.getMessage());
		}
		return listClauDet;
	}

	/**
	 * @return the listado
	 */
	public List<GEN_ContratoPlantillas_Cab> getListPlanCab() {
		listPlanCab = mngCont.findAllContPlanCab();
		return listPlanCab;
	}
	
	/**
	 * Redirecciona a crear nuevo contrato
	 * @return
	 */
	public String nuevaPlantillaContrato(){
		setPlanCabTmp(null);
		return "ncontratos?faces-redirect=true";
	}
	
	/**
	 * Crea la plantilla de contrato temporal
	 */
	public void crearPlantillaContrato(){
		try {
			System.out.println("entra");
			if(getTipoContrato().isEmpty() || getTipoContrato()==null){
				Mensaje.crearMensajeWARN("Seleccione tipo de contrato");
			}
			else{
			setPlanCabTmp(mngCont.crearPantillaContratoTmp(getNombre(),  getTipoContrato(),getDescripcion()));
			Mensaje.crearMensajeINFO("Creación correcta");
			}
		} catch (Exception e) {
			Mensaje.crearMensajeWARN(e.getMessage());
		}
	}
	
	/**
	 * Agregar cláusula a plantilla de contrato
	 */
	public void agregarClauPlanCont(){
		try {
			mngCont.addClausulaPlantillaContrato(getNroClausula(), getClausula());
			Mensaje.crearMensajeINFO("Cláusula agregada correctamente");
			setNroClausula(null);setClausula("");
		} catch (Exception e) {
			Mensaje.crearMensajeWARN(e.getMessage());
		}
	}
	
	/**
	 * Cancela la acción de agregar claúsula
	 */
	public void cancelAgregarClau() {
		setNroClausula(null);setClausula("");
		Mensaje.crearMensajeINFO("Se ha cancelado la creación de cláusula");
	}
	
	/**
	 * Quita cláusula creada
	 */
	public void quitarClauPlanCont(GEN_ContratoPlantillaClausulas_Det d){
		try {
			mngCont.removeClausulaPlantillaTmp(d);
			Mensaje.crearMensajeINFO("Cláusula eliminada correctamente");
		} catch (Exception e) {
			Mensaje.crearMensajeWARN(e.getMessage());
		}
	}
	
	/**
	 * Guarda la plantilla de contrato
	 * @return contratos page
	 */
	public String guardarPlantCont(){
		try {
			System.out.println("entraaaa");
			mngCont.saveContratoPlantillaTmp(getPlanCabTmp());		
			Mensaje.crearMensajeINFO("Plantilla de contrato almacenada correctamente");
			setTipoContrato("");setNombre("");setDescripcion("");setPlanCabTmp(null);
			return "contratos?faces-redirect=true";
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
			return "";
		}
	}
	
	/**
	 * Cancela la creación de plantilla
	 * @return
	 */
	public String cancelarPlantilla(){
		setTipoContrato("");setNombre("");setDescripcion("");setPlanCabTmp(null);
		return "contratos?faces-redirect=true";
	}
	
	/**
	 * Listado de tipos de contratos existentes
	 * @return List<SelectItem>
	 */
	@SuppressWarnings("rawtypes")
	public List<SelectItem> listaTiposContrato(){
		List<SelectItem> tipos = new ArrayList<SelectItem>();
		HashMap<String,String> mapa = mngCont.getMatrizTipoContrato();
		Iterator iterator = mapa.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			tipos.add(new SelectItem(mentry.getValue().toString(), mentry.getKey().toString()));
		}
		return tipos;
	}
	
	/*****************************EDICION******************************/
	/**
	 * Carga los datos pertenecientes a una plantilla de contratos
	 * @param p plantilla de contratos
	 * @return
	 */
	public String cargarDatosPlanCont(GEN_ContratoPlantillas_Cab p){
		setIdContPlan(p.getCpc_id());
		setNombre(p.getCpc_nombre());
		setDescripcion(p.getCpc_descripcion());
		setEstado(p.getCpc_estado());
		return "econtratos?faces-redirect=true";
	}
	
	/**
	 * Carga los datos pertenecientes a una cláusula de contrato
	 * @param d claúsula
	 */
	public void cargarClauPlan(GEN_ContratoPlantillaClausulas_Det d){
		idClauPlan=d.getCpd_id();
		nroClausula=d.getCpd_numero();
		clausula=d.getCpp_clausula();
	}
	
	/**
	 * Edita los datos de una claúsula del contrato
	 */
	public void editarClauCont(){
		try {
			mngCont.editClausulaPlantillaContrato(getIdClauPlan(), getClausula());
			Mensaje.crearMensajeINFO("Edición de claúsula correcta");
			setClausula("");setIdClauPlan(0);setNroClausula(null);
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}
	
	/**
	 * Agrega una nueva cláusula al contrato
	 */
	public void agregarClauCont(){
		try {
			mngCont.sumClausulaPlantillaContrato(getNroClausula(), getClausula(), getPlanCabTmp());
			Mensaje.crearMensajeINFO("Claúsula agragada correctamente");
			setClausula("");setNroClausula(null);
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}
	
	/**
	 * Cambia de estado a una cláusula de contrato
	 * @param d claúsula
	 */
	public void cambioEstadoClau(GEN_ContratoPlantillaClausulas_Det d){
		try {
			mngCont.cambioEstadoClausulaPlantillaContrato(d.getCpd_id());
			Mensaje.crearMensajeINFO("Cambio de estado correcto");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}
	
	/**
	 * Finaliza la edición de contrato
	 * @return pag de contratos
	 */
	public String finalizarED(){
		try {
			mngCont.editarCabPlanContrato(getPlanCabTmp(), getNombre(), getDescripcion(), getEstado());
			setPlanCabTmp(null);setIdContPlan(0);setNombre("");setDescripcion("");
			return "contratos?faces-redirect=true";
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
			return "contratos?faces-redirect=true";
		}
	}
	
	/**
	 * Lista de estados /////////////////////metodo a
	 * repetir//////////////////////////////
	 * 
	 * @return lista de todos los estados
	 */
	public List<SelectItem> getlistEstados() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Estados> completo = mngCont.findAllEstados();
		for (GEN_Estados est : completo) {
			lista.add(new SelectItem(est.getEst_id(), est.getEst_id() + " : "
					+ est.getEst_nombre()));
		}
		return lista;
	}
	
	/**
	 * Cancela la acción de editar o crear una claúsula
	 */
	public void cancelarClau() {
		setNroClausula(null);setClausula("");
		Mensaje.crearMensajeINFO("Se ha cancelado el proceso de cláusula");
	}
	
	/**
	 * Cancela la creación de plantilla
	 * @return
	 */
	public String cancelarEdPlantilla(){
		setPlanCabTmp(null);setIdContPlan(0);setNombre("");setDescripcion("");
		return "contratos?faces-redirect=true";
	}
}
