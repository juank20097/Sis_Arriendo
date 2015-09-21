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
import arriendo.entidades.ARR_SitiosArticulos;
import arriendo.entidades.GEN_Articulos;
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
	private List<ARR_Contratos_Det> resp;
	private ARR_Contratos_Det contraTempDet;
	private String observacion;
	private Float costo;
	private char estado;
	private Integer sitio_sel;
	private String num_cab;
	private List<GEN_Articulos> lisArt;
	
	/******** HABILITADORES *****/
	private boolean guardado;
	private boolean finalizado;
	private boolean vboton;
	private boolean imprimir;
	private boolean valor;

	
	public ContratosBean() {
		mngCont = new ManagerContratos();
		guardado = true;
		finalizado = true;
		vboton = true;
		imprimir = true;
		valor= false;
		observacion ="";
		lisArt = new ArrayList<GEN_Articulos>();
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
	 * @return the lisArt
	 */
	public List<GEN_Articulos> getLisArt() {
		return lisArt;
	}
	/**
	 * @param lisArt the lisArt to set
	 */
	public void setLisArt(List<GEN_Articulos> lisArt) {
		this.lisArt = lisArt;
	}
	/**
	 * @return the valor
	 */
	public boolean isValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(boolean valor) {
		this.valor = valor;
	}
	/**
	 * @return the imprimir
	 */
	public boolean isImprimir() {
		return imprimir;
	}
	/**
	 * @param imprimir the imprimir to set
	 */
	public void setImprimir(boolean imprimir) {
		this.imprimir = imprimir;
	}
	/**
	 * @return the num_cab
	 */
	public String getNum_cab() {
		return num_cab;
	}
	/**
	 * @param num_cab the num_cab to set
	 */
	public void setNum_cab(String num_cab) {
		this.num_cab = num_cab;
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
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the resp
	 */
	public List<ARR_Contratos_Det> getResp() {
		return resp;
	}
	/**
	 * @param resp the resp to set
	 */
	public void setResp(List<ARR_Contratos_Det> resp) {
		this.resp = resp;
	}
	/**
	 * @return the costo
	 */
	public Float getCosto() {
		return costo;
	}
	/**
	 * @param costo the costo to set
	 */
	public void setCosto(Float costo) {
		this.costo = costo;
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
	 * @return the lista de contactos
	 */
	public List<ARR_Contratos_Cab> getListaContratos() {
		return mngCont.findAllContratos_Cab();
	}

	/**
	 * @return the lista de Contratos_Calusulas _det
	 */
	public List<ARR_ContratoClausulas_Det> getListClau() {
		if (getCab_numero() != null || !getCab_numero().isEmpty())
			listClau = mngCont.findAllClauByNroCont(getCab_numero());
		return listClau;
	}

	/**
	 * @return the lista de Personas
	 */
	public List<GEN_Personas> getLstPer() {
		lstPer = mngCont.findAllPersona();
		return lstPer;
	}

	/**
	 * @return the lista de las Plantilla de un contrato
	 */
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
	 * @return lista de las personas que se asemejan 
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
		setContraTempDet(null);
		setCab_fechaini(null);
		setCab_fechafin(null);
		setCab_numero(null);
		setCab_observacion(null);
		setCab_estado('A');
		finalizado = true;
		imprimir= true;
		guardado=true;
		valor = false;
		list = new ArrayList<ARR_Contratos_Det>();
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
				Mensaje.crearMensajeWARN("No se ha seleccionado una plantilla");
			} 
			 else {
				setContraTemp(mngCont.crearContratoTmp(getPersona(),
						new Timestamp(getCab_fechaini().getTime()),
						new Timestamp(getCab_fechafin().getTime()), getCpId(),
						getCpc_tipo(),getCab_observacion()));
				setCab_numero(getContraTemp().getCab_numero());
				setCab_observacion(getContraTemp().getCab_observacion());
				vboton=false;
				guardado=true;
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
			if (list.isEmpty() || list==null){
				Mensaje.crearMensajeWARN("Es necesario insertar un sitio antes de guardar");
			}
			else{
			setCab_numero(mngCont.guardarContratoTmp(getContraTemp(), getList()));
			setFinalizado(false);
			setGuardado(true);
			Mensaje.crearMensajeINFO("Contrato guardado de forma correcta");
		}
		}catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Permite finalizar el contrato
	 */
	public void finalizarContrato() {
		try {
			mngCont.finalizarContrato(getCab_numero(),lisArt);
			setFinalizado(true);
			setImprimir(false);
			setGuardado(true);
			setValor(true);
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
	 * Cancela contrato arriendo de una edicion
	 * 
	 * @return página de contratos arriendo
	 */
	public String cancelarContrato() throws Exception{
		//setPersona(null);
		//setPersonaId("");
		setCab_fechafin(null);
		setCab_fechaini(null);
		setCab_observacion(null);
		setCpId(null);
		setCab_numero(null);
		setGuardado(false);
		setFinalizado(false);
		if (resp.isEmpty()){
			System.out.println("Nada");
		}else{
		for (ARR_Contratos_Det ar : resp) {
			mngCont.insertar_contrato_det(ar);
		}
		}
		list = new ArrayList<ARR_Contratos_Det>();
		resp = new ArrayList<ARR_Contratos_Det>();
		return "convivienda?faces-redirect=true";
	}
	

	/**
	 * Cancela contrato de arriendo de una adicion
	 * 
	 * @return página de contratos arriendo
	 */
	public String cancelarContraton() throws Exception{
		//setPersona(null);
		//setPersonaId("");
		setCab_fechafin(null);
		setCab_fechaini(null);
		setCab_observacion(null);
		setCpId(null);
		setCab_numero(null);
		setGuardado(false);
		setFinalizado(false);
		list = new ArrayList<ARR_Contratos_Det>();
		resp = new ArrayList<ARR_Contratos_Det>();
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
	public String cargarDatosContrato(ARR_Contratos_Cab c) throws Exception {
		String r="";
		if (c.getCab_estado()=='I') {
			Mensaje.crearMensajeWARN("Este contrato no se puede Editar, porque ha sido ANULADO.");
			r="";
		} if (c.getCab_estado()=='F'){
			setCab_numero(c.getCab_numero());
			setNum_cab(c.getCab_numero());
			//setPersona(c.get);
			//setPersonaId(c.getGenPersona().getPerId());
			setCab_fechaini(new Date(c.getCab_fechaini().getTime()));
			setCab_fechafin(new Date(c.getCab_fechafin().getTime()));
			setCab_observacion(c.getCab_observacion());
			setGuardado(false);
			List<ARR_Contratos_Det> cd = mngCont.findAllContratos_Det();
			list= new ArrayList<ARR_Contratos_Det>();
			resp= new ArrayList<ARR_Contratos_Det>();
			System.out.println(cd.size());
			for (ARR_Contratos_Det a : cd) {
				if (a.getCon_cab().getCab_numero().equals(c.getCab_numero())){
					list.add(a);
					resp.add(a);
				}
			}
			this.buscarArticulo(list);
			if (c.getCab_estado()=='F'){
				setFinalizado(true);
				setValor(true);
				setGuardado(true);
		}
			else{
				setFinalizado(true);
				setValor(false);
			}
			r= "econvivienda?faces-redirect=true";
		}
		if (c.getCab_estado()=='A') {
			setCab_numero(c.getCab_numero());
			setNum_cab(c.getCab_numero());
			//setPersona(c.get);
			//setPersonaId(c.getGenPersona().getPerId());
			setCab_fechaini(new Date(c.getCab_fechaini().getTime()));
			setCab_fechafin(new Date(c.getCab_fechafin().getTime()));
			setCab_observacion(c.getCab_observacion());
			setGuardado(false);
			List<ARR_Contratos_Det> cd = mngCont.findAllContratos_Det();
			list= new ArrayList<ARR_Contratos_Det>();
			resp= new ArrayList<ARR_Contratos_Det>();
			System.out.println(cd.size());
			for (ARR_Contratos_Det a : cd) {
				if (a.getCon_cab().getCab_numero().equals(c.getCab_numero())){
					list.add(a);
					resp.add(a);
					mngCont.eliminar_contrato_det(a);
				}
			}
			this.buscarArticulo(list);
			if (c.getCab_estado()=='F'){
				setFinalizado(true);
				setValor(true);
				setGuardado(true);
		}
			else{
				setFinalizado(true);
				setValor(false);
			}
			r = "econvivienda?faces-redirect=true";	
			}
		return r;
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
			if (list.isEmpty() || list==null){
				Mensaje.crearMensajeWARN("Es necesario insertar un sitio antes de guardar");
			} else{
			mngCont.editarContratoCabG(getCab_numero(), getPersona(),
					new Timestamp(getCab_fechaini().getTime()), new Timestamp(
							getCab_fechafin().getTime()), getCab_observacion(), getList());
			resp = new ArrayList<ARR_Contratos_Det>();
			Mensaje.crearMensajeINFO("Cambios correctamente guardados");
			finalizado=false; }
		} catch (Exception e) {
			Mensaje.crearMensajeERROR(e.getMessage());
		}
	}

	/**
	 * Imprime un reporte de los datos de un contrato
	 */
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

	/**
	 * Muestra un reporte de los datos de un contrato
	 */
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
	 * Metodo de la lista de los sitios libres
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
	
	/**
	 * Metodo para insertar el sitio al contrato nuevo 
	 * 
	 * @return lista 
	 */
	public List<ARR_Contratos_Det> addContra_Tem() throws Exception{
		lisArt = new ArrayList<GEN_Articulos>();
		if (getSitio_sel()==null || getSitio_sel()==-1){
			Mensaje.crearMensajeINFO("Seleccione un sitio a añadir");
		}else{
			contraTempDet = mngCont.crearContratoTmpDet(observacion, sitio_sel);
			list.add(contraTempDet);
		}
		this.buscarArticulo(list);
		vboton=true;
		guardado=false;
		return list;
	}
	
	/**
	 * Metodo para insertar el sitio al contrato en una edición
	 * 
	 * @return lista 
	 */
	public List<ARR_Contratos_Det> addContra_Tem2() throws Exception{
		lisArt = new ArrayList<GEN_Articulos>();
		
		if (getSitio_sel()==null || getSitio_sel()==-1){
			Mensaje.crearMensajeINFO("Seleccione un sitio a añadir");
		}else{
			contraTempDet = mngCont.crearContratoTmpDet(observacion, sitio_sel);
			contraTempDet.setCon_cab(mngCont.findContratoByID(getNum_cab()));
			list.add(contraTempDet);
		}
		this.buscarArticulo(list);
		vboton=true;
		return list;
	}
	
	/**
	 * Metodo para eliminar el sitio al contrato
	 * @param a
	 * @return 
	 */
	public void quitarDet(ARR_Contratos_Det a){
		vboton=false;
		list.remove(a);
	}
	
	/**
	 * Metodo para mostrar el sitio en los contratos cabecera
	 * @param cc
	 * @return 
	 */
	public String sitioVer(ARR_Contratos_Cab cc){
		String r="";
		List<ARR_Contratos_Det> l=mngCont.findAllContratos_Det();
		for (ARR_Contratos_Det cd : l) {
			if (cc.getCab_numero()==cd.getCon_cab().getCab_numero()){
				r=cd.sit.getSit_nombre();
			}
		}
		return r;
	}
	
	/**
	 * Metodo para listar los articulos correcpondientes a un sitio
	 * 
	 * @return 
	 */
	public void buscarArticulo(List<ARR_Contratos_Det> l){
		lisArt = new ArrayList<GEN_Articulos>();
		List<ARR_SitiosArticulos> a= new ArrayList<ARR_SitiosArticulos>();
		List<ARR_SitiosArticulos> sa= mngCont.findAllSitiosArticulos();
		List<GEN_Articulos> art= mngCont.findAllArticulos();
		for (ARR_Contratos_Det acd : l) {
			for (ARR_SitiosArticulos s : sa) {
				if (acd.sit.getSit_id()==s.getSit().getSit_id()){
					a.add(s);
				}
			}
		}
		for (GEN_Articulos g : art) {
			for (ARR_SitiosArticulos j: a){
				if(j.getArt_id()==g.getArt_id()){
					lisArt.add(g);
				}
			}
			
		}
	}
	
	
	
	
	

}
