package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author guoyiguang
 * @description $
 * @date 2023/4/11$
 */
@RestController
@RequestMapping("/collectionController")
public class CollectionController {


    public static void main(String[] args) {
        listToAnotherList();
    }


    public static void MapOf(){

        Map<Integer, String> integerStringMap = Map.of(1, "1", 2, "2");
        System.out.println(integerStringMap);
        integerStringMap.put(1,"11");
        System.out.println(integerStringMap);

    }




    /**
     * 功能描述: 将一个List 转成 另一个list
     * @author guoyiguang
     * @date 2023/12/19
     * @param
     * @return
     */
    public static void listToAnotherList(){

        List<Map<String,Object>> list  = new ArrayList<>();
        Map<String,Object> map  =  new HashMap<>();
        map.put("name","a");
        map.put("age",10);
        list.add(map);

        Map<String,Object> map2  =  new HashMap<>();
        map2.put("name","b");
        map2.put("age",10);
        list.add(map2);

        Map<String,Object> map3  =  new HashMap<>();
        map3.put("name","c");
        map3.put("age",6);
        list.add(map3);

        Map<String,Object> map4  =  new HashMap<>();
        map4.put("name","d");
        map4.put("age",6);
        list.add(map4);

        List<Map<String, Object>> collect = list.stream().map(e -> {
            Map<String, Object> m = new HashMap<>();
            m.put("name", e.get("name"));
            m.put("age", e.get("age"));
            // 返回的 元素 也可以是对象
            return m;
        }).collect(Collectors.toList());

        //   [{name_hh=三, age=10}, {name_hh=四, age=6}]
        System.out.println(collect);

        Collections.sort(collect,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Map o11 = (Map) o1;
                Map o21 = (Map) o2;
                // 约定：  o11 物理位置 在前 ，o21 在后， o11 小， o21 大 ，返回-1 ,不换位置
                return (int)o11.get("age") - (int)o21.get("age");
            }
        });
        System.out.println("升序： java 8 之前"+collect);

        // 升序版本1 java8 写法： javaUtils 包下的 Collections类
        Collections.sort(collect,((o1, o2) ->(int)o1.get("age") - (int)o2.get("age") ));

        System.out.println("升序： java 8 之后 v1"+collect);
        // comparingInt 这个函数式接口的定义: int applyAsInt(T value),接收一个 入参T ，返回一个出参 int，下例 的 (int)e.get("age")  是
        // 函数式接口的实现
        Collections.sort(collect, Comparator.comparingInt(e->(int)e.get("age")));

        System.out.println("升序： java 8 之后 v2"+collect);
        collect.sort(Comparator.comparingInt(e->(int)e.get("age")));

        System.out.println("升序： java 8 之后 v3"+collect);

        // 降序
        Collections.sort(collect,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Map o11 = (Map) o1;
                Map o21 = (Map) o2;
                // 约定：  o11 物理位置 在前 ，o21 在后， o11 小， o21 大 ，返回1 ,换位置
                return (int)o21.get("age") - (int)o11.get("age");
            }
        });
        System.out.println("降序： java 8 之前"+collect);

        // 降序版本1 java8 写法： javaUtils 包下的 Collections类
        Collections.sort(collect,((o1, o2) ->(int)o2.get("age") - (int)o1.get("age") ));

        System.out.println("降序： java 8 之后 v1"+collect);

        collect.sort(((o1, o2) ->(int)o2.get("age") - (int)o1.get("age") ));

        System.out.println("降序： java 8 之后 v2"+collect);

        // 多属性排序：

        //  多属性排序： java8 之前

        Collections.sort(collect,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Map o11 = (Map) o1;
                Map o21 = (Map) o2;
                int o1Age = (int) o11.get("age");
                int o2Age = (int) o21.get("age");
                // 如果年龄一样，则按照 name 降序
                if(o1Age == o2Age){
                    String o1Name = (String) o11.get("name");
                    String o2Name = (String) o21.get("name");
                    //   约定：  o11 物理位置 在前 ，o21 在后， o11 小， o21 大 ，返回 1 , 换位置
                    return  o2Name.compareTo(o1Name);
                }
                // 约定：  o11 物理位置 在前 ，o21 在后， o11 小， o21 大 ，返回-1 ,不换位置
                return o1Age - o2Age;
            }
        });
        System.out.println("多属性排序 age 升序，age一样的话，name 降序： java 8 之前 "+collect);

        //  多属性排序： java8 之后

        final List<Map<String, Object>> collect1 = collect.stream().sorted((o1, o2) -> {
            Map o11 = (Map) o1;
            Map o21 = (Map) o2;
            int o1Age = (int) o11.get("age");
            int o2Age = (int) o21.get("age");
            if (o1Age == o2Age) {
                String o1Name = (String) o11.get("name");
                String o2Name = (String) o21.get("name");
                //   约定：  o11 物理位置 在前 ，o21 在后， o11 小， o21 大 ，返回 1 , 换位置
                return o2Name.compareTo(o1Name);
            }

            return (int) o1.get("age") - (int) o2.get("age");
        }).collect(Collectors.toList());

        System.out.println("多属性排序 age 升序，age一样的话，name 降序： java 8 之后v1 "+collect1);


        //  多属性排序： java8 之后 v2
      List<Map<String,Object>>  collectV2 = collect.stream()
                .sorted(
                        // 静态方法默认是 升序的
                        Comparator.comparing(e->{Map m =  (Map)e; return  (int)m.get("age") ;}).reversed()
                                // age一样的话 ,比较 name 降序
                               .thenComparing(e->((Map)e).get("name").toString()).reversed()
                ).collect(Collectors.toList());

        System.out.println("多属性排序 age 升序，age一样的话，name 降序： java 8 之后v2 "+collectV2);



    }




}
