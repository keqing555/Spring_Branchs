package com.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.ssm.bean.Efunction;
import com.ssm.bean.Employee;
import com.ssm.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("function")
public class FunctionController {
    @Autowired
    private FunctionService functionService;

    /**
     * 获取当前用户功能
     */
    @RequestMapping("currentFunctions")
    @ResponseBody
    public JSONArray currentFunctions(HttpSession session) {
        //获取当前用户
        Employee employee = (Employee) session.getAttribute("employee");
        //获取当前用户功能
        List<Efunction> funList = functionService.findFunctionByEid(employee.getEid());
        //把功能转为前端指定的json格式
        JSONArray jsonArray = functionService.transfer(funList);
        return jsonArray;
    }

    /**
     * 根据分页条件获取功能
     */
    @RequestMapping("findFunctionsByCondition")
    @ResponseBody
    public List<Efunction> findFunctionsByCondition(Efunction function) {
        return functionService.findFunctionsByCondition(function);
    }
}
