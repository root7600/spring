package com.yan.spring.factory;

/**
 * @author hairui
 * @date 2021/11/4
 * @des
 */
public interface InitializingBean {

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;

}
