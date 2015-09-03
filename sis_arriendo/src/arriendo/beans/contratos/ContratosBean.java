package arriendo.beans.contratos;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import arriendo.entidades.ARR_ContratoClausulas_Det;
import arriendo.entidades.ARR_Contratos_Cab;
import arriendo.entidades.ARR_Contratos_Det;
import arriendo.entidades.GEN_ContratoPlantillas_Cab;
import arriendo.entidades.GEN_Personas;
import arriendo.entidades.GEN_Sitios;
import arriendo.generico.Mensaje;
import arriendo.manager.ManagerContratos;
import arriendo.manager.SitiosDAO;

@ManagedBean
@SessionScoped
public class ContratosBean implements Serializable {
	private static final long serialVersionUID =  -2629525039606674631L;
	private ManagerContratos mngCont;
	private SitiosDAO manager;
	/********** CABECERA *********/
	private String cab_numero;
	private String personaId;
	private GEN_Personas persona;
	private Date cab_fecha;
	private Date cab_fechaini;
	private Date cab_fechafin;
	private Date factual;
	private String cab_observacion;
	private char cab_estado;
	private String cpc_tipo;
	private Integer cpId;
	private ARR_Contratos_Cab contraTemp;

	/********** CLAUSULAS ********/
	private ARR_ContratoClausulas_Det clau;
	private Integer nroClau;
	private String clausula;
	/********** LISTADOS *********/
	private List<ARR_ContratoClausulas_Det> listClau;
	private List<GEN_Personas> lstPer;
	
	
	/********** DETALLE SITIOS *********/
	private List<ARR_Contratos_Det> list;
	private ARR_Contratos_Det contraTempDet;
	private String observacion;
	private Float costo;
	private char estado;
	private Integer sitio_sel;
	
	 
	/******** HABILITADORES *****/
	private boolean guardado;
	private boolean finalizado;
	private boolean vboton;

	public ContratosBean() {
		mngCont = new ManagerContratos();
		guardado = false;
		finalizado = false;
		vboton = true;
		list = new ArrayList<ARR_Contratos_Det>();
	}
	/**
	 * @return the cab_numero
	 */
	public String getCab_numero() {
		return cab_numero;
	}
	/**
	 * @param cab_numero the cab_numero to set
	 */
	public void setCab_numero(String cab_numero) {
		this.cab_numero = cab_numero;
	}
	
