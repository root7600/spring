package com.yan.spring.bean;

import com.yan.spring.context.annotation.Component;

import java.util.Random;

/**
 * @author hairui
 * @date 2021/11/7
 * @des
 */
@Component("itemService")
public class ItemService implements IItemService{

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
