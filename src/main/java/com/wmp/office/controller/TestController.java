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

    @GetMapping("/test")
    public ApiResult test(@RequestParam("type") Integer type) {
        return testService.test(type);
    }


}