package com.baizhi.lb.service.impl;

import com.baizhi.lb.dao.UserDao;
import com.baizhi.lb.entity.User;
import com.baizhi.lb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public boolean signIn(String username, String password) {
        int row = userDao.findUserByNameAndPassword(username, password);
        return row!=0;
    }

    @Override
    public User queryByName(String username) {
        return userDao.queryByName(username);
    }
}
