package com.baizhi.lb.test;

import com.baizhi.lb.dao.PersonDao;
import com.baizhi.lb.entity.Person;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpringMyBatis {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    @Test
    public void testEnv(){
        SqlSessionFactory factory = (SqlSessionFactory) ctx.getBean("factory");
        System.out.println(factory.openSession().getConnection());
    }

    @Test
    public void testSelectAll(){
        PersonDao personDao = (PersonDao) ctx.getBean("personDao");
        List<Person> personList = personDao.selectAll();
        for (Person p:personList) {
            System.out.println(p);
        }
    }
}
