package com.binhai.user;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String op = request.getParameter("op");
        UserDao userDao = new UserDao();

        if("selectAll".equals(op)){//查询所有数据

                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(userDao.selectAll());

        }else if("add".equals(op)){//添加数据
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            String xingming = request.getParameter("xingming");
            String zhuanye = request.getParameter("zhuanye");
            String banji = request.getParameter("banji");
            String xingbie = request.getParameter("xingbie");
            UserBean userBean = new UserBean();
            userBean.setName(name);
            userBean.setPass(pass);
            userBean.setXingbie(xingbie);
            userBean.setXingming(xingming);
            userBean.setBanji(banji);
            userBean.setZhuanye(zhuanye);
            userDao.save(userBean);
        }else if("selectUser".equals(op)){
            String xingming = request.getParameter("xingming");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(userDao.selectUser(xingming));
        }else if("modify".equals(op)){//打开修改界面
            String id = request.getParameter("id");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(userDao.selectUserById(id));
        }else if("update".equals(op)){//修改数据库
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");
            String xingming = request.getParameter("xingming");
            String zhuanye = request.getParameter("zhuanye");
            String banji = request.getParameter("banji");
            String xingbie = request.getParameter("xingbie");
            UserBean userBean = new UserBean();
            userBean.setName(name);
            userBean.setPass(pass);
            userBean.setXingbie(xingbie);
            userBean.setXingming(xingming);
            userBean.setBanji(banji);
            userBean.setZhuanye(zhuanye);
            userBean.setId(Integer.parseInt(id));
            userDao.updateUser(userBean);

        }else if("deleteUser".equals(op)){
            String id = request.getParameter("id");
            userDao.deleteUser(id);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
