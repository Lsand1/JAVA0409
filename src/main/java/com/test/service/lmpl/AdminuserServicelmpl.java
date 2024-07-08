package com.test.service.lmpl;

import com.github.pagehelper.PageHelper;
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
public class AdminuserServicelmpl implements AdminuserService {
    @Resource
    AdminuserDao adminuserDao;

    @Override
    public Adminuser getAdminuser(Adminuser adminuser) {
        //密码加密
        String psw = DigestUtils.md5DigestAsHex(adminuser.getPassword().getBytes());
        System.out.println(psw);
        adminuser.setPassword(psw);
        return adminuserDao.getAdminuser(adminuser);
    }

    @Override
    public List<Adminuser> queryAllAdminuser() {
        return adminuserDao.queryAllAdminuser();
    }

    @Override
    public Adminuser queryBytID(Integer id) {
        return adminuserDao.queryBytID(id);
    }


    @Override
    public PageInfo<Adminuser> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Adminuser> adminusers = adminuserDao.queryAllAdminuser();
        PageInfo<Adminuser> pageInfo = new PageInfo<>(adminusers);
        return pageInfo;
    }

    @Override
    public int update(Adminuser adminuser) {
        String psw = DigestUtils.md5DigestAsHex("123456".getBytes());
        adminuser.setPassword(psw);
        return adminuserDao.update(adminuser);
    }


    @Override
    public int insert(Adminuser adminuser) {
        String psw = DigestUtils.md5DigestAsHex("123456".getBytes());
        adminuser.setPassword(psw);
        return adminuserDao.insert(adminuser);
    }

    @Override
    public Response<Adminuser> updatemima(Adminuser adminuser) {
        Response<Adminuser>  res= Response.success("更新失败！");;
            String psw = DigestUtils.md5DigestAsHex(adminuser.getPassword().getBytes());
            adminuser.setPassword(psw);
            int num = adminuserDao.updatemima(adminuser);
            if (num > 0  ){
                res = Response.success("更新成功！",adminuser);
            }

            return res;
    }
}
