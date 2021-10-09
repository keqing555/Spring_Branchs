package com.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.ssm.bean.Efunction;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface FunctionService {
    //获取当前用户的功能
    List<Efunction> findFunctionByEid(long eid);

    //把当前用户功能转为前端指定的json格式
    JSONArray transfer(List<Efunction> funList);
}
