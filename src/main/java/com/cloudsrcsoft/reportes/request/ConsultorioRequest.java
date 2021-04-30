package com.cloudsrcsoft.reportes.request;

public class ConsultorioRequest extends BaseRequest{
	private String secUsuLocal;
	private String idEspecialidad;
	
	public String getSecUsuLocal() {
		return secUsuLocal;
	}
	public void setSecUsuLocal(String secUsuLocal) {
		this.secUsuLocal = secUsuLocal;
	}
	public String getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
}
