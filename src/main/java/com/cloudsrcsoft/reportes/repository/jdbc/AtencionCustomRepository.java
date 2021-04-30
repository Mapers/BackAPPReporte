package com.cloudsrcsoft.reportes.repository.jdbc;

import java.util.List;
import java.util.Map;

import com.cloudsrcsoft.reportes.request.CabeceraPedidoLabRequest;
import com.cloudsrcsoft.reportes.request.CodigoMedicoRequest;
import com.cloudsrcsoft.reportes.request.ConsultorioRequest;
import com.cloudsrcsoft.reportes.request.DetallePedidoLabRequest;
import com.cloudsrcsoft.reportes.request.EspecialidadRequest;

public interface AtencionCustomRepository {

	List<Map<String, Object>> getListaCabeceraPedido_lab(CabeceraPedidoLabRequest cabeceraPedidoLab);

	List<Map<String, Object>> getListaCabeceraPedido_lab(DetallePedidoLabRequest detallePedidoLab);

	List<Map<String, Object>> searchByCodigoMedico(CodigoMedicoRequest codigoMedico);

	List<Map<String, Object>> getEspecialidad(EspecialidadRequest especialidad);

	List<Map<String, Object>> getConsultorio(ConsultorioRequest consultorio);

}
