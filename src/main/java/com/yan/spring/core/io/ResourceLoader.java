package com.yan.spring.core.io;

/**
 * @author hairui
 * @date 2021/11/2
 * @des
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
