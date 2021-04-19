package com.example.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.task.entity.TLabel;
import com.example.task.mapper.TLabelMapper;
import com.example.task.service.ITLabelService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 项目标签 服务实现类
 * </p>
 *
 * @author wto
 * @since 2021-04-19
 */
@Service
public class TLabelServiceImpl extends ServiceImpl<TLabelMapper, TLabel> implements ITLabelService {

}
