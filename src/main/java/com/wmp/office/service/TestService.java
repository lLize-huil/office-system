package com.wmp.office.service;

import com.wmp.office.dto.vo.TestVo;
import com.wmp.office.enums.FailureEnum;
import com.wmp.office.mapper.TestMapper;
import com.wmp.office.utils.BaseUtil;
import com.wmp.office.utils.exception.ServiceException;
import com.wmp.office.utils.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TestService extends BaseUtil {

    @Value("${spring.datasource.url}")
    String datasource;

    @Autowired
    TestMapper testMapper;

    public ApiResult<TestVo> test(Integer type) {
        if(type.equals(1)){
            TestVo vo = new TestVo();
            vo.setDataSource("连接数据库:" + datasource);
            vo.setTableCount("表数量:"+ testMapper.selectTableCount());
            return success(vo);
        }
        throw new ServiceException(FailureEnum.SYSTEM_INNER_ERROR, HttpStatus.BAD_REQUEST);
    }


}
