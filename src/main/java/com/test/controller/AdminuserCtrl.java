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

/**
 * 管理员用户控制器类，用于处理后台管理员用户的增删改查操作。
 */
@Controller
@RequestMapping("/admin/adminuser")
public class AdminuserCtrl {

    // 日志记录器
    private static final Logger logger = LoggerFactory.getLogger(AdminuserCtrl.class);

    // 通过@Resource注解自动注入AdminuserService服务
    @Resource
    private AdminuserService adminuserService;

    /**
     * 分页查询管理员用户列表。
     * @param pageNum 当前页码
     * @param pageSize 每页显示的条目数
     * @param model Spring MVC模型，用于向视图传递数据
     * @return 转发到显示管理员用户列表的视图
     */
    @GetMapping("getadminuserList")
    public String getadminuserList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
            Model model) {
        try {
            // 调用服务层方法进行分页查询
            PageInfo<Adminuser> adminuserPageInfo = adminuserService.queryAllByPage(pageNum, pageSize);
            // 将分页信息添加到模型
            model.addAttribute("adminuserPageInfo", adminuserPageInfo);
            // 返回管理员用户列表视图
            return "adminuserList";
        } catch (Exception e) {
            // 记录异常信息
            logger.error("Error retrieving adminuser list", e);
            // 添加错误信息到模型
            model.addAttribute("error", "Failed to retrieve adminuser list.");
            // 返回错误视图
            return "error";
        }
    }

    // ... 其他方法的注释 ...

    /**
     * 修改管理员用户的密码。
     * @param adminuser 包含新密码的管理员用户实体
     * @return ResponseEntity对象，包含操作结果和状态码
     */
    @PostMapping("editmimaAdminuser")
    public ResponseEntity<Response<Adminuser>> editmimaAdminuser(@RequestBody Adminuser adminuser) {
        try {
            // 调用服务层方法修改密码
            Response<Adminuser> response = adminuserService.updatemima(adminuser);
            // 根据操作成功与否设置HTTP状态码
            return ResponseEntity.status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                    .body(response);
        } catch (Exception e) {
            // 记录异常信息
            logger.error("Error changing adminuser password", e);
            // 返回内部服务器错误状态码和错误信息
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Response<>(false, "Password change failed", null));
        }
    }
}