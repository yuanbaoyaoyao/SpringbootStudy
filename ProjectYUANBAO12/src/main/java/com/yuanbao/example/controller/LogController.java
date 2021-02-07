package com.yuanbao.example.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "LogController",description = "Log测试")
@RestController
public class LogController {
    @GetMapping("/test")
    public String showLog(){
        log.warn("日志测试");
        return "ok";
    }
}
