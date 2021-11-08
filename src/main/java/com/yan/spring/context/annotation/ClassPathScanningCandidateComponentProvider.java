package com.yan.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.yan.spring.factory.config.BeanDefinition;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author hairui
 * @date 2021/11/8
 * @des
 * 这里先要提供一个可以通过配置路径 basePackage=com.yang.spring.bean，
 * 解析出 classes 信息的工具方法 findCandidateComponents，通过这个方法就可以扫描到所有 @Component 注解的 Bean 对象了。
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
