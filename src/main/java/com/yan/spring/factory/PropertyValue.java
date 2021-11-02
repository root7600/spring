package com.yan.spring.factory;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class PropertyValue {

    private  String name;

    private Object value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
