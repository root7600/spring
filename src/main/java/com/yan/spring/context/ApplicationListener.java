package com.yan.spring.context;

import com.yan.spring.context.event.ApplicationEvent;

import java.util.EventListener;

public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
