package com.yan.spring.factory.config;

import com.yan.spring.factory.PropertyValues;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class BeanDefinition {

    private Class bean;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class bean) {
        this.bean = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class bean, PropertyValues propertyValues) {
        this.bean = bean;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBean() {
        return bean;
    }

    public void setBean(Class bean) {
        this.bean = bean;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
