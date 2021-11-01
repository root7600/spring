package com.yan.spring.factory.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.BeanDefinition;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws SpringBeanException {
        Object bean = null;
        try{
            bean = beanDefinition.getBean().newInstance();
        }catch (Exception e){
            throw new SpringBeanException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }
}
