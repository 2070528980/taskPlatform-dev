package com.example.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.task.entity.TUser;
import com.example.task.mapper.TUserMapper;
import com.example.task.service.ITUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author wto
 * @since 2021-03-24
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Override
    public TUser findOneByUserName(String userName) {
        return getOne(new QueryWrapper<TUser>().eq("SLOGINNAME",userName).last("limit 1"));
    }
}
