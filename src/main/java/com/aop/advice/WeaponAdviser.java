package com.aop.advice;

import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用注解方式添加AOP代理
 * 在配置文件里开启注解配置AOP
 * 和Spring-AOP只能同时开启一个
 */
@Component  //创建该类的实例，放到容器里
@Aspect
public class WeaponAdviser {
    /**
     * excution表达式用来定位切点的，提供了两个通配符：
     * *：代表任意返回数据类型，任意包，任意类，任意方法
     * ..:代表任意参数
     */
    @Pointcut(value = "execution(* com.aop.service.*.*(..))")
    public void pc() {

    }

    @Before("pc()")
    public void beforeAdvice() {
        System.out.println("我是加到方法前的功能");
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
    }

    @After("pc()")
    public void afterAdvice() {
        System.out.println("我是加到方法后的功能");
        //关闭连接
        MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
    }

    @Around("pc()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("我是环绕前置功能");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("我是环绕后置功能");
        //提交事务
        MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
    }

    @AfterReturning("pc()")
    public void returnAdvice() {
        System.out.println("我是加在方法返回时的功能");
    }

    @AfterThrowing("pc()")
    public void afterException() {
        System.out.println("我是加在方法出现异常时的功能");
        //回滚事务
        MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());
    }
}
