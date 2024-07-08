package com.test.dao;

import com.test.entity.Adminuser;
import com.test.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminuserDao {

    @Select("select * from adminuser where name=#{adminuser.name} AND password =#{adminuser.password}")
    Adminuser getAdminuser(@Param("adminuser") Adminuser adminuser);
//根据id查询
    @Select("select * from adminuser where id = #{id}")
     Adminuser queryBytID(Integer id);
//查询全部
    @Select("select * from adminuser")
    List<Adminuser> queryAllAdminuser();
//修改
    @Update("update adminuser SET " +
            " password = #{adminuser.password}" +
            "  where id = #{adminuser.id}")
    int update(@Param("adminuser") Adminuser adminuser);
    //添加
    @Insert("INSERT INTO adminuser" +
            "(password,name)" +
            "VALUES(" +
            "#{adminuser.password},"+
            "#{adminuser.name}" +
            ")")
    int insert(@Param("adminuser") Adminuser adminuser);

    @Update("update adminuser SET " +
            " password = #{adminuser.password}" +
            "  where id = #{adminuser.id}")
    int updatemima(@Param("adminuser") Adminuser adminuser);

}
