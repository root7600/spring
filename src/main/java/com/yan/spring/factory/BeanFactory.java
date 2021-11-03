package com.yan.spring.factory;

import com.yan.spring.exception.SpringBeanException;

/**
 * @author hairui
 * @date 2021/11/1
 * @des bean 工厂
 */
public interface BeanFactory {

    /**
     * 获取对象
     * @param name
     * @return
     */
     Object getBean(String name);

    /**
     *
     * @param name
     * @param args
     * @return
     * @throws SpringBeanException
     */
    Object getBean(String name, Object... args) throws SpringBeanException;

    /**
     * 获取对象
     * @param name
     * @return
     */
    <T> T getBean(String name,Class<T> classType);
}
