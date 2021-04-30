package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.model.CondicionBean;
import com.cloudsrcsoft.reportes.model.ConsultorioBean;
import com.cloudsrcsoft.reportes.model.ServicioBean;
import com.cloudsrcsoft.reportes.model.TestBean;
import com.cloudsrcsoft.reportes.model.TurnoBean;
import com.cloudsrcsoft.reportes.request.BaseGuardarBitacora;
import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.BaseGuardarTokenRequest;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.request.ReporteNum001Request;
import com.cloudsrcsoft.reportes.request.ReporteNum002Request;
import com.cloudsrcsoft.reportes.request.ReporteNum003Request;
import com.cloudsrcsoft.reportes.request.ReporteNum004Request;
import com.cloudsrcsoft.reportes.request.ReporteNum005Request;
import com.cloudsrcsoft.reportes.request.ReporteNum006Request;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;
import com.cloudsrcsoft.reportes.model.TestBean;

public interface ReporteCustomRepository {


	List<Map<String, Object>> getConsultaFiltro(ReporteConsultaFiltroRequest reporte);
	Integer setGuardarTokenUsuario(BaseGuardarTokenRequest reporte);
	List<Map<String, Object>> getConfiguracionNotificacion(BaseRequest reporte);
	Integer setGuardarBitacora(BaseGuardarBitacora reporte);
	Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte);
	List<Map<String, Object>> getListaEspecialidad(BaseRequest base);

}
