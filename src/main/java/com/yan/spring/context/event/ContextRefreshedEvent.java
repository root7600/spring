package com.yan.spring.context.event;

import com.yan.spring.context.event.ApplicationContextEvent;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
