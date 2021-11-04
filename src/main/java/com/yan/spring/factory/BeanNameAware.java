package com.yan.spring.factory;

/**
 * Interface to be implemented by beans that want to be aware of their bean name in a bean factory.
 * 实现此接口，既能感知到所属的 BeanName
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);
}
