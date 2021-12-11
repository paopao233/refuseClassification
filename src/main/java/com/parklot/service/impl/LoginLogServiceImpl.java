package com.parklot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.parklot.entity.LoginLog;
import com.parklot.mapper.LoginLogMapper;
import com.parklot.service.ClassificationService;
import com.parklot.service.LoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.parklot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ale
 * @since 2021-11-27
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ClassificationService classificationService;



    @Override
    public List<LoginLog> queryLoginLog(int limit) {

        QueryWrapper<LoginLog> logQueryWrapper = new QueryWrapper<>();
        logQueryWrapper.select("id","username","ip","status","login_time")
                        .orderByDesc("id")
                        .last("limit "+limit);//限制返回的数量  拼接


        List<LoginLog> loginLogs = loginLogMapper.selectList(logQueryWrapper);
        return loginLogs;
    }

    //后台首页数据
    @Override
    public Map<String, Object> queryDashboard() {
        Map<String,Object> map = new HashMap<>();
        //管理员人数
        int adminNum = userService.queryAdminNum();

        //普通用户人数
        int ordinaryNum = userService.queryOrdinaryNum();
        //垃圾分类词条个数

        //登录记录条数
        int loginInfoNum = loginLogMapper.queryLoginInfoNum();

        //查询垃圾分类词条总数
        int classificationNum = classificationService.queryClassificationNum();

        map.put("adminNum",adminNum);
        map.put("ordinaryNum", ordinaryNum);
        map.put("loginInfoNum",loginInfoNum);
        map.put("classificationNum", classificationNum);

        return map;
    }


}
