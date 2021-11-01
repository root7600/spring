package com.yan.spring.bean;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class UserService {

    private  String userName;

    public UserService() {
    }

    public UserService(String userName) {
        this.userName = userName;
    }

    public void say(String args){
        System.out.println(args+"say welcome spring");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
