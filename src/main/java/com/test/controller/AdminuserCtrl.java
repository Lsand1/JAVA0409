package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Adminuser;
import com.test.entity.Response;
import com.test.service.AdminuserService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/adminuser")
public class AdminuserCtrl {

    private static final Logger logger = LoggerFactory.getLogger(AdminuserCtrl.class);

    @Resource
    private AdminuserService adminuserService;

    // 分页查询管理员用户列表
    @GetMapping("getadminuserList")
    public String getadminuserList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
            Model model) {
        try {
            PageInfo<Adminuser> adminuserPageInfo = adminuserService.queryAllByPage(pageNum, pageSize);
            model.addAttribute("adminuserPageInfo", adminuserPageInfo);
            return "adminuserList";
        } catch (Exception e) {
            logger.error("Error retrieving adminuser list", e);
            model.addAttribute("error", "Failed to retrieve adminuser list.");
            return "error"; // Assuming you have an error view set up
        }
    }

    // 修改管理员用户信息
    @PutMapping("editAdminuser")
    public ResponseEntity<Response<Integer>> editAdminuser(@RequestBody Adminuser adminuser) {
        try {
            int num = adminuserService.update(adminuser);
            return ResponseEntity.ok(new Response<>(true, "Update successful", num));
        } catch (Exception e) {
            logger.error("Error updating adminuser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(false, "Update failed", 0)); // 使用明确的错误代码
        }
    }

    // 添加管理员用户
    @PostMapping("addAdminuser")
    public ResponseEntity<Response<Integer>> addAdminuser(@RequestBody Adminuser adminuser) {
        try {
            int num = adminuserService.insert(adminuser);
            return ResponseEntity.ok(new Response<>(true, "Insert successful", num));
        } catch (Exception e) {
            logger.error("Error inserting adminuser", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(false, "Insert failed", 0)); // 使用明确的错误代码
        }
    }

    // 跳转到修改密码页面
    @GetMapping("gomima")
    public String gomimaAdminuser() {
        return "mimaAdminuser"; // Ensure you have a view named 'mimaAdminuser'
    }

    // 修改密码
    @PostMapping("editmimaAdminuser")
    public ResponseEntity<Response<Adminuser>> editmimaAdminuser(@RequestBody Adminuser adminuser) {
        try {
            Response<Adminuser> response = adminuserService.updatemima(adminuser);
            return ResponseEntity.status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            logger.error("Error changing adminuser password", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(false, "Password change failed", null)); // 使用null或适当的错误代码
        }
    }

}