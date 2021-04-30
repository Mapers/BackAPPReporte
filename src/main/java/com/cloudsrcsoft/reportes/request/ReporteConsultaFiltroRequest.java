package com.cloudsrcsoft.reportes.request;
import java.util.List;
public class ReporteConsultaFiltroRequest{
	
	private String cTypeDate;
	private List<String> cListEspecialidad;
	private String cDesde;
	private String cHasta;
	public String getcTypeDate() {
		return cTypeDate;
	}
	public void setcTypeDate(String cTypeDate) {
		this.cTypeDate = cTypeDate;
	}
	public List<String> getcListEspecialidad() {
		return cListEspecialidad;
	}
	public void setcListEspecialidad(List<String> cListEspecialidad) {
		this.cListEspecialidad = cListEspecialidad;
	}
	public String getcDesde() {
		return cDesde;
	}
	public void setcDesde(String cDesde) {
		this.cDesde = cDesde;
	}
	public String getcHasta() {
		return cHasta;
	}
	public void setcHasta(String cHasta) {
		this.cHasta = cHasta;
	}
	public ReporteConsultaFiltroRequest(String cTypeDate, List<String> cListEspecialidad, String cDesde,
			String cHasta) {
		super();
		this.cTypeDate = cTypeDate;
		this.cListEspecialidad = cListEspecialidad;
		this.cDesde = cDesde;
		this.cHasta = cHasta;
	}

}

