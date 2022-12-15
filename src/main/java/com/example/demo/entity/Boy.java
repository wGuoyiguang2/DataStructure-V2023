package com.example.demo.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-14 14:43
 **/
@Data
public class Boy   implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;
    private String sex2;
    private String createdTimeStr;
    private String chaodai;
    private Integer sex;
    // 新增加 的 属性
    private String newAttr;

    // 新增另一个 的 属性
    private String newAttr2;

    // 线程名称
    private String threadName;

}
