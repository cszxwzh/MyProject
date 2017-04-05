package com.xqls.control.zxw;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xqls.entity.zxw.DataTables;
import com.xqls.entity.zxw.JsonResult;
import com.xqls.entity.zxw.equipment;
import com.xqls.entity.zxw.operationlog;
import com.xqls.service.zxw.equipmentService;
import com.xqls.service.zxw.operationlogService;
import com.xqls.utils.zxw.DateFromate;
import com.xqls.utils.zxw.ExcelUtil;
import com.xqls.utils.zxw.ResponeUtil;

@Controller
@RequestMapping("/oper")
public class operationlogControl {
@Autowired
private operationlogService operationlogService;
@Autowired
private equipmentService equipmentService;

@RequestMapping("/dolist")
@ResponseBody
public DataTables selByPage(int start,int length,String starttime,String endtime,HttpServletRequest request) {
	//操作记录对应的操作类型
	String types = request.getParameter("types");
	String[] typeStrs =null;
	if(types!=null&&types.length()>1){
		System.out.println(types.substring(1));
		typeStrs = types.substring(1).split(",");
	}
	//设备id
	String equipid = request.getParameter("equipId");
	//if(equipid!=null&&!("".equals(equipid)))
	System.out.println("设备id是："+equipid+"0".equals(equipid));
	Map<String, Object> map =new HashMap<String, Object>();
	Date startDate =null;
	Date endDate=null;
	if(!(starttime==null || "".equals(starttime))){
	startDate = DateFromate.stringtodate(starttime);
	endDate = DateFromate.stringtodate(endtime);
	}
	map.put("startDate", startDate);
	map.put("endDate", endDate);
	if ("0".equals(equipid)) {
		equipid=null;
	}
	map.put("end", length+start);
	map.put("start", start);
	map.put("types", typeStrs);
	map.put("equipId", equipid);
	List<operationlog> oplist = operationlogService.selByPage(map);
	int records = operationlogService.selcount(map);
	DataTables dt = new DataTables(records, records, oplist);
	return dt;
}
@RequestMapping("/doexport")
public void doexport(String starttime,String endtime,HttpServletResponse response,HttpServletRequest request) throws IOException {
	//操作记录对应的操作类型
	String types = request.getParameter("types");
	String[] typeStrs =null;
	if(types!=null&&types.length()>1){
		System.out.println(types.substring(1));
		typeStrs = types.substring(1).split(",");
	}
	//设备id
	String equipid = request.getParameter("equipId");
	Map<String, Object> map =new HashMap<String, Object>();
	Date startDate =null;
	Date endDate=null;
	
	if(!(starttime==null || "".equals(starttime))){
		startDate = DateFromate.stringtodate(starttime);
		endDate = DateFromate.stringtodate(endtime);
	}
	map.put("startDate", startDate);
	map.put("endDate", endDate);
	map.put("types", typeStrs);
	if ("0".equals(equipid)) {
		equipid=null;
	}
	map.put("equipId", equipid);
	List<Map> oplist = operationlogService.selByExport(map);
	String[] headers = {"记录编号","操作时间","操作内容","操作设备","设备地区","操作人员"};
	Workbook wb = new HSSFWorkbook();
	ExcelUtil.fillExcelData(wb, oplist, headers);
	ResponeUtil.exportfile(response, wb, "操作记录.xls");
}



@RequestMapping("tolist")
public ModelAndView tolist(){
	Map<String, String> opertype = operationlogService.opertype;
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("oper/dooperatiolist");
	modelAndView.addObject("opertype", opertype);
	List<equipment> elist = equipmentService.selAll();
	modelAndView.addObject("elist", elist);
	return modelAndView;
}
@RequestMapping("doaddlog")
@ResponseBody
public JsonResult doaddlog(operationlog operationlog){
	JsonResult js = new JsonResult();
	System.out.println("设备类型"+operationlog.getOperType());
	String operType = operationlog.getOperType();
	int res = 0;
	boolean ces = operType!=null&&!("operate".equals(operType));
	if(operType!=null&&!("operate".equals(operType))){
		res = operationlogService.addoperofequip(operationlog);
	}else if(operType!=null){
		res = operationlogService.addoperofuser(operationlog);
	}
	if(res>0){
		js.setTag(true);
		js.setMessage("插入成功");
	}else {
		js.setTag(false);
		js.setMessage("插入失败");
	}
	return js;
}
@RequestMapping("toaddlog")
public String toadd(HttpServletRequest request){
	Map<String, String> opertype = operationlogService.opertype;
	List<equipment> elist = equipmentService.selAll();
	request.setAttribute("opertype", opertype);
	request.setAttribute("elist", elist);
	return "oper/toaddlog";
}
}
