package com.cloudsrcsoft.reportes.request;

public class BaseRequest {
	private String codGrupoCia;
	private String codLocal;
	
	public BaseRequest() {
		this.codGrupoCia = "";
		this.codLocal = "";
	}
	
	public String getCodGrupoCia() {
		return codGrupoCia;
	}
	public void setCodGrupoCia(String codGrupoCia) {
		this.codGrupoCia = codGrupoCia;
	}
	public String getCodLocal() {
		return codLocal;
	}
	public void setCodLocal(String codLocal) {
		this.codLocal = codLocal;
	}
	
	
}
