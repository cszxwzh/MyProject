package com.xqls.utils.zxw;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.xqls.entity.zxw.operationlog;


public class ExcelUtil {
	public static void fillExcelData(Workbook wb,List<Map> oplist,String[] headers){
		int rownum=0;
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(rownum++);
		for (int i = 0; i < headers.length; i++) {
			row.createCell(i).setCellValue(headers[i]);
		}
		
		for (int i = 0; i < oplist.size(); i++) {
			row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(oplist.get(i).get("OPER_ID").toString());
			
			CellStyle cellStyle = wb.createCellStyle();
			CreationHelper creationHelper = wb.getCreationHelper();
			cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-mm-dd"));
			
			Cell cell = row.createCell(1);
			cell.setCellValue(oplist.get(i).get("OPER_DATE").toString());
			cell.setCellStyle(cellStyle);
			
			row.createCell(2).setCellValue(oplist.get(i).get("OPER_INFO").toString());
			if(oplist.get(i).get("EQUIP_NAME")!=null)
			row.createCell(3).setCellValue(oplist.get(i).get("EQUIP_NAME").toString());
			if(oplist.get(i).get("BLOCK_NAME")!=null)
			row.createCell(4).setCellValue(oplist.get(i).get("BLOCK_NAME").toString());
			if(oplist.get(i).get("USER_NAME")!=null)
			row.createCell(5).setCellValue(oplist.get(i).get("USER_NAME").toString());
		}
	}
}
