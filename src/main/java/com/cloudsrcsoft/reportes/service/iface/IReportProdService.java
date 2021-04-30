package com.cloudsrcsoft.reportes.service.iface;

import java.util.List;

import com.cloudsrcsoft.reportes.model.ReporteProd001Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd002Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd003Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd004Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd005Bean;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;

public interface IReportProdService {
	List<ReporteProd001Bean> getReporteProd001(ReporteProduccionRequest reporte);

	List<ReporteProd002Bean> getReporteProd002(ReporteProduccionRequest reporte);

	List<ReporteProd003Bean> getReporteProd003(ReporteProduccionRequest reporte);

	List<ReporteProd004Bean> getReporteProd004(ReporteProduccionRequest reporte);

	List<ReporteProd005Bean> getReporteProd005(ReporteProduccionRequest reporte);
}
