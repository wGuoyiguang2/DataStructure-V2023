package com.example.demo;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;


/**
 * 功能描述 : 排序算法
 * @author guoyiguang
 * @date 2022/12/28
 * @param
 * @return
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SortApplicationTests {







    /**
     * 功能描述 ： 冒泡排序
     * @author guoyiguang
     * @date 2023年1月3日15:38:00
     * @param
     * @return
     */
    @Test
    public void testLocalDateTime() {

        bubbleSort();


    }



    /**
     * 功能描述 : 冒泡排序 :假如数组长度是 n
     *           冒泡排序 ：
     *                    外循环n-1 次
     *                   每一次内for循环 将最大的数放到最后面（相对于前面数的最后，不一定是真正的最后，第一次外循环是放到最后）
     * @author guoyiguang
     * @date 2023/1/3
     * @param
     * @return
     */
    public  void bubbleSort(){

        int[] arr = { 44, 3, 38,5};
//      第一次 for 循环：     3,  38, 5 , 44  （产生了一个最大值 44）
//      第二次 for 循环：     3,  5 , 38, 44  （产生了一个最大值 38）
//      第三次 for 循环：     3,  5 , 38, 44  （产生了一个最大值 5）

       // int[] arr = { 44, 3, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};


        for(int m = 0; m< arr.length-1 ;m++ ){

            // 一个for 内循环 全部执行完，会产生一个最大值
            // 要所有元素排序，需要执行 n-1 次
            for(int i=0;i < arr.length-1 ;i++){
                // 定义一个临时变量 存放 较大值
                int tem ;
                // 相邻的两个元素两两比对，产生一个最大值
                if(arr[i] > arr[i+1]  ){
                    tem = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]= tem;
                }
            }
        }



        System.out.println(arr);
        System.out.println(arr);



    }

    public  void bubbleSortV2(){

        int[] arr = { 44, 3, 38,5};
//      第一次 for 循环：     3,  38, 5 , 44  （产生了一个最大值 44），  下次内循环只需要 循环到 下标2
//      第二次 for 循环：     3,  5 , 38, 44  （产生了一个最大值 38）    下次内循环只需要 循环到 下标1
//      第三次 for 循环：     3,  5 , 38, 44  （产生了一个最大值 5）

        // int[] arr = { 44, 3, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};


        for(int m = 0; m< arr.length-1 ;m++ ){

            // 一个for 内循环 全部执行完，会产生一个最大值
            // 要所有元素排序，需要执行 n-1 次(此处优化代码)
            for(int i=0;i < arr.length-1-m ;i++){
                // 定义一个临时变量 存放 较大值
                int tem ;
                // 相邻的两个元素两两比对，产生一个最大值
                if(arr[i] > arr[i+1]  ){
                    tem = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]= tem;
                }
            }
        }



        System.out.println(arr);
        System.out.println(arr);



    }






}
