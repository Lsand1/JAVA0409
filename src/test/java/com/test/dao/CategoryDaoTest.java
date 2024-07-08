package com.test.dao;

import com.test.entity.Category;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryDaoTest {
    @Resource
    CategoryDao categoryDao;

    @org.junit.jupiter.api.Test
    void queryBytID() {
        Category c= categoryDao.queryBytID(1);
        System.out.println(c.getId()+"----"+c.getName());
    }
}