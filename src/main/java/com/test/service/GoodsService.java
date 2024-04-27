package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Goods;

import java.util.List;

public interface GoodsService {
//    List<Goods> queryAllGoods() ;

    PageInfo<Goods> queryAllByPage(Integer pageNum, Integer pageSize);

    Goods queryById(Integer id);

    boolean deleteById(int gdID);

    int insert(Goods goods);

    int update(Goods goods);
}
