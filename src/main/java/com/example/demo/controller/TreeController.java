package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
@RequestMapping("/factoryModel")
public class TreeController {



    @RequestMapping("/getTree")
    public List<Map> getTree(Map para){


        Map f = new HashMap();
        f.put("name","单位");
        f.put("uid","1");
        f.put("parent_uid","0");

        Map son = new HashMap();
        son.put("name","单位_");
        son.put("uid","2");
        son.put("parent_uid","1");

        Map son3 = new HashMap();
        son3.put("name","单位_SON_2");
        son3.put("uid","5");
        son3.put("parent_uid","2");


        Map f2 = new HashMap();
        f2.put("name","工厂");
        f2.put("uid","3");
        f2.put("parent_uid","0");

        Map son2 = new HashMap();
        son2.put("name","工厂_JE");
        son2.put("uid","4");
        son2.put("parent_uid","3");




        List<Map> list = new ArrayList<>();
        list.add(f);
        list.add(son);
        list.add(f2);
        list.add(son2);
        list.add(son3);

        // 模糊查询
        if(null != para.get("name") && para.get("name").toString().length() > 0){
            // ① 模糊查询 ： 目标 SON
            List<Map> targetDataList = list.stream().filter(e -> e.get("name").toString().contains(para.get("name").toString())).collect(Collectors.toList());

            // ② 找父
            Set<Map> targetParentSet  = new HashSet<>();

            getRootList(targetDataList, list,  targetParentSet);

            // 目标数据+父
            List<Map>  list0 = new ArrayList<>();
            for(Map map :targetParentSet){
                if(!list0.contains(map)){
                    list0.add(map);
                }
            }
            for(Map map :targetDataList){
                if(!list0.contains(map)){
                    list0.add(map);
                }
            }

            List<Map> likeRootList = list0.stream().filter(e -> e.get("parent_uid").toString().equals("0")).collect(Collectors.toList());

            List<Map> factoryTree = getFactoryTree(likeRootList, list0);
            return factoryTree;
        }else{
            // 获取root
            List<Map> rootList = list.stream().filter(e -> e.get("parent_uid").toString().equals("0")).collect(Collectors.toList());
            List<Map> factoryTree = getFactoryTree(rootList, list);

            return factoryTree;
        }

    }


    public  List<Map>  getFactoryTree(List<Map> rootList ,List<Map> allFactories){

        if(CollectionUtils.isEmpty(rootList)){
            return new ArrayList<>();
        }

        for(Map root : rootList){
            List<Map> sonList = allFactories.stream().filter(e -> e.get("parent_uid").toString().equals(root.get("uid").toString())).collect(Collectors.toList());
            if(!CollectionUtils.isEmpty(sonList)){
                root.put("children",sonList);
                getFactoryTree(sonList, allFactories);
            }

        }
        return rootList;

    }


    public  Set<Map>  getRootList(List<Map> sonList ,List<Map> allFactories,Set<Map> targetParentSet){

        if(CollectionUtils.isEmpty(sonList)){
            return targetParentSet;
        }

        for(Map son : sonList){
            List<Map> patentList = allFactories.stream().filter(e -> e.get("uid").toString().equals(son.get("parent_uid").toString())).collect(Collectors.toList());

            if(!CollectionUtils.isEmpty(patentList) && null !=patentList.get(0) && !targetParentSet.contains(patentList.get(0)) ){
                targetParentSet.add(patentList.get(0));
            }
            getRootList(patentList, allFactories,targetParentSet);

        }
        return targetParentSet;

    }




}
