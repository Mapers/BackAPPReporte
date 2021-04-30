package com.cloudsrcsoft.reportes.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.model.ReporteProd001Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd002Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd003Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd004Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd005Bean;
import com.cloudsrcsoft.reportes.repository.jdbc.ReportProdCustomRepository;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;
import com.cloudsrcsoft.reportes.service.iface.IReportProdService;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

@Service
public class ReportProdServiceImpl implements IReportProdService{
	
	private static final Logger log = LoggerFactory.getLogger(ReportProdServiceImpl.class);
	
	@Autowired
	private ReportProdCustomRepository reportProdCustomRepository;
	
	@Override
	public List<ReporteProd001Bean> getReporteProd001(ReporteProduccionRequest reporte) {
		log.info("INI:: getReporteProd001");
		List<ReporteProd001Bean> lstReporte = new ArrayList<ReporteProd001Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportProdCustomRepository.getReporteProd001(reporte);
		
		ReporteProd001Bean reporteBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteProd001Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setFechaAtencion(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setCtdTickets(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setTotalHumanidad(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setTotalTercero(ReportesUtil.getStringFromValue(reg_line, 6));
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd001");
		return lstReporte;
	}

	@Override
	public List<ReporteProd002Bean> getReporteProd002(ReporteProduccionRequest reporte) {
		log.info("INI:: getReporteProd002");
		List<ReporteProd002Bean> lstReporte = new ArrayList<ReporteProd002Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportProdCustomRepository.getReporteProd002(reporte);
		
		ReporteProd002Bean reporteBean = null;
		
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteProd002Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
		
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 7));
			
			lstReporte.add(reporteBean);
		}
		log.info("FIN:: getReporteProd002");
		return lstReporte;
	}

	@Override
	public List<ReporteProd003Bean> getReporteProd003(ReporteProduccionRequest reporte) {
		log.info("INI:: getReporteProd003");
		List<ReporteProd003Bean> lstReporte = new ArrayList<ReporteProd003Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportProdCustomRepository.getReporteProd003(reporte);
		
		ReporteProd003Bean reporteBean = null;
		
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteProd003Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 7));
			
			lstReporte.add(reporteBean);
		}
		log.info("INI:: getReporteProd003");
		return lstReporte;
	}

	@Override
	public List<ReporteProd004Bean> getReporteProd004(ReporteProduccionRequest reporte) {
		log.info("INI:: getReporteProd004");
		List<ReporteProd004Bean> lstReporte = new ArrayList<ReporteProd004Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportProdCustomRepository.getReporteProd004(reporte);
		
		ReporteProd004Bean reporteBean = null;
		
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteProd004Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setCtdPedidos(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setCtdAtenciones(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setIncremento(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 7));
			
			lstReporte.add(reporteBean);
		}
		log.info("INI:: getReporteProd004");
		return lstReporte;
	}

	@Override
	public List<ReporteProd005Bean> getReporteProd005(ReporteProduccionRequest reporte) {
		log.info("INI:: getReporteProd005");
		List<ReporteProd005Bean> lstReporte = new ArrayList<ReporteProd005Bean>();
		
		List<LinkedCaseInsensitiveMap<String>> data = reportProdCustomRepository.getReporteProd005(reporte);
		
		ReporteProd005Bean reporteBean = null;
		
		for(LinkedCaseInsensitiveMap<String> reg : data) {
			reporteBean = new ReporteProd005Bean();
			//log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			reporteBean.setFechaVenta(ReportesUtil.getStringFromValue(reg_line, 0));
			reporteBean.setFechaAtencion(ReportesUtil.getStringFromValue(reg_line, 1));
			reporteBean.setPagado(ReportesUtil.getStringFromValue(reg_line, 2));
			reporteBean.setMedico(ReportesUtil.getStringFromValue(reg_line, 3));
			reporteBean.setNumPedido(ReportesUtil.getStringFromValue(reg_line, 4));
			reporteBean.setNumOrden(ReportesUtil.getStringFromValue(reg_line, 5));
			reporteBean.setTipoComprobante(ReportesUtil.getStringFromValue(reg_line, 6));
			reporteBean.setComprobante(ReportesUtil.getStringFromValue(reg_line, 7));
			reporteBean.setPaciente(ReportesUtil.getStringFromValue(reg_line, 8));
			reporteBean.setProducto(ReportesUtil.getStringFromValue(reg_line, 9));
			reporteBean.setCantidad(ReportesUtil.getStringFromValue(reg_line, 10));
			reporteBean.setDescuento(ReportesUtil.getStringFromValue(reg_line, 11));
			reporteBean.setPpTotal(ReportesUtil.getStringFromValue(reg_line, 12));
			reporteBean.setPtTotal(ReportesUtil.getStringFromValue(reg_line, 13));
			reporteBean.setHumanidad(ReportesUtil.getStringFromValue(reg_line, 14));
			reporteBean.setTercero(ReportesUtil.getStringFromValue(reg_line, 15));
			
			lstReporte.add(reporteBean);			
		}
		
		log.info("INI:: getReporteProd005");
		return lstReporte;
	}
	
}
