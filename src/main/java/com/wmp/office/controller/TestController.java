package com.wmp.office.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/test")
@RestController
public class TestController {


    @GetMapping("/get")
    public ResponseResult get() {
        return ResponseResult.okResult();
    }


}