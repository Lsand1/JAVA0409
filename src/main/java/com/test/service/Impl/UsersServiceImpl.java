package com.test.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.entity.Users;
import com.test.dao.UsersDao;
import com.test.service.UsersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Users)表服务实现类
 *
 * @author suxuexia
 * @since 2024-05-07 10:07:19
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    @Override
    public PageInfo<Users> queryByPage(Users users, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public PageInfo<Users> queryAllByPage(Users users, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Users> usersList = usersDao.queryAll(users);
        PageInfo<Users> pageInfo = new PageInfo<>(usersList);
        return pageInfo;
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

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }
}
