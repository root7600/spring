package com.yan.spring.factory.config;

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
