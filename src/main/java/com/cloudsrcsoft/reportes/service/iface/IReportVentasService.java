package com.cloudsrcsoft.reportes.service.iface;

import java.util.List;

import com.cloudsrcsoft.reportes.model.ReporteVentas001Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas002Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas003Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas004Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas005Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas006Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas007Bean;
import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;

public interface IReportVentasService {

	List<ReporteVentas001Bean> getReporteVentas001(ReporteVentasRequest reporte);

	List<ReporteVentas002Bean> getReporteVentas002(ReporteVentasRequest reporte);

	List<ReporteVentas003Bean> getReporteVentas003(ReporteVentasRequest reporte);

	List<ReporteVentas004Bean> getReporteVentas004(ReporteVentasRequest reporte);

	List<ReporteVentas005Bean> getReporteVentas005(ReporteVentasRequest reporte);

	List<ReporteVentas006Bean> getReporteVentas006(ReporteVentasRequest reporte);

	List<ReporteVentas007Bean> getReporteVentas007(ReporteVentasRequest reporte);

}
