package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Category;
import com.test.entity.Goods;
import com.test.entity.Response;
import com.test.service.CategoryService;
import com.test.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品控制器，用于处理后台商品管理的相关Web请求。
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsCtrl {

    // 通过@Resource注解自动注入GoodsService服务
    @Resource
    private GoodsService goodsService;

    // 通过@Resource注解自动注入CategoryService服务
    @Resource
    private CategoryService categoryService;

    /**
     * 获取商品列表，并支持分页查询。
     *
     * @param model        Spring MVC模型，用于向视图传递数据
     * @param pageNum      当前页码，缺省值为1
     * @param pageSize     每页显示的条目数，缺省值为3
     * @return            转发到商品列表页面
     */
    @RequestMapping("/getGoodsList")
    public String getGoodsList(
            Model model,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        PageInfo<Goods> goodsListPage = goodsService.queryAllByPage(pageNum, pageSize);
        model.addAttribute("goodsListPage", goodsListPage);
        return "goodslogin"; // 商品列表页面
    }

    /**
     * 根据商品ID删除商品。
     *
     * @param gdID       要删除的商品ID
     * @param model       Spring MVC模型，用于向视图传递消息
     * @return           根据删除结果重定向到商品列表页面
     */
    @GetMapping("/delGoods/{id}")
    public String delGoods(@PathVariable("id") int gdID, Model model) {
        boolean flag = goodsService.deleteById(gdID);
        if (flag) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "该商品不允许删除！");
        }
        return "redirect:/admin/goods/getGoodsList"; // 重定向到商品列表页面
    }

    /**
     * RESTful API，用于删除商品。
     *
     * @param gdID 要删除的商品ID
     * @return     如果删除成功返回true，否则返回false
     */
    @ResponseBody
    @DeleteMapping("/delGoods/{id}")
    public boolean delGoods2(@PathVariable("id") int gdID) {
        return goodsService.deleteById(gdID);
    }

    /**
     * 跳转到添加商品的页面，并加载所有商品分类信息。
     *
     * @param model Spring MVC模型，用于向视图传递商品分类列表
     * @return     转发到添加商品页面
     */
    @GetMapping("/gotoAddGoods")
    public String gotoAddGoods(Model model) {
        List<Category> categoryList = categoryService.queryAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "goodsAdd"; // 添加商品页面
    }

    /**
     * 添加新商品。
     *
     * @param goods       包含新商品信息的Goods实体
     * @param model       Spring MVC模型，用于向视图传递消息
     * @return           转发到添加商品页面
     */
    @PostMapping("/addGoods")
    public String addGoods(Goods goods, Model model) {
        int result = Integer.parseInt(goodsService.insert(goods)); // 调用服务层添加商品
        model.addAttribute("msg", result > 0 ? "添加成功" : "添加失败");
        List<Category> categoryList = categoryService.queryAllCategory(); // 获取所有商品分类
        model.addAttribute("categoryList", categoryList); // 传递商品分类到视图
        return "goodsAdd"; // 转发到添加商品页面
    }

    /**
     * 根据商品ID获取商品详情。
     *
     * @param gID        商品ID
     * @param model      Spring MVC模型，用于向视图传递商品和分类信息
     * @return           转发到商品编辑页面
     */
    @GetMapping("/{id}")
    public String getGoods(@PathVariable("id") int gID, Model model) {
        List<Category> categoryList = categoryService.queryAllCategory(); // 获取所有商品分类
        model.addAttribute("categoryList", categoryList); // 传递商品分类到视图
        Goods goods = goodsService.queryById(gID).getData(); // 根据ID获取商品详情
        model.addAttribute("goods", goods); // 传递商品详情到视图
        return "goodsEdit"; // 商品编辑页面
    }

    /**
     * 更新商品信息。
     *
     * @param goods       包含更新后商品信息的Goods实体
     * @param model       Spring MVC模型，用于向视图传递消息
     * @return           转发到商品编辑页面
     */
    @PostMapping("/editGoods")
    public String editGoods(Goods goods, Model model) {
        Response<Goods> result = goodsService.update(goods); // 调用服务层更新商品
        String message = "更新成功";
        model.addAttribute("msg", message); // 传递更新结果消息到视图
        return "goodsEdit"; // 转发到商品编辑页面
    }
}