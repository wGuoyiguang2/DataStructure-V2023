package com.example.demo.entity.link;

/**
 * @author guoyiguang   自定义节点
 * @description zidingyijiedian$
 * @date 2022/12/15$
 */

import lombok.Data;

@Data
public class MyNode {

   private String value;


   private MyNode next;

    @Override
    public String toString() {
        return "MyNode{" +
                "value='" + value +
                '}';
    }
}
