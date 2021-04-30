package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import com.cloudsrcsoft.reportes.request.BaseGuardarBitacora;
import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.BaseGuardarTokenRequest;
import com.cloudsrcsoft.reportes.request.BaseRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.security.JwtUser;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

import oracle.jdbc.OracleTypes;
@Repository
public class ReporteJdbcRepository implements ReporteCustomRepository {
	private static final Logger log = LoggerFactory.getLogger(ReporteJdbcRepository.class);

	private JdbcTemplate jdbcTemplate;	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Autowired
    private UserDetailsService userDetailsService;
	@Override
	public List<Map<String, Object>> getConsultaFiltro(ReporteConsultaFiltroRequest reporte) {

		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("RPT_CONSULTA_FILTRO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cListEspecialidad", ReportesUtil.getStringFromListString(reporte.getcListEspecialidad()))
														   .addValue("typeDate", reporte.getcTypeDate())
														   .addValue("cFechaInicial", reporte.getcDesde())
														   .addValue("cFechaFinal", reporte.getcHasta());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}
	@Override
	public Integer setGuardarTokenUsuario(BaseGuardarTokenRequest reporte) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentUserName = authentication.getName();
	    System.out.println(currentUserName);

	    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(currentUserName);
		return  jdbcTemplate.update("call RPT_GUARDAR_TOKEN_NOTIFICATION(?,?,?)",
				reporte.getNotification_token(),
				reporte.getDevice(),
				user.getId());
		
	
			}
	@Override
	public Integer setGuardarBitacora(BaseGuardarBitacora reporte) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentUserName = authentication.getName();
	    System.out.println(currentUserName);

	    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(currentUserName);
		return  jdbcTemplate.update("call RPT_GUARDAR_BITACORA(?,?,?,?,?)",
				reporte.getDate(),
				reporte.getImei(),
				reporte.getType_model(),
				reporte.getType_phone(),
				user.getId());
		
	
			}
	@Override
	public List<Map<String, Object>> getConfiguracionNotificacion(BaseRequest base) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentUserName = authentication.getName();
	    System.out.println(currentUserName);

	    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(currentUserName);
	    System.out.println(user.getId());
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_CONFIG_USER_FIG")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", base.getCodGrupoCia())
														   .addValue("cCodLocal_in", base.getCodLocal())
														   .addValue("cCodUsuario", user.getId());;
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	
			}
	@Override
	public Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String currentUserName = authentication.getName();
	    System.out.println(currentUserName);
	    Integer opcion=0;
	    if(reporte.getId()==null){
		  opcion=0;

	    }else {
			  opcion=1;

	    }
	    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(currentUserName);
	    System.out.println(user.getId().intValue());
	    
		return  jdbcTemplate.update("call RPT_GUARDAR_CONFIG_USER(?,?,?,?,?,?,?,?,?,?)",
				reporte.getId(),
				opcion,
				reporte.getEnable(),
				reporte.getDate(),
				reporte.getType_query(),
				reporte.getType_queries().toString(),
				user.getId().intValue()
				,reporte.getType_send(),reporte.getDate_end(),
				reporte.getSpecialities().toString());
	
			}
	@Override
	public List<Map<String, Object>> getListaEspecialidad(BaseRequest base) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("HW_RPT")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("F_CUR_LISTA_ESPECIALIDAD")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", base.getCodGrupoCia())
														   .addValue("cCodLocal_in", base.getCodLocal());
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}
}