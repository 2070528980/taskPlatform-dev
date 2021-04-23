package com.example.task.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DateUtil;
import com.example.task.common.utils.DrmFileUtils;
import com.example.task.common.utils.JsonUtil;
import com.example.task.common.utils.MinioUtil;
import com.example.task.entity.TTask;
import com.example.task.entity.TUser;
import com.example.task.service.ITTaskService;
import com.example.task.service.ITUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wto
 * @since 2021-03-31
 */
@RestController
@RequestMapping("/api/index/task")
public class TTaskController {


    @Autowired
    private ITTaskService taskService;

    private Logger logger = LoggerFactory.getLogger(TTaskController.class);

    @RequestMapping("/save")
    public Object save(String jsonStr) {

//        System.out.println("-----------save--------------");
        TTask tTask = JSON.toJavaObject(JSON.parseObject(jsonStr),TTask.class);
        if(tTask.getId()!=null){
            tTask.setUpdateDate(DateUtil.getSNDate());
        }else {
            tTask.setProjectState(1);
            tTask.setCreateDate(DateUtil.getSNDate());
            tTask.setUpdateDate(DateUtil.getSNDate());
        }

//        System.out.println(tTask);
//        return  MessageResult.error();
        return MessageResult.success(taskService.saveOrUpdate(tTask));

    }

    @RequestMapping("/list")
    @ResponseBody
    public String list(@RequestParam(value="page",required = false,defaultValue = "1") Integer pageNum, @RequestParam(value="limit",required = false,defaultValue = "1") Integer limit
            , @RequestParam(value="keyword",required = false,defaultValue = "") String keyword, @RequestParam(value="ProjectState",required = false,defaultValue = "") String ProjectState
    ) {

//        System.out.println(pageNum);
//        System.out.println(limit);
        IPage<TTask> page = new Page<>(pageNum,limit);
        QueryWrapper<TTask> queryWrapper = new QueryWrapper<TTask>()
                .like("ProjectState",ProjectState)
                .like("projectName",keyword).orderByDesc("updateDate");
        IPage<TTask> pigpenIPage =  taskService.page(page,queryWrapper);
        String json = JSON.toJSONString(pigpenIPage.getRecords());
        return "{\"code\":0,\"msg\":\"\",\"count\":"+pigpenIPage.getTotal()+",\"data\":"+json+"}";
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public Object listAll(String keyword) {

        return MessageResult.success(taskService.list());
    }

    @RequestMapping("/del")
    public Object del(Integer id) {
        return MessageResult.success(taskService.removeById(id));
    }

    @RequestMapping("/getOneByID")
    public Object getOneByID(Integer id) {
        return MessageResult.success(taskService.getById(id));
    }

    @RequestMapping("/")
    public Object test() {
        return  MessageResult.success();
    }


    @RequestMapping("/batchUpdateDate")
    public Object batchUpdateDate(String idStr) {
        String[] idArr =idStr.split(",");
        TTask task = new TTask();
        task.setUpdateDate(DateUtil.getSNDate());
        return MessageResult.success(taskService.update(task,new QueryWrapper<TTask>().in("id",idArr)));
    }

    @RequestMapping("/batchUpdateState")
    public Object batchUpdateState(String idStr,Integer ProjectState) {
        String[] idArr =idStr.split(",");
        TTask task = new TTask();
        task.setProjectState(ProjectState);
        task.setUpdateDate(DateUtil.getSNDate());
        return MessageResult.success(taskService.update(task,new QueryWrapper<TTask>().in("id",idArr)));
    }









}

