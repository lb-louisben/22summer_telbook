package com.baizhi.lb.dao;

import com.baizhi.lb.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDao {
    /**
     * 添加新联系人
     * @param p 联系人对象
     */
    void insertPerson(Person p);
    /**
     * 展示所有联系人
     *
     * @return list
     */
    List<Person> selectAll();

    void deleteOne(Integer id);

    Person selectById(Integer id);

    void update(Person p);

    int getTotalCount();
    List<Person> selectByPage(@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);
}
