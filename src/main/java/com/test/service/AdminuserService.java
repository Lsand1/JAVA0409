package com.test.service;

import com.github.pagehelper.PageInfo;
import com.test.entity.Adminuser;
import com.test.entity.Category;
import com.test.entity.Response;

import java.util.List;

public interface AdminuserService {
    Adminuser getAdminuser(Adminuser adminuser);

    List<Adminuser> queryAllAdminuser();
    Adminuser queryBytID(Integer id);

    PageInfo<Adminuser> queryAllByPage(Integer pageNum, Integer pageSize);
    int update(Adminuser adminuser);

    int insert(Adminuser adminuser);
    Response<Adminuser> updatemima(Adminuser adminuser);

}
