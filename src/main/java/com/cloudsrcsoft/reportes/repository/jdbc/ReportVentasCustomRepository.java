package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;

@Repository
public interface ReportVentasCustomRepository {
	List<LinkedCaseInsensitiveMap<String>> getReporteVentas001(ReporteVentasRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteVentas002(ReporteVentasRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteVentas003(ReporteVentasRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteVentas004(ReporteVentasRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteVentas005(ReporteVentasRequest reporte);
	
	List<LinkedCaseInsensitiveMap<String>> getReporteVentas006(ReporteVentasRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteVentas007(ReporteVentasRequest reporte);
}
