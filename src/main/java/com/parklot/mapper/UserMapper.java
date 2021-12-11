package com.parklot.mapper;

import com.parklot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */

public interface UserMapper extends BaseMapper<User> {
    //查询管理员用户数
    int queryAdminNum();

    //查询普通用户数
    int queryOrdinaryNum();

}
