package com.clsteach.listener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.clsteach.utils.*;
//在线登录人数统计 是登录的人数
public class LoginListener2 implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		ServletContext servletContext = event.getSession().getServletContext();
		System.out.println("新用户登录了"+event.getValue());
		Object logincount = servletContext.getAttribute("logincount");
		if(logincount==null){
			servletContext.setAttribute("logincount", 1);
		}else {
			servletContext.setAttribute("logincount", Integer.valueOf(logincount.toString())+1);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println("新用户退出登录了"+event.getValue());
		ServletContext servletContext = event.getSession().getServletContext();
		Object logincount = servletContext.getAttribute("count");
		if(logincount!=null){
			servletContext.setAttribute("logincount", Integer.valueOf(logincount.toString())-1);
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
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

