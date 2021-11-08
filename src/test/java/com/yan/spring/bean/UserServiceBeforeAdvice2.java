package com.yan.spring.bean;

import com.yan.spring.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author hairui
 * @date 2021/11/8
 * @des
 * 与上一章节的拦截方法相比，我们不在是实现 MethodInterceptor 接口，而是实现 MethodBeforeAdvice 环绕拦截。
 * 在这个方法中我们可以获取到方法的一些信息，如果还开发了它的 MethodAfterAdvice 则可以两个接口一起实现。
 */
public class UserServiceBeforeAdvice2 implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());

    }
}
