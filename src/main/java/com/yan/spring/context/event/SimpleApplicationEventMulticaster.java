package com.yan.spring.context.event;

import com.yan.spring.context.ApplicationListener;
import com.yan.spring.factory.BeanFactory;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 */
public class SimpleApplicationEventMulticaster  extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
