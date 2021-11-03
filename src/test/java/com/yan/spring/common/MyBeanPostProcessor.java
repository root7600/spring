package com.yan.spring.common;

import com.yan.spring.bean.UserService;
import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.config.BeanPostProcessor;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws SpringBeanException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setuId("10004");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws SpringBeanException {
        return bean;
    }
}
