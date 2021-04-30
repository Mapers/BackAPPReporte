package com.cloudsrcsoft.reportes.request;

import java.util.List;

public class ReporteNum005Request extends BaseRequest{
	private String cSecUsu;
	private List<String> cListAnio;
	private List<String> cListMes;
	private List<String> cListEspecialidad;
	private List<String> cListConsultorio;
	private String cDesde;
	private String cHasta;
	public String getcSecUsu() {
		return cSecUsu;
	}
	public void setcSecUsu(String cSecUsu) {
		this.cSecUsu = cSecUsu;
	}
	public List<String> getcListAnio() {
		return cListAnio;
	}
	public void setcListAnio(List<String> cListAnio) {
		this.cListAnio = cListAnio;
	}
	public List<String> getcListMes() {
		return cListMes;
	}
	public void setcListMes(List<String> cListMes) {
		this.cListMes = cListMes;
	}
	public List<String> getcListEspecialidad() {
		return cListEspecialidad;
	}
	public void setcListEspecialidad(List<String> cListEspecialidad) {
		this.cListEspecialidad = cListEspecialidad;
	}
	public List<String> getcListConsultorio() {
		return cListConsultorio;
	}
	public void setcListConsultorio(List<String> cListConsultorio) {
		this.cListConsultorio = cListConsultorio;
	}
	public String getcDesde() {
		return cDesde;
	}
	public void setcDesde(String cDesde) {
		this.cDesde = cDesde;
	}
	public String getcHasta() {
		return cHasta;
	}
	public void setcHasta(String cHasta) {
		this.cHasta = cHasta;
	}
	
	
	
}
