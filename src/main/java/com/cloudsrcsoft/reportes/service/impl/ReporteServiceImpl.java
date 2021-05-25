package com.cloudsrcsoft.reportes.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cloudsrcsoft.reportes.entity.UserNotificationConfigEntity;
import com.cloudsrcsoft.reportes.exception.BusinessException;
import com.cloudsrcsoft.reportes.repository.jpa.UserNotificationConfigRepository;
import com.cloudsrcsoft.reportes.security.JwtUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
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
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private UserNotificationConfigRepository userNotificationConfigRepository;
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
//		return reporteCustomRepository.setGuardarConfiguracionNotificacion(reporte);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		log.info("Current user name: {}", currentUserName);

		JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(currentUserName);
		return this.setGuardarConfiguracionNotificacion(reporte, user.getId().intValue());
	}

	@Override
	public Integer setGuardarConfiguracionNotificacion(BaseGuardarConfigNotificaciones reporte, Integer userId) {
		Optional<UserNotificationConfigEntity> optUserConfig;
		if (reporte.getId() == null) {
			UserNotificationConfigEntity userConfig = new UserNotificationConfigEntity();
			userConfig.setName(reporte.getName());
			userConfig.setEnabled(reporte.getEnable());
			userConfig.setStartDate(reporte.getDate());
			userConfig.setEndingDate(reporte.getDate_end());
			userConfig.setTypeQuery(reporte.getType_query());
			userConfig.setTypeQueries(reporte.getType_queries().toString());
			userConfig.setUserId(userId);
			userConfig.setSendingType(reporte.getType_send());
			userConfig.setSpecialities(reporte.getSpecialities().toString());
			optUserConfig = Optional.of(this.userNotificationConfigRepository.save(userConfig));
		} else {
			optUserConfig = this.userNotificationConfigRepository.findById(reporte.getId().longValue())
					.map(model -> {
						model.setName(reporte.getName());
						model.setEnabled(reporte.getEnable());
						model.setStartDate(reporte.getDate());
						model.setTypeQuery(reporte.getType_query());
						model.setTypeQueries(reporte.getType_queries().toString());
						model.setSendingType(reporte.getType_send());
						model.setSpecialities(reporte.getSpecialities().toString());
						return Optional.of(this.userNotificationConfigRepository.save(model));
					}).orElseThrow(() -> new BusinessException("User notification config id not found"));
		}

		return optUserConfig.isPresent() ? 1 : 0;
	}

	@Override
	public Integer deleteConfiguracionNotificacion(Integer id) {
		return this.userNotificationConfigRepository.deleteUserNotificationConfigById(id.longValue());
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
