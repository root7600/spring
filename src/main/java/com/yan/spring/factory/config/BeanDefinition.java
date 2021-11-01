package com.yan.spring.factory.config;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class BeanDefinition {

    private Class bean;


    public BeanDefinition(Class bean) {
        this.bean = bean;
    }

    public Class getBean() {
        return bean;
    }

    public void setBean(Class bean) {
        this.bean = bean;
    }
}
