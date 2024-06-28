package com.wmp.office.service;

import com.wmp.office.enums.FailureEnum;
import com.wmp.office.utils.BaseUtil;
import com.wmp.office.utils.exception.ServiceException;
import com.wmp.office.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestService extends BaseUtil {

    @Value("${spring.datasource.url}")
    String datasource;

    public ApiResult getEnvironment(Integer type) {
        if(type.equals(1)){
            return success("连接数据库：" + datasource);
        }
        throw new ServiceException(FailureEnum.SYSTEM_INNER_ERROR, HttpStatus.BAD_REQUEST);
    }


}
