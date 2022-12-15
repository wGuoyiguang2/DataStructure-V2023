package com.example.demo.thread;

import com.example.demo.entity.Boy;
import com.example.demo.mapper.BoyMapper;
import com.example.demo.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @program: springboot_01
 * @description:  程序中使用的是Callable接口，可以获取线程的返回值
 *                  没有返回值的  用 Runnable 接口
 * @author: guoyiguang
 * @create: 2021-07-11 11:01
 **/
@Slf4j
public class BoyStatisticsTask implements Callable {




    // 偏移量
    private int offSet;


    // 每页显示数量
    private int pageSize;
    // 将实际参数通过构造器传入任务内部
    public BoyStatisticsTask(int offSet,int pageSize) {
        this.offSet = offSet;
        this.pageSize = pageSize;
    }


    @Override
    public Object call() throws Exception {
        // 要执行的任务
        Object boyMapperObj = SpringUtil.getBean("boyMapper");
        BoyMapper boyMapper = (BoyMapper) boyMapperObj;
        List<Boy> list3 = boyMapper.getList3(offSet,pageSize);
        // 设置线程名称
        for (Boy boy : list3) {
            boy.setThreadName(Thread.currentThread().getName());
        }
        return list3;
    }
}
