package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2023年10月30日11:43:33
 **/

@RestController
public class CompletableFutureController {



    @RequestMapping("/completablefuture/hello")
    public String hello(){

        return "success";
    }
}
