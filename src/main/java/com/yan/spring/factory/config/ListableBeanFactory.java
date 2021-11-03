package com.yan.spring.factory.config;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.BeanFactory;

import java.util.Map;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws SpringBeanException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws SpringBeanException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
