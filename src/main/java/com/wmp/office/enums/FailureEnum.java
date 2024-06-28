package com.wmp.office.enums;

import lombok.Getter;

/**
 * 请求失败状态信息定义
 * @author liuph
 */
@Getter
public enum FailureEnum {

    // ****************************************** 服务内部错误 100000 ~ 100099 *************************************************************
    //服务器内部错误
    SYSTEM_INNER_ERROR(100000,"服务器内部错误"),

    //远程调用失败
    FEIGN_INVOKE_ERROR(100001,"Remote call failed"),

    // ****************************************** 认证错误 100100 ~ 100199 *************************************************************
    //访问令牌无效
    AUTH_FAIL(100100,"Access token was invalid"),

    //令牌格式错误
    BAD_TOKEN_FORMAT(100101, "bad token format"),

    // ****************************************** 参数问题 10200 ~ 10299 *************************************************************
    //参数错误
    PARAM_ERROR(100200,"参数错误"),

    //时间格式错误
    TIME_FORMAT_ERROR(100201,"time format error"),


    // ****************************************** 业务问题 10300 ~ 10399 *************************************************************




    ;

    private  int code;

    private String msg;

    FailureEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
