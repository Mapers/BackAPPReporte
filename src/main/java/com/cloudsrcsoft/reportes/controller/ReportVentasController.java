package com.cloudsrcsoft.reportes.controller;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.model.BaseExcelBean;
import com.cloudsrcsoft.reportes.model.ReporteVentas001Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas002Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas003Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas004Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas005Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas006Bean;
import com.cloudsrcsoft.reportes.model.ReporteVentas007Bean;
import com.cloudsrcsoft.reportes.request.ReporteVentasRequest;
import com.cloudsrcsoft.reportes.service.iface.IReportVentasService;
import com.cloudsrcsoft.reportes.util.ExcelGenerator;

@RestController
@RequestMapping(value = "/report-ventas")
public class ReportVentasController {

	private static final Logger log = LoggerFactory.getLogger(ReportVentasController.class);

	@Autowired
	private IReportVentasService reportVentasService;
	
	@PostMapping(path = "/getReporteTotal")
	public Map<String, Object> getReporteTotal(@RequestBody ReporteVentasRequest reporte){
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("reporteProd001", reportVentasService.getReporteVentas001(reporte));
		data.put("reporteProd002", reportVentasService.getReporteVentas002(reporte));
		data.put("reporteProd003", reportVentasService.getReporteVentas003(reporte));
		data.put("reporteProd004", reportVentasService.getReporteVentas004(reporte));
		data.put("reporteProd005", reportVentasService.getReporteVentas005(reporte));
		data.put("reporteProd006", reportVentasService.getReporteVentas006(reporte));
		data.put("reporteProd007", reportVentasService.getReporteVentas007(reporte));
		
		return data;
	} 

