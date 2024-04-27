package com.test.dao;

import com.test.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryDao {

    @Select("select * from category where id = #{cid}")
    Category queryBytID(Integer cid);

    @Select("select * from category")
    List<Category> queryAllCategory();
}
