package com.yan.spring.factory.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws SpringBeanException {
        Object bean = null;
        try{
            bean = createBeanInstant(beanName,beanDefinition,args);
        }catch (Exception e){
            throw new SpringBeanException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected Object createBeanInstant(String beanName, BeanDefinition beanDefinition, Object[] args){
        Constructor constructorToUse = null;
        Class bean = beanDefinition.getBean();
        Constructor[] declaredConstructors = bean.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
