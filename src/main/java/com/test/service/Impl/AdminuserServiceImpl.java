package com.test.service.Impl;

import com.test.dao.AdminuserDao;
import com.test.entity.Adminuser;
import com.test.service.AdminuserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AdminuserServiceImpl implements AdminuserService {

    @Resource
    AdminuserDao adminuserDao ;

    @Override
    public Adminuser getAdminuser(Adminuser adminuser) {
        // 密码加密
        String psw = DigestUtils.md5DigestAsHex(adminuser.getPassword().getBytes());
        System.out.println(psw);
        adminuser.setPassword(psw);
        return adminuserDao.getAdminuser(adminuser);
    }
}
