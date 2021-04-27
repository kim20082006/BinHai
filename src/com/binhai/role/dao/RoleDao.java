package com.binhai.role.dao;

import com.alibaba.fastjson.JSON;
import com.binhai.db.DB;
import com.binhai.role.bean.RoleBean;
import com.binhai.user.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//完成角色数据库访问
public class RoleDao {

    public List selectAll(){
        List list = new ArrayList();

        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "select * from t_role";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                RoleBean roleBean = new RoleBean();

                roleBean.setName(resultSet.getString("name"));
                roleBean.setBeizhu(resultSet.getString("beizhu"));
                list.add(roleBean);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
