package com.yan.spring.context.event;

import com.yan.spring.context.event.ApplicationContextEvent;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(Object source) {
        super(source);
    }
}
