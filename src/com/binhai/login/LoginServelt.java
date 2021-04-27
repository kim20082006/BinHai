package com.binhai.login;

import com.binhai.user.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户名
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        //访问数据库验证用户是否有效
        UserDao userDao = new UserDao();

        if(userDao.login(name, pass)){
            //获取当前会话
           HttpSession session = request.getSession();
            //把当前用户放在session里存储
            session.setAttribute("yonghu", name);
            //登录成功，进入主界面
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }else{
            //登录失败，进入login界面
            //        request.getRequestDispatcher("login.jsp").forward(request, response);
            response.sendRedirect("login.jsp");
        }

    }
}
