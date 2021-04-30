package com.cloudsrcsoft.reportes.model;

public class ServicioBean {
	private String codigoProducto;
	private String descripcion;
	private String codigoCompania;
	private String codigoLocal;
	private String codigoEspecialidad;
	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
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
	public String getCodigoEspecialidad() {
		return codigoEspecialidad;
	}
	public void setCodigoEspecialidad(String codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}
	@Override
	public String toString() {
		return "ServicioBean [codigoProducto=" + codigoProducto + ", descripcion=" + descripcion + ", codigoCompania="
				+ codigoCompania + ", codigoLocal=" + codigoLocal + ", codigoEspecialidad=" + codigoEspecialidad + "]";
	}
}
