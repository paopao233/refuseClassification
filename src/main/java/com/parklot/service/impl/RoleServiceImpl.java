package com.parklot.service.impl;

import com.parklot.entity.Role;
import com.parklot.mapper.RoleMapper;
import com.parklot.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ale
 * @since 2021-11-24
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
