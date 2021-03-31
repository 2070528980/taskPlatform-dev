package com.example.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.task.entity.TTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@Mapper
public interface TTaskMapper extends BaseMapper<TTask> {

}
