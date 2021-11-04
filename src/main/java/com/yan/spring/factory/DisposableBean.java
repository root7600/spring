package com.yan.spring.factory;

public interface DisposableBean {
    /**
     * 销毁bean
     * @throws Exception
     */
    void destroy() throws Exception;

}
