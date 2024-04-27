package com.test.dao;


import com.test.entity.Adminuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminuserDao {
    // 根据用户名和密码查找用户
    @Select("select * from adminuser where name=#{adminuser.name} AND password =#{adminuser.password}")
    Adminuser getAdminuser(@Param("adminuser") Adminuser adminuser);
}
