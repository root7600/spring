package com.yan.spring.context;

import com.yan.spring.core.io.ResourceLoader;
import com.yan.spring.factory.HierarchicalBeanFactory;
import com.yan.spring.factory.config.ListableBeanFactory;

/**
 * @author hairui
 * @date 2021/11/3
 * @des
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher{
}
