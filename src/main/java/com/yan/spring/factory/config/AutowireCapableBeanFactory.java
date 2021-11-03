package com.yan.spring.factory.config;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.BeanFactory;

public interface AutowireCapableBeanFactory  extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws SpringBeanException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws SpringBeanException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws SpringBeanException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws SpringBeanException;

}
