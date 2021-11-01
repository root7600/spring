package com.yan.spring.factory.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBean();
        try {
            if (null != ctor) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new SpringBeanException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
