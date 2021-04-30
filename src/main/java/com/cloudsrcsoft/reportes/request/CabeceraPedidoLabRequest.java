package com.cloudsrcsoft.reportes.request;

public class CabeceraPedidoLabRequest extends BaseRequest{
	private String correlativo;
	private String numCompPago;
	private String codTipProcPago;
	
	
	public String getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}
	public String getNumCompPago() {
		return numCompPago;
	}
	public void setNumCompPago(String numCompPago) {
		this.numCompPago = numCompPago;
	}
	public String getCodTipProcPago() {
		return codTipProcPago;
	}
	public void setCodTipProcPago(String codTipProcPago) {
		this.codTipProcPago = codTipProcPago;
	}

	@Override
	public String toString() {
		return "DetallePedidoLabRequest [correlativo=" + correlativo + ", numCompPago=" + numCompPago
				+ ", codTipProcPago=" + codTipProcPago + "]";
	}

}
