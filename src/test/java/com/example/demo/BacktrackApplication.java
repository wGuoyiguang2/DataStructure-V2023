package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 回溯su：
 *       回溯：横向收缩，纵向组合
 *
 *       回溯最⼤的好处是有⾮常明确的模板，所有的回溯都是⼀个⼤框架，因此透彻理解回溯的框架是解决⼀切回溯问题
 *       的基础。回溯不是万能的，⽽且能解决的问题也是⾮常明确的，例如组合、分割、⼦集、排列，棋盘等等
 *
 *       解题模板：
 *
 *       void backtracking(参数) {
 *         if (终⽌条件) {
 *          存放结果;
 *           return;
 *         }
 *          for (选择本层集合中元素（画成树，就是树节点孩⼦的⼤⼩）){
 *          处理节点;
 *          backtracking();
 *          回溯，撤销处理结果;
 *         }
 *  }
 *
 * @author guoyiguang
 * @description $
 * @date 2023/2/8$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BacktrackApplication {


    /**
     * 功能描述
     *
     *  LeetCode77 ：给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。例如，输⼊n=4，k=2，则输出：
     *  [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
     *
     *   分析：四个里面选两个
     *        1  2  3  4
     *
     *        1:            2 :      3           4
     *
     *      [2,3,4]       [ 3,4]    [4]         无
     * @date 2023/2/8
     */
    @Test
    public void leetCode77Main() {

        List<List<Integer>> result = new ArrayList<>();
        for(int i =1; i<=4 ;i++){
            leetCode77(i,4,result ,0);
        }

        System.out.println(result);
        System.out.println(result);


    }


    public void  leetCode77(int current,int max,List<List<Integer>> result,int depth){

        // 终止条件
        if(depth >1 ){
            return ;
        }

        // 相似的逻辑

        for(int i =current+1; i <=max ;i++){
            List<Integer> sonResult = new ArrayList<>();

            sonResult.add(current);
            sonResult.add(i);
            result.add(sonResult);

            //
            leetCode77(i,max,result,depth++);

        }


    }











}
