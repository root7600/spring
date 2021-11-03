package com.yan.spring.factory;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.AutowireCapableBeanFactory;
import com.yan.spring.factory.config.BeanDefinition;
import com.yan.spring.factory.config.BeanPostProcessor;
import com.yan.spring.factory.config.ConfigurableBeanFactory;
import com.yan.spring.factory.config.ListableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException;

    void preInstantiateSingletons() throws SpringBeanException;

    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
