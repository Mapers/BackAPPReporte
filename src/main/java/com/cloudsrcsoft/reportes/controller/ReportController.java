package com.cloudsrcsoft.reportes.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.model.CondicionBean;
import com.cloudsrcsoft.reportes.model.ConsultorioBean;
import com.cloudsrcsoft.reportes.model.ServicioBean;
import com.cloudsrcsoft.reportes.model.TestBean;
import com.cloudsrcsoft.reportes.model.TurnoBean;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteNum001Request;
import com.cloudsrcsoft.reportes.request.ReporteNum002Request;
import com.cloudsrcsoft.reportes.request.ReporteNum003Request;
import com.cloudsrcsoft.reportes.request.ReporteNum004Request;
import com.cloudsrcsoft.reportes.request.ReporteNum005Request;
import com.cloudsrcsoft.reportes.request.ReporteNum006Request;
import com.cloudsrcsoft.reportes.service.iface.IReportService;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
	
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private IReportService reportService;
	
	@GetMapping(path = "/reportTest")
	public List<TestBean> reportTest() {
		log.info("init report test");
		return reportService.getReportTest();
		//throw new BusinessException("error");
	}
	
	@PostMapping(path = "/getReporteNum001")
	public List<Map<String, Object>> getReporteNum001(@RequestBody ReporteNum001Request reporte){
		return reportService.getReporteNum001(reporte);
	}
	@PostMapping(path = "/getReporteNum002")
	public List<Map<String, Object>> getReporteNum002(@RequestBody ReporteNum002Request reporte){
		return reportService.getReporteNum002(reporte);
	}
	@PostMapping(path = "/getReporteNum003")
	public List<Map<String, Object>> getReporteNum003(@RequestBody ReporteNum003Request reporte){
		return reportService.getReporteNum003(reporte);
	}
	@PostMapping(path = "/getReporteNum004")
	public List<Map<String, Object>> getReporteNum004(@RequestBody ReporteNum004Request reporte){
		return reportService.getReporteNum004(reporte);
	}
	@PostMapping(path = "/getReporteNum005")
	public List<Map<String, Object>> getReporteNum005(@RequestBody ReporteNum005Request reporte){
		return reportService.getReporteNum005(reporte);
	}
	@PostMapping(path = "/getReporteNum006")
	public List<Map<String, Object>> getReporteNum006(@RequestBody ReporteNum006Request reporte){
		return reportService.getReporteNum006(reporte);
	}
	
	@PostMapping(path = "/getListaAnio")
	public List<Map<String, Object>> getListaAnio(@RequestBody BaseRequest base){
		return reportService.getListaAnio(base);
	}
	
	@PostMapping(path = "/getListaMes")
	public List<Map<String, Object>> getListaMes(@RequestBody BaseRequest base){
		System.out.println("Entro: ");
		return reportService.getListaMes(base);
	}
	
	
	
	@PostMapping(path = "/getListaConsultorio")
	public List<Map<String, Object>> getListaConsultorio(@RequestBody ConsultorioBean consultorio){
		log.info("consultorio" + consultorio.toString());
		return reportService.getListaConsultorio(consultorio);
	}
	
	@PostMapping(path = "/getTurno")
	public List<TurnoBean> getTurno(@RequestBody TurnoBean turno){
		log.info("turno" + turno.toString());
		return reportService.getTurno(turno);
	}
	
	@PostMapping(path = "/getCondicion")
	public List<CondicionBean> getCondicion(@RequestBody CondicionBean condicion){
		log.info("condicion" + condicion.toString());
		return reportService.getCondicion(condicion);
	}
	
	@PostMapping(path = "/getServicios")
	public List<ServicioBean> getServicio(@RequestBody ServicioBean servicio){
		log.info("servicio" + servicio.toString());
		return reportService.getServicio(servicio);
	}
	
	@GetMapping(path = "/getVersion")
	public String getVersion(@RequestParam("tipo") String tipo) {
		log.info("TIPO: " + tipo);
		return "{\"version\" : \""+ reportService.getVersion(tipo) +"\"}";
	}
}
