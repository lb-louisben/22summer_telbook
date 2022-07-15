package com.baizhi.lb.service;

import com.baizhi.lb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    boolean signIn(String username, String password);

    User queryByName(String username);
}
