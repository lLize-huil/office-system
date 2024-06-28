package com.wmp.office.dto.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class UserEntity {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名，用手机号做唯一键
     */
    private String account;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 0:管理员，1：组长，2：普通用户
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createtime;

}

