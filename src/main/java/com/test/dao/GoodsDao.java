package com.test.dao;

import com.test.entity.Category;
import com.test.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "sale_quantity", property = "saleQuantity"),
            @Result(column = "category_id", property = "category", javaType = Category.class,
                    one = @One(select = "com.test.dao.CategoryDao.queryBytID"))
    })
    @Select("select * from goods")
    List<Goods> queryAllGoods();

    @Results({
            @Result( column = "category_id",property = "categoryId"),
            @Result( column = "sale_quantity",property = "saleQuantity"),
    })
    @Select("select * from goods where id = #{id}")
    Goods queryById(Integer id);




    @Delete("DELETE FROM goods WHERE id = #{gdID} ")
    int deleteById(int gdID);

    @Insert("INSERT INTO goods" +
            "(category_id,code,name,price,quantity,sale_quantity,addtime,hot,image)" +
            "VALUES(" +
            "#{goods.categoryId}" +
            ",#{goods.code}" +
            ",#{goods.name}" +
            ",#{goods.price}" +
            ",#{goods.quantity}" +
            ",0" +
            ",now()" +
            ",#{goods.hot}" +
            ",#{goods.image}" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "goods.id")
    int insert(@Param("goods") Goods goods);

    @Update("update goods SET " +
            " category_id = #{goods.categoryId}" +
            ",code = #{goods.code}" +
            ",name = #{goods.name}" +
            ",price = #{goods.price}" +
            ",quantity = #{goods.quantity}" +
            ",hot = #{goods.hot}" +
            ",image = #{goods.image}" +
            "  where id = #{goods.id}")
    int update(@Param("goods") Goods goods);

}
