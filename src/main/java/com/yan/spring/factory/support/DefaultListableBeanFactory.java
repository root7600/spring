package com.yan.spring.factory.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new SpringBeanException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
}
