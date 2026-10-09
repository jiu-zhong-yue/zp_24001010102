package com.recruitment.controller;
import com.recruitment.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Result<String> hello() {
        return Result.success("欢迎来到招聘网站！Spring Boot 3.2 + Java 17");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> systemInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("projectName", "招聘网站");
        info.put("version", "1.0.0");
        info.put("springBootVersion", "3.2.2");
        info.put("javaVersion", System.getProperty("java.version"));
        info.put("serverTime", LocalDateTime.now());
        info.put("status", "运行中");
        return Result.success(info);
    }


    @GetMapping("/health")
    public Result<Map<String, Object>> health() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", "UP");
        data.put("app", "recruitment-website");
        return Result.success(data);
    }


    @GetMapping("/now")
    public Result<String> now() {
        return Result.success(LocalDateTime.now().toString());
    }
}