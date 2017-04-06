package com.clsteach.contorl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clsteach.entity.DataTables;
import com.clsteach.entity.JsonResult;
import com.clsteach.entity.loginuser;
import com.clsteach.entity.teach;
import com.clsteach.service.LoginuserService;

@Controller
@RequestMapping("/jsp/loginuser")
public class loginuserControl {
@Autowired
private LoginuserService logservice;

@RequestMapping("/login")
public String login(){
	return "jsp/loginuser/login";
}
@RequestMapping("/logout")
public String loginout(HttpServletRequest request){
	HttpSession session = request.getSession();
	session.removeAttribute("log");
	return "jsp/loginuser/login";
}
@RequestMapping("/dologin")
@ResponseBody
public JsonResult checklogin(loginuser loginuser,HttpServletRequest request){
	JsonResult js = new JsonResult();
	loginuser loginuser2 = logservice.checkloginuser(loginuser);
	if(loginuser2!=null){
		js.setTag(true);
		js.setMessage("登录成功！");
		HttpSession session = request.getSession();
		loginuser login = new loginuser();
		login.setLogName(loginuser2.getLogName());
		login.setLogPsw(loginuser2.getLogPsw());
		login.setLogType(loginuser2.getLogType());
		session.setAttribute("log", login);
	}else {
		js.setTag(false);
		js.setMessage("登录失败！");
	}
	return js;
}
@RequestMapping("/tosignin")
public String tosigin(){
	return "jsp/loginuser/signin";
}
@RequestMapping("/dosignin")
@ResponseBody
public JsonResult dosigin(loginuser loginuser){
	JsonResult js = new JsonResult();
	int res = logservice.addloginuser(loginuser);
	if(res>0){
		js.setTag(true);
		js.setMessage("注册成功！");
	}else if(res==0) {
		js.setTag(false);
		js.setMessage("注册失败！");
	}else {
		js.setTag(false);
		js.setMessage("用户名已经被使用！");
	}
	return js;
}
@RequestMapping("/userinfo")
public String doseluser(String logName,HttpServletRequest request){
	loginuser loginuser = logservice.selBylogName(logName);
	request.setAttribute("loginuser", loginuser);
	return "jsp/loginuser/usershow";
}
@RequestMapping("/userup/{logId}")
public String touserup(@PathVariable int logId,HttpServletRequest request){
	System.out.println("获取到的id为："+logId);
	loginuser loginuser = logservice.selById(logId);
	request.setAttribute("loginuser", loginuser);
	return "jsp/loginuser/userup";
}
@RequestMapping("/userlist")
@ResponseBody
public DataTables userlist(int start,int length,String key1){
	DataTables dt = new DataTables();
	List<loginuser> llist = logservice.selByPage(start, length, key1);
	int records = logservice.selCounts(key1);
	dt.setData(llist);
	dt.setRecordsFiltered(records);
	dt.setRecordsTotal(records);
	return dt;
}
@RequestMapping("/userdis")
public String userdisplay(){
	return "jsp/loginuser/userlist";
}

@RequestMapping("toedit")
public String toedituser(int logId,HttpServletRequest request){
	loginuser loginuser = logservice.selById(logId);
	request.setAttribute("loginuser", loginuser);
	return "jsp/loginuser/userupdate";
}

@RequestMapping("doedit")
@ResponseBody
public JsonResult doedituser(loginuser loginuser,HttpServletRequest request){
	JsonResult js = new JsonResult();
	System.out.println(loginuser.getLogId()+loginuser.getLogName());
	int res = logservice.update(loginuser);
	if(res>0){
		js.setTag(true);
		js.setMessage("用户信息更新成功！");
	}else {
		js.setTag(false);
		js.setMessage("用户信息更新失败！");
	}
	return js;
}

@RequestMapping("toadd")
public String toadduser(){
	return "jsp/loginuser/useradd";
}
@RequestMapping("doadd")
@ResponseBody
public JsonResult doadduser(loginuser loginuser){
	JsonResult js = new JsonResult();
	int res = logservice.addloginuser(loginuser);
	if(res>0){
		js.setTag(true);
		js.setMessage("用户信息添加成功！");
	}else {
		js.setTag(false);
		js.setMessage("用户信息添加失败！");
	}
	return js;
}
@RequestMapping("/dodel")
@ResponseBody
public JsonResult dodeluser(int logId){
	System.out.println("logid is "+logId);
	JsonResult js = new JsonResult();
	int res = logservice.delloginuser(logId);
	if(res>0){
		js.setTag(true);
		js.setMessage("用户信息删除成功！");
	}else {
		js.setTag(false);
		js.setMessage("用户信息删除失败！");
	}
	return js;
}
}
