package com.cloudsrcsoft.reportes.model;

public class CondicionBean {
	private String codigoCompania;
	private String codigoLocal;
	private String secUsuLocal;
	private String condicion;
	private String descripcion;
	
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
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
	public String getSecUsuLocal() {
		return secUsuLocal;
	}
	public void setSecUsuLocal(String secUsuLocal) {
		this.secUsuLocal = secUsuLocal;
	}
	@Override
	public String toString() {
		return "CondicionBean [codigoCompania=" + codigoCompania + ", codigoLocal=" + codigoLocal + ", secUsuLocal="
				+ secUsuLocal + ", condicion=" + condicion + ", descripcion=" + descripcion + "]";
	}
	
	
}
