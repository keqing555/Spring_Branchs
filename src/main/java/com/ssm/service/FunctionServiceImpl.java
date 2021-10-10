package com.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssm.bean.Efunction;
import com.ssm.dao.EfunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private EfunctionMapper efunctionMapper;

    @Override
    public List<Efunction> findFunctionByEid(long eid) {
        List<Efunction> funList = efunctionMapper.findFunctionByEid(eid);
        return funList;
    }

    @Override
    public JSONArray transfer(List<Efunction> funList) {

        JSONArray jsonArray = new JSONArray();
        //获取当前用户的一级功能
        for (Efunction fun : funList) {
            if (fun.getParentid() == 0) {
                JSONObject jsonObject_1 = new JSONObject();
                jsonObject_1.put("id", fun.getFid());
                jsonObject_1.put("test", fun.getFname());
                //获取一级功能下的二级功能
                JSONArray children = new JSONArray();
                for (Efunction child : funList) {
                    if (child.getParentid() == fun.getFid()) {
                        JSONObject jsonObject_2 = new JSONObject();
                        jsonObject_2.put("id", child.getFid());
                        jsonObject_2.put("text", child.getFname());
                        jsonObject_2.put("url", child.getUrl());
                        children.add(jsonObject_2);
                    }
                    jsonObject_1.put("children", children);
                    jsonArray.add(jsonObject_1);
                }
            }
        }
        return jsonArray;
    }


}
