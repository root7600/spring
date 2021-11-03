package com.yan.spring.factory.config;

import com.yan.spring.core.io.Resource;
import com.yan.spring.core.io.ResourceLoader;
import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.context.support.BeanDefinitionRegistry;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws SpringBeanException;

    void loadBeanDefinitions(Resource... resources) throws SpringBeanException;

    void loadBeanDefinitions(String location) throws SpringBeanException;

    void loadBeanDefinitions(String... locations) throws SpringBeanException;
}
