package com.wmp.office.utils.exception;

import com.wmp.office.enums.FailureEnum;
import com.wmp.office.utils.result.ApiResult;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    HttpServletResponse response;

    @ExceptionHandler(ServiceException.class)
    public ApiResult<Void> serviceException(ServiceException exception){
        //设置code
        HttpStatus httpStatus = exception.getHttpStatus();
        response.setStatus(httpStatus.value());
        //设置body
        FailureEnum failureEnum = exception.getFailureEnum();
        log.info("GlobalExceptionHandler.serviceException code: {},msg: {}",failureEnum.getCode(),failureEnum.getMsg());
        return ApiResult.error().code(failureEnum.getCode()).msgParam(failureEnum.getMsg());
    }

}
