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

import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;

import oracle.jdbc.OracleTypes;

@Repository
public class ReportProdJdbcRepository implements ReportProdCustomRepository{
	
	private static final Logger log = LoggerFactory.getLogger(ReportProdJdbcRepository.class);

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<LinkedCaseInsensitiveMap<String>> getReporteProd001(ReporteProduccionRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_PRODUCCION_01")
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
	public List<LinkedCaseInsensitiveMap<String>> getReporteProd002(ReporteProduccionRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_PRODUCCION_02")
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
	public List<LinkedCaseInsensitiveMap<String>> getReporteProd003(ReporteProduccionRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_PRODUCCION_04")
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
	public List<LinkedCaseInsensitiveMap<String>> getReporteProd004(ReporteProduccionRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_PRODUCCION_05")
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
	public List<LinkedCaseInsensitiveMap<String>> getReporteProd005(ReporteProduccionRequest reporte) {
		log.info("REPORTE_BEAN: " + reporte.toString());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_HH_PRODUCCION_03")
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
