package com.baizhi.lb.service.impl;

import com.baizhi.lb.dao.PersonDao;
import com.baizhi.lb.entity.Person;
import com.baizhi.lb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> listAllPersons() {
        return personDao.selectAll();
    }

    @Override
    @Transactional
    public void register(Person p) {
        personDao.insertPerson(p);
    }

    @Override
    public void deleteOnePerson(Integer id) {
        personDao.deleteOne(id);
    }

    @Override
    public Person selectById(Integer id) {
        return personDao.selectById(id);
    }

    @Override
    public void update(Person p) {
        personDao.update(p);
    }

    /**
     * 计算总页数
     *
     * @param pageSize 页面展示条数
     * @return 总页数
     * 7行   展示3行    总页数 7/3
     * 9行   展示3行    总页数 9/3
     */
    @Override
    public Integer getTotalPage(Integer pageSize) {
        int totalCount = personDao.getTotalCount();

        return (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
    }

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页面展示条数
     * @return list
     */
    @Override
    public List<Person> queryByPage(Integer currentPage, Integer pageSize) {
        int startIndex = (currentPage - 1) * pageSize;
        return personDao.selectByPage(startIndex, pageSize);
    }
}
