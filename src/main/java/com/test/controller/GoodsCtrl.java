package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Category;
import com.test.entity.Goods;
import com.test.service.CategoryService;
import com.test.service.GoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/goods")
public class GoodsCtrl {
    @Resource
    GoodsService goodsService;
    @Resource
    CategoryService categoryService;
     @RequestMapping("/getGoodsList")
    public String getGoodsList(Model model,
                               @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize){
        PageInfo<Goods> goodsListPage=goodsService.queryAllByPage(pageNum,pageSize);
        model.addAttribute("goodsListPage",goodsListPage);
        return "goodslogin";
    }
    @GetMapping("/delGoods/{id}")
    public String delGoods(@PathVariable("id") int gdID,Model model){
        boolean flag= goodsService.deleteById(gdID);
        if(flag){
            model.addAttribute("msg","删除成功！");
        }else {
            model.addAttribute("msg","该商品不允许删除！");
        }
        return "forward:/admin/goods/getGoodsList";
    }
    @ResponseBody
    @DeleteMapping("/delGoods/{id}")
    public boolean delGoods2(@PathVariable("id") int gdID){
        boolean flag= goodsService.deleteById(gdID);
        return flag;
    }
    @GetMapping("/gotoAddGoods")
    public String gotoAdd(Model model){
        List<Category> categoryList=categoryService.queryAllCategory();
        model.addAttribute("categoryList",categoryList);
        return "goodsAdd";
    }
    @PostMapping("/addGoods")
    public String addGoods(Goods goods,Model model){
            model.addAttribute("msg",goodsService.insert(goods));
            List<Category> categoryList=categoryService.queryAllCategory();
            model.addAttribute("categoryLis",categoryList);
        //return "forward:/admin/goods/getGoodsList";
        return  "goodsAdd";
    }
    @GetMapping("/{id}")
    public String getGoods(@PathVariable("id") int gID,Model model){
       List<Category> categoryList=categoryService.queryAllCategory();
       model.addAttribute("categoryList",categoryList);
       Goods goods=goodsService.queryById(gID).getData();

       model.addAttribute("goods",goods);
        return "goodsEdit";
    }
    @PostMapping("/editGoods")
    public String editGoods(Goods goods,Model model){
        model.addAttribute("msg",goodsService.update(goods).getMessage());
        return "goodsEdit";
    }
}
