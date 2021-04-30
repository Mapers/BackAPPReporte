package com.cloudsrcsoft.reportes.model;

public class ConsultorioBean {
	private String codigoCompania;
	private String codigoLocal;
	private String especialidad;
	
	public String getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(String codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoLocal() {
		return codigoLocal;
	}
	public void setCodigoLocal(String codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	@Override
	public String toString() {
		return "ConsultorioBean [codigoCompania=" + codigoCompania + ", codigoLocal=" + codigoLocal + ", especialidad="
				+ especialidad + "]";
	}
	
	
}
