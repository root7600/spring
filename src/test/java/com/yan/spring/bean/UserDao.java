package com.yan.spring.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hairui
 * @date 2021/11/2
 * @des
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<String, String>();

    static {
        hashMap.put("10001", "常有理");
        hashMap.put("10002", "小胖子");
        hashMap.put("10003", "臭脚");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
