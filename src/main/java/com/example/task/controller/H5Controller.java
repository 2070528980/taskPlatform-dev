package com.example.task.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.task.common.msg.MessageResult;
import com.example.task.entity.TTask;
import com.example.task.service.ITLabelService;
import com.example.task.service.ITTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/api/H5")
public class H5Controller {


    @Autowired
    private ITTaskService taskService;

    @Autowired
    private ITLabelService labelService;

    private Logger logger = LoggerFactory.getLogger(H5Controller.class);


    @RequestMapping("/taskListAll")
    @ResponseBody
    public Object taskListAll(String keyword,String select) {
        System.out.println("keyword:"+keyword);
        System.out.println("select:"+select);
        QueryWrapper<TTask> queryWrapper = new QueryWrapper<TTask>().like("projectLabel",select)
                .and(wrapper -> wrapper.like("projectName",keyword).or().like("projectLabel",keyword));
        return MessageResult.success(taskService.list(queryWrapper));
    }


    @RequestMapping("/taskByID")
    @ResponseBody
    public Object taskByID(Integer id) {

        return MessageResult.success(taskService.getById(id));
    }

    @RequestMapping("/labelListAll")
    @ResponseBody
    public Object labelListAll(String keyword) {

        return MessageResult.success(labelService.list());
    }








}

