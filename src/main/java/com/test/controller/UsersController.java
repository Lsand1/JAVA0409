package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.entity.Users;
import com.test.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name="UsersController",description = "会员的增删改查")
@RestController
@RequestMapping("users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @Operation(summary="根据条件查询会员")
    @RequestMapping(value = "getUserList", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<PageInfo<Users>> queryByPage( @RequestBody Users users, Integer pageNum, Integer pageSize ) {
        return ResponseEntity.ok(this.usersService.queryByPage(users, pageNum,pageSize));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Users> queryById(@Parameter(description = "输入id查询") @PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Users> add(@RequestBody Users users) {
        return ResponseEntity.ok(this.usersService.insert(users));
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Users> edit(@RequestBody Users users) {
        return ResponseEntity.ok(this.usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usersService.deleteById(id));
    }

}

