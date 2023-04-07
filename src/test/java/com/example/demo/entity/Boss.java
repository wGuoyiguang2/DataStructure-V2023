package com.example.demo.entity;

import com.mysql.cj.conf.BooleanProperty;
import com.mysql.cj.conf.IntegerProperty;
import com.mysql.cj.conf.LongProperty;
import com.mysql.cj.conf.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-01-10 15:21
 **/
public class Boss {
    private String name;
    private Integer age;

    public Boss() {
    }

    public Boss(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boss boss = (Boss) o;
        return Objects.equals(name, boss.name) &&
                Objects.equals(age, boss.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }





}
