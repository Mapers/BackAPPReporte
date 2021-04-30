package com.cloudsrcsoft.reportes.request;

public class ReporteVentasRequest {
	private String codigoCompania;
	private String codigoLocal;
	private String fechaInicio;
	private String fechaFin;
	private String usuarioCajero;
	private String consultorio;
	private String especialidad;
	private String inicioVenta;
	private String finVenta;
	private String turno;
	private String condicion;
	private String medico;
	private String servicio;
	private String ip;
	
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
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getUsuarioCajero() {
		return usuarioCajero;
	}
	public void setUsuarioCajero(String usuarioCajero) {
		this.usuarioCajero = usuarioCajero;
	}
	public String getConsultorio() {
		return consultorio;
	}
	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getInicioVenta() {
		return inicioVenta;
	}
	public void setInicioVenta(String inicioVenta) {
		this.inicioVenta = inicioVenta;
	}
	public String getFinVenta() {
		return finVenta;
	}
	public void setFinVenta(String finVenta) {
		this.finVenta = finVenta;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	@Override
	public String toString() {
		return "ReporteProd001Request [codigoCompania=" + codigoCompania + ", codigoLocal=" + codigoLocal
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", usuarioCajero=" + usuarioCajero
				+ ", consultorio=" + consultorio + ", especialidad=" + especialidad + ", inicioVenta=" + inicioVenta
				+ ", finVenta=" + finVenta + ", turno=" + turno + ", condicion=" + condicion + ", medico=" + medico
				+ ", servicio=" + servicio + ", ip=" + ip + "]";
	}
}
