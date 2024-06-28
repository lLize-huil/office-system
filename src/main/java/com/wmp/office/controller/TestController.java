package com.wmp.office.controller;

import com.wmp.office.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wmp.office.utils.result.ApiResult;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/environment")
    public ApiResult getEnvironment(@RequestParam("type") Integer type) {
        return testService.getEnvironment(type);
    }


}