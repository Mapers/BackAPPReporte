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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsrcsoft.reportes.model.BaseExcelBean;
import com.cloudsrcsoft.reportes.model.ReporteProd001Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd002Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd003Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd004Bean;
import com.cloudsrcsoft.reportes.model.ReporteProd005Bean;
import com.cloudsrcsoft.reportes.request.ReporteProduccionRequest;
import com.cloudsrcsoft.reportes.service.iface.IReportProdService;
import com.cloudsrcsoft.reportes.util.ExcelGenerator;

@RestController
@RequestMapping(value = "/report-prod")
public class ReportProduccionController {

	private static final Logger log = LoggerFactory.getLogger(ReportProduccionController.class);

	@Autowired
	private IReportProdService reportProdService;
	
	@PostMapping(path = "/getReporteTotal")
	public Map<String, Object> getReporteTotal(@RequestBody ReporteProduccionRequest reporte){
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("reporteProd001", reportProdService.getReporteProd001(reporte));
		data.put("reporteProd002", reportProdService.getReporteProd002(reporte));
		data.put("reporteProd003", reportProdService.getReporteProd003(reporte));
		data.put("reporteProd004", reportProdService.getReporteProd004(reporte));
		data.put("reporteProd005", reportProdService.getReporteProd005(reporte));
		
		return data;
	}

	@PostMapping(path = "/getReporteProd001")
	public List<ReporteProd001Bean> getReporteProd001(@RequestBody ReporteProduccionRequest reporte) {
		List<ReporteProd001Bean> lstReporte = reportProdService.getReporteProd001(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteProd002")
	public List<ReporteProd002Bean> getReporteProd002(@RequestBody ReporteProduccionRequest reporte) {
		List<ReporteProd002Bean> lstReporte = reportProdService.getReporteProd002(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteProd003")
	public List<ReporteProd003Bean> getReporteProd003(@RequestBody ReporteProduccionRequest reporte) {
		List<ReporteProd003Bean> lstReporte = reportProdService.getReporteProd003(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteProd004")
	public List<ReporteProd004Bean> getReporteProd004(@RequestBody ReporteProduccionRequest reporte) {
		List<ReporteProd004Bean> lstReporte = reportProdService.getReporteProd004(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/getReporteProd005")
	public List<ReporteProd005Bean> getReporteProd005(@RequestBody ReporteProduccionRequest reporte) {
		List<ReporteProd005Bean> lstReporte = reportProdService.getReporteProd005(reporte);
		return lstReporte;
	}

	@PostMapping(path = "/exportToExcel")
	public ResponseEntity<Object> exportToExcel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody ReporteProduccionRequest reporte) throws Exception {

		List<BaseExcelBean> baseExcel = new ArrayList<BaseExcelBean>();

		BaseExcelBean baseExcelRep001 = new BaseExcelBean();

		baseExcelRep001.setColumns(new String[] { "FECHA ATENCION", "CANT. PEDIDOS", "CANT. ATENCIONES", "P.P TOTAL",
				"P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep001.setSheetName("Reporte Diario");

		Map<String, Object[]> map = new LinkedHashMap<String, Object[]>();

		List<ReporteProd001Bean> lstReporte1 = reportProdService.getReporteProd001(reporte);
		String[] object = null;

		int index = 0;
		for (ReporteProd001Bean rep : lstReporte1) {

			object = new String[] { rep.getFechaAtencion(), rep.getCtdTickets(), rep.getCtdAtenciones(),
					rep.getPpTotal(), rep.getPtTotal(), rep.getIncremento(), rep.getTotalHumanidad(),
					rep.getTotalTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep001.setData(map);

		BaseExcelBean baseExcelRep002 = new BaseExcelBean();

		baseExcelRep002.setColumns(new String[] { "PRODUCTO", "CANT. PEDIDOS", "CANT. ATENCIONES", "P.P TOTAL",
				"P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep002.setSheetName("Productos Total");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteProd002Bean> lstReporte2 = reportProdService.getReporteProd002(reporte);
		object = null;

		index = 0;
		for (ReporteProd002Bean rep : lstReporte2) {

			object = new String[] { rep.getProducto(), rep.getCtdPedidos(), rep.getCtdAtenciones(), rep.getPpTotal(),
					rep.getPtTotal(), rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep002.setData(map);

		BaseExcelBean baseExcelRep003 = new BaseExcelBean();

		baseExcelRep003.setColumns(new String[] { "PRODUCTO", "CANT. PEDIDOS", "CANT. ATENCIONES", "P.P TOTAL",
				"P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep003.setSheetName("Productos Normal");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteProd003Bean> lstReporte3 = reportProdService.getReporteProd003(reporte);
		object = null;

		index = 0;
		for (ReporteProd003Bean rep : lstReporte3) {

			object = new String[] { rep.getProducto(), rep.getCtdPedidos(), rep.getCtdAtenciones(), rep.getPpTotal(),
					rep.getPtTotal(), rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep003.setData(map);

		BaseExcelBean baseExcelRep004 = new BaseExcelBean();

		baseExcelRep004.setColumns(new String[] { "PRODUCTO", "CANT. PEDIDOS", "CANT. ATENCIONES", "P.P TOTAL",
				"P.T TOTAL", "INCREMENTO", "HUMANIDAD", "TERCERO" });
		baseExcelRep004.setSheetName("Productos Especial");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteProd004Bean> lstReporte4 = reportProdService.getReporteProd004(reporte);
		object = null;

		index = 0;
		for (ReporteProd004Bean rep : lstReporte4) {

			object = new String[] { rep.getProducto(), rep.getCtdPedidos(), rep.getCtdAtenciones(), rep.getPpTotal(),
					rep.getPtTotal(), rep.getIncremento(), rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep004.setData(map);

		BaseExcelBean baseExcelRep005 = new BaseExcelBean();

		baseExcelRep005.setColumns(new String[] { "FECHA VENTA", "FECHA ATENCION", "PAGADO", "MEDICO", "NUM_PEDIDO", "NUM_ORDEN",
				"TIPO COMP", "COMPROBANTE", "PACIENTE", "PRODUCTO", "CANTIDAD", "DESCUENTO", "P.P TOTAL", "P.T TOTAL",
				"HUMANIDAD", "TERCERO" });
		baseExcelRep005.setSheetName("Reporte Detallado");

		map = new LinkedHashMap<String, Object[]>();

		List<ReporteProd005Bean> lstReporte5 = reportProdService.getReporteProd005(reporte);
		object = null;

		index = 0;
		for (ReporteProd005Bean rep : lstReporte5) {

			object = new String[] { rep.getFechaVenta(), rep.getFechaAtencion(), rep.getPagado(), rep.getMedico(),
					rep.getNumPedido(), rep.getNumOrden() , rep.getTipoComprobante(), rep.getPaciente(), rep.getProducto(),
					rep.getCantidad(), rep.getDescuento(), rep.getProducto(), rep.getPpTotal(), rep.getPtTotal(),
					rep.getHumanidad(), rep.getTercero() };

			map.put(String.valueOf(index), object);

			index++;
		}

		baseExcelRep005.setData(map);

		baseExcel.add(baseExcelRep001);
		baseExcel.add(baseExcelRep002);
		baseExcel.add(baseExcelRep003);
		baseExcel.add(baseExcelRep004);
		baseExcel.add(baseExcelRep005);
		ByteArrayInputStream in = ExcelGenerator.reportToExcel(baseExcel);
		// return IOUtils.toByteArray(in);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=Reporte.xlsx");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));

	}
}