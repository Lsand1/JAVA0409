package com.test.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dao.GoodsDao;
import com.test.entity.Goods;
import com.test.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsDao goodsDao;

//    @Override
//    public List<Goods> queryAllGoods() {
//        return goodsDao.queryAllGoods();
//    }

    @Override
    public PageInfo<Goods> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsDao.queryAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    @Override
    public Goods queryById(Integer id) {
        return goodsDao.queryById(id);
    }

    @Override
    public boolean deleteById(int gdID) {
        return goodsDao.deleteById(gdID) > 0;
    }

    @Override
    public int insert(Goods goods) {
        return goodsDao.insert(goods);
    }

    @Override
    public int update(Goods goods) {
        return goodsDao.update(goods);
    }


}
