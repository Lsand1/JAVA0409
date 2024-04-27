package com.test.service.Impl;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import com.test.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryDao categoryDao;

    @Override
    public List<Category> queryAllCategory() {
        return categoryDao.queryAllCategory();
    }
}
