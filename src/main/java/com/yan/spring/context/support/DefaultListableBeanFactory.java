package com.yan.spring.context.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ConfigurableListableBeanFactory;
import com.yan.spring.factory.config.BeanDefinition;
import com.yan.spring.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null){
            throw new SpringBeanException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws SpringBeanException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws SpringBeanException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBean();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }


}
