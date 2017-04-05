package com.xqls.control.zxw;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xqls.entity.zxw.JsonResult;
import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.block;
import com.xqls.service.zxw.blockService;

@Controller
@RequestMapping("/block")
public class blockControl {

@Autowired
private blockService blockService;

@RequestMapping("/dolist")
public String dolist(HttpServletRequest request) {
	List<block> blist = blockService.selAll();
	request.setAttribute("blist", blist);
	return "block/doblocklist";
}
@RequestMapping("/treeresult")
@ResponseBody
public List<TreeResult> treeResult(){
	List<TreeResult> blist = blockService.selTree();
	return blockService.selTree();
}
@RequestMapping("/dodel")
@ResponseBody
public JsonResult dodel(String blockNum){
	JsonResult js = new JsonResult();
	block block = blockService.selblockByNum(blockNum);
	int res = 0;
	if(block!=null){
	res = blockService.delblockByNum(blockNum);
	}else {
		res=1;
	}
	if(res>0){
		js.setTag(true);js.setMessage("删除成功！");
	}else {
		js.setTag(false);js.setMessage("删除失败！");
	}
	return js;
}
@RequestMapping("/doupd")
@ResponseBody
public JsonResult doupd(String blockNum,String blockName){
	JsonResult js = new JsonResult();
	block block =new block();
	block.setBlockNum(blockNum);
	block.setBlockName(blockName);
	block oBlock = blockService.selblockByNumAndName(block);
	System.out.println("oblock的值是"+oBlock);
	int res = 0;
	if(oBlock==null){
		res = blockService.updblockByNum(block);		
	}else {
		res = 1;
	}
	if(res>0){
		js.setTag(true);js.setMessage("更新成功！");
	}else {
		js.setTag(false);js.setMessage("更新失败！");
	}
	return js;
}
@RequestMapping("/doadd")
@ResponseBody
public JsonResult doadd(String blockNum,String blockName){
	JsonResult js = new JsonResult();
	block block =new block();
	block.setBlockNum(blockNum);
	block.setBlockName(blockName);
	String firstnum = blockService.selsamenum(blockNum)+1+"";
	for (int i = firstnum.length(); i < 4; i++) {
		firstnum = "0"+ firstnum;
	}
	System.out.println("区块编码是："+blockNum+firstnum);
	blockNum = blockNum+firstnum;
	block.setBlockNum(blockNum);
	int res = blockService.addblock(block);
	if(res>0){
		js.setTag(true);js.setMessage("更新成功！");js.setData(block);
	}else {
		js.setTag(false);js.setMessage("更新失败！");
	}
	return js;
}
@RequestMapping("/showtoadd")
public String showtoadd(){
	return "block/toaddequip";
}
}
