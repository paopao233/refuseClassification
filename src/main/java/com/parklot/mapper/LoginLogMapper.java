package com.parklot.mapper;

import com.parklot.entity.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ale
 * @since 2021-11-27
 */


public interface LoginLogMapper extends BaseMapper<LoginLog> {
    //查询登录记录的数量
    int queryLoginInfoNum();


}
