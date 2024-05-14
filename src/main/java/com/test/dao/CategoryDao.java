package com.test.dao;

import com.test.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDao {

    @Select("select * from category where id = #{cid}")
    Category queryBytID(Integer cid);

    @Select("select * from category")
    List<Category> queryAllCategory();

    @Delete("delete from category where id = #{id}")
    int deleteById(Integer id);

    @Update("update category SET " +
            " `name` = #{category.name}" +
            "  where id = #{category.id}")
    int update(@Param("category") Category category);

    @Insert("insert into category(`name`) values (#{category.name})")
    int insert(String name);
}
