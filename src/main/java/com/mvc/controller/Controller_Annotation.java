package com.mvc.controller;

import com.mvc.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 注解传参方式
 */
@Controller
@RequestMapping("annotation")
public class Controller_Annotation {
    //用注解传参数
    @RequestMapping("ann")
    public String ann(@RequestParam(name = "rname", required = true, defaultValue = "刻晴") String name) {
        //传给name接受不到，要传给rname
        System.out.println(name);
        return "success";
    }

    //用注解获取请求头
    @RequestMapping("ann2")
    public String ann2(@RequestHeader("Host") String host, @RequestHeader("Referer") String referer) {
        System.out.println(host);
        System.out.println(referer);
        return "success";
    }

    //注解获取请求体
    @RequestMapping("ann3")
    public String ann3(@RequestBody String data) {
        System.out.println(data);
        return "success";
    }

    //@RequestBody不适用与get请求方式，通常用json格式数据绑定到bean对象中
    @RequestMapping("ann4")
    public String ann4(@RequestBody Role role) {
        System.out.println(role);
        return "success";
    }

}