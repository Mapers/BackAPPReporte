package com.cloudsrcsoft.reportes.request;

public class CodigoMedicoRequest {
	private String codMedico;
	private String apellido;
	private String nombre;
	private String cpm;
	
	public String getCodMedico() {
		return codMedico;
	}
	public void setCodMedico(String codMedico) {
		this.codMedico = codMedico;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCpm() {
		return cpm;
	}
	public void setCpm(String cpm) {
		this.cpm = cpm;
	}
	
}
