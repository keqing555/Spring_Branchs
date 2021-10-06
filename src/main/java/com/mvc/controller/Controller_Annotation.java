package com.mvc.controller;

import com.mvc.bean.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注解传参方式
 */
@Controller
@RequestMapping("annotation")
//注解在类上，作用是将请求域中的参数放到session域，共享参数
@SessionAttributes(value = {"model", "modelAndView"})
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

    //注入CookieValue
    //ModelAttribute修饰在参数上
    @RequestMapping("cookie")
    public String cookie(@CookieValue("JSESSIONID") String cookie, @ModelAttribute("publicParam") String publicParam) {
        System.out.println("JSESSIONID:" + cookie);
        System.out.println("获取到的公共参数是：" + publicParam);
        return "success";
    }

    //ModelAttribute修饰在方法上
    //在方法参数上修饰@ModelAttribute，在运行时会先运行这个方法
    @ModelAttribute("publicParam")
    public String modelAttribute() {
        //获取公共参数
        return "刻晴别刮了";
    }

    //在请求域存放数据
    @RequestMapping("session")
    public ModelAndView session(ModelAndView modelAndView) {
        modelAndView.addObject("model", "匣里龙吟");
        modelAndView.addObject("modelMap", "绿剑");
        modelAndView.addObject("modelAndView", "黑剑");
        return modelAndView;
    }
}