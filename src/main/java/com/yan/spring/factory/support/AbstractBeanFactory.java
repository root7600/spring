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
        return doGetBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws SpringBeanException {
       return doGetBean(name,args);
    }

    protected <T> T doGetBean(String name, Object... args){
        Object bean = this.getSingleton(name);
        if (bean != null) {
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> classType) {
        return (T)doGetBean(name);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws SpringBeanException;

}
