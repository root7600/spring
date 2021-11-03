package com.yan.spring.context.support;

import com.yan.spring.context.AbstractXmlApplicationContext;
import com.yan.spring.exception.SpringBeanException;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws SpringBeanException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws SpringBeanException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws SpringBeanException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws SpringBeanException {
        this.configLocations = configLocations;
        refresh();
    }
    
    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
