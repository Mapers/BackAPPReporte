package com.cloudsrcsoft.reportes.request;

import java.util.List;

public class ReporteNum002Request extends BaseRequest{
	private String cSecUsu;
	private List<String> cListAnio;
	private List<String> cListMes;
	
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
}
