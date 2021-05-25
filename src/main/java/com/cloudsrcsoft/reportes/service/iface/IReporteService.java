package com.cloudsrcsoft.reportes.service.iface;

import java.util.List;
import java.util.Map;

import com.cloudsrcsoft.reportes.request.BaseGuardarBitacora;
import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.BaseGuardarTokenRequest;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;

public interface IReporteService {
	List<Map<String, Object>> getConsultaFiltro(ReporteConsultaFiltroRequest reporte);
	Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte);
	Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte, Integer userId);
	Integer deleteConfiguracionNotificacion(Integer id);
	Integer setGuardarTokenUsuario(BaseGuardarTokenRequest reporte);
	List<Map<String, Object>> getConfiguracionNotificacion(BaseRequest base);
	Integer setGuardarBitacora(BaseGuardarBitacora base);

	List<Map<String, Object>> getListaEspecialidad(BaseRequest base);

}
