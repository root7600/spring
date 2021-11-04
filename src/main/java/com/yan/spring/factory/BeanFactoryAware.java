package com.yan.spring.factory;

import com.yan.spring.exception.SpringBeanException;

/**
 * @author hairui
 * @date 2021/11/4
 * @des
 * interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 * 实现此接口，既能感知到所属的 BeanFactory
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws SpringBeanException;
}
