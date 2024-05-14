package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Users;

/**
 * (Users)表服务接口
 *
 * @author suxuexia
 * @since 2024-05-07 10:07:19
 */
public interface UsersService {

    Users queryById(Integer id);
    PageInfo<Users> queryAllByPage(Users users,Integer pageNum, Integer pageSize);

    Users insert(Users users);

    Users update(Users users);

    boolean deleteById(Integer id);

}
