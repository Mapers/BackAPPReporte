package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.util.LinkedCaseInsensitiveMap;

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
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;

public interface ReportCustomRepository {

	List<TestBean> getReportTest();
	
	List<Map<String, Object>> getReporteNum001(ReporteNum001Request reporte);
	
	List<Map<String, Object>> getReporteNum002(ReporteNum002Request reporte);
	
	List<Map<String, Object>> getReporteNum003(ReporteNum003Request reporte);
	
	List<Map<String, Object>> getReporteNum004(ReporteNum004Request reporte);
	
	List<Map<String, Object>> getReporteNum005(ReporteNum005Request reporte);
	
	List<Map<String, Object>> getReporteNum006(ReporteNum006Request reporte);

	List<Map<String, Object>> getListaAnio(BaseRequest base);

	List<Map<String, Object>> getListaMes(BaseRequest base);


	List<Map<String, Object>> getListaConsultorio(ConsultorioBean consultorio);

	List<LinkedCaseInsensitiveMap<String>> getTurno(TurnoBean turno);

	List<LinkedCaseInsensitiveMap<String>> getCondicion(CondicionBean condicion);

	List<LinkedCaseInsensitiveMap<String>> getServicio(ServicioBean servicio);

	String getVersion(String tipo);


}
