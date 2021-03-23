package com.example.task.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.task.entity.DrmUser;
import com.example.task.mapper.DrmUserMapper;
import com.example.task.service.IDrmUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wto
 * @since 2019-11-26
 */
@Service
public class DrmUserServiceImpl extends ServiceImpl<DrmUserMapper, DrmUser> implements IDrmUserService {


    @Override
    public DrmUser findOneByUserName(String userName) {
        return getOne(new QueryWrapper<DrmUser>().eq("phoneNumber",userName).last("limit 1"));
    }

    @Override
    public DrmUser selectByLoginName(String userName) {
        return null;
    }
}
