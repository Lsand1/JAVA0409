package com.test.controller;


import com.github.pagehelper.PageInfo;
import com.test.entity.Users;
import com.test.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * (Users)表控制层
 *
 * @author suxuexia
 * @since 2024-03-21 10:15:57
 */
@Controller
@RequestMapping("/admin/users")
public class UsersCtrl {

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "getUserList", method = {RequestMethod.GET, RequestMethod.POST})
    public String getUserList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
                              Users users,
                              Model model) {
        PageInfo<Users> userListPage = usersService.queryAllByPage(users, pageNum, pageSize);
        model.addAttribute("userListPage", userListPage);
        return "userList";
    }

    @GetMapping("delUser/{id}")
    public String delUser(@PathVariable("id") int id, Model model) {
        boolean flag = usersService.deleteById(id);
        if (flag) {
            model.addAttribute("msg", "删除成功！");
        } else {
            model.addAttribute("msg", "该用户不允许删除！");
        }
        return "forward:/admin/users/getUserList";
    }
}

