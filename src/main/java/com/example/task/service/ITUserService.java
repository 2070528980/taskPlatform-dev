package com.example.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.task.entity.TUser;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author wto
 * @since 2021-03-24
 */
public interface ITUserService extends IService<TUser> {

    TUser findOneByUserName(String userName);


}
