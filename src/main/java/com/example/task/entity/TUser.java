package com.example.task.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author wto
 * @since 2021-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TUser对象", description="后台用户表")
public class TUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "登录账号")
    @TableField("SLOGINNAME")
    private String sloginname;

    @ApiModelProperty(value = "登录密码")
    @TableField("SPASSWORD")
    private String spassword;

    @ApiModelProperty(value = "用户真实姓名")
    @TableField("SREALNAME")
    private String srealname;

    @ApiModelProperty(value = "角色ID")
    @TableField("IROLEID")
    private Long iroleid;

    @ApiModelProperty(value = "插入时间")
    @TableField("DCREATETIME")
    private Date dcreatetime;

    @ApiModelProperty(value = "更新时间")
    @TableField("DUPDATETIME")
    private Date dupdatetime;

    @TableField("DSTATUS")
    private Integer dstatus;

    @ApiModelProperty(value = "用户描述")
    @TableField("USERDESC")
    private String userdesc;


}
