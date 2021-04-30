package com.cloudsrcsoft.reportes.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.request.CabeceraPedidoLabRequest;
import com.cloudsrcsoft.reportes.request.CodigoMedicoRequest;
import com.cloudsrcsoft.reportes.request.ConsultorioRequest;
import com.cloudsrcsoft.reportes.request.DetallePedidoLabRequest;
import com.cloudsrcsoft.reportes.request.EspecialidadRequest;
import com.cloudsrcsoft.reportes.service.iface.IAtencionService;

@RestController
@RequestMapping(value = "/atencion")
public class AtencionController {
	
private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	
	@Autowired
	private IAtencionService atencionService;
	
	@PostMapping(path = "/getListaCabeceraPedido_lab")
	public Map<String, Object> getListaCabeceraPedido_lab(@RequestBody CabeceraPedidoLabRequest cabeceraPedidoLab){
		return atencionService.getListaCabeceraPedido_lab(cabeceraPedidoLab).get(0);
	}
	
	@PostMapping(path = "/getListaDetallePedido_lab")
	public List<Map<String, Object>> getListaDetallePedido_lab(@RequestBody DetallePedidoLabRequest detallePedidoLab){
		return atencionService.getListaDetallePedido_lab(detallePedidoLab);
	}
	
	@PostMapping(path = "/searchByCodigoMedico")
	public List<Map<String, Object>> searchByCodigoMedico(@RequestBody CodigoMedicoRequest codigoMedico){
		return atencionService.searchByCodigoMedico(codigoMedico);
	}
	
	@PostMapping(path = "/getEspecialidad")
	public List<Map<String, Object>> getEspecialidad(@RequestBody EspecialidadRequest especialidad){
		return atencionService.getEspecialidad(especialidad);
	}
	
	@PostMapping(path = "/getConsultorio")
	public List<Map<String, Object>> getConsultorio(@RequestBody ConsultorioRequest consultorio){
		return atencionService.getConsultorio(consultorio);
	}
}