	@PostMapping(path = "/getReporteVentas001")
	public List<ReporteVentas001Bean> getReporteProd001(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas001Bean> lstReporte = reportVentasService.getReporteVentas001(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteVentas002")
	public List<ReporteVentas002Bean> getReporteProd002(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas002Bean> lstReporte = reportVentasService.getReporteVentas002(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteVentas003")
	public List<ReporteVentas003Bean> getReporteProd003(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas003Bean> lstReporte = reportVentasService.getReporteVentas003(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteVentas004")
	public List<ReporteVentas004Bean> getReporteProd004(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas004Bean> lstReporte = reportVentasService.getReporteVentas004(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteVentas005")
	public List<ReporteVentas005Bean> getReporteProd005(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas005Bean> lstReporte = reportVentasService.getReporteVentas005(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteVentas006")
	public List<ReporteVentas006Bean> getReporteProd006(@RequestBody ReporteVentasRequest reporte) {
		List<ReporteVentas006Bean> lstReporte = reportVentasService.getReporteVentas006(reporte);
		return lstReporte;
	}
	
	

	@PostMapping(path = "/exportToExcel")
	public ResponseEntity<Object> exportToExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ReporteVentasRequest reporte) throws Exception {

		List<BaseExcelBean> baseExcel = new ArrayList<BaseExcelBean>();

		BaseExcelBean baseExcelRep001 = new BaseExcelBean();

		baseExcelRep001.setColumns(new String[] { "ESPECIALIDAD", "FECHA VENTA", "CANT. PEDIDOS", "CANT. ATENCIONES",
				"TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep001.setSheetName("Resumen total");

		Map<String, Object[]> map = new LinkedHashMap<String, Object[]>();

		List<ReporteVentas001Bean> lstReporte1 = reportVentasService.getReporteVentas001(reporte);
		String[] object = null;

		int index = 0;
		for (ReporteVentas001Bean rep : lstReporte1) {

			object = new String[] { rep.getEspecialidad(), rep.getFechaVenta(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep001.setData(map);

		BaseExcelBean baseExcelRep002 = new BaseExcelBean();

		baseExcelRep002.setColumns(new String[] { "ESPECIALIDAD", "CONSULTORIO", "FECHA VENTA", "CANT. PEDIDOS",
				"CANT. ATENCIONES", "TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "INCREMENTO" });
		baseExcelRep002.setSheetName("Agrupado por día");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteVentas002Bean> lstReporte2 = reportVentasService.getReporteVentas002(reporte);
		object = null;

		index = 0;
		for (ReporteVentas002Bean rep : lstReporte2) {

			object = new String[] { rep.getEspecialidad(), rep.getConsultorio(), rep.getFechaVenta(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep002.setData(map);

		BaseExcelBean baseExcelRep003 = new BaseExcelBean();

		baseExcelRep003.setColumns(new String[] { "ESPECIALIDAD", "CONSULTORIO", "PRODUCTO", "CANT. PEDIDOS",
				"CANT. ATENCIONES", "TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep003.setSheetName("Agrupado por servicio");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteVentas003Bean> lstReporte3 = reportVentasService.getReporteVentas003(reporte);
		object = null;

		index = 0;
		for (ReporteVentas003Bean rep : lstReporte3) {

			object = new String[] { rep.getEspecialidad(), rep.getConsultorio(), rep.getProducto(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep003.setData(map);

		BaseExcelBean baseExcelRep004 = new BaseExcelBean();

		baseExcelRep004.setColumns(new String[] { "ESPECIALIDAD", "CONSULTORIO", "PRODUCTO", "CANT. PEDIDOS",
				"CANT. ATENCIONES", "TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep004.setSheetName("Servicio normal");
		
		map = new LinkedHashMap<String, Object[]>();
		
		List<ReporteVentas004Bean> lstReporte4 = reportVentasService.getReporteVentas004(reporte);
		object = null;

		index = 0;
		for (ReporteVentas004Bean rep : lstReporte4) {

			object = new String[] { rep.getEspecialidad(), rep.getConsultorio(), rep.getProducto(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep004.setData(map);

		BaseExcelBean baseExcelRep005 = new BaseExcelBean();

		baseExcelRep005.setColumns(new String[] { "ESPECIALIDAD", "CONSULTORIO", "PRODUCTO", "CANT. PEDIDOS",
				"CANT. ATENCIONES", "TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep005.setSheetName("Servicio especial");
		
		
		map = new HashMap<String, Object[]>();
		
		List<ReporteVentas005Bean> lstReporte5 = reportVentasService.getReporteVentas005(reporte);
		object = null;

		index = 0;
		for (ReporteVentas005Bean rep : lstReporte5) {

			object = new String[] { rep.getEspecialidad(), rep.getConsultorio(), rep.getProducto(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep005.setData(map);

		BaseExcelBean baseExcelRep006 = new BaseExcelBean();

		baseExcelRep006.setColumns(new String[] { "ESPECIALIDAD", "CONSULTORIO", "FECHA VENTA", "FECHA ATENCION",
				"PAGADO", "MEDICO", "NUMERO PEDIDO", "NUMERO ORDEN", "TIPO COMP", "COMPROBANTE", "PACIENTE", "PRODUCTO", "CANTIDAD",
				"DESCUENTO", "TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "HUMANIDAD", "TERCERO" });
		baseExcelRep006.setSheetName("Detallado");
		
		
		map = new LinkedHashMap<String, Object[]>();
		
		List<ReporteVentas006Bean> lstReporte6 = reportVentasService.getReporteVentas006(reporte);
		object = null;

		index = 0;
		for (ReporteVentas006Bean rep : lstReporte6) {

			object = new String[] { rep.getEspecialidad(), rep.getConsultorio(), rep.getFechaVenta(), rep.getFechaAtencion(),
					rep.getPagado(), rep.getMedico(), rep.getNumPedido(), rep.getNumOrden(), rep.getTipoComprobante(), rep.getComprobante(),
					rep.getPaciente(), rep.getProducto(), rep.getCantidad(), rep.getDescuento(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep006.setData(map);
		
		BaseExcelBean baseExcelRep007 = new BaseExcelBean();

		baseExcelRep007.setColumns(new String[] {"ESPECIALIDAD", "CANT. PEDIDOS", "CANT. ATENCIONES",
				"TOTAL VENTA", "P.P TOTAL", "P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO"});
		baseExcelRep007.setSheetName("Todo Unido");
		
		
		
		map = new LinkedHashMap<String, Object[]>();
		List<ReporteVentas007Bean> lstReporte7 = reportVentasService.getReporteVentas007(reporte);
		object = null;

		index = 0;
		for (ReporteVentas007Bean rep : lstReporte7) {

			object = new String[] { rep.getEspecialidad(), rep.getCtdPedidos(),
					rep.getCtdAtenciones(), rep.getTotalVenta(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep007.setData(map);
		
		baseExcel.add(baseExcelRep007);
		baseExcel.add(baseExcelRep001);
		baseExcel.add(baseExcelRep002);
		baseExcel.add(baseExcelRep003);
		baseExcel.add(baseExcelRep004);
		baseExcel.add(baseExcelRep005);
		baseExcel.add(baseExcelRep006);

		ByteArrayInputStream in = ExcelGenerator.reportToExcel(baseExcel);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Reporte.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
}
