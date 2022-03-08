package com.cloudsrcsoft.reportes.controller;

import java.util.List;
import java.util.Map;

import com.cloudsrcsoft.reportes.exception.BusinessException;
import com.cloudsrcsoft.reportes.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloudsrcsoft.reportes.service.iface.IReporteService;
import com.cloudsrcsoft.reportes.response.SingleResponse;

@RestController
@RequestMapping(value = "/reporte")
public class ReporteController {
    private static final Logger log = LoggerFactory.getLogger(ReporteController.class);
    @Autowired
    private IReporteService reporteService;

    @PostMapping(path = "/consultafiltro")
    public List<Map<String, Object>> getConsultaFiltro(@RequestBody ReporteConsultaFiltroRequest reporte) {
        log.debug("[ReporteController] Start getConsultaFiltro");
        return reporteService.getConsultaFiltro(reporte);
    }

    @PostMapping(path = "/usuario/token/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setGuardarTokenUsuario(@RequestBody BaseGuardarTokenRequest reporte) {
        log.info("[CONTROLLER][ReporteController] Start setGuardarTokenUsuario - token: {}", reporte.getNotification_token());
        int response = reporteService.setGuardarTokenUsuario(reporte);
        return ResponseEntity.ok(new SingleResponse(response != 0));
    }

    @PostMapping(path = "/usuario/token/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteTokenUsuario(@RequestBody BaseGuardarTokenRequest reporte) {
        log.info("[CONTROLLER][ReporteController] Start deleteTokenUsuario - token: {}", reporte.getNotification_token());
        int response = reporteService.deleteTokenUsuario(reporte);
        log.info("Device token delete: {} row(s)", response);
        return ResponseEntity.ok(new SingleResponse(true));
    }

    @PostMapping(path = "/configuracion-notificaciones/guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setGuardarConfiguracionNotificacion(@RequestBody BaseGuardarConfigNotificaciones reporte) {
        int response = reporteService.setGuardarConfiguracionNotificacion(reporte);
        log.info("User notification config response value: {}", response);
        return ResponseEntity.ok(new SingleResponse(response != 0));
    }

    @PostMapping(path = "/configuracion-notificaciones/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteConfiguracionNotificacion(@RequestBody Map<String, Integer> data) {
        this.validateIdField(data);
        int response = reporteService.deleteConfiguracionNotificacion(data.get("id"));
        log.info("User notification config delete: {} row(s)", response);
        return ResponseEntity.ok(new SingleResponse(true));
    }

    @PostMapping(path = "/configuracion-notificaciones/activar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> activarConfiguracionNotificacion(@RequestBody Map<String, Integer> data) {
        this.validateIdField(data);
        int response = reporteService.updateEstadoConfiguracionNotificacion(data.get("id"), true);
        log.info("User notification config - status active: {}", response);
        return ResponseEntity.ok(new SingleResponse(true));
    }

    @PostMapping(path = "/configuracion-notificaciones/desactivar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> desactivarConfiguracionNotificacion(@RequestBody Map<String, Integer> data) {
        this.validateIdField(data);
        int response = reporteService.updateEstadoConfiguracionNotificacion(data.get("id"), false);
        log.info("User notification config - status false: {}", response);
        return ResponseEntity.ok(new SingleResponse(true));
    }

    @PostMapping(path = "/configuracion-notificaciones")
    public List<Map<String, Object>> getConfiguracionNotificacion(@RequestBody BaseRequest reporte) {
        return reporteService.getConfiguracionNotificacion(reporte);
    }

    @PostMapping(path = "/bitacora/guardar")
    public ResponseEntity<Object> setGuardarBitacora(@RequestBody BaseGuardarBitacora reporte) {
        reporteService.setGuardarBitacora(reporte);
        return ResponseEntity.ok(new SingleResponse(true));
    }

    @PostMapping(path = "/getListaEspecialidad")
    public List<Map<String, Object>> getListaEspecialidad(@RequestBody BaseRequest base) {
        return reporteService.getListaEspecialidad(base);
    }

    private void validateIdField(Map<String, Integer> data) {
        if (data.isEmpty() || !data.containsKey("id")) {
            throw new BusinessException("Enter id field");
        }
    }
}
