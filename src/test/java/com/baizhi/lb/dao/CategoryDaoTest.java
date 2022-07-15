package com.baizhi.lb.dao;

import com.baizhi.lb.entity.Category;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CategoryDaoTest extends TestCase {

    public void testSelectAllCate() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        CategoryDao categoryDao = (CategoryDao) ctx.getBean("categoryDao");
        List<Category> categories = categoryDao.selectAllCate();

        for(Category i : categories){
            System.out.println(i);
        }
    }
}