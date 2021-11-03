package com.yan.spring.common;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ConfigurableListableBeanFactory;
import com.yan.spring.factory.PropertyValue;
import com.yan.spring.factory.PropertyValues;
import com.yan.spring.factory.config.BeanDefinition;
import com.yan.spring.factory.config.BeanFactoryPostProcessor;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws SpringBeanException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
