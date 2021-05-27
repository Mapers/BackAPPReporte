package com.cloudsrcsoft.reportes.taks;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.sql.DataSource;

import com.google.common.base.Splitter;
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

import oracle.jdbc.OracleTypes;

import com.cloudsrcsoft.reportes.request.BaseGuardarConfigNotificaciones;
import com.cloudsrcsoft.reportes.request.PushNotificationRequest;
import com.cloudsrcsoft.reportes.request.ReporteConsultaFiltroRequest;
import com.cloudsrcsoft.reportes.service.PushNotificationService;
import com.cloudsrcsoft.reportes.service.iface.IReporteService;
import org.springframework.util.StringUtils;

@Component
public class Tasks {
    private static final Logger log = LoggerFactory.getLogger(Tasks.class);


    private JdbcTemplate jdbcTemplate;
    @Autowired
    private IReporteService reporteService;
    @Autowired
    private PushNotificationService pushNotificationService;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Scheduled(fixedRate = 15000)
    public void logCurrentDate() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("HW_RPT")
                .withCatalogName("HHW_REPORTE")
                .withFunctionName("F_CUR_CONFIG_USER_1")
                .declareParameters(new SqlOutParameter("FarmaCursor", OracleTypes.CURSOR));
        SqlParameterSource in = new MapSqlParameterSource().addValue("cCodGrupoCia_in", "ok")
                .addValue("cCodLocal_in", "ok");
        Map<String, Object> m = simpleJdbcCall.execute(in);
        List<Map<String, Object>> mb = (List<Map<String, Object>>) m.get("FarmaCursor");

