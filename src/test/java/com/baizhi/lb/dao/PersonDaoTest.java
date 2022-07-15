package com.baizhi.lb.dao;

import com.baizhi.lb.entity.Category;
import com.baizhi.lb.entity.Person;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PersonDaoTest extends TestCase {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    PersonDao personDao = (PersonDao) ctx.getBean("personDao");

    public void testSelectAll() {
        List<Person> personList = personDao.selectAll();
        for (Person p : personList) {
            System.out.println(p);
        }
    }

    public void testInsertPerson() {
        Person person = new Person();
        person.setName("张涵博");
        person.setMobile("19912341234");
        person.setTelphone("010-123456");
        person.setEmail("zhanghanbo@qq.com");
        person.setCity("成都");
        person.setCategory(new Category(1, null));
        person.setBirthday(new Date(2001, 8, 12));

        personDao.insertPerson(person);
    }

    public void testSelectById() {
        Integer id = 1001;

        Person person = personDao.selectById(id);

        System.out.println(person);
    }

    public void testDeleteOne() {
    }


    public void testUpdate() {
    }

    public void testSelectByPage() {
        List<Person> personList = personDao.selectByPage(0, 3);
        for (Person p : personList) {
            System.out.println(p);
        }
    }
}