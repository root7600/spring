package com.yan.spring.factory.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.BeanFactory;
import com.yan.spring.factory.config.BeanDefinition;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        Object bean = this.getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws SpringBeanException;

}
