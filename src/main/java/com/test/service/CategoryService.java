package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryAllCategory();

    PageInfo<Category> queryAllByPage(Integer pageNum, Integer pageSize);

    int deleteById(Integer id);

    int update(Category category);

    int insert(String name);
}
