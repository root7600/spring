package com.yan.spring.context.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hairui
 * @date 2021/11/5
 * @des FactoryBeanRegistrySupport
 * 类主要处理的就是关于 FactoryBean 此类对象的注册操作，之所以放到这样一个单独的类里，
 * 就是希望做到不同领域模块下只负责各自需要完成的功能，避免因为扩展导致类膨胀到难以维护。
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{

    /**
     * Cache of singleton objects created by FactoryBeans: FactoryBean name --> object
     */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    // 一级缓存，普通对象
    private final Map<String, Object> singletonFactories = new ConcurrentHashMap<String, Object>();

    // 二级缓存，提前暴漏对象，没有完全实例化的对象
    private final Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<String, Object>();

    // 三级缓存，存放代理对象
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new SpringBeanException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }


}
