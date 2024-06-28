package com.wmp.office.utils;

import com.wmp.office.enums.FailureEnum;
import com.wmp.office.utils.exception.ServiceException;
import com.wmp.office.utils.result.ApiResult;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * controller 基类
 * @author liuph
 */
public class BaseUtil {

    /**
     * @Author: lizehui
     * @Description: Date类型转换为时间戳字符串
     * @Date: 2024/3/23 19:28
     */
    public String DateToTimeStamp(Date date){
        long timestamp = date.getTime();
        return Long.toString(timestamp);
    }

    /**
     * @Author: lizehui
     * @Description: 比较两个日期时间的方法
     * comparison < 0 dateTime1String 早于 dateTime2String
     * comparison > 0 dateTime1String 晚于 dateTime2String
     * comparison = 0 dateTime1String 等于 dateTime2String
     * @Date: 2024/2/18 20:08
     */
    public static Integer compareDateTime(String dateTime1String, String dateTime2String) {
        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime1;
        LocalDateTime dateTime2;
        // 解析字符串为 LocalDateTime 对象
        try {
            dateTime1 = LocalDateTime.parse(dateTime1String, formatter);
            dateTime2 = LocalDateTime.parse(dateTime2String, formatter);
        }catch (Exception e){
            throw new ServiceException(FailureEnum.TIME_FORMAT_ERROR, HttpStatus.UNAUTHORIZED);
        }

        // 比较两个日期时间
        int comparison = dateTime1.compareTo(dateTime2);
        return comparison;
    }


    /**
     * @Author: lizehui
     * @Description: 年-月-日 时:分:秒 转换为 Date
     * @Date: 2023/12/18 10:29
     */
    public static Date StringToTimeStamp(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(time);
        }catch (Exception e){
            throw new ServiceException(FailureEnum.TIME_FORMAT_ERROR, HttpStatus.UNAUTHORIZED);
        }

    }

    /**
     * @Author: lizehui
     * @Description: Date 转换为 年-月-日 时:分:秒
     * @Date: 2023/12/18 10:29
     */
    public static String TimeStampToString(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }

    /**
     * 响应成功（无返回数据）
     * @author liupenghao
     * @return ApiResult
     */
    protected ApiResult<Void> success() {
        return ApiResult.ok().code(200);
    }

    /**
     * 响应成功（有返回数据）
     * @author liupenghao
     * @param data 返回数据
     * @return ApiResult
     */
    protected <T> ApiResult<T> success(T data) {
        return ApiResult.ok().code(200).data(data);
    }

    /**
     * 响应失败（无提醒消息）
     * @author liupenghao
     * @return ApiResult
     */
    protected ApiResult failure(){
        return ApiResult.error();
    }

}
