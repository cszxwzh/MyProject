package com.xqls.control.zxw;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xqls.entity.zxw.DataTables;
import com.xqls.entity.zxw.JsonResult;
import com.xqls.entity.zxw.block;
import com.xqls.entity.zxw.equipment;
import com.xqls.service.zxw.blockService;
import com.xqls.service.zxw.equipmentService;
import com.xqls.service.zxw.operationlogService;

@Controller
@RequestMapping("/equip")
public class equipControl {
@Autowired
private equipmentService equipmentService;
@Autowired
private blockService blockService;

@RequestMapping("/dolist")
@ResponseBody
public DataTables dolist(int start,int length,HttpServletRequest request){
	String key = request.getParameter("key");
	System.out.println("获取到的值是："+key);
	DataTables dt = new DataTables();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("start", start);
	map.put("index", start+length);
	map.put("blockNum", key);
	List<Map> eqlist = equipmentService.selByPage(map);
	int records = equipmentService.selByCount(map);
	dt.setData(eqlist);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
@RequestMapping("/toadd")
public String toadd(HttpServletRequest request){
	List<String> eqlist = equipmentService.equiptype;
	request.setAttribute("eqlist", eqlist);
	return "block/toaddequip";
}
@RequestMapping("toedit")
public String toedit(Integer equipId,HttpServletRequest request){
	Map equipmap = equipmentService.selById(equipId);
	request.setAttribute("equipmap", equipmap);
	List<String> eqlist = equipmentService.equiptype;
	request.setAttribute("eqlist", eqlist);
	return "block/toeditequip";
}
@RequestMapping("/doadd")
@ResponseBody
public JsonResult doadd(equipment equipment){
	JsonResult js = new JsonResult();
	block block = blockService.selblockByNum(equipment.getBlockNum());
	equipment.setBlockId(block.getBlockId());
	int res = equipmentService.addequip(equipment);
	if(res>0){
		js.setTag(true);js.setMessage("添加成功");
	}else {
		js.setTag(false);js.setMessage("添加失败");
	}
	return js;
}
@RequestMapping("/doedit")
@ResponseBody
public JsonResult doedit(equipment equipment){
	JsonResult js = new JsonResult();
	block block = blockService.selblockByNum(equipment.getBlockNum());
	equipment.setBlockId(block.getBlockId());
	System.out.println(equipment);
	int res = equipmentService.updequip(equipment);
	if(res>0){
		js.setTag(true);js.setMessage("修改成功");
	}else {
		js.setTag(false);js.setMessage("修改失败");
	}
	return js;
}
@RequestMapping("/dodel")
@ResponseBody
public JsonResult dodel(Integer equipId){
	JsonResult js = new JsonResult();
	int res = equipmentService.delequip(equipId);
	System.out.println("删除的结果是："+res);
	if(res>0){
		js.setTag(true);
		js.setMessage("删除成功");
	}else {
		js.setTag(false);
		js.setMessage("删除失败");
	}
	return js;
}

@RequestMapping("/selbyblock")
@ResponseBody
//根据区块的编号查询设备，在联动查询时候使用
public List<equipment> selbyblock(String blockNum){ 
	List<equipment> elist = equipmentService.selByBlock(blockNum);  
	return elist;
}
}
