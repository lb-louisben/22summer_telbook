package com.baizhi.lb.dao;

import com.baizhi.lb.entity.Person;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserDaoTest extends TestCase {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    public void testFindUserByNameAndPassword() {
        String username = "baizhi";
        String password = "123456";
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        int row = userDao.findUserByNameAndPassword(username, password);

        System.out.println(row);
    }
}