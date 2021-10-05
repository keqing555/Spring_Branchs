package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理请求的控制层代码
 */
@Controller
@RequestMapping("example")
public class ExampleController {
    @RequestMapping("test_1")
    public String test_1() {
        System.out.println("处理请求1");
        return "success";
    }
}
