package com.clsteach.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

import com.clsteach.entity.loginuser;


public class LoginFilter implements Filter {
/*
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 不过滤的uri  
        String[] notFilter = new String[] { "login", "index.html" };  
  
        // 请求的uri  
        String uri = request.getRequestURI();  
  
        // uri中包含background时才进行过滤  
        if (uri.indexOf("jsp") != -1) {  
            // 是否过滤  
            boolean doFilter = true;  
            for (String s : notFilter) {  
                if (uri.indexOf(s) != -1) {  
                    // 如果uri中包含不过滤的uri，则不进行过滤  
                    doFilter = false;  
                    break;  
                }  
            }  
            if (doFilter) {  
                // 执行过滤  
                // 从session中获取登录者实体  
                Object obj = request.getSession().getAttribute("logName");  
                if (null == obj) {  
                    // 如果session中不存在登录者实体，则弹出框提示重新登录  
                    // 设置request和response的字符集，防止乱码  
                    request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");  
                    PrintWriter out = response.getWriter();  
                    String loginPage = "/Clsteach/jsp/loginuser/login";  
                    StringBuilder builder = new StringBuilder();  
                    builder.append("<script type=\"text/javascript\">");  
                    builder.append("alert('当前页面需要登录后才能访问，请登录！');");  
                    builder.append("window.location.href='");  
                    builder.append(loginPage);  
                    builder.append("';");  
                    builder.append("</script>");  
                    out.print(builder.toString());  
                } else {  
                    // 如果session中存在登录者实体，则继续  
                    filterChain.doFilter(request, response);  
                }  
            } else {  
                // 如果不执行过滤，则继续  
                filterChain.doFilter(request, response);  
            }  
        } else {  
            // 如果uri中不包含background，则继续  
            filterChain.doFilter(request, response);  
        }  
    }  */
	

	@Override
	public void destroy() {
		System.out.println("filter销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain arg2) throws IOException, ServletException {
		System.out.println("filter运行了！");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		loginuser loginuser = (loginuser)session.getAttribute("log");
		if (loginuser!=null) {
			System.out.println("filter进行了页面跳转！");
			arg2.doFilter(request, response);
		}else {			
			System.out.println("filter阻止了页面跳转！");
			response.sendRedirect(request.getContextPath()+"/jsp/loginuser/login");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter初始化");
	}

/*	@Override
	protected void doFilterInternal(HttpServletRequest arg0,
			HttpServletResponse arg1, FilterChain arg2)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}*/

}
