package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Users;


public interface UsersService {

    Users queryById(Integer id);
    PageInfo<Users> queryByPage(Users users,Integer pageNum, Integer pageSize);

    PageInfo<Users> queryAllByPage(Users users, Integer pageNum, Integer pageSize);

    Users insert(Users users);

    Users update(Users users);

    boolean deleteById(Integer id);

}
