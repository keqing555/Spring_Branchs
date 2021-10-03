package com.aop.advice;

import com.aop.util.MyJdbcFactory;
import com.aop.util.MyTransactionManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 代理模式实现通知
 * 使用注解方式添加通知
 * 注解配置AOP和Spring-AOP只能同时开启一个
 * 本类是代理事务通知
 */
@Component  //创建该类的实例，放到容器里
@Aspect
public class WeaponAdviser {
    private int count=1;
    /**
     * excution表达式用来定位切点的，提供了两个通配符：
     * *：代表任意返回数据类型，任意包，任意类，任意方法
     * ..:代表任意参数
     */
    @Pointcut(value = "execution(void com.aop.service.*.*(..))")
    public void pc() {

    }

    @Before("pc()")
    public void beforeAdvice() {
        System.out.println(count++ +"我是加到方法前的功能");
        //开启事务
        MyTransactionManager.beginTransaction(MyJdbcFactory.getConnection());
    }

    @After("pc()")
    public void afterAdvice() {
        System.out.println(count++ +"我是加到方法后的功能");

    }

    @Around("pc()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(count++ +"我是环绕前置功能");
        joinPoint.proceed();
        System.out.println(count++ +"我是环绕后置功能");
        //提交事务
        MyTransactionManager.commitTransaction(MyJdbcFactory.getConnection());
    }

    @AfterReturning("pc()")
    public void returnAdvice() {
        System.out.println(count++ +"我是加在方法返回时的功能");
        //关闭连接
        //注意几种通知的加载顺序，在生命周期的最后（返回时）关闭连接
        MyJdbcFactory.closeConnection(MyJdbcFactory.getConnection());
    }

    @AfterThrowing("pc()")
    public void afterException() {
        System.out.println(count++ +"我是加在方法出现异常时的功能");
        //回滚事务
        MyTransactionManager.rollbackTransaction(MyJdbcFactory.getConnection());
    }
}
