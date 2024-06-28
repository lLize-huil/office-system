package com.wmp.office.utils.exception;

import com.wmp.office.enums.FailureEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * service 层异常处理
 */
@Getter
public class ServiceException extends RuntimeException {

    private final FailureEnum failureEnum;

    private final HttpStatus httpStatus;

    /**
     * failureEnum HTTP返回Body值
     * httpStatus HTTP返回code值
     */
    public ServiceException(FailureEnum failureEnum, HttpStatus httpStatus) {
        super(failureEnum.getMsg());
        this.failureEnum = failureEnum;
        this.httpStatus = httpStatus;
    }

}
