package com.yan.spring.context.event;

import com.yan.spring.context.ApplicationContext;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 * ApplicationContextEvent 是定义事件的抽象类，所有的事件包括关闭、刷新，
 * 以及用户自己实现的事件，都需要继承这个类。
 */
public class ApplicationContextEvent extends ApplicationEvent{

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
