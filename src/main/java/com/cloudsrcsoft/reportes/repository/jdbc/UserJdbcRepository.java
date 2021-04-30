package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.cloudsrcsoft.reportes.security.model.UserModel;

import oracle.jdbc.OracleTypes;

@Repository
public class UserJdbcRepository implements UserCustomRepository{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public UserModel findByUsername(String username) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("HHW_REPORTE")
				.withFunctionName("GET_USUARIO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", "001")
														   .addValue("cCod_Local_in", "001")
														   .addValue("cSecUsu_local_in", username);
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		
		
		return (UserModel) m.get("FarmaCursor");
		
	}
}