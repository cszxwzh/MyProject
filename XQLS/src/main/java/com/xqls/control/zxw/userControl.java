package com.xqls.control.zxw;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xqls.entity.zxw.DataTables;
import com.xqls.entity.zxw.JsonResult;
import com.xqls.entity.zxw.SelectPerms;
import com.xqls.entity.zxw.TreeResult;
import com.xqls.entity.zxw.User;
import com.xqls.entity.zxw.block;
import com.xqls.entity.zxw.role;
import com.xqls.service.zxw.blockService;
import com.xqls.service.zxw.userService;


@Controller
@RequestMapping("/user")
public class userControl {
	@Autowired
	private userService userService;
	@Autowired
	private blockService blockService;
	
@RequestMapping("/login")
public String login(User user,HttpServletRequest request){
	Subject currentuser = SecurityUtils.getSubject();
	UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
	try {
		currentuser.login(token);
		return "redirect:success";
	} catch (AuthenticationException e) {
		e.printStackTrace();
		request.setAttribute("user", user);
		request.setAttribute("errormsg", "用户名或密码错误");
		return "redirect:tologin";
	}
}
@RequestMapping("/tologin")
public String tologin(){
	return "login/tologin";
}
@RequestMapping("/unauthor")
public String tounauthor(){
	return "login/unauthor";
}
@RequestMapping("/success")
public String tosuccess(){
	return "login/success";
}

/*以下为用户的增删改查的方法*/
@RequestMapping("/douserlist")
@ResponseBody
public DataTables douserlist(int start,int length,String username,String rolename,String blockname){
	DataTables dt = new DataTables();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("index", length+start);
	map.put("start", start);
	map.put("username", username);
	map.put("rolename", rolename);
	map.put("blockname", blockname);
	System.out.println("blockname:"+blockname+"***********************");
	List<Map> userList = userService.selUserByPage(map);
	int records = userService.selUserCount(map);
	dt.setData(userList);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
@RequestMapping("/touserlist")
public String touserlist(){
	return "user/douserlist";
}
@RequestMapping("/touseradd")
public String toadd(HttpServletRequest request){
	List<Map> rolelist= userService.selRoles();
	request.setAttribute("rolelist", rolelist);
	Map<Integer, String> warn = userService.warn;
	request.setAttribute("warn", warn);
	return "user/touseradd";
}
@RequestMapping("/douseradd")
@ResponseBody
public JsonResult doadd(User user){
	JsonResult js = new JsonResult();
	block block = blockService.selblockByNum(user.getBlocknum());
	user.setBlockid(block.getBlockId());
	User user1 = userService.selByName(user.getUsername());
	int res = 0;
	if(user1==null){
		res = userService.adduser(user);		
	}
	if(res>0){
		js.setTag(true);js.setMessage("用户添加成功！");
	}else if(res<0) {
		js.setTag(false);js.setMessage("用户添加失败");
	}else {
		js.setTag(false);js.setMessage("用户名已经存在！");
	}
	return js;
}
@RequestMapping("/douseredit")
@ResponseBody
public JsonResult doedit(User user){
	JsonResult js = new JsonResult();
	block block = blockService.selblockByNum(user.getBlocknum());
	user.setBlockid(block.getBlockId());
	int res = userService.updUser(user);
	if(res>0){
		js.setTag(true);js.setMessage("用户添加成功！");
	}else {
		js.setTag(false);js.setMessage("用户添加失败");
	}
	return js;
}

@RequestMapping("/touseredit")
public String toedit(int userid,HttpServletRequest request){
	List<Map> rolelist= userService.selRoles();
	request.setAttribute("rolelist", rolelist);
	Map user = userService.selUserById(userid);
	request.setAttribute("user", user);
	Map<Integer, String> warn = userService.warn;
	request.setAttribute("warn", warn);
	return "user/touseredit";
}
@RequestMapping("/douserdel")
@ResponseBody
public JsonResult dodel(int userid){
	JsonResult js = new JsonResult();
	int res = userService.delUser(userid);
	if(res>0){
		js.setTag(true);js.setMessage("用户删除成功！");
	}else {
		js.setTag(false);js.setMessage("用户删除失败！");
	}
	return js;
}
/*以下为角色的增删改查的方法*/
@RequestMapping("/torolelist")
public String torolelist(){
	return "user/dorolelist";
}
@RequestMapping("/dorolelist")
@ResponseBody
public DataTables dorolerlist(int start,int length,String rolename){
	DataTables dt = new DataTables();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("index", length+start);
	map.put("start", start);
	map.put("rolename", rolename);
	List<Map> userList = userService.selRoleByPage(map);
	int records = userService.selRoleCount(map);
	dt.setData(userList);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
//权限树的地址映射
@RequestMapping("/permstree")
public String permstree(int roleid,HttpServletRequest request){
	request.setAttribute("roleid", roleid);
	return "user/permstree";
}
@RequestMapping("/dopermstree")
@ResponseBody
public List<TreeResult> dopermstree(int roleid){
	List<TreeResult> treeResults = userService.selAllPerms(roleid);
	return treeResults;
}

//权限的授予
@RequestMapping("/changperms")
@ResponseBody
public JsonResult changeperms(@RequestBody String nodes,int rid) throws Exception{
	JsonResult js = new JsonResult();
	String ce = nodes.substring(1, nodes.length()-1);
	ObjectMapper mapper = new ObjectMapper();  
	mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, SelectPerms.class); 
	List<SelectPerms> lst =  (List<SelectPerms>)mapper.readValue(ce, javaType); 
	int res = userService.delPermsByRole(rid);
	if(res<0){
		js.setTag(false);js.setMessage("授权失败");
		return js;
	}
	for (SelectPerms selectPerms : lst) {
		userService.addRoleAndPerms(selectPerms);
	}
	js.setTag(true);js.setMessage("授权成功");
	return js;
}
//角色添加的地址映射
@RequestMapping("/toroleadd")
public String toroleadd(){
	return "user/toroleadd";
}
//角色的添加和权限的添加
@RequestMapping("/doaddroleandperms")
@ResponseBody
public JsonResult doaddroleandperms(@RequestBody String nodes,String rolename) throws JsonParseException, JsonMappingException, IOException{
	JsonResult js = new JsonResult();
	String ce = nodes.substring(1, nodes.length()-1);
	ObjectMapper mapper = new ObjectMapper();  
	mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, SelectPerms.class); 
	List<SelectPerms> lst =  (List<SelectPerms>)mapper.readValue(ce, javaType);
	role role = new role(0, rolename);
	int res = userService.addRoleAndPerms(role, lst);
	if (res>0) {
		js.setTag(true);js.setMessage("角色添加成功");
	}else {
		js.setTag(false);js.setMessage("角色添加失败");
	}
	return js;
}
}
