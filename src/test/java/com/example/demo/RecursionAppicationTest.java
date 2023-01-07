package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guoyiguang
 * @description 递归$
 * @date 2023/1/7$
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecursionAppicationTest {



    /**
     * 递归的适用场景：
     *    ①重复性的操作/重复性的计算逻辑
     *    ②有停止重复操作或者重复计算的条件
     *
     *    比如斐波那契-卢卡斯数列,树的递归，折半查找 等
     *
     *    斐波那契-卢卡斯数列数列定义如下
     *
     *  斐波那契（fibonacciSequence）数列1，1，2，3，5，8…，和卢卡斯（LucasSequence）数列1，3，4，7，11，18…，
     *
     *     斐波那契（fibonacci）数列1，1，2，3，5，8…，和卢卡斯（Lucas）数列1，3，4，7，11，18…，
     *       具有相同的性质：从第三项开始，每一项都等于前两项之和，我们称之为斐波那契—卢卡斯递推。
     *       凡符合斐波那契—卢卡斯递推的数列就称为斐波那契—卢卡斯数列
     *
     *
     */


    @Test
    public void recursionTest() {

//        int fibonacciSequenceInt = fibonacciSequence(5);
//        int lucasSequenceInt=   lucasSequence(5);
        System.out.println();


    }


    /**
     * 功能描述 :
     *
     * 斐波那契（fibonacciSequence）数列 1，1，2，3，5，8…，
     *
     *  下标：   0   ，1   ，2  ，3  ，4  ，5
     *  value：1  ， 1    ，2  ，3 ，5  ，8
     *  结论： 后面一个value是前面两个数的和 ，即
     *        f（n）=  f（n-1）+f（n-2）
     *
     *                而 f（n-1）=  f（n-2）+f（n-3）= f(0)
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */
    public int fibonacciSequence(int index){
        // 前两个数（终止条件）
        if(index == 0 || index==1){
            return  1 ;
        }

        // 有点类似  分而治之的思想，最后将两个结果合并就是 要求的值（每一个 index 对应的value是这样算的，重复的逻辑）
       return  fibonacciSequence(index-1)+fibonacciSequence(index-2);

    }


    /**
     * 功能描述 : 卢卡斯数列
     *          1,3,4,7
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */
    public int lucasSequence(int index){
        // index 为 0（终止条件）
        if(index == 0){
            return  1 ;
        }

        // index 为 1（终止条件）
        if(index == 1){
            return  3 ;
        }

        // 有点类似  分而治之的思想，最后将两个结果合并就是 要求的值（每一个 index 对应的value是这样算的，重复的逻辑）
        return  lucasSequence(index-1)+lucasSequence(index-2);

    }














}
