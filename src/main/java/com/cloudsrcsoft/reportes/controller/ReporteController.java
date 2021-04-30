package com.cloudsrcsoft.reportes.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.repository.jpa.UserRepository;
import com.cloudsrcsoft.reportes.request.BaseGuardarBitacora;
import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.BaseGuardarTokenRequest;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.service.iface.IReporteService;
import com.cloudsrcsoft.reportes.response.JwtAuthenticationResponse;
import com.cloudsrcsoft.reportes.response.SingleResponse;
import com.cloudsrcsoft.reportes.security.JwtUser;
import com.cloudsrcsoft.reportes.security.model.User;

@RestController
@RequestMapping(value = "/reporte")
public class ReporteController {
	private static final Logger log = LoggerFactory.getLogger(ReporteController.class);
	@Autowired
	private IReporteService reporteService;

	
	@PostMapping(path = "/consultafiltro")
	public List<Map<String, Object>> getConsultaFiltro(@RequestBody ReporteConsultaFiltroRequest reporte){
	    System.out.println("Entro: ");
		return reporteService.getConsultaFiltro(reporte);
	}
	@PostMapping(path = "/usuario/token/guardar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> setGuardarTokenUsuario(@RequestBody BaseGuardarTokenRequest reporte){
	   
            System.out.println("Entro: ");
	    reporteService.setGuardarTokenUsuario(reporte);
        return ResponseEntity.ok(new SingleResponse( true));
	}
	@PostMapping(path = "/configuracion-notificaciones/guardar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> setGuardarConfiguracionNotificacion(@RequestBody BaseGuardarConfigNotificaciones reporte){

	
	
	   System.out.println(reporteService.setGuardarConfiguracionNotificacion(reporte));
	        return ResponseEntity.ok(new SingleResponse (true));
	}
	@PostMapping(path = "/configuracion-notificaciones")
	
	public List<Map<String, Object>> getConfiguracionNotificacion(@RequestBody BaseRequest reporte){
	
	  		return reporteService.getConfiguracionNotificacion(reporte);
	}
	@PostMapping(path = "/bitacora/guardar")
	
	public  ResponseEntity<?> setGuardarBitacora(@RequestBody BaseGuardarBitacora reporte){
	
	  		 reporteService.setGuardarBitacora(reporte);
	        return ResponseEntity.ok(new SingleResponse (true));
	}
	@PostMapping(path = "/getListaEspecialidad")
	public List<Map<String, Object>> getListaEspecialidad(@RequestBody BaseRequest base){
		log.info("Especialidad" + base.toString());
		return reporteService.getListaEspecialidad(base);
	}
}
