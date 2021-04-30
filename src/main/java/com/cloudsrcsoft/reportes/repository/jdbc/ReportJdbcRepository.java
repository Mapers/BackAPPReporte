package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.Date;
import java.util.HashMap;
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

import com.cloudsrcsoft.reportes.model.CondicionBean;
import com.cloudsrcsoft.reportes.model.ConsultorioBean;
import com.cloudsrcsoft.reportes.model.ServicioBean;
import com.cloudsrcsoft.reportes.model.TestBean;
import com.cloudsrcsoft.reportes.model.TurnoBean;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteNum001Request;
import com.cloudsrcsoft.reportes.request.ReporteNum002Request;
import com.cloudsrcsoft.reportes.request.ReporteNum003Request;
import com.cloudsrcsoft.reportes.request.ReporteNum004Request;
import com.cloudsrcsoft.reportes.request.ReporteNum005Request;
import com.cloudsrcsoft.reportes.request.ReporteNum006Request;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;
import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

import oracle.jdbc.OracleTypes;

@Repository
public class ReportJdbcRepository implements ReportCustomRepository{
	
	private static final Logger log = LoggerFactory.getLogger(ReportJdbcRepository.class);

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<TestBean> getReportTest() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("EC_REPORTES")
				.withCatalogName("PKG_REPORTES_WEB")
				.withFunctionName("FN_GET_REPORT_TEST")
				.declareParameters(new SqlOutParameter("CLOUDSRCSOFTCURSOR", OracleTypes.CURSOR));
		
		//new SqlParameter("cStartDate", Types.DATE),
		//new SqlParameter("cStartEnd", Types.DATE),
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cStartDate", new Date())
														   .addValue("cEndDate", new Date());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<TestBean>) m.get("CLOUDSRCSOFTCURSOR");
	}

	@Override
	public List<Map<String, Object>> getReporteNum001(ReporteNum001Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_01")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
														   .addValue("cCodLocal_in", reporte.getCodLocal())
														   .addValue("cSecUsu_in", reporte.getcSecUsu())
														   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()));
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getReporteNum002(ReporteNum002Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_02")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
				   .addValue("cCodLocal_in", reporte.getCodLocal())
				   .addValue("cSecUsu_in", reporte.getcSecUsu())
				   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()))
				   .addValue("cListMes_in", ReportesUtil.getStringFromListString(reporte.getcListMes()));
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getReporteNum003(ReporteNum003Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_03")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
				   .addValue("cCodLocal_in", reporte.getCodLocal())
				   .addValue("cSecUsu_in", reporte.getcSecUsu())
				   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()))
				   .addValue("cListMes_in", ReportesUtil.getStringFromListString(reporte.getcListMes()))
				   .addValue("cListEspecialidad_in", ReportesUtil.getStringFromListString(reporte.getcListEspecialidad()));	
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getReporteNum004(ReporteNum004Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_04")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
				   .addValue("cCodLocal_in", reporte.getCodLocal())
				   .addValue("cSecUsu_in", reporte.getcSecUsu())
				   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()))
				   .addValue("cListMes_in", ReportesUtil.getStringFromListString(reporte.getcListMes()))
				   .addValue("cListEspecialidad_in", ReportesUtil.getStringFromListString(reporte.getcListEspecialidad()))
				   .addValue("cListConsultorio_in", ReportesUtil.getStringFromListString(reporte.getcListConsultorio()));
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getReporteNum005(ReporteNum005Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_05")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
				   .addValue("cCodLocal_in", reporte.getCodLocal())
				   .addValue("cSecUsu_in", reporte.getcSecUsu())
				   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()))
				   .addValue("cListMes_in", ReportesUtil.getStringFromListString(reporte.getcListMes()))
				   .addValue("cListEspecialidad_in", ReportesUtil.getStringFromListString(reporte.getcListEspecialidad()))
				   .addValue("cListConsultorio_in", ReportesUtil.getStringFromListString(reporte.getcListConsultorio()))
				   .addValue("cDesde_in", reporte.getcDesde())
				   .addValue("cHasta_in", reporte.getcHasta());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getReporteNum006(ReporteNum006Request reporte) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_RPT_NUM_06")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", reporte.getCodGrupoCia())
				   .addValue("cCodLocal_in", reporte.getCodLocal())
				   .addValue("cSecUsu_in", reporte.getcSecUsu())
				   .addValue("cListAnio_in", ReportesUtil.getStringFromListString(reporte.getcListAnio()))
				   .addValue("cListMes_in", ReportesUtil.getStringFromListString(reporte.getcListMes()))
				   .addValue("cListEspecialidad_in", ReportesUtil.getStringFromListString(reporte.getcListEspecialidad()))
				   .addValue("cListConsultorio_in", ReportesUtil.getStringFromListString(reporte.getcListConsultorio()))
				   .addValue("cDesde_in", reporte.getcDesde())
				   .addValue("cHasta_in", reporte.getcHasta());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getListaAnio(BaseRequest base) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_LISTA_ANIO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", base.getCodGrupoCia())
				   											.addValue("cCodLocal_in", base.getCodLocal());;
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getListaMes(BaseRequest base) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_LISTA_MES")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", base.getCodGrupoCia())
				   											.addValue("cCodLocal_in", base.getCodLocal());;
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	

	@Override
	public List<Map<String, Object>> getListaConsultorio(ConsultorioBean consultorio) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_LISTA_CONSULTORIO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", consultorio.getCodigoCompania())
														   .addValue("cCodLocal_in", consultorio.getCodigoCompania())
														   .addValue("cIdEspecialidad_in", consultorio.getEspecialidad());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<LinkedCaseInsensitiveMap<String>> getTurno(TurnoBean turno) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("GET_TURNO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", turno.getCodigoCompania())
														   .addValue("cCod_Local_in", turno.getCodigoLocal())
														   .addValue("cSecUsu_local_in", turno.getSecUsuLocal());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}

	@Override
	public List<LinkedCaseInsensitiveMap<String>> getCondicion(CondicionBean condicion) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("GET_CONDICION")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", condicion.getCodigoCompania())
														   .addValue("cCod_Local_in", condicion.getCodigoLocal())
														   .addValue("cSecUsu_local_in", condicion.getSecUsuLocal());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}

	@Override
	public List<LinkedCaseInsensitiveMap<String>> getServicio(ServicioBean servicio) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("get_prod_servicios")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", servicio.getCodigoCompania())
														   .addValue("cCod_Local_in", servicio.getCodigoLocal())
														   .addValue("cCodEspecialidad", servicio.getCodigoEspecialidad());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		return ((List<LinkedCaseInsensitiveMap<String>>) m.get("FarmaCursor"));
	}

	@Override
	public String getVersion(String tipo) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("GET_VERSION");
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("cTipo", tipo.trim());
		return simpleJdbcCall.executeFunction(String.class, in);
	}
	
}
