package com.example.task.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.task.common.msg.MessageResult;
import com.example.task.common.utils.DateUtil;
import com.example.task.entity.TLabel;
import com.example.task.service.ITLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 项目标签 前端控制器
 * </p>
 *
 * @author wto
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/api/index//label")
public class TLabelController {


    @Autowired
    private ITLabelService labelService;



    @RequestMapping("/listTable")
    @ResponseBody
    public String list(@RequestParam(value="page",required = false,defaultValue = "1") Integer page, @RequestParam(value="limit",required = false,defaultValue = "1") Integer limit
            , @RequestParam(value="keyword",required = false,defaultValue = "") String keyword
    ) {
        IPage<TLabel> page1 = new Page<>(page,limit);
        QueryWrapper<TLabel> queryWrapper = new QueryWrapper<TLabel>()
                .like("CHANNEL_NO",keyword);
        IPage<TLabel> pigpenIPage =  labelService.page(page1,null);
        String json = JSON.toJSONString(pigpenIPage.getRecords());
        return "{\"code\":0,\"msg\":\"\",\"count\":"+pigpenIPage.getTotal()+",\"data\":"+json+"}";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Object listAll(String keyword) {

        return MessageResult.success(labelService.list());
    }


    @RequestMapping("/save")
    public Object save(String jsonStr) {

//        System.out.println("-----------save--------------");
        TLabel projectlabel = JSON.toJavaObject(JSON.parseObject(jsonStr), TLabel.class);
        if(projectlabel.getId()!=null){
            projectlabel.setUpdateDate(DateUtil.getSNDate());
        }else {
            projectlabel.setStatus(1);
            projectlabel.setCreateDate(DateUtil.getSNDate());
            projectlabel.setUpdateDate(DateUtil.getSNDate());
        }
        return MessageResult.success(labelService.saveOrUpdate(projectlabel));
    }

    @RequestMapping("/del")
    public Object del(Integer id) {
        return MessageResult.success(labelService.removeById(id));
    }


    @RequestMapping("/getOneByID")
    public Object getOneByID(Integer id) {
        return MessageResult.success(labelService.getById(id));
    }



}

