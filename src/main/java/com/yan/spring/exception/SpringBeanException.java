package com.yan.spring.exception;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class SpringBeanException extends RuntimeException {

    public SpringBeanException(String message) {
        super(message);
    }

    public SpringBeanException() {
        super();
    }

    public SpringBeanException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringBeanException(Throwable cause) {
        super(cause);
    }
}
