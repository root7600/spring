package com.yan.spring.bean;

import com.yan.spring.factory.DisposableBean;
import com.yan.spring.factory.InitializingBean;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
public class UserService implements InitializingBean , DisposableBean {

    private String uId;

    private String company;
    private String location;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("userService---destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("userService---init");
    }
}
