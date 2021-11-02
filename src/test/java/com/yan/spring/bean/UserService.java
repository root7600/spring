package com.yan.spring.bean;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void say(String args){
        System.out.println(args+"查询用户信息：" + userDao.queryUserName(uId));
    }


}
