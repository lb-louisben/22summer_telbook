package com.baizhi.lb.dao;

import com.baizhi.lb.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     * 根据 用户昵称和密码查找
     * @param username 昵称
     * @param password 密码
     * @return 非0则存在
     */
    int findUserByNameAndPassword(@Param("username") String username,@Param("password") String password);

    User queryByName(@Param("username") String username);


}
