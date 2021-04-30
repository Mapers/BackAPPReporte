package com.cloudsrcsoft.reportes.model;

public class ReporteProd005Bean {
	private String fechaVenta;
	private String fechaAtencion;
	private String pagado;
	private String medico;
	private String numPedido;
	private String numOrden;
	private String tipoComprobante;
	private String comprobante;
	private String paciente;
	private String producto;
	private String cantidad;
	private String descuento;
	private String ppTotal;
	private String ptTotal;
	private String humanidad;
	private String tercero;
	
	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getPagado() {
		return pagado;
	}

	public void setPagado(String pagado) {
		this.pagado = pagado;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}

	public String getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(String numOrden) {
		this.numOrden = numOrden;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
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
		return "ReporteProd005Bean [fechaVenta=" + fechaVenta + ", fechaAtencion=" + fechaAtencion + ", pagado="
				+ pagado + ", medico=" + medico + ", numPedido=" + numPedido + ", tipoComprobante=" + tipoComprobante
				+ ", comprobante=" + comprobante + ", paciente=" + paciente + ", producto=" + producto + ", cantidad="
				+ cantidad + ", descuento=" + descuento + ", ppTotal=" + ppTotal + ", ptTotal=" + ptTotal
				+ ", humanidad=" + humanidad + ", tercero=" + tercero + "]";
	}
}
