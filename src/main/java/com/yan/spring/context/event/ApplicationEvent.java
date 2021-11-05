package com.yan.spring.context.event;

import java.util.EventObject;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 * 以继承 java.util.EventObject 定义出具备事件功能的抽象类 ApplicationEvent，
 * 后续所有事件的类都需要继承这个类。
 *
 */
public abstract class ApplicationEvent  extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
