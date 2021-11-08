package com.yan.spring.aop.adapter;

import com.yan.spring.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author hairui
 * @date 2021/11/8
 * @des
 * MethodBeforeAdviceInterceptor 实现了 MethodInterceptor 接口，
 * 在 invoke 方法中调用 advice 中的 before 方法，传入对应的参数信息。
 * 而这个 advice.before 则是用于自己实现 MethodBeforeAdvice 接口后做的相应处理。
 * 其实可以看到具体的 MethodInterceptor 实现类，其实和我们之前做的测试是一样的，只不过现在交给了 Spring 来处理
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice advice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice advice) {
        this.advice = advice;
    }

    public MethodBeforeAdviceInterceptor() {
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        this.advice.before(invocation.getMethod(), invocation.getArguments(), invocation.getThis());
        return invocation.proceed();
    }
}
