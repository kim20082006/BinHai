package com.binhai.role.service;

import com.alibaba.fastjson.JSON;
import com.binhai.role.dao.RoleDao;

//完成业务功能
public class RoleService {

    RoleDao dao;
    public RoleService() {
        dao = new RoleDao();
    }

    public String selectAll() {
        //把list转化成json数据,json字符串
        String json = JSON.toJSONString(dao.selectAll());
        return json;
    }
}
