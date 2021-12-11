package com.parklot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.parklot.entity.User;
import com.parklot.mapper.UserMapper;
import com.parklot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int createUser(User user) {
        int result = userMapper.insert(user);
        return result;
    }


    @Override
    public int queryAdminNum() {
       return userMapper.queryAdminNum();
    }

    @Override
    public int queryOrdinaryNum() {
        return userMapper.queryOrdinaryNum();
    }

    @Override
    public List<User> queryAllUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","username","email","create_time","update_time");
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }
}
