package com.clsteach.contorl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clsteach.entity.DataTables;
import com.clsteach.entity.JsonResult;
import com.clsteach.entity.cls;
import com.clsteach.entity.clsex;
import com.clsteach.entity.clsex2;
import com.clsteach.entity.ctrelation;
import com.clsteach.entity.ctrelationex;
import com.clsteach.entity.stage;
import com.clsteach.entity.stageex;
import com.clsteach.entity.teach;
import com.clsteach.entity.teachex;
import com.clsteach.service.ClsService;
import com.clsteach.service.CtrelationService;
import com.clsteach.service.StageService;
import com.clsteach.service.TeachService;

@Controller
@RequestMapping("/jsp/cls")
public class clsControl {
@Autowired
private ClsService clsService;
@Autowired
private TeachService teaService;
@Autowired
private StageService stService;
@Autowired
private CtrelationService ctService;

@RequestMapping("/clslist")
@ResponseBody
public DataTables clslist(int start,int length,String key1){
	DataTables dt = new DataTables();
	clsex clsex = new clsex();
	if(key1!=null&&!("".equals(key1)))
	clsex.setClsName(key1);
	List<clsex2> cList = clsService.selByPage2(start, length, clsex);
	System.out.println("查询的结果长度为"+cList.size());
	int records = clsService.selRecords2(clsex);
	dt.setData(cList);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
@RequestMapping("/clsshow")
public String clsshow(){
	return "/jsp/cls/clslist";
}
@RequestMapping("/teachselect")
public String teachselect(){
	return "/jsp/cls/teachselect";
}
@RequestMapping("/login")
public String login(){
	return "jsp/loginuser/login";
}
@RequestMapping("/toedit")
public String toeditcls(int clsId,HttpServletRequest request){
	cls cls = clsService.selById(clsId);
	request.setAttribute("cls", cls);
	return "/jsp/cls/clsupdate";
}
@RequestMapping("/doedit")
@ResponseBody
public JsonResult doeditcls(cls cls){
	JsonResult js = new JsonResult();
	int res = clsService.update(cls);
	if(res>0){
		js.setTag(true);
		js.setMessage("班级信息修改成功！");
	}else {
		js.setTag(false);
		js.setMessage("班级信息修改失败！");
	}
	return js;
}

@RequestMapping("/doadd")
@ResponseBody
public JsonResult doaddcls(cls cls){
	JsonResult js = new JsonResult();
	int res = clsService.addcls(cls);
	if(res>0){
		js.setTag(true);
		js.setMessage("班级信息添加成功！");
	}else if(res==0){
		js.setTag(false);
		js.setMessage("班级信息添加失败！");
	}else {
		js.setTag(false);
		js.setMessage("班级名称已经存在，添加失败！");
	}
	return js;
}

@RequestMapping("/toadd")
public String toaddcls(){
	return "/jsp/cls/clsadd";
}

@RequestMapping("/dodel")
@ResponseBody
public JsonResult dodelcls(int clsId){
	JsonResult js = new JsonResult();
	int res = clsService.delcls(clsId);
	if(res>0){
		js.setTag(true);
		js.setMessage("班级信息删除成功！");
	}else if(res<0) {
		js.setTag(false);
		js.setMessage("该班级还有学生，不能删除！");
	}else {
		js.setTag(false);
		js.setMessage("班级信息删除成功！");
	}
	return js;
}

@RequestMapping("/tocon")
public String toconteach(int clsId,HttpServletRequest request){
	cls cls = clsService.selById(clsId);
	List<stage> stlist = stService.selAll();
	List<teach> tealist = teaService.selAll();
	request.setAttribute("cls", cls);
	request.setAttribute("stlist", stlist);
	request.setAttribute("tealist", tealist);
	return "jsp/cls/teachcon";
}
@RequestMapping("/docon")
@ResponseBody
public JsonResult doconteach(ctrelation ctrelation){
	JsonResult js = new JsonResult();
	ctrelation ctre =  ctService.selByclsAndsta(ctrelation);
	int res = 0;
	if(ctre==null){
		res = ctService.addCtrelation(ctrelation);
		if(res>0){
			js.setTag(true);
			js.setMessage("带班老师添加成功！");
		}
	}else {
		ctrelation.setRelaId(ctre.getRelaId());
		res = ctService.update(ctrelation);
		if(res>0){
			js.setTag(true);
			js.setMessage("带班老师修改成功！");
		}
	}
	
	return js;
}
@RequestMapping("/toteach")
public String toteach(int teachId,HttpServletRequest request){
	teachex teachex = teaService.selClsTeach(teachId);
	request.setAttribute("teacher", teachex);
	return "jsp/cls/teachshow";
}
@RequestMapping("/tostu")
public String tostu(String clsName,HttpServletRequest request){
	request.setAttribute("clsName", clsName);
	return "jsp/cls/stushow";
}
@RequestMapping("/selteach")
@ResponseBody
public JsonResult selteach(int clsId,int staId){
	JsonResult js = new JsonResult();
	ctrelation ctrelation = new ctrelation();
	ctrelation.setClsId(clsId);
	ctrelation.setStaId(staId);
	ctrelationex ctre = new ctrelationex();
	if(staId!=0){
	ctre = ctService.selByclsAndsta(ctrelation);
	}else {
		ctre.setTeachId(0);
	}
	js.setTag(true);
	js.setData(ctre);
	js.setMessage("查询成功！");
	return js;
}
@RequestMapping("/todetail")
public String seldetail(int clsId,HttpServletRequest request){
	List<stageex> stList = stService.selectByclsteach(clsId);
	clsex clsex = new clsex();
	cls cls = null;
	if(stList.size()<1){
		clsex = null;
	}
	else{
		cls = clsService.selById(clsId);
		clsex.setClsId(cls.getClsId());
		clsex.setClsName(cls.getClsName());
		clsex.setStagelist(stList);
	}
	
	request.setAttribute("clsex", clsex);
	return "jsp/cls/clsteachlist";
}
}
