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

import kioschay.model.entities.GenPersona;
import arriendo.entidades.ARR_ContratoClausulas_Det;
import arriendo.entidades.ARR_Contratos_Cab;
import arriendo.entidades.ARR_Inter_Per;
import arriendo.entidades.GEN_ContratoPlantillas_Cab;
import arriendo.entidades.GEN_Personas;
import arriendo.manager.ManagerContratos;

@ManagedBean
@SessionScoped
public class ContratosBean implements Serializable {
	private static final long serialVersionUID = 2414699501306955263L;
	private ManagerContratos mngCont;
	/********** CABECERA *********/
	private String cab_numero;
	private Date cab_fecha;
	private Date cab_fechaini;
	private Date cab_fechafin;
	private String cab_observacion;
	private char cab_estado;
	private String cpc_tipo;
	private GenPersona persona;

	private ARR_Contratos_Cab contraTemp;
	/********** CLAUSULAS ********/
	private ARR_ContratoClausulas_Det clau;
	/********** LISTADOS *********/
	private List<ARR_ContratoClausulas_Det> listClau;
	private List<GEN_Personas> lstPer;
	/*
	private Integer nroClau;
	private String clausula;
	/********** LISTADOS *********
	
	 */
	/******** HABILITADORES *****/
	private boolean guardado;
	private boolean finalizado;

	public ContratosBean() {
		mngCont = new ManagerContratos();
		guardado = false;
		finalizado = false;
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
	 * @return the cpc_tipo
	 */
	public String getCpc_tipo() {
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
			if (p.getPerId().toLowerCase().contains(query.toLowerCase()))
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
		return "nconbici?faces-redirect=true";
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
			if (getPersona() == null) {
				Mensaje.crearMensajeWARN("Seleccione persona de contrato");
			} else if (getFechaFin() == null || getFechaInicio() == null) {
				Mensaje.crearMensajeWARN("Seleccione la fecha inicio y fin para el contrato");
			} else {
				setContraTemp(mngCont.crearContratoTmp(getPersona(),
						new Timestamp(getFechaInicio().getTime()),
						new Timestamp(getFechaFin().getTime()), getCpId(),
						getArtTipo()));
				setContNro(getContraTemp().getConNumero());
				setDescripcion(getContraTemp().getConDescripcion());
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
	public void cargarClausula(PreContratoclausulasDet clau) {
		setClau(clau);
		setNroClau(clau.getCcdNumero());
		setClausula(clau.getCcdClausula());
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
			setContNro(mngCont.guardarContratoTmp(getContraTemp()));
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
			mngCont.finalizarContrato(getContNro());
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
			mngCont.anularContrato(getContNro());
			Mensaje.crearMensajeINFO("Se anuló el contrato de forma correcta");
			return "conbicicleta?faces-redirect=true";
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
		setPersona(null);
		setPersonaId("");
		setFechaFin(null);
		setFechaInicio(null);
		setGuardado(false);
		setFinalizado(false);
		return "conbicicleta?faces-redirect=true";
	}

	/************************************ EDICIÓN ************************************/

	/**
	 * Carga los datos del contrato y setea variables boleanas de ayuda
	 * 
	 * @param c
	 *            contrato cabecera de bicicleta
	 * @return
	 */
	public String cargarDatosContrato(PreContratoCab c) {
		if (c.getConEstado().equals(PreContratoCab.INACTIVO)) {
			Mensaje.crearMensajeWARN("Este contrato no se puede Editar, porque ha sido ANULADO.");
			return "";
		} else {
			setContNro(c.getConNumero());
			setPersona(c.getGenPersona());
			setPersonaId(c.getGenPersona().getPerId());
			setFechaInicio(new Date(c.getConFechaInicio().getTime()));
			setFechaFin(new Date(c.getConFechaFin().getTime()));
			setDescripcion(c.getConDescripcion());
			setGuardado(true);
			if (c.getConEstado().equals(PreContratoCab.FINALIZADO))
				setFinalizado(true);
			else
				setFinalizado(false);
			return "econbici?faces-redirect=true";
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
			mngCont.editarContratoCabG(getContNro(), getPersona(),
					new Timestamp(getFechaInicio().getTime()), new Timestamp(
							getFechaFin().getTime()), getDescripcion());
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
			PreContratoCab c = mngCont.findContratoByID(getContNro());
			parametros.put("pNumero", getContNro());
			parametros.put("pEncabezado", c.getConDescripcion());
			parametros.put("pPerID", c.getGenPersona().getPerId());
			parametros.put("pApellidos", c.getGenPersona().getPerApellidos());
			parametros.put("pNombres", c.getGenPersona().getPerNombres());
			parametros.put("pFechaInicio",
					formateador.format(c.getConFechaInicio()));
			parametros.put("pFechaFinal",
					formateador.format(c.getConFechaFin()));
			parametros.put("pRutaImage", carpetaReportes + File.separatorChar
					+ "yachay-logo1.png");

			List<PreContratoclausulasDet> datos = mngCont
					.findAllClauByNroCont(getContNro());

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
			parametros.put("pNumero", getContNro());
			parametros.put("pEncabezado", getDescripcion());
			parametros.put("pPerID", getPersonaId());
			parametros.put("pApellidos", getPersona().getPerApellidos());
			parametros.put("pNombres", getPersona().getPerNombres());
			parametros
					.put("pFechaInicio", formateador.format(getFechaInicio()));
			parametros.put("pFechaFinal", formateador.format(getFechaFin()));
			parametros.put("pRutaImage", carpetaReportes + File.separatorChar
					+ "yachay-logo1.png");

			List<PreContratoclausulasDet> datos = mngCont
					.findAllClauByNroCont(getContNro());

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

}
