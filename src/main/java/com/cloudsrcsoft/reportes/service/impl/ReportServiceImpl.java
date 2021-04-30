package com.cloudsrcsoft.reportes.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.model.CondicionBean;
import com.cloudsrcsoft.reportes.model.ConsultorioBean;
import com.cloudsrcsoft.reportes.model.ReporteProd001Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd002Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd003Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd004Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd005Bean;
import com.cloudsrcsoft.reportes.model.ServicioBean;
import com.cloudsrcsoft.reportes.model.TestBean;
import com.cloudsrcsoft.reportes.model.TurnoBean;
import com.cloudsrcsoft.reportes.repository.jdbc.ReportCustomRepository;
import com.cloudsrcsoft.reportes.repository.mybatis.spec.ReportMapper;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteNum001Request;
import com.cloudsrcsoft.reportes.request.ReporteNum002Request;
import com.cloudsrcsoft.reportes.request.ReporteNum003Request;
import com.cloudsrcsoft.reportes.request.ReporteNum004Request;
import com.cloudsrcsoft.reportes.request.ReporteNum005Request;
import com.cloudsrcsoft.reportes.request.ReporteNum006Request;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;
import com.cloudsrcsoft.reportes.service.iface.IReportService;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

@Service
public class ReportServiceImpl implements IReportService{
	
	private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private ReportMapper reportMapper;
	
	@Autowired
	private ReportCustomRepository reportCustomRepository;
	
	@Override
	public List<TestBean> getReportTest() {
		log.info("init report service test");
		return reportCustomRepository.getReportTest();
	}

	@Override
	public List<Map<String, Object>> getReporteNum001(ReporteNum001Request reporte) {
		return reportCustomRepository.getReporteNum001(reporte);
	}

	@Override
	public List<Map<String, Object>> getReporteNum002(ReporteNum002Request reporte) {
		return reportCustomRepository.getReporteNum002(reporte);
	}

	@Override
	public List<Map<String, Object>> getReporteNum003(ReporteNum003Request reporte) {
		return reportCustomRepository.getReporteNum003(reporte);
	}

	@Override
	public List<Map<String, Object>> getReporteNum004(ReporteNum004Request reporte) {
		return reportCustomRepository.getReporteNum004(reporte);
	}

	@Override
	public List<Map<String, Object>> getReporteNum005(ReporteNum005Request reporte) {
		return reportCustomRepository.getReporteNum005(reporte);
	}

	@Override
	public List<Map<String, Object>> getReporteNum006(ReporteNum006Request reporte) {
		return reportCustomRepository.getReporteNum006(reporte);
	}

	@Override
	public List<Map<String, Object>> getListaAnio(BaseRequest base) {
		return reportCustomRepository.getListaAnio(base);
	}

	@Override
	public List<Map<String, Object>> getListaMes(BaseRequest base) {
		return reportCustomRepository.getListaMes(base);
	}

	

	@Override
	public List<Map<String, Object>> getListaConsultorio(ConsultorioBean consultorio) {
		return reportCustomRepository.getListaConsultorio(consultorio);
	}

	@Override
	public List<TurnoBean> getTurno(TurnoBean turno) {
		List<TurnoBean> lstTurnos = new ArrayList<>();
		List<LinkedCaseInsensitiveMap<String>> turnos = reportCustomRepository.getTurno(turno);
		
		TurnoBean turnoBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : turnos) {
			turnoBean = new TurnoBean();
			log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			turnoBean.setTurno(reg_line[0]);
			turnoBean.setDescripcion(reg_line[1]);
			
			lstTurnos.add(turnoBean);
		}
		
		return lstTurnos;
	}

	@Override
	public List<CondicionBean> getCondicion(CondicionBean condicion) {
		List<CondicionBean> lstCondiciones = new ArrayList<>();
		List<LinkedCaseInsensitiveMap<String>> condiciones = reportCustomRepository.getCondicion(condicion);
		
		CondicionBean condicionBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : condiciones) {
			condicionBean = new CondicionBean();
			log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			condicionBean.setCondicion(reg_line[0]);
			condicionBean.setDescripcion(reg_line[1]);
			
			lstCondiciones.add(condicionBean);
		}
		
		return lstCondiciones; 
	}

	@Override
	public List<ServicioBean> getServicio(ServicioBean servicio) {
		List<ServicioBean> lstServicios = new ArrayList<>();
		List<LinkedCaseInsensitiveMap<String>> servicios = reportCustomRepository.getServicio(servicio);
		
		ServicioBean servicioBean = null;
		for(LinkedCaseInsensitiveMap<String> reg : servicios) {
			servicioBean = new ServicioBean();
			log.info(reg.get("DATOS"));
			String[] reg_line = ReportesUtil.getListFromString(reg.get("DATOS"));
			
			servicioBean.setCodigoProducto(reg_line[0]);
			servicioBean.setDescripcion(reg_line[1]);
			
			lstServicios.add(servicioBean);
		}
		
		return lstServicios;
	}

	@Override
	public String getVersion(String tipo) {
		return reportCustomRepository.getVersion(tipo);
	}
}
