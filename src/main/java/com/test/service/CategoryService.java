package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryAllCategory();
   PageInfo<Category> queryAllByPage(Integer pageNum, Integer pageSize);

   // Category queryById(Integer id);

    //boolean deleteById(int cID);
    int deleteById(Integer id);

    int insert(String  name);

    int update(Category category);
}
