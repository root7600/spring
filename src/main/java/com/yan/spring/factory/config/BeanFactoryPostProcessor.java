package com.yan.spring.factory.config;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws SpringBeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws SpringBeanException;
}
