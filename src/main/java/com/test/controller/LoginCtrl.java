package com.test.controller;

import com.test.entity.Adminuser;
import com.test.service.AdminuserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class LoginCtrl {
    @Resource
    AdminuserService adminuserService;
    @GetMapping("/gologin")
    public String tologin() {
        return "login";
    }
    @PostMapping("/dologin")
    public String dologin(Adminuser adminuser, Model model,HttpSession session) {
        System.out.println(adminuser.getName() + "====" + adminuser.getPassword());
        System.out.println("登录处理");

        Adminuser user =adminuserService.getAdminuser(adminuser);
        System.out.println(user);
        if (user==null){
            model.addAttribute("msg","用户名或密码不正确");
            return "login";
        }
        session.setAttribute("adu",user);
        return "redirect:/admin/goods/getGoodsList";
    }
    @GetMapping("/logout")
    public String doLogout(HttpSession session){
        session.removeAttribute("aduName");
        session.invalidate();
        return "login";
    }

}
