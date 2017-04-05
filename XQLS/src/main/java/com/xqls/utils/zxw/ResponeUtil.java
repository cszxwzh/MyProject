package com.xqls.utils.zxw;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;

public class ResponeUtil {
public static void exportfile(HttpServletResponse response,Workbook wb,String filename) throws IOException {
	response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("utf-8"),"iso8859-1"));
	response.setContentType("application/ynd.ms-excel;charset=UTF-8");
	OutputStream out = response.getOutputStream();
	wb.write(out);
	out.flush();
	out.close();
}
}
