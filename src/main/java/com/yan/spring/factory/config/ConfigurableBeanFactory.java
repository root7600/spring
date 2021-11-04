package com.yan.spring.factory.config;

import com.yan.spring.factory.HierarchicalBeanFactory;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    void destroySingletons();
}
