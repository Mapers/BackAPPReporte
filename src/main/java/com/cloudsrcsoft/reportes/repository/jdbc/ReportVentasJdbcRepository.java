package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;

import oracle.jdbc.OracleTypes;

@Repository
public class ReportVentasJdbcRepository implements ReportVentasCustomRepository{
	private static final Logger log = LoggerFactory.getLogger(ReportVentasJdbcRepository.class);

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas001(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_00")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas002(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_01")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas003(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_02")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas004(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_04")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas005(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_05")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas006(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_03")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}


	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteVentas007(ReporteVentasRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_VENTA_TOTUNIDO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodigoCompania())
														   .addValue("cCodLocal_in", reporte.getCodigoLocal())
														   .addValue("cFechaInicio", reporte.getFechaInicio())
														   .addValue("cFechaFin", reporte.getFechaFin())
														   .addValue("cSecUsuCajero", reporte.getUsuarioCajero())
														   .addValue("cIdConsultorio_in", reporte.getEspecialidad())
														   .addValue("cIdBus_in",reporte.getConsultorio())
														   .addValue("cIniVenta",reporte.getInicioVenta())
														   .addValue("cFinVenta",reporte.getFinVenta())
														   .addValue("cMedico",reporte.getMedico())
														   .addValue("cServicio",reporte.getServicio())
														   .addValue("cTurno",reporte.getTurno())
														   .addValue("cCondicion",reporte.getCondicion())
														   .addValue("cIpPC_in",reporte.getIp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);	
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}
}
