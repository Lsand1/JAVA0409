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
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/admin")
public class LoginCtrl {

    @Resource
    AdminuserService adminuserService;

    @GetMapping("/goLogin")
    public String toLogin() {
        return "login";
        //return "../templates/login.html";
    }

    @PostMapping("/doLogin")

    //public String doLogin(String uName,@RequestParam(value = "pwd") String uPwd){
    public String doLogin(Adminuser adminuser, Model model,HttpSession session) {
        System.out.println(adminuser.getName() + " ===" + adminuser.getPassword());
        System.out.println("登录处理");

        Adminuser user = adminuserService.getAdminuser(adminuser);
        System.out.println(user);

        if(user== null){
            model.addAttribute("msg","用户名或者密码不正确");
            return "login";
        }
        session.setAttribute("aduName",user.getName());
        return "redirect:/admin/goods/getGoodsList";

    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session){

        session.removeAttribute("aduName");
        session.invalidate();
        return "login";
    }

}
