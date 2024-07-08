package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Category;
import com.test.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/category")
public class CategoryCtrl {
    @Resource
    CategoryService categoryService;
    @RequestMapping(value = "/getCategoryList",method = {RequestMethod.GET,RequestMethod.POST})
    public String getCategoryList(Model model,
                                  @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "5")Integer pageSize){
        PageInfo<Category> categoryPage=categoryService.queryAllByPage(pageNum,pageSize);
        model.addAttribute("categoryPage",categoryPage);
        return "category";
    }

    @ResponseBody
    @GetMapping("/delCategory/{id}")
    public int delCategory( @PathVariable("id") int id) {
    int flag =  categoryService.deleteById(id);
    return flag;
    }

    @ResponseBody
    @RequestMapping(value = "/editCategory",method = RequestMethod.POST)
        public int editCategory(@RequestBody Category category){
        System.out.println(category);
        int num= categoryService.update(category);
        return num;
    }

    @ResponseBody
    @PostMapping( "/addCategory")
    public int addCategory(String name){
        System.out.println(name+"----");
        int num= categoryService.insert(name);
        return num;
    }
}
