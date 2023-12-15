package com.example.demo.controller;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2023年10月30日11:43:33
 **/

@RestController
public class SortController {


    public static void main(String[] args) {



        // 实现一个功能：类似 sql的  order by age,name  (age 一样的话，再按照 name 排序)
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","c");
        map1.put("age",12);
        list.add(map1);


        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","b");
        map2.put("age",12);
        list.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("name","a");
        map3.put("age",12);
        list.add(map3);

        Map<String,Object> map4 = new HashMap<>();
        map4.put("name","a");
        map4.put("age",11);
        list.add(map4);


        Map<String,Object> map5 = new HashMap<>();
        map5.put("name","b");
        map5.put("age",11);
        list.add(map5);


        Map<String,Object> map6 = new HashMap<>();
        map6.put("name","c");
        map6.put("age",11);
        list.add(map6);

        Map<String,Object> map7 = new HashMap<>();
        map7.put("name","a");
        map7.put("age",10);
        list.add(map7);



        Map<String,Object> map8 = new HashMap<>();
        map8.put("name","b");
        map8.put("age",10);
        list.add(map8);

        Map<String,Object> map9 = new HashMap<>();
        map9.put("name","c");
        map9.put("age",10);
        list.add(map9);


        // 错误的处理方式： 本质 是先按照 name 排序，name 一样再按照 age 排序
        List<Map<String, Object>> wrongSortedList   = list.stream().sorted(Comparator.comparing(
                m -> (Integer)((Map)m).get("age")
        ))
                .sorted(Comparator.comparing(
                        m -> ((Map)m).get("name").toString()
                ))

           .collect(Collectors.toList());
        // [{name=a, age=10},
        // {name=a, age=11},
        // {name=a, age=12},
        // {name=b, age=10},
        // {name=b, age=11},
        // {name=b, age=12},
        // {name=c, age=10},
        // {name=c, age=11},
        // {name=c, age=12}]
        //

        System.out.println(" sorted :wrongSortedList"+wrongSortedList.toString());

        List<Map<String, Object>> thenComparingSortedList   = list.stream().sorted(Comparator.comparing(
                m -> (Integer)((Map)m).get("age")
                // thenComparing : age 一样的时候，再按照name 排序
        ).thenComparing(
                m -> ((Map)m).get("name").toString()
        ))
                .collect(Collectors.toList());
        // [{name=a, age=10},
        // {name=b, age=10},
        // {name=c, age=10},
        // {name=a, age=11},
        // {name=b, age=11},
        // {name=c, age=11},
        // {name=a, age=12},
        // {name=b, age=12},
        // {name=c, age=12}]
        //
        System.out.println(" thenComparing :thenComparingSortedList"+thenComparingSortedList.toString());



//    约定：位置  i1 在前，i2 在后,默认   i1 值小，i2 值大
//    i1.compareTo(i2) > 0 , i1 大 ,降序
//    i1.compareTo(i2) < 0 ,i1 小 ,升序
//          此时若我们要定义升序，则使此方法的返回值为小于0，则可return i1 - i2；
//          此时若我们要定义降序，则使此方法的返回值为大于0（大于0 会交换两个元素的位置），则可return i2 - i1；
//
//        public int compare(int i1,int i2){
//    ...
//        }
//        可以简单的理解为，
//        正数负数控制着两个元素是否进交换，如果是正数，就交换两个元素，如果是负数或者零，就不进行交换，同时o1和o2代表了其在数组中的相对顺序，o1在前，o2在后。

        // 需求： 先按照 age 升序，age一样，再按照 name 降序
        Collections.sort(list, new Comparator<Object>() {
            public int compare(Object arg0, Object arg1) {
                Map<String,Object> a0 = (Map) arg0;
                Map<String,Object> a1 = (Map) arg1;
                if( ObjectUtil.isNotEmpty(a0.get("name")) && ObjectUtil.isNotEmpty(a0.get("age")) &&
                        ObjectUtil.isNotEmpty(a1.get("name")) && ObjectUtil.isNotEmpty(a1.get("age"))

                ){
                    Integer a0Gr = (Integer) a0.get("age");
                    Integer a1Gr = (Integer) a1.get("age");
                    if(a0Gr == a1Gr ){
                        String a0Name = a0.get("name").toString();
                        String a1Name = a1.get("name").toString();
                        // 降序，return 1, i1 - i2
                        return a1Name.compareTo(a0Name);
                    }else{
                        // 升序,return -1 ,  i1 - i2
                         return a0Gr-a1Gr;
                    }

                }
                return 0;
            }});

        // [{name=c, age=10},
        // {name=b, age=10},
        // {name=a, age=10},
        // {name=c, age=11},
        // {name=b, age=11},
        // {name=a, age=11},
        // {name=c, age=12},
        // {name=b, age=12},
        // {name=a, age=12}]

        System.out.println(" compare :list"+list.toString());


    }







}
