package com.cloudsrcsoft.reportes.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudsrcsoft.reportes.repository.jdbc.AtencionCustomRepository;
import com.cloudsrcsoft.reportes.request.CabeceraPedidoLabRequest;
import com.cloudsrcsoft.reportes.request.CodigoMedicoRequest;
import com.cloudsrcsoft.reportes.request.ConsultorioRequest;
import com.cloudsrcsoft.reportes.request.DetallePedidoLabRequest;
import com.cloudsrcsoft.reportes.request.EspecialidadRequest;
import com.cloudsrcsoft.reportes.service.iface.IAtencionService;

@Service
public class AtencionServiceImpl implements IAtencionService{
	
	@Autowired
	private AtencionCustomRepository atencionCustomRepository;
	
	@Override
	public List<Map<String, Object>> getListaCabeceraPedido_lab(CabeceraPedidoLabRequest cabeceraPedidoLab) {
		return atencionCustomRepository.getListaCabeceraPedido_lab(cabeceraPedidoLab);
	}

	@Override
	public List<Map<String, Object>> getListaDetallePedido_lab(DetallePedidoLabRequest detallePedidoLab) {
		return atencionCustomRepository.getListaCabeceraPedido_lab(detallePedidoLab);
	}

	@Override
	public List<Map<String, Object>> searchByCodigoMedico(CodigoMedicoRequest codigoMedico) {
		return atencionCustomRepository.searchByCodigoMedico(codigoMedico);
	}

	@Override
	public List<Map<String, Object>> getEspecialidad(EspecialidadRequest especialidad) {
		return atencionCustomRepository.getEspecialidad(especialidad);
	}

	@Override
	public List<Map<String, Object>> getConsultorio(ConsultorioRequest consultorio) {
		return atencionCustomRepository.getConsultorio(consultorio);
	}

}
