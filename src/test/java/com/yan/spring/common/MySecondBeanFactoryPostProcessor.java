package com.yan.spring.common;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ConfigurableListableBeanFactory;
import com.yan.spring.factory.config.BeanFactoryPostProcessor;

import java.util.Map;

/**
 * @author hairui
 * @date 2021/11/4
 * @des
 */
public class MySecondBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws SpringBeanException {
        Map<String, BeanFactoryPostProcessor> beansOfType = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        System.out.println(beansOfType);
    }
}
