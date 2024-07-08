package com.test.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Goods;
import com.test.entity.Users;
import com.test.dao.UsersDao;
import com.test.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    @Override
    public PageInfo<Users> queryByPage(Users users, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Users> usersList=usersDao.queryAllByLimit(users);
        PageInfo<Users> pageInfo=new PageInfo<>(usersList);
        return pageInfo;
    }

    @Override
    public PageInfo<Users> queryAllByPage(Users users, Integer pageNum, Integer pageSize) {
        return null;
    }


    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }
}
