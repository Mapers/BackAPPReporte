package com.cloudsrcsoft.reportes.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudsrcsoft.reportes.repository.jdbc.ReporteCustomRepository;
import com.cloudsrcsoft.reportes.repository.mybatis.spec.ReportMapper;
import com.cloudsrcsoft.reportes.request.BaseGuardarBitacora;
import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.BaseGuardarTokenRequest;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.service.iface.IReporteService;
@Service
public class ReporteServiceImpl implements IReporteService{
	private static final Logger log = LoggerFactory.getLogger(ReporteServiceImpl.class);
	@Autowired
	private ReportMapper reportMapper;
	@Autowired
	private ReporteCustomRepository reporteCustomRepository;
	@Override
	public List<Map<String, Object>> getConsultaFiltro(ReporteConsultaFiltroRequest reporte) {
		return reporteCustomRepository.getConsultaFiltro(reporte);

	}
	@Override
	public Integer setGuardarTokenUsuario(BaseGuardarTokenRequest reporte) {
		return reporteCustomRepository.setGuardarTokenUsuario(reporte);

	}
	@Override

	public Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte) {
		return reporteCustomRepository.setGuardarConfiguracionNotificacion(reporte);

	}
	@Override

	public List<Map<String, Object>> getConfiguracionNotificacion(BaseRequest reporte) {
		return reporteCustomRepository.getConfiguracionNotificacion(reporte);

	}
	public Integer setGuardarBitacora(BaseGuardarBitacora reporte) {
		return reporteCustomRepository.setGuardarBitacora(reporte);

	}
	@Override
	public List<Map<String, Object>> getListaEspecialidad(BaseRequest base) {
		return reporteCustomRepository.getListaEspecialidad(base);
	}
}
