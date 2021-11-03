package com.yan.spring.factory.config;

import com.yan.spring.core.io.DefaultResourceLoader;
import com.yan.spring.core.io.ResourceLoader;
import com.yan.spring.context.support.BeanDefinitionRegistry;

/**
 * @author hairui
 * @date 2021/11/2
 * @des
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;


    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
