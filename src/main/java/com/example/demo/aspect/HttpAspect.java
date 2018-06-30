package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用APO处理请求:面向切面编程
 */
@Aspect
@Component
public class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //拦截一个请求 Before 注解 是在方法执行之前开始走
    @Before("execution(public * com.example.demo.db.DBUserControl.getAllUser(..))")
    public void log() {
        logger.info("HttpAspect Aspect Component log 11111");
    }

    //拦截一个Controll Before 所有请求  Before 注解 是在方法执行之前开始走
    @Before("execution(public * com.example.demo.db.DBUserControl.*(..))")
    public void interceptLog() {
        logger.info("HttpAspect Aspect Component interceptLog 2222");
    }

    //拦截一个Controll After After注解 是在方法走之后再走的方法    Before 注解 是在方法执行之前开始走
    @After("execution(public * com.example.demo.db.DBUserControl.*(..))")
    public void doAfter() {
        logger.info("HttpAspect Aspect Component doAfter 3333");
    }


    /**
     * 利用 @pointcut 注解进行 拦截的注解 start ------------------------
     */
    //拦截一个请求 Before 注解 是在方法执行之前开始走
    @Pointcut("execution(public * com.example.demo.db.DBUserControl.*(..))")
    public void log2() {

    }

    /**
     * 监听请求的数据
     */
    @Before("log2()")
    public void doBefore(JoinPoint joinPoint) {

        logger.info("HttpAspect Aspect @Pointcut Component doBefore 444");

        /**
         * 获取Http请求的内容 include:URL  IP Method 请求的哪个类 哪个类中的哪个方法 传的是什么参数
         */
        //URl
        //method Post get delete
        //ip
        //类方法 请求的哪个类的方法
        //参数 请求的参数
        //1.获取Request的URL
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("Request url = {}", request.getRequestURL());

        //2.获取Request的 方式 是Get Post  delete path
        logger.info("Request method = {}", request.getMethod());

        //3.获取Request的IP  是 Ip地址
        logger.info("Request ip = {}", request.getRemoteAddr());

        //4.请求的获取到类名 + 类方法
        logger.info("Request class_method  = {}", joinPoint.getSignature().getDeclaringTypeName() + " 方法：" + joinPoint.getSignature().getName());

        //5.请求的方法中的请求 参数
        logger.info("Request args = " + joinPoint.getArgs().toString());

    }

    @After("log2()")
    public void doAfter2() {
        logger.info("HttpAspect Aspect @Pointcut Component doAfter2 5555");
    }


    /**
     * 监听返回的数据
     */
    @AfterReturning(returning = "object", pointcut = "log2()")
    public void doAfterReturning(Object object) {
        logger.info("Request response = {}", object.toString());

    }

    // --------------------- 利用 @pointcut 注解进行 拦截的注解 end ------------------------

}
