package com.yan.spring.context.support;

import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.BeanFactory;
import com.yan.spring.factory.FactoryBean;
import com.yan.spring.factory.config.BeanDefinition;
import com.yan.spring.factory.config.BeanPostProcessor;
import com.yan.spring.factory.config.ConfigurableBeanFactory;
import com.yan.spring.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport  implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /** BeanPostProcessors to apply in createBean */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) {
        return doGetBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws SpringBeanException {
       return doGetBean(name,args);
    }

    protected <T> T doGetBean(String name, Object... args){

        Object sharedInstance = getSingleton(name);
        if (sharedInstance != null) {
            // 如果是 FactoryBean，则需要调用 FactoryBean#getObject
            return (T) getObjectForBeanInstance(sharedInstance, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name, beanDefinition,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> classType) {
        return (T)doGetBean(name);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws SpringBeanException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws SpringBeanException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);

        if (object == null) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }

        return object;
    }

}
