package com.wmp.office.dto.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

@Data
@Table(value = "user", comment = "用户表")
public class UserEntity {

    @TableId(type = IdType.AUTO)
    @Column(name = "id", type = MySqlTypeConstant.INT, isKey = true,
            isAutoIncrement = true, comment = "主键id")
    private Integer id;

    @Column(comment = "用户名，用手机号做唯一键")
    private String account;

    @Column(comment = "用户昵称")
    private String name;

    @Column(comment = "密码")
    private String password;

    @Column(comment = "0:管理员，1：组长，2：普通用户")
    private Integer type;

    @Column(type = MySqlTypeConstant.DATETIME, comment = "创建时间")
    private Date createtime;

}

