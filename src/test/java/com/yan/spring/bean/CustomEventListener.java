package com.yan.spring.bean;

import com.yan.spring.context.ApplicationListener;

import java.util.Date;

/**
 * @author hairui
 * @date 2021/11/5
 * @des
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
