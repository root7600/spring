package com.yan.spring.bean;

import com.yan.spring.context.ApplicationContext;
import com.yan.spring.context.annotation.Autowired;
import com.yan.spring.context.annotation.Component;
import com.yan.spring.context.annotation.Value;
import com.yan.spring.exception.SpringBeanException;
import com.yan.spring.factory.ApplicationContextAware;
import com.yan.spring.factory.BeanClassLoaderAware;
import com.yan.spring.factory.BeanFactory;
import com.yan.spring.factory.BeanFactoryAware;
import com.yan.spring.factory.BeanNameAware;
import com.yan.spring.factory.DisposableBean;
import com.yan.spring.factory.InitializingBean;

/**
 * @author hairui
 * @date 2021/11/1
 * @des
 */
@Component
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private String uId;

    private String company;
    private String location;

    private UserDao userDao;

    @Autowired
    private ItemDao itemDao;

    public String queryItemInfo() {
        return itemDao.queryItemName(uId) + "," + company + "," + location;
    }

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
    public void setApplicationContext(ApplicationContext applicationContext) throws SpringBeanException {
        System.out.println("applicationContext:"+applicationContext);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("classLoader:"+classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws SpringBeanException {
        System.out.println("beanFactory:"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("name:"+name);
    }
}
