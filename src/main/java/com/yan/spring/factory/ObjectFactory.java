package com.yan.spring.factory;

import com.yan.spring.exception.SpringBeanException;

public interface ObjectFactory<T> {

    T getObject() throws SpringBeanException;
}
