package com.yan.spring.factory;

import com.yan.spring.context.ApplicationContext;
import com.yan.spring.exception.SpringBeanException;

/**
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware{

    void setApplicationContext(ApplicationContext applicationContext) throws SpringBeanException;
}
