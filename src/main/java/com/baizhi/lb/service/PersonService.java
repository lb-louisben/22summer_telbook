package com.baizhi.lb.service;

import com.baizhi.lb.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> listAllPersons();

    void register(Person p);

    void deleteOnePerson(Integer id);

    Person selectById(Integer id);

    void update(Person p);



    Integer getTotalPage(Integer pageSize);
    List<Person> queryByPage(Integer currentPage, Integer pageSize);
}
