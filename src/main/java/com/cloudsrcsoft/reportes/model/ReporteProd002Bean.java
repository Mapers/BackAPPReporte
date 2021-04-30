package com.cloudsrcsoft.reportes.model;

public class ReporteProd002Bean {
	private String producto;
	private String ctdPedidos;
	private String ctdAtenciones;
	private String ppTotal;
	private String ptTotal;
	private String incremento;
	private String humanidad;
	private String tercero;
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCtdPedidos() {
		return ctdPedidos;
	}
	public void setCtdPedidos(String ctdPedidos) {
		this.ctdPedidos = ctdPedidos;
	}
	public String getCtdAtenciones() {
		return ctdAtenciones;
	}
	public void setCtdAtenciones(String ctdAtenciones) {
		this.ctdAtenciones = ctdAtenciones;
	}
	public String getPpTotal() {
		return ppTotal;
	}
	public void setPpTotal(String ppTotal) {
		this.ppTotal = ppTotal;
	}
	public String getPtTotal() {
		return ptTotal;
	}
	public void setPtTotal(String ptTotal) {
		this.ptTotal = ptTotal;
	}
	public String getIncremento() {
		return incremento;
	}
	public void setIncremento(String incremento) {
		this.incremento = incremento;
	}
	public String getHumanidad() {
		return humanidad;
	}
	public void setHumanidad(String humanidad) {
		this.humanidad = humanidad;
	}
	public String getTercero() {
		return tercero;
	}
	public void setTercero(String tercero) {
		this.tercero = tercero;
	}
	@Override
	public String toString() {
		return "ReporteProd002Bean [producto=" + producto + ", ctdPedidos=" + ctdPedidos + ", ctdAtenciones="
				+ ctdAtenciones + ", ppTotal=" + ppTotal + ", ptTotal=" + ptTotal + ", incremento=" + incremento
				+ ", humanidad=" + humanidad + ", tercero=" + tercero + "]";
	}
}
