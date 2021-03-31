package com.example.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.task.entity.TTask;
import com.example.task.mapper.TTaskMapper;
import com.example.task.service.ITTaskService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@Service
public class TTaskServiceImpl extends ServiceImpl<TTaskMapper, TTask> implements ITTaskService {

}
