package com.cloudsrcsoft.reportes.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cloudsrcsoft.reportes.model.BaseExcelBean;

public class ExcelGenerator {
	public static ByteArrayInputStream reportToExcel(List<BaseExcelBean> baseExcel) throws Exception {

		if (baseExcel.isEmpty()) {
			throw new Exception("No se encuentra datos.");
		}

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			for (BaseExcelBean base : baseExcel) {
				CreationHelper createHelper = workbook.getCreationHelper();

				Sheet sheet = workbook.createSheet(base.getSheetName());

				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				//headerFont.setColor(IndexedColors.BLUE.getIndex());

				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);

				// Row for Header
				Row headerRow = sheet.createRow(0);

				// Header
				for (int col = 0; col < base.getColumns().length; col++) {
					Cell cell = headerRow.createCell(col);
					cell.setCellValue(base.getColumns()[col]);
					cell.setCellStyle(headerCellStyle);
					sheet.autoSizeColumn(col);
				}

				// CellStyle for Age
				CellStyle ageCellStyle = workbook.createCellStyle();
				ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
				
				if(base.getData() != null && !base.getData().isEmpty()) {
					Set<String> keyset = base.getData().keySet();
	
					int rowIdx = 1;
					for (String key : keyset) {
						Row row = sheet.createRow(rowIdx++);
						Object[] objArr = base.getData().get(key);
						int cellnum = 0;
						for (Object obj : objArr) {
							Cell cell = row.createCell(cellnum++);
							if (obj instanceof String)
								cell.setCellValue((String) obj);
							else if (obj instanceof Integer)
								cell.setCellValue((Integer) obj);
						}
					}
				}
				
			}
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

	public static ByteArrayInputStream test() throws IOException {
		String[] COLUMNs = { "Id", "Name", "Address", "Age" };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("Customers");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			// CellStyle for Age
			CellStyle ageCellStyle = workbook.createCellStyle();
			ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

			int rowIdx = 1;
			for (int i = 0; i < 5; i++) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(11);
				row.createCell(1).setCellValue(12);
				row.createCell(2).setCellValue(12);

				Cell ageCell = row.createCell(3);
				ageCell.setCellValue(16);
				ageCell.setCellStyle(ageCellStyle);
			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}

}
