package com.parklot.service;

import com.parklot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
public interface UserService extends IService<User> {
    //创建用户
    int createUser(User user);

    //查询管理员用户数
    int queryAdminNum();

    //查询普通用户数
    int queryOrdinaryNum();

    //查询所有用户
    List<User> queryAllUser();
}
