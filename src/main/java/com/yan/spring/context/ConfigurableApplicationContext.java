package com.yan.spring.context;

import com.yan.spring.exception.SpringBeanException;

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     *
     * @throws SpringBeanException
     */
    void refresh() throws SpringBeanException;

    void registerShutdownHook();

    void close();

}
