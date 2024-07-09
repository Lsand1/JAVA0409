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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 商品服务实现类，实现了GoodsService接口中定义的所有业务逻辑。
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    // 通过@Resource注解自动注入GoodsDao数据访问对象
    @Resource
    private GoodsDao goodsDao;

    // 通过@Resource注解自动注入RedisTemplate，用于操作Redis缓存
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 分页查询所有商品。
     * @param pageNum 当前页码
     * @param pageSize 每页显示的商品数量
     * @return 分页信息对象，包含商品列表和分页数据。
     */
    @Override
    public PageInfo<Goods> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsDao.queryAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo;
    }

    /**
     * 根据商品ID查询商品信息，并使用Redis缓存。
     * @param id 商品ID
     * @return 商品信息的响应对象。
     */
    @Override
    public Response<Goods> queryById(Integer id) {
        // 先从缓存中查询
        Response obj = (Response) redisTemplate.opsForValue().get("goods_" + id);
        // 如果有，返回结果
        if (obj != null){
            return obj;
        }
        // 如果缓存中没有该数据，查询数据库
        Response<Goods> res = Response.success(goodsDao.queryById(id));
        // 存到缓存中
        redisTemplate.opsForValue().set("goods_" + id, res, 1, TimeUnit.HOURS);
        return res;
    }

    /**
     * 根据商品ID删除商品，并清除缓存。
     * @param gdID 商品ID
     * @return 删除操作的成功与否。
     */
    @Override
    public boolean deleteById(int gdID) {
        boolean flag = goodsDao.deleteById(gdID) > 0;
        if (flag) {
            redisTemplate.delete("goods_" + gdID);
        }
        return flag;
    }

    /**
     * 插入新商品，并进行价格有效性校验。
     * @param goods 要添加的商品实体
     * @return 操作结果的描述信息。
     */
    @Override
    public String insert(Goods goods) {
        String msg = "商品添加失败";
        // 商品价格有效性校验
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

    /**
     * 更新商品信息，并使用Redis缓存。
     * @param goods 包含更新信息的商品实体
     * @return 商品信息的响应对象。
     */
    @Override
    public Response<Goods> update(Goods goods) {
        Response<Goods> res = null;
        // 商品价格有效性校验
        if (null == goods.getPrice() || goods.getPrice() < 0) {
            res = Response.fail("商品价格范围不正确");
            return res;
        }
        int num = goodsDao.update(goods);
        if (num > 0) {
            res = Response.success("商品【" + goods.getId() + "---" + goods.getName() + "】编辑成功！", goods);
            // 更新缓存
            redisTemplate.opsForValue().set("goods_" + goods.getId(), res);
        } else {
            res = Response.fail("商品编辑失败！");
        }
        return res;
    }
}