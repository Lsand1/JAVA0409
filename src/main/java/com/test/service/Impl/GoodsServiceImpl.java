package com.test.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dao.GoodsDao;
import com.test.entity.Goods;
import com.test.entity.Response;
import com.test.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Cacheable(cacheNames = "goods",key = "#id")
    @Override
    public Response<Goods>  queryById(Integer id) {
        Response<Goods> res = Response.success(goodsDao.queryById(id));
        return res;
    }



    @CacheEvict(cacheNames = "goods",key = "#gdID")
    @Override
    public boolean deleteById(int gdID) {
        return goodsDao.deleteById(gdID) > 0;
    }

    @Override
    public String insert(Goods goods) {
        String msg = "商品添加失败";
        //
        if (goods.getPrice() == null || goods.getPrice() <= 0) {
            msg = "商品价格范围不正确";
            return msg;
        }
        int num = goodsDao.insert(goods);
        if (num > 0) {
            msg = "商品【" + goods.getId() + "---" + goods.getName() + "】添加成功！";
        }
        return msg;
    }

    @CachePut(cacheNames = "goods",key = "#goods.id")
    @Override
    public Response<Goods> update(Goods goods) {

        Response<Goods> res = null;
        if (null == goods.getPrice() || goods.getPrice() < 0) {
            res = Response.fail("商品价格范围不正确");
            return res;
        }
        int num = goodsDao.update(goods);
        if (num > 0) {
            res = Response.success("商品【" + goods.getId() + "---" + goods.getName() + "】编辑成功！",goods);
        } else {
            res = Response.fail("商品编辑失败！");
        }

        return res;
    }


}
