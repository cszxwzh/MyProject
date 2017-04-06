package com.clsteach.contorl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clsteach.entity.DataTables;
import com.clsteach.entity.JsonResult;
import com.clsteach.entity.teach;
import com.clsteach.service.TeachService;
import com.clsteach.utils.DateFromate;

@Controller
@RequestMapping("/jsp/teach")
public class teachControl {
	@Autowired
	private TeachService tService;
	@RequestMapping("/teachlist")
	@ResponseBody
	public DataTables teachlist(int start,int length,String key1,String key2){
		teach teach = new teach();
		if(key1!=null&&!("".equals(key1)))
		teach.setTeachName("%"+key1+"%");
		if(key2!=null&&!("".equals(key2)))
		teach.setTeachIntro("%"+key2+"%");
		List<Map> tlist = tService.selByNewPage(start, length, teach);
		if(tlist.size()>0){
			for (Map map : tlist) {
				map.put("ENTRY_DATE", DateFromate.datetostring((Date) map.get("ENTRY_DATE")));
			}
		}
		int records = tService.selCounts(teach);
		DataTables dt = new DataTables();
		dt.setData(tlist);
		dt.setRecordsFiltered(records);
		dt.setRecordsTotal(records);
		return dt;
	}
	@RequestMapping("teachshow")
	public String showteach(){
		return "jsp/teach/teachlist";
	}
	@RequestMapping("toedit")
	public String toeditteach(int teachId,HttpServletRequest request){
		teach teacher = tService.selById(teachId);
		request.setAttribute("teacher", teacher);
		return "jsp/teach/teachupdate";
	}
	
	@RequestMapping("doedit")
	@ResponseBody
	public JsonResult doeditteach(teach teacher,HttpServletRequest request){
		JsonResult js = new JsonResult();
		int res = tService.update(teacher);
		if(res>0){
			js.setTag(true);
			js.setMessage("教师信息更新成功！");
		}else {
			js.setTag(false);
			js.setMessage("教师信息更新失败！");
		}
		return js;
	}
	
	@RequestMapping("toadd")
	public String toaddteach(){
		return "jsp/teach/teachadd";
	}
	@RequestMapping("doadd")
	@ResponseBody
	public JsonResult doaddteach(teach teacher){
		JsonResult js = new JsonResult();
		int res = tService.addteach(teacher);
		if(res>0){
			js.setTag(true);
			js.setMessage("教师信息添加成功！");
		}else {
			js.setTag(false);
			js.setMessage("教师信息添加失败！");
		}
		return js;
	}
	@RequestMapping("/dodel")
	@ResponseBody
	public JsonResult dodelteach(int teachId){
		JsonResult js = new JsonResult();
		int res = tService.delteach(teachId);
		if(res>0){
			js.setTag(true);
			js.setMessage("教师信息删除成功！");
		}else {
			js.setTag(false);
			js.setMessage("教师信息删除失败！");
		}
		return js;
	}
	@RequestMapping("tosel")
	@ResponseBody
	public JsonResult toselteach(int teachId){
		JsonResult js = new JsonResult();
		teach teach = tService.selById(teachId);
		js.setData(teach);
		js.setTag(true);
		return js;
	}
}