        for (Map<String, Object> map : mb) {

            System.out.println(mb);

            try {
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(map.get("DATE_CONFIG").toString());

                String cadena = "";
                String cadena2 = "";
                String mensaje = "";
                String mensaje2 = "";

                Integer parte = 0;
                Calendar fecha = Calendar.getInstance();
                Calendar fechaactual = Calendar.getInstance();
                fecha.setTime(date1);
                List<Map<String, Object>> mapa2;
                String date_config_end;
                if ((fecha.get(Calendar.MONTH) + 1) == (fechaactual.get(Calendar.MONTH) + 1) &&
                        (fecha.get(Calendar.YEAR)) == (fechaactual.get(Calendar.YEAR))) {
                    List<String> listStrings2;

                    String especialidades = map.get("SPECIALITIES").toString().replaceAll("[\\[\\](){}]", "").trim();
                    String[] str = especialidades.split(",");
                    listStrings2 = java.util.Arrays.asList(str);
                    System.out.println(listStrings2);

                    if (map.get("DATE_CONFIG_END") == null) {
                        date_config_end = null;
                        ReporteConsultaFiltroRequest reporte = new ReporteConsultaFiltroRequest(map.get("TYPE_SEND").toString(), listStrings2, map.get("DATE_CONFIG").toString(), map.get("DATE_CONFIG").toString());
                        mapa2 = reporteService.getConsultaFiltro(reporte);

                    } else {
                        date_config_end = map.get("DATE_CONFIG_END").toString();
                        ReporteConsultaFiltroRequest reporte = new ReporteConsultaFiltroRequest(map.get("TYPE_SEND").toString(), listStrings2, map.get("DATE_CONFIG").toString(), map.get("DATE_CONFIG_END").toString());
                        mapa2 = reporteService.getConsultaFiltro(reporte);

                    }
                    for (Map<String, Object> map2 : mapa2) {
                        switch (map.get("TYPE_QUERY").toString()) {
                            case "TOTAL_MOUNT":
                                cadena = "TOTAL_MOUNT";
                                cadena2 = "TOTAL_AMOUNT";
                                parte = 0;
                                mensaje2 = "S/";
                                break;
                            case "REQUEST":
                                cadena = "REQUEST";
                                cadena2 = "ORDERS";
                                mensaje = "pedidos";

                                parte = 1;

                                break;
                            case "ATTENTION":
                                cadena = "ATTENTION";
                                parte = 2;
                                cadena2 = "ATTENTIONS";
                                mensaje = "atenciones";

                                break;
                        }
                        String opciones = map.get("TYPE_QUERIES").toString().replaceAll("[\\[\\](){}]", "");
                        String[] parts = opciones.split(",");
                        System.out.println(map2.get(cadena2).toString());
                        System.out.println(parts[parte].replace(cadena + "=", "").trim());
                        System.out.println(map.get("DATE_CONFIG_END"));
                        if (Double.parseDouble(map2.get(cadena2).toString()) >= Double.parseDouble(parts[parte].replace(cadena + "=", "").trim()) && Double.parseDouble(map.get("ENABLED").toString()) == 1) {
                            // ENVIO DE NOTIFICACION
                            String notificationName = map.containsKey("NAME") ? map.get("NAME").toString() : "Nueva notificación";
                            Double amount = Double.parseDouble(parts[parte].replace(cadena + "=", "").trim());
                            String strAmount;
                            if ("TOTAL_MOUNT".equals(cadena)) {
                                strAmount = String.format("%.2f", amount);
                            } else {
                                int value = amount.intValue();
                                strAmount = String.valueOf(value);
                            }
                            String typeDescription = mensaje2 + strAmount + " " + mensaje;
                            String notificationDate = "";
                            if (map.containsKey("TYPE_SEND")) {
                                switch (map.get("TYPE_SEND").toString()) {
                                    case "MONTH":
                                        String month = new SimpleDateFormat("MMMM", new Locale("es", "ES")).format(fecha.getTime());
                                        notificationDate = String.format("del mes de %s", StringUtils.capitalize(month));
                                        break;
                                    case "RANGE":
                                        String initDate = map.get("DATE_CONFIG").toString();
                                        String endDate = map.get("DATE_CONFIG_END").toString();
                                        notificationDate = String.format("desde %s al %s", initDate, endDate);
                                        break;
                                    default:
                                        String date = new SimpleDateFormat("dd/MM/yyyy").format(fecha.getTime());
                                        notificationDate = String.format("para el día %s", date);
                                        break;
                                }
                            }
                            String notificationMessage = String.format("Se superó los %s %s", typeDescription, notificationDate);
                            PushNotificationRequest request = new PushNotificationRequest(notificationName, notificationMessage, "", map.get("TOKEN_ID").toString());

                            log.info("Sending push user notification with data: {}", request);
                            pushNotificationService.sendPushNotificationToToken(request);
						  /*jdbcTemplate.update("call RPT_GUARDAR_CONFIG_USER(?,?,?,?,?,?,?,?,?,?)",
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
								);*/
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            Integer configId = map.get("ID") != null ? Integer.parseInt(map.get("ID").toString()) : null;
                            LocalDate startDate = map.get("DATE_CONFIG") != null ? LocalDate.parse(map.get("DATE_CONFIG").toString(), formatter) : null;
                            String query = map.get("TYPE_QUERY") != null ? map.get("TYPE_QUERY").toString() : null;

                            LinkedHashMap<String, Double> queries = new LinkedHashMap<>();
                            if (map.get("TYPE_QUERIES") != null) {
                                Map<String, String> mapQueries = Splitter.on(',').withKeyValueSeparator('=').split(opciones);
                                for (Map.Entry<String, String> entry : mapQueries.entrySet()) {
                                    if (!entry.getValue().equalsIgnoreCase("null") && StringUtils.hasText(entry.getValue())) {
                                        queries.put(entry.getKey().trim(), Double.parseDouble(entry.getValue()));
                                    } else {
                                        queries.put(entry.getKey(), null);
                                    }
                                }
                            }
                            String sendingType = map.get("TYPE_SEND") != null ? map.get("TYPE_SEND").toString() : null;

                            List<String> specialities = new ArrayList<>();
                            if (map.get("SPECIALITIES") != null) {
                                String mapSpecialities = map.get("SPECIALITIES").toString().replaceAll("[\\[\\](){}]", "");
                                specialities = Splitter.on(",")
                                        .omitEmptyStrings()
                                        .trimResults()
                                        .splitToList(mapSpecialities);
                            }

                            LocalDate endingDate = date_config_end != null ? LocalDate.parse(date_config_end, formatter) : null;
                            String notifName = map.containsKey("NAME") ? map.get("NAME").toString() : "";

                            BaseGuardarConfigNotificaciones reporte = new BaseGuardarConfigNotificaciones();
                            reporte.setName(notifName);
                            reporte.setId(configId);
                            reporte.setEnable(0);
                            reporte.setDate(startDate);
                            reporte.setType_query(query);
                            reporte.setType_queries(queries);
                            reporte.setType_send(sendingType);
                            reporte.setDate_end(endingDate);
                            reporte.setSpecialities(specialities);
                            int userId = Integer.parseInt(map.get("USER_ID").toString());
                            this.reporteService.setGuardarConfiguracionNotificacion(reporte, userId);
                        }


                    }

                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
