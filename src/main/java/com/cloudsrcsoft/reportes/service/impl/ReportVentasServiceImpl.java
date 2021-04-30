package com.cloudsrcsoft.reportes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.model.ReporteProd001Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas001Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas002Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas003Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas004Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas005Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas006Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas007Bean;
import com.cloudsrcsoft.reportes.repository.jdbc.ReportVentasCustomRepository;
import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;
import com.cloudsrcsoft.reportes.service.iface.IReportVentasService;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

@Service
public class ReportVentasServiceImpl implements IReportVentasService{

	private static final Logger log = LoggerFactory.getLogger(ReportVentasServiceImpl.class);
	
	@Autowired
	private ReportVentasCustomRepository reportVentasCustomRepository;
	
	@Override
	public List<ReporteVentas001Bean> getReporteVentas001(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd001");
		List<ReporteVentas001Bean> lstReporte = new ArrayList<ReporteVentas001Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas001(reporte);
		
		ReporteVentas001Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas001Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setFechaVenta(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 9));
			
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd001");
		return lstReporte;
	}

	@Override
	public List<ReporteVentas002Bean> getReporteVentas002(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd002");
		List<ReporteVentas002Bean> lstReporte = new ArrayList<ReporteVentas002Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas002(reporte);
		
		ReporteVentas002Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas002Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setConsultorio(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setFechaVenta(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 10));
			
			lstReporte.add(reporteBean);
		}
		
		log.info("FIN:: getReporteProd002");
		return lstReporte;
	}

	@Override
	public List<ReporteVentas003Bean> getReporteVentas003(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd003");
		List<ReporteVentas003Bean> lstReporte = new ArrayList<ReporteVentas003Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas003(reporte);
		
		ReporteVentas003Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas003Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setConsultorio(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 10));
			lstReporte.add(reporteBean);
		}
		
		log.info("FIN:: getReporteProd003");
		return lstReporte;
	}

	@Override
	public List<ReporteVentas004Bean> getReporteVentas004(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd004");
		List<ReporteVentas004Bean> lstReporte = new ArrayList<ReporteVentas004Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas004(reporte);
		
		ReporteVentas004Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas004Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setConsultorio(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 10));
			lstReporte.add(reporteBean);
		}
		
		log.info("FIN:: getReporteProd004");
		return lstReporte;
	}

	@Override
	public List<ReporteVentas005Bean> getReporteVentas005(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd005");
		List<ReporteVentas005Bean> lstReporte = new ArrayList<ReporteVentas005Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas005(reporte);
		
		ReporteVentas005Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas005Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setConsultorio(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 10));
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd005");
		
		return lstReporte;
	}

	@Override
	public List<ReporteVentas006Bean> getReporteVentas006(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd006");
		List<ReporteVentas006Bean> lstReporte = new ArrayList<ReporteVentas006Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas006(reporte);
		
		ReporteVentas006Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas006Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setConsultorio(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setFechaVenta(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setFechaAtencion(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setPagado(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setMedico(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setNumPedido(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setNumOrden(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setTipoComprobante(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setComprobante(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setPaciente(ReportesUtil.getStringFromValue(reg_line, 10));
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 11));
			reporteBean.setCantidad(ReportesUtil.getStringFromValue(reg_line, 12));
			reporteBean.setDescuento(ReportesUtil.getStringFromValue(reg_line, 13));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 14));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 15));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 16));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 17));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 18));
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd006");
		
		return lstReporte;
	}

	@Override
	public List<ReporteVentas007Bean> getReporteVentas007(ReporteVentasRequest reporte) {
		log.info("INI:: getReporteProd007");
		List<ReporteVentas007Bean> lstReporte = new ArrayList<ReporteVentas007Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportVentasCustomRepository.getReporteVentas007(reporte);
		
		ReporteVentas007Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteVentas007Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setEspecialidad(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setTotalVenta(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 8));
			
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd007");
		
		return lstReporte;
	}

}
