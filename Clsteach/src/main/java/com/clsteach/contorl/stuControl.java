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
import com.clsteach.entity.stu;
import com.clsteach.entity.stuex;
import com.clsteach.service.ClsService;
import com.clsteach.service.StuService;

@Controller
@RequestMapping("/jsp/stu")
public class stuControl {
@Autowired
private StuService stService;
@Autowired
private ClsService cService;

@RequestMapping("/stulist")
@ResponseBody
public DataTables stulist(int start,int length,String key1,String key2){
	DataTables dt = new DataTables();
	
	stuex stuex = new stuex();
	cls cls = new cls();
	if(key1!=null&&!("".equals(key1)))
		stuex.setStuName("%"+key1+"%");
	if(key2!=null&&!("".equals(key2)))
	cls.setClsName("%"+key2+"%");
	stuex.setCls(cls);
	
	dt.setData(stService.selByPage(start, length, stuex));
	int records = stService.selCounts(stuex);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
	@RequestMapping("/stushow")
	public String stushow(){
		return "jsp/stu/stulist";
	}
	
	@RequestMapping("/toedit")
	public String toeditstu(int stuId,HttpServletRequest request){
		stu stu = stService.selById(stuId);
		List<cls> clist = cService.selAll();
		request.setAttribute("stu", stu);
		request.setAttribute("clist", clist);
		return "jsp/stu/stuupdate";
	}
	
	@RequestMapping("/doedit")
	@ResponseBody
	public JsonResult doeditstu(stu stu){
		JsonResult js = new JsonResult();
		int res = stService.update(stu);
		if(res>0){
			js.setTag(true);
			js.setMessage("学生信息修改成功！");
		}else{
			js.setTag(false);
			js.setMessage("学生信息修改失败！");
		}
		return js;
	}
	
	@RequestMapping("/toadd")
	public String toaddstu(HttpServletRequest request){
		List<cls> clist = cService.selAll();
		request.setAttribute("clist", clist);
		return "jsp/stu/stuadd";
	}
	@RequestMapping("/doadd")
	@ResponseBody
	public JsonResult doaddstu(stu stu,HttpServletRequest request){
		JsonResult js = new JsonResult();
		int res = stService.addStu(stu);
		if(res>0){
			js.setTag(true);
			js.setMessage("学生添加成功！");
		}else if (res==0) {
			js.setTag(false);
			js.setMessage("学生添加失败！");
		}else{
			js.setTag(false);
			js.setMessage("学号已经被使用，请修改后重新提交！");
		}
		return js;
	}
	
	@RequestMapping("/dodel")
	@ResponseBody
	public JsonResult dodelstu(int stuId){
		JsonResult js = new JsonResult();
		int res = stService.delStu(stuId);
		if(res>0){
			js.setTag(true);
			js.setMessage("学生信息删除成功！");
		}else{
			js.setTag(false);
			js.setMessage("学生信息删除失败！");
		}
		return js;
	}
}
