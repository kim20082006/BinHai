package com.binhai.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//过滤器相关的设置
@WebFilter(filterName = "LoginFilter",urlPatterns = {"/main.jsp","/user/*","/role/*"})
public class LoginFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {

        HttpServletRequest request = (HttpServletRequest)req;
        final HttpServletResponse response = (HttpServletResponse)resp;
        String loginname = (String) request.getSession().getAttribute("yonghu");

        try {
            if(loginname == null){
                String tishi = "登录用户信息失效！";
                response.setContentType("text/html;charset=UTF-8");
                String url = "'"+request.getContextPath()+"/login.jsp'";
                PrintWriter writer = response.getWriter();
                writer.write("<script>");
                writer.write("alert('" + tishi + "');");
                writer.write("top.document.location.href='login.jsp'");
                writer.write("</script>");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            chain.doFilter(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