	/**
	 * @return the vboton
	 */
	public boolean isVboton() {
		return vboton;
	}
	/**
	 * @param vboton the vboton to set
	 */
	public void setVboton(boolean vboton) {
		this.vboton = vboton;
	}
	/**
	 * @return the contraTempDet
	 */
	public ARR_Contratos_Det getContraTempDet() {
		return contraTempDet;
	}
	/**
	 * @param contraTempDet the contraTempDet to set
	 */
	public void setContraTempDet(ARR_Contratos_Det contraTempDet) {
		this.contraTempDet = contraTempDet;
	}
	/**
	 * @return the list
	 */
	public List<ARR_Contratos_Det> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<ARR_Contratos_Det> list) {
		this.list = list;
	}
	/**
	 * @return the sitio_sel
	 */
	public Integer getSitio_sel() {
		return sitio_sel;
	}
	/**
	 * @param sitio_sel the sitio_sel to set
	 */
	public void setSitio_sel(Integer sitio_sel) {
		this.sitio_sel = sitio_sel;
	}
	/**
	 * @return the factual
	 */
	public Date getFactual() {
		factual = new Date();
		return factual;
	}
	/**
	 * @return the nroClau
	 */
	public Integer getNroClau() {
		return nroClau;
	}
	/**
	 * @param nroClau the nroClau to set
	 */
	public void setNroClau(Integer nroClau) {
		this.nroClau = nroClau;
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
	 * @return the cpId
	 */
	public Integer getCpId() {
		return cpId;
	}
	/**
	 * @param cpId the cpId to set
	 */
	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}
	/**
	 * @return the personaId
	 */
	public String getPersonaId() {
		return personaId;
	}
	/**
	 * @param personaId the personaId to set
	 */
	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}
	/**
	 * @return the persona
	 */
	public GEN_Personas getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(GEN_Personas persona) {
		this.persona = persona;
	}
	/**
	 * @return the cpc_tipo
	 */
	public String getCpc_tipo() {
		cpc_tipo = "GenVivienda";//TIPO DE BICICLETAS
		return cpc_tipo;
	}
	/**
	 * @param cpc_tipo the cpc_tipo to set
	 */
	public void setCpc_tipo(String cpc_tipo) {
		this.cpc_tipo = cpc_tipo;
	}
	/**
	 * @return the clau
	 */
	public ARR_ContratoClausulas_Det getClau() {
		return clau;
	}
	/**
	 * @param clau the clau to set
	 */
	public void setClau(ARR_ContratoClausulas_Det clau) {
		this.clau = clau;
	}
	/**
	 * @return the cab_fecha
	 */
	public Date getCab_fecha() {
		return cab_fecha;
	}
	/**
	 * @param cab_fecha the cab_fecha to set
	 */
	public void setCab_fecha(Date cab_fecha) {
		this.cab_fecha = cab_fecha;
	}
	/**
	 * @return the cab_fechaini
	 */
	public Date getCab_fechaini() {
		return cab_fechaini;
	}
	/**
	 * @param cab_fechaini the cab_fechaini to set
	 */
	public void setCab_fechaini(Date cab_fechaini) {
		this.cab_fechaini = cab_fechaini;
	}
	/**
	 * @return the cab_fechafin
	 */
	public Date getCab_fechafin() {
		return cab_fechafin;
	}
	/**
	 * @param cab_fechafin the cab_fechafin to set
	 */
	public void setCab_fechafin(Date cab_fechafin) {
		this.cab_fechafin = cab_fechafin;
	}
	/**
	 * @return the cab_observacion
	 */
	public String getCab_observacion() {
		return cab_observacion;
	}
	/**
	 * @param cab_observacion the cab_observacion to set
	 */
	public void setCab_observacion(String cab_observacion) {
		this.cab_observacion = cab_observacion;
	}
	/**
	 * @return the cab_estado
	 */
	public char getCab_estado() {
		return cab_estado;
	}
	/**
	 * @param cab_estado the cab_estado to set
	 */
	public void setCab_estado(char cab_estado) {
		this.cab_estado = cab_estado;
	}
	/**
	 * @return the contraTemp
	 */
	public ARR_Contratos_Cab getContraTemp() {
		return contraTemp;
	}
	/**
	 * @param contraTemp the contraTemp to set
	 */
	public void setContraTemp(ARR_Contratos_Cab contraTemp) {
		this.contraTemp = contraTemp;
	}
	/**
	 * @return the guardado
	 */
	public boolean isGuardado() {
		return guardado;
	}

	/**
	 * @param guardado
	 *            the guardado to set
	 */
	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}

	/**
	 * @return the finalizado
	 */
	public boolean isFinalizado() {
		return finalizado;
	}

	/**
	 * @param finalizado
	 *            the finalizado to set
	 */
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	/**
	 * @return the lista
	 */
	public List<ARR_Contratos_Cab> getListaContratos() {
		return mngCont.findAllContratos_Cab();
	}

	/**
	 * @return the listClau
	 */
	public List<ARR_ContratoClausulas_Det> getListClau() {
		if (getCab_numero() != null || !getCab_numero().isEmpty())
			listClau = mngCont.findAllClauByNroCont(getCab_numero());
		return listClau;
	}

	/**
	 * @return the lstPer
	 */
	public List<GEN_Personas> getLstPer() {
		lstPer = mngCont.findAllPersona();
		return lstPer;
	}

	public List<SelectItem> getListaPlantillas() {
		List<SelectItem> rsp = new ArrayList<SelectItem>();
		List<GEN_ContratoPlantillas_Cab> todos = mngCont
				.plantillasContratoPorContrato(getCpc_tipo());
		for (GEN_ContratoPlantillas_Cab p : todos) {
			rsp.add(new SelectItem(p.getCpc_id(), p.getCpc_nombre()));
		}
		return rsp;
	}

	/**
	 * Permite buscar una persona por dni
	 * 
	 * @param query
	 *            dni
	 * @return
	 */
	public List<GEN_Personas> completePersona(String query) {
		List<GEN_Personas> allPers = getLstPer();
		List<GEN_Personas> filterPers = new ArrayList<GEN_Personas>();
		for (GEN_Personas p : allPers) {
			if (p.getPer_id().toLowerCase().contains(query.toLowerCase()))
				filterPers.add(p);
		}
		return filterPers;
	}

	/**
	 * Redirecciona a crear nuevo contrato
	 * 
	 * @return
	 */
	public String nuevoContrato() {
		setContraTemp(null);
		setCab_fechaini(new Date());
		setCab_fechafin(new Date());
		return "nconvivienda?faces-redirect=true";
	}

	/**
	 * Busca la persona perteneciente al contrato
	 */
	public void buscarPersona() {
		try {
			GEN_Personas p = mngCont.findPersonaByID(getPersonaId());
			if (p == null) {
				Mensaje.crearMensajeWARN("No existe persona registrada");
			} else {
				setPersona(p);
			}
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Crea contrato temporal
	 */
	public void crearContrato() {
		try {
			if (getCab_fechafin() == null || getCab_fechaini() == null) {
				Mensaje.crearMensajeWARN("Seleccione la fecha inicio y fin para el contrato");
				System.out.println(cpId);
			} else
			if (cpId == null || cpId == -1 || cpId==0) {
				Mensaje.crearMensajeWARN("No se ha selleccionado una plantilla");
			} 
			 else {
				setContraTemp(mngCont.crearContratoTmp(getPersona(),
						new Timestamp(getCab_fechaini().getTime()),
						new Timestamp(getCab_fechafin().getTime()), getCpId(),
						getCpc_tipo()));
				setCab_numero(getContraTemp().getCab_numero());
				setCab_observacion(getContraTemp().getCab_observacion());
				vboton=false;
				Mensaje.crearMensajeINFO("Creación correcta");
			}
		} catch (Exception e) {
			Mensaje.crearMensajeWARN(e.getMessage());
		}
	}

	/**
	 * Carga datos de cláusula seleccionada
	 * 
	 * @param clau
	 *            cláusula
	 */
	public void cargarClausula(ARR_ContratoClausulas_Det clau) {
		setClau(clau);
		setNroClau(clau.getCcd_numero());
		setClausula(clau.getCcd_clausula());
	}

	/**
	 * Edita el texto de la claúsula cargada
	 */
	public void editarTextClausula() {
		mngCont.editarClausulaContratoTmp(getClau(), getClausula());
		setClau(null);
		setNroClau(null);
		setClausula("");
		Mensaje.crearMensajeINFO("Edición de cláusula correcta");
	}

	/**
	 * Cancela la edición de una claúsula
	 */
	public void cancelEdTextClausula() {
		setClau(null);
		setNroClau(null);
		setClausula("");
	}

	/**
	 * Guarda el contrato
	 */
	public void guardarContrato() {
		try {
			setCab_numero(mngCont.guardarContratoTmp(getContraTemp()));
			setGuardado(true);
			Mensaje.crearMensajeINFO("Contrato guardado de forma correcta");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Permite finalizar el contrato
	 */
	public void finalizarContrato() {
		try {
			mngCont.finalizarContrato(getCab_numero());
			setFinalizado(true);
			Mensaje.crearMensajeINFO("Finalización de contrato exitosa");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Permite anular el contrato
	 * 
	 * @return página xhtml correspondiente
	 */
	public String anularContrato() {
		try {
			mngCont.anularContrato(getCab_numero());
			Mensaje.crearMensajeINFO("Se anuló el contrato de forma correcta");
			return "convivienda?faces-redirect=true";
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
			return "";
		}

	}

	/**
	 * Cancela contrato bicicletas
	 * 
	 * @return página de contratos bicicleta
	 */
	public String cancelarContrato() {
		//setPersona(null);
		//setPersonaId("");
		setCab_fechafin(null);
		setCab_fechaini(null);
		setCab_observacion(null);
		setCpId(null);
		setGuardado(false);
		setFinalizado(false);
		setVboton(true);
		return "convivienda?faces-redirect=true";
	}

	/************************************ EDICIÓN ************************************/

	/**
	 * Carga los datos del contrato y setea variables boleanas de ayuda
	 * 
	 * @param c
	 *            contrato cabecera de bicicleta
	 * @return
	 */
	public String cargarDatosContrato(ARR_Contratos_Cab c) {
		if (c.getCab_estado()=='I') {
			Mensaje.crearMensajeWARN("Este contrato no se puede Editar, porque ha sido ANULADO.");
			return "";
		} else {
			setCab_numero(c.getCab_numero());
			//setPersona(c.get);
			//setPersonaId(c.getGenPersona().getPerId());
			setCab_fechaini(new Date(c.getCab_fechaini().getTime()));
			setCab_fechafin(new Date(c.getCab_fechafin().getTime()));
			setCab_observacion(c.getCab_observacion());
			setGuardado(true);
			if (c.getCab_estado()=='F')
				setFinalizado(true);
			else
				setFinalizado(false);
			return "econvivienda?faces-redirect=true";
		}
	}

	/**
	 * Edita Cláusula de contrato guardado
	 */
	public void editarClausulaG() {
		try {
			mngCont.editarClausulaContratoG(getClau(), getClausula());
			Mensaje.crearMensajeINFO("Claúsula editada correctamente");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Edita Cabecera de contrato guardado
	 */
	public void editarContratoG() {
		try {
			mngCont.editarContratoCabG(getCab_numero(), getPersona(),
					new Timestamp(getCab_fechaini().getTime()), new Timestamp(
							getCab_fechafin().getTime()), getCab_observacion());
			Mensaje.crearMensajeINFO("Cambios correctamente guardados");
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	public void imprimirRptContrato() {

		try {
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			String carpetaReportes = (String) servletContext
					.getRealPath(File.separatorChar + "reports");
			String rutaReporte = carpetaReportes + File.separatorChar
					+ "rptContratoBicicletas.jasper";
			// rutaReporte=
			// "reports"+File.separatorChar+"rptContratoBicicletas.jasper";

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

			Map<String, Object> parametros = new HashMap<String, Object>();
			ARR_Contratos_Cab c = mngCont.findContratoByID(getCab_numero());
			parametros.put("pNumero", getCab_numero());
			parametros.put("pEncabezado", c.getCab_observacion());
			//parametros.put("pPerID", c.getGenPersona().getPerId());
			//parametros.put("pApellidos", c.getGenPersona().getPerApellidos());
			//parametros.put("pNombres", c.getGenPersona().getPerNombres());
			parametros.put("pFechaInicio",
					formateador.format(c.getCab_fechaini()));
			parametros.put("pFechaFinal",
					formateador.format(c.getCab_fechafin()));
			parametros.put("pRutaImage", carpetaReportes + File.separatorChar
					+ "yachay-logo1.png");

			List<ARR_ContratoClausulas_Det> datos = mngCont
					.findAllClauByNroCont(getCab_numero());

			JasperPrint informe = JasperFillManager.fillReport(rutaReporte,
					parametros, new JRBeanCollectionDataSource(datos));
			HttpServletResponse response = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition",
					"attachment; filename=jsfReporte.pdf");
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(informe, stream);

			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

			// JasperViewer ventanaVisor = new JasperViewer(informe,false);

			// ventanaVisor.setVisible(true);

		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error al crear reporte: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public void mostrarRptContrato() {

		try {
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			String carpetaReportes = (String) servletContext
					.getRealPath(File.separatorChar + "reports");
			String rutaReporte = carpetaReportes + File.separatorChar
					+ "rptContratoBicicletas.jasper";
			// rutaReporte=
			// "reports"+File.separatorChar+"rptContratoBicicletas.jasper";

			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("pNumero", getCab_numero());
			parametros.put("pEncabezado", getCab_observacion());
			parametros.put("pPerID", getPersonaId());
			//parametros.put("pApellidos", getPersona().getPerApellidos());
			//parametros.put("pNombres", getPersona().getPerNombres());
			parametros
					.put("pFechaInicio", formateador.format(getCab_fechaini()));
			parametros.put("pFechaFinal", formateador.format(getCab_fechafin()));
			parametros.put("pRutaImage", carpetaReportes + File.separatorChar
					+ "yachay-logo1.png");

			List<ARR_ContratoClausulas_Det> datos = mngCont
					.findAllClauByNroCont(getCab_numero());

			JasperPrint informe = JasperFillManager.fillReport(rutaReporte,
					parametros, new JRBeanCollectionDataSource(datos));
			HttpServletResponse response = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition",
					"attachment; filename=jsfReporte.pdf");
			ServletOutputStream stream = response.getOutputStream();

			JasperExportManager.exportReportToPdfStream(informe, stream);

			stream.flush();
			stream.close();
			FacesContext.getCurrentInstance().responseComplete();

			// JasperViewer ventanaVisor = new JasperViewer(informe,false);

			// ventanaVisor.setVisible(true);

		} catch (Exception e) {
			Mensaje.crearMensajeERROR("Error al crear reporte: "
					+ e.getMessage());
			e.printStackTrace();
		}

	}
	
///////////////////////////////////////////////////////////////////DETALLES SITIOS////////////////////////////////////////////////////////////////
	
	/**
	 * Lista 
	 * 
	 * @return lista de todas
	 */
	public List<SelectItem> getlistSitios() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<GEN_Sitios> completo = manager.findAllSitios();
		for (GEN_Sitios s : completo) {
			if (s.getSit_estado()=='A'){
			lista.add(new SelectItem(s.getSit_id(), s.getSit_nombre()));
			}
			}
		return lista;
	}
	
	public List<ARR_Contratos_Det> addContra_Tem(){
		System.out.println("si entra");
		if (getSitio_sel()==null || getSitio_sel()==-1){
			Mensaje.crearMensajeINFO("Seleccione un sitio a añadir");
			System.out.println("se sale");
		}else{
			System.out.println(contraTemp.getCab_numero());
			System.out.println(sitio_sel);
		try {
			contraTempDet = mngCont.crearContratoTmpDet(observacion, costo, estado, sitio_sel, getContraTemp().getCab_numero());
			list.add(contraTempDet);
		} catch (Exception e) {
			Mensaje.crearMensajeINFO("no se pudo crear el detalle debido a este error: "+e);
		}
		}
		System.out.println(list.size());
		return list;
	}
	
	public void quitarDet(ARR_Contratos_Det a){
		list.remove(a);
	}
	
	public String irDetalle(){
		return "dconvivienda?faces-redirect=true";
	}
	
	public String irContrato(){
		return "nconvivienda?faces-redirect=true";
	}

}
