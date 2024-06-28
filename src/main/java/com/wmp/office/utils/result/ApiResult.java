package com.wmp.office.utils.result;


import lombok.Data;

/**
 * 返回结果封装
 */
@Data
public class ApiResult<T> {

    private boolean success;

    private String message = "";
    private Integer code;
    private T data;

    public static ApiResult ok() {
        ApiResult result = new ApiResult();
        result.setSuccess(true);
        return result;
    }

    public static ApiResult error() {
        ApiResult result = new ApiResult();
        result.setSuccess(false);
        return result;
    }

    public ApiResult<T> data(T data) {
        this.setData(data);
        return this;
    }

    public ApiResult msgParam(String msgParam) {
        this.setMessage(msgParam);
        return this;
    }

    public ApiResult code(Integer code) {
        this.setCode(code);
        return this;
    }
}

