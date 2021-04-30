package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;

import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;

public interface ReportProdCustomRepository {
	List<LinkedCaseInsensitiveMap<String>> getReporteProd001(ReporteProduccionRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteProd002(ReporteProduccionRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteProd003(ReporteProduccionRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteProd004(ReporteProduccionRequest reporte);

	List<LinkedCaseInsensitiveMap<String>> getReporteProd005(ReporteProduccionRequest reporte);
}
