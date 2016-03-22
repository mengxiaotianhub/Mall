package com.mengxiaotian.learn.mall.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
 
             // 执行过滤  
             // 从session中获取登录者实体  
             Object obj1 = request.getSession().getAttribute("userName");  
             Object obj2 = request.getSession().getAttribute("userName");  
             if (obj1 == null & obj2 ==null) {  
                 // 如果session中不存在登录者实体，则弹出框提示重新登录  
                 PrintWriter out = response.getWriter();  
                 String loginPage = "/mall/index.html";  
                 StringBuilder builder = new StringBuilder();  
                 builder.append("<script type=\"text/javascript\">");  
                 builder.append("alert('please login again.');");  
                 builder.append("window.top.location.href='");  
                 builder.append(loginPage);  
                 builder.append("';");  
                 builder.append("</script>");  
                 out.print(builder.toString());  
             } else {  
                 // 如果session中存在登录者实体，则继续  
                 filterChain.doFilter(request, response);  
             }  
         } 

}
