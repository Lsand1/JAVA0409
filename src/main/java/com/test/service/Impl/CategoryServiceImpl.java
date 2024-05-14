package com.test.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dao.CategoryDao;
import com.test.dao.GoodsDao;
import com.test.entity.Category;
import com.test.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryDao categoryDao;

    @Resource
    GoodsDao goodsDao;

    @Override
    public List<Category> queryAllCategory() {
        return categoryDao.queryAllCategory();
    }

    @Override
    public PageInfo<Category> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Category> category = categoryDao.queryAllCategory();
        PageInfo<Category> pageInfo = new PageInfo<>(category);
        return pageInfo;
    }

    @Transactional
    @Override
    public int deleteById(Integer id) {
        int num = 0;
        try {
            goodsDao.deleteByTypeId(id);
            num =  categoryDao.deleteById(id);
        }catch (Exception e){

        }
        return num;
    }

    @Override
    public int update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public int insert(String name) {
        return categoryDao.insert(name);
    }

}
