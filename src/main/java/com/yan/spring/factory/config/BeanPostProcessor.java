package com.yan.spring.factory.config;

import com.yan.spring.exception.SpringBeanException;

public interface BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws SpringBeanException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws SpringBeanException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws SpringBeanException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws SpringBeanException;
}
