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

/**
 * 管理员用户服务实现类，实现了AdminuserService接口中定义的所有业务逻辑。
 */
@Service
public class AdminuserServiceImpl implements AdminuserService {

    // 通过@Resource注解自动注入AdminuserDao数据访问对象
    @Resource
    private AdminuserDao adminuserDao;

    /**
     * 根据管理员用户信息查询管理员用户。
     * @param adminuser 管理员用户实体，包含登录名和密码等信息。
     * @return 查询到的管理员用户实体。
     */
    @Override
    public Adminuser getAdminuser(Adminuser adminuser) {
        // 对密码进行MD5加密处理
        String psw = DigestUtils.md5DigestAsHex(adminuser.getPassword().getBytes());
        System.out.println(psw);
        adminuser.setPassword(psw); // 设置加密后的密码
        return adminuserDao.getAdminuser(adminuser); // 调用DAO层方法执行查询
    }

    /**
     * 查询所有管理员用户。
     * @return 管理员用户列表。
     */
    @Override
    public List<Adminuser> queryAllAdminuser() {
        return List.of(); // 返回空列表，实际应调用DAO层方法获取数据
    }

    /**
     * 根据ID查询管理员用户。
     * @param id 管理员用户ID。
     * @return 查询到的管理员用户实体。
     */
    @Override
    public Adminuser queryBytID(Integer id) {
        return null; // 返回null，实际应调用DAO层方法获取数据
    }

    /**
     * 分页查询管理员用户列表。
     * @param pageNum 当前页码。
     * @param pageSize 每页显示的条目数。
     * @return 分页信息对象，包含查询结果和分页数据。
     */
    @Override
    public PageInfo<Adminuser> queryAllByPage(Integer pageNum, Integer pageSize) {
        return null; // 返回null，实际应调用DAO层方法并使用PageHelper进行分页
    }

    /**
     * 更新管理员用户信息。
     * @param adminuser 包含更新信息的管理员用户实体。
     * @return 受影响的行数。
     */
    @Override
    public int update(Adminuser adminuser) {
        return 0; // 返回0，实际应调用DAO层方法执行更新并返回受影响的行数
    }

    /**
     * 插入新的管理员用户。
     * @param adminuser 要插入的管理员用户实体。
     * @return 受影响的行数。
     */
    @Override
    public int insert(Adminuser adminuser) {
        return 0; // 返回0，实际应调用DAO层方法执行插入并返回受影响的行数
    }

    /**
     * 更新管理员密码。
     * @param adminuser 包含新密码的管理员用户实体。
     * @return 包含操作结果的响应对象。
     */
    @Override
    public Response<Adminuser> updatemima(Adminuser adminuser) {
        return null; // 返回null，实际应实现密码更新逻辑并返回响应
    }
}