package com.cloudsrcsoft.reportes.taks;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cloudsrcsoft.reportes.controller.ReportController;
import com.cloudsrcsoft.reportes.util.ReportesUtil;

import io.jsonwebtoken.lang.Arrays;
import oracle.jdbc.OracleTypes;

import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.PushNotificationRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.service.PushNotificationService;
import com.cloudsrcsoft.reportes.service.iface.IReporteService;

@Component
public class Tasks {
	private static final Logger log = LoggerFactory.getLogger(ReportController.class);
	

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private IReporteService reporteService;
	@Autowired
	private PushNotificationService pushNotificationService;
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
@Scheduled(fixedRate=15000)
public void logCurrentDate() {
	SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withSchemaName("HW_RPT")
			.withCatalogName("HHW_REPORTE")
			.withFunctionName("F_CUR_CONFIG_USER_1")
			.declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
	SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", "ok")
													   .addValue("cCodLocal_in","ok");
	Map<String, Object> m = simpleJdbcCall.execute(in);
	List<Map<String, Object>> mb=(List<Map<String, Object>>) m.get("FarmaCursor");
	
	for (Map<String, Object> map : mb) {
	
		System.out.println(mb);

		try {			
			 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(map.get("DATE_CONFIG").toString());  
			 
			String cadena ="";
			String cadena2 ="";
			String mensaje="";
			String mensaje2="";

			Integer parte = 0;
			Calendar fecha = Calendar.getInstance();
			Calendar fechaactual = Calendar.getInstance();
			fecha.setTime(date1);
			List<Map<String, Object>> mapa2;
			String date_config_end;
			if((fecha.get(Calendar.MONTH)+1)==(fechaactual.get(Calendar.MONTH)+1) &&
					(fecha.get(Calendar.YEAR))==(fechaactual.get(Calendar.YEAR))) {
				List<String> listStrings2 = new ArrayList<String>();

				String especialidades =map.get("SPECIALITIES").toString().replaceAll("[\\[\\](){}]","").trim();
				String  str[]= especialidades.split(",");
				listStrings2=java.util.Arrays.asList(str);
				System.out.println(listStrings2.toString());

				if(map.get("DATE_CONFIG_END")==null){
					date_config_end=null;
					ReporteConsultaFiltroRequest reporte =new ReporteConsultaFiltroRequest(map.get("TYPE_SEND").toString(),listStrings2,map.get("DATE_CONFIG").toString(),map.get("DATE_CONFIG").toString());
				 mapa2 =reporteService.getConsultaFiltro(reporte);

				}
				else {
					date_config_end=map.get("DATE_CONFIG_END").toString();
					ReporteConsultaFiltroRequest reporte =new ReporteConsultaFiltroRequest(map.get("TYPE_SEND").toString(),listStrings2,map.get("DATE_CONFIG").toString(),map.get("DATE_CONFIG_END").toString());
					mapa2 =reporteService.getConsultaFiltro(reporte);

				}
				for (Map<String, Object> map2 : mapa2) {
					switch (map.get("TYPE_QUERY").toString()) 
			        {
			            case "TOTAL_MOUNT": cadena="TOTAL_MOUNT";
			            cadena2="TOTAL_AMOUNT";
			            parte=0;
			            mensaje2="S/";
			                     break;
			            case  "REQUEST" :cadena="REQUEST";
			            cadena2="ORDERS";
			            mensaje="pedidos";

			            parte=1;

			                     break;
			            case "ATTENTION": cadena="ATTENTION" ;
			            parte=2;
			            cadena2="ATTENTIONS";
			            mensaje="atenciones";

			                     break;
			        }
					String opciones =map.get("TYPE_QUERIES").toString().replaceAll("[\\[\\](){}]","");
					String[] parts = opciones.split(",");
					System.out.println(map2.get(cadena2).toString());
					System.out.println(parts[parte].replace(cadena +"=","").trim());
					System.out.println(map.get("DATE_CONFIG_END"));
					if(Double.parseDouble(map2.get(cadena2).toString())>=Double.parseDouble(parts[parte].replace(cadena +"=","").trim()) && Double.parseDouble(map.get("ENABLED").toString())==1)  {
						//System.out.println("entro");
						//System.out.println(map.get("TOKEN_ID").toString());
						//ENVIO DE NOTIFICACION
						PushNotificationRequest request=new PushNotificationRequest(fecha.toString(),"Se superó los " + mensaje2+ parts[parte].replace(cadena +"=","").trim() + mensaje + fecha.toString(),"",map.get("TOKEN_ID").toString());
				        
						pushNotificationService.sendPushNotificationToToken(request);
						  jdbcTemplate.update("call RPT_GUARDAR_CONFIG_USER(?,?,?,?,?,?,?,?,?,?)",
								map.get("ID").toString(),
								1,
								0,
								map.get("DATE_CONFIG").toString(),
								map.get("TYPE_QUERY").toString(),
								map.get("TYPE_QUERIES").toString(),
								map.get("USER_ID").toString(),
								map.get("TYPE_SEND").toString(),
								date_config_end,
								map.get("SPECIALITIES").toString()
								);
					}
							
					
				}
			
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
}
