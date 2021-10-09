package com.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.ssm.bean.Efunction;
import com.ssm.bean.Employee;
import com.ssm.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public JSONArray currentFunctions(HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        List<Efunction> funList = functionService.findFunctionByEid(employee.getEid());
        JSONArray jsonArray = functionService.transfer(funList);
        return jsonArray;
    }
}
