package com.yan.spring.factory;

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
}
