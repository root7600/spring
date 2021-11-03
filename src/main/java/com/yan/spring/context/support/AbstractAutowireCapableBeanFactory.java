package com.yan.spring.context.support;

import cn.hutool.core.bean.BeanUtil;
import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.PropertyValue;
import com.yan.spring.factory.PropertyValues;
import com.yan.spring.factory.config.AutowireCapableBeanFactory;
import com.yan.spring.factory.config.BeanDefinition;
import com.yan.spring.factory.config.BeanPostProcessor;
import com.yan.spring.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws SpringBeanException {
        Object bean = null;
        try{
            bean = createBeanInstant(beanName,beanDefinition,args);
            //填充属性
            this.applyPropertyValues(beanName,bean,beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            initializeBean(beanName,bean,beanDefinition);
        }catch (Exception e){
            throw new SpringBeanException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws SpringBeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (null == current){
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws SpringBeanException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (null == current) {
                return result;
            }
            result = current;
        }
        return result;
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

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

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new SpringBeanException("Error setting property values：" + beanName);
        }
    }
}
