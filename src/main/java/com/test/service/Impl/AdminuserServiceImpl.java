package com.test.service.Impl;

import com.github.pagehelper.PageInfo;
import com.test.dao.AdminuserDao;
import com.test.entity.Adminuser;
import com.test.entity.Response;
import com.test.service.AdminuserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

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

    @Override
    public List<Adminuser> queryAllAdminuser() {
        return List.of();
    }

    @Override
    public Adminuser queryBytID(Integer id) {
        return null;
    }

    @Override
    public PageInfo<Adminuser> queryAllByPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public int update(Adminuser adminuser) {
        return 0;
    }

    @Override
    public int insert(Adminuser adminuser) {
        return 0;
    }

    @Override
    public Response<Adminuser> updatemima(Adminuser adminuser) {
        return null;
    }
}
