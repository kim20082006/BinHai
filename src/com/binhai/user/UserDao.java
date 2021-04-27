package com.binhai.user;

import com.alibaba.fastjson.JSON;
import com.binhai.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理访问数据库类
 * dao----database  access  object
 */
public class UserDao {

    /**
     * 登录
     * @param name
     * @param pass
     * @return成功返回true，失败返回false
     */
    public boolean login(String name,String pass){
         //要使用代码自动补全ctrl+alt+v
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql="select * from t_user where name='"+name+"' and pass='"+pass+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }

    /**
     * 查询所有用户，返回json字符串
     * @return
     */
    public String selectAll(){
        List list = new ArrayList();
        String json="";
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "select * from t_user";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setName(resultSet.getString("name"));
                userBean.setPass(resultSet.getString("pass"));
                userBean.setXingming(resultSet.getString("xingming"));
                userBean.setBanji(resultSet.getString("banji"));
                userBean.setZhuanye(resultSet.getString("zhuanye"));
                userBean.setXingbie(resultSet.getString("xingbie"));
                list.add(userBean);
            }

            //把list转化成json数据,json字符串
             json = JSON.toJSONString(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 保存用户信息到数据库
     * @param bean
     *
     */
    public void save(UserBean bean) {
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "insert into t_user  value(0,'" + bean.getName() + "','" + bean.getPass() + "','" + bean.getXingming() + "','" + bean.getBanji() + "','" + bean.getZhuanye() + "','" + bean.getXingbie() + "')";
            statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 条件查询
     * @param xingming
     * @return
     */
    public String selectUser(String xingming) {
        List list = new ArrayList();
        String json="";
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "select * from t_user where xingming like '%"+xingming+"%'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setName(resultSet.getString("name"));
                userBean.setPass(resultSet.getString("pass"));
                userBean.setXingming(resultSet.getString("xingming"));
                userBean.setBanji(resultSet.getString("banji"));
                userBean.setZhuanye(resultSet.getString("zhuanye"));
                userBean.setXingbie(resultSet.getString("xingbie"));
                list.add(userBean);
            }
            //把list转化成json数据,json字符串
            json = JSON.toJSONString(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 根据用户id查询用户详细信息
     * @param id
     * @return
     */
    public String  selectUserById(String id) {
        String json="";
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "select * from t_user where id="+id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                UserBean userBean = new UserBean();
                userBean.setId(resultSet.getInt("id"));
                userBean.setName(resultSet.getString("name"));
                userBean.setPass(resultSet.getString("pass"));
                userBean.setXingming(resultSet.getString("xingming"));
                userBean.setBanji(resultSet.getString("banji"));
                userBean.setZhuanye(resultSet.getString("zhuanye"));
                userBean.setXingbie(resultSet.getString("xingbie"));
                json = JSON.toJSONString(userBean);
            }
            //把list转化成json数据,json字符串

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 修改用户信息
     * @param userBean
     */
    public void updateUser(UserBean userBean) {
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "update t_user set name='"+userBean.getName()+"'," +
                    " pass='"+userBean.getPass()+"'," +
                    " xingming='"+userBean.getXingming()+"'," +
                    " banji='"+userBean.getBanji()+"'," +
                    " zhuanye='"+userBean.getZhuanye()+"'," +
                    " xingbie='"+userBean.getXingbie()+"' " +
                    " where id="+userBean.getId();
            statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(String id) {
        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "delete from t_user where id="+id;
            statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
