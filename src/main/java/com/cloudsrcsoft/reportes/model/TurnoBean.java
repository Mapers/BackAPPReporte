package com.cloudsrcsoft.reportes.model;

public class TurnoBean {
	private String codigoCompania;
	private String codigoLocal;
	private String secUsuLocal;
	private String turno;
	private String descripcion;
	
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
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
		return "TurnoBean [codigoCompania=" + codigoCompania + ", codigoLocal=" + codigoLocal + ", secUsuLocal="
				+ secUsuLocal + ", turno=" + turno + ", descripcion=" + descripcion + "]";
	}
}
