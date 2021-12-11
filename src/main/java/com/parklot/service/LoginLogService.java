package com.parklot.service;

import com.parklot.entity.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ale
 * @since 2021-11-27
 */
public interface LoginLogService extends IService<LoginLog> {
    //查询所有的登录记录
    List<LoginLog> queryLoginLog(int limit);

    //dashboard数据
    Map<String,Object> queryDashboard();

}
