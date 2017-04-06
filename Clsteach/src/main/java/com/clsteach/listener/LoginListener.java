package com.clsteach.listener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.clsteach.utils.*;
//在线人数统计 访问页面的人员人数 不是登录的人数
public class LoginListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		System.out.println("session创建了");
		Object count = servletContext.getAttribute("count");
		if(count==null){
			servletContext.setAttribute("count", 1);
		}else {
			servletContext.setAttribute("count", Integer.valueOf(count.toString())+1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁了");
		ServletContext servletContext = se.getSession().getServletContext();
		Object count = servletContext.getAttribute("count");
		if(count!=null){
			servletContext.setAttribute("count", Integer.valueOf(count.toString())-1);
		}
	}
	
	
	/*Timer timer=null;
	TimerTask task = null;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		timer = new Timer();
		task = new MyTask();
		timer.schedule(task, 0, 10000l);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		System.out.println("定时任务已经取消~~~~~");
	}*/

}
class MyTask extends TimerTask{
	@Override
	public void run() {
		
		System.out.println(DateFromate.datetostringmm(new Date())+"执行了监听~~~");
	}
}
