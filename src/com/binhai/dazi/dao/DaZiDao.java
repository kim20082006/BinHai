package com.binhai.dazi.dao;

import com.alibaba.fastjson.JSON;
import com.binhai.dazi.bean.DaziBean;
import com.binhai.db.DB;
import com.binhai.user.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaZiDao {
    public static String selectAll(){
        List list = new ArrayList();

        try {
            Connection connetion = DB.getConnetion();
            Statement statement = connetion.createStatement();
            String sql = "select * from t_dazi";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                DaziBean bean = new DaziBean();
                bean.setId(resultSet.getInt("id"));
                bean.setName(resultSet.getString("name"));
                bean.setBanji(resultSet.getString("banji"));
                bean.setIfpass(resultSet.getString("ifpass"));
                list.add(bean);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        //把list转化成json数据,json字符串
        String json = JSON.toJSONString(list);
        return json;
    }
}
