<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取用户名
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    if(name.equals("admin")&& pass.equals("1")){
        //把当前用户放在session里存储
        session.setAttribute("yonghu", name);
        //登录成功，进入主界面
       request.getRequestDispatcher("main.jsp").forward(request, response);
    }else{
       //登录失败，进入login界面
       //        request.getRequestDispatcher("login.jsp").forward(request, response);
        response.sendRedirect("login.jsp");
    }

%>