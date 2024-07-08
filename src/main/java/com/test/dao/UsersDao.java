package com.test.dao;

import com.test.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-07 10:43:51
 */
@Mapper
public interface UsersDao {

    Users queryById(Integer id);


    List<Users> queryAllByLimit(Users users);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Users> queryAll(Users users);
}

