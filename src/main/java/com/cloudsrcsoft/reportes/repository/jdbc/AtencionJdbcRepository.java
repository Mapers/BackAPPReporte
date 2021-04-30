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

import com.cloudsrcsoft.reportes.request.CabeceraPedidoLabRequest;
import com.cloudsrcsoft.reportes.request.CodigoMedicoRequest;
import com.cloudsrcsoft.reportes.request.ConsultorioRequest;
import com.cloudsrcsoft.reportes.request.DetallePedidoLabRequest;
import com.cloudsrcsoft.reportes.request.EspecialidadRequest;

import oracle.jdbc.OracleTypes;

@Repository
public class AtencionJdbcRepository implements AtencionCustomRepository{
	private static final Logger log = LoggerFactory.getLogger(AtencionJdbcRepository.class);

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Map<String, Object>> getListaCabeceraPedido_lab(CabeceraPedidoLabRequest cabeceraPedidoLab) {
		log.info(cabeceraPedidoLab.toString());
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("PTOVENTA_WEB")
				.withFunctionName("CAJ_LISTA_CABECERA_PEDIDO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", cabeceraPedidoLab.getCodGrupoCia())
														   .addValue("cCodLocal_in",cabeceraPedidoLab.getCodLocal())
														   .addValue("cNumPedVta_in", cabeceraPedidoLab.getCorrelativo())
														   .addValue("cNumCompPag", cabeceraPedidoLab.getNumCompPago())
														   .addValue("cFlagTipProcPago", cabeceraPedidoLab.getCodTipProcPago());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getListaCabeceraPedido_lab(DetallePedidoLabRequest detallePedidoLab) {
		log.info(detallePedidoLab.toString());
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("PTOVENTA_WEB")
				.withFunctionName("CAJ_LISTA_DETALLE_PEDIDO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", detallePedidoLab.getCodGrupoCia())
														   .addValue("cCodLocal_in", detallePedidoLab.getCodLocal())
														   .addValue("cNumPedVta_in", detallePedidoLab.getCorrelativo())
														   .addValue("cTipComp_in", detallePedidoLab.getTipoComp())
														   .addValue("cNumComp_in", detallePedidoLab.getNumComp());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> searchByCodigoMedico(CodigoMedicoRequest codigoMedico) {
		log.info(codigoMedico.toString());
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("PTOVENTA_WEB")
				.withFunctionName("CME_LISTA_MEDICOS")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodMedico_in", codigoMedico.getCodMedico())
														   .addValue("cApellido_in", codigoMedico.getApellido())
														   .addValue("cNombre_in", codigoMedico.getNombre())
														   .addValue("cCMP_in", codigoMedico.getCpm());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getEspecialidad(EspecialidadRequest especialidad) {
		log.info(especialidad.toString());
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("PTOVENTA_WEB")
				.withFunctionName("GET_ESPECIALIDAD")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", especialidad.getCodGrupoCia())
														   .addValue("cCod_Local_in", especialidad.getCodLocal())
														   .addValue("cSecUsu_local_in", especialidad.getSecUsuLocal());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}

	@Override
	public List<Map<String, Object>> getConsultorio(ConsultorioRequest consultorio) {
		log.info(consultorio.toString());
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName("VENTA")
				.withCatalogName("PTOVENTA_WEB")
				.withFunctionName("GET_CONSULTORIO")
				.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
				
		SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", consultorio.getCodGrupoCia())
														   .addValue("cCod_Local_in", consultorio.getCodLocal())
														   .addValue("cSecUsu_local_in", consultorio.getSecUsuLocal())
														   .addValue("vIDEspecialidad", consultorio.getIdEspecialidad());
		
		Map<String, Object> m = simpleJdbcCall.execute(in);
		
		return (List<Map<String, Object>>) m.get("FarmaCursor");
	}	
}
