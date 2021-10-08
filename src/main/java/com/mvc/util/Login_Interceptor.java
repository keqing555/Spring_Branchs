package com.mvc.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * 拦截器会加到控制层方法执行前
 */
public class Login_Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String logged = (String) session.getAttribute("logged");
        System.out.println("logged:" + logged);
        if (logged != null && logged != "") {
            System.out.println("已登陆");
            return true;
        } else {
            System.out.println("未登陆");
            response.sendRedirect("/login.jsp");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("控制层方法返回时拦截器1");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("控制层方法执行结束，响应后拦截器1");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
