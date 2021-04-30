package com.cloudsrcsoft.reportes.request;

public class DetallePedidoLabRequest extends BaseRequest{
	
	private String correlativo;
	private String tipoComp;
	private String numComp;
	
	public String getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}
	public String getTipoComp() {
		return tipoComp;
	}
	public void setTipoComp(String tipoComp) {
		this.tipoComp = tipoComp;
	}
	public String getNumComp() {
		return numComp;
	}
	public void setNumComp(String numComp) {
		this.numComp = numComp;
	}
	@Override
	public String toString() {
		return "DetallePedidoLabRequest [correlativo=" + correlativo + ", tipoComp=" + tipoComp + ", numComp=" + numComp
				+ "]";
	}
	
	
}
