package com.yan.spring.context;

import com.yan.spring.context.support.DefaultListableBeanFactory;
import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ConfigurableListableBeanFactory;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws SpringBeanException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
