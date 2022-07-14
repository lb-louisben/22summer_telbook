package com.baizhi.lb.service.impl;

import com.baizhi.lb.entity.Category;
import com.baizhi.lb.entity.Person;
import com.baizhi.lb.service.PersonService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PersonServiceImplTest extends TestCase {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    PersonService personService = (PersonService) ctx.getBean("personService");

    public void testListAllPersons() {
        List<Person> list = personService.listAllPersons();

        for (Person p : list) {
            System.out.println(p);
        }
    }

    public void testRegister() {
        Person person = new Person();
        person.setName("张洋");
        person.setMobile("19912341232");
        person.setTelphone("010-123457");
        person.setEmail("zhangyang@qq.com");
        person.setCity("成都");
        person.setCategory(new Category(1, null));
        person.setBirthday(new Date(2001, Calendar.AUGUST, 12));

        personService.register(person);
    }

    public void testQueryByPage() {
        List<Person> list = personService.queryByPage(2, 3);
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public void testGetTotalPage() {
        Integer totalPage = personService.getTotalPage(10);
        System.out.println(totalPage);
    }
}