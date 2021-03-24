package com.example.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.task.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author wto
 * @since 2021-03-24
 */

@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}
