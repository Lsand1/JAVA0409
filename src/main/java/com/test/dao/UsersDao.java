package com.test.dao;

import com.test.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author suxuexia
 * @since 2024-05-07 10:07:15
 */
@Mapper
public interface UsersDao {

    Users queryById(Integer id);

    List<Users> queryAll(Users users);

    int insert(Users users);

    int update(Users users);

    int deleteById(Integer id);

}

