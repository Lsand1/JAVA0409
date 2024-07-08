package com.test.dao;

import com.test.entity.Category;
import com.test.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDao {
    @Select("select * from category where id = #{cid}")
    Category queryBytID(Integer cid);

    @Select("select * from category")
    List<Category> queryAllCategory();

    @Delete("DELETE FROM category WHERE id = #{id} ")
    int deleteById(int id);

    @Insert("INSERT INTO category" +
            "(name)" +
            "VALUES(" +
            "#{category}" +
            ")")

    int insert(String category);

    @Update("update category SET " +
            "name = #{category.name}" +
            "  where id = #{category.id}")
    int update(@Param("category") Category category);

}
