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

        //bubbleSort();

        // 插入排序
        insertSort();


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



    /**
     * 功能描述  插入排序
     *
     * 数组中的数据分为两个区间： 未排序区间和已排序区间
       初始已排序区间只有一个元素，就是数组中的第一个元素。

       插入算法的核心思想：
     * 取未排序区间中的元素，在已排序区间中找合适的插入位置将其插入（未排的元素大于左边紧挨着的元素即可），并保证已排序区间数据一直有
     * 序。重复这个过程，直到未排序区间中元素为空，算法结束。
     * @author guoyiguang
     * @date 2023/1/3
     * @param
     * @return
     */
    public  void insertSort(){


        // 特殊情况
        // int[] arr = {44, 3};
        // int[] arr = {44, 3, 38,5};
//      第一次 for 循环：    44,  3,38,5   --->   (3),44,   38,5  （已排序：3,44 ；未排 38, 5 ）
//      第二次 for 循环：    3,44,   38,5   ---> 3,(38),44,     5  （已排序：3,  ,44 ；未排   5 ）
//      第三次 for 循环：    3,38,44,  5    ---> 3,(5)，38,44       （已排序：3,5，38，44 ；未排  0 ）  需要循环  n-1次

        //int[] arr = {5,4, 3, 2, 1};
//        第一次 for   5,   4, 3, 2, 1 ---> (4),5,        3, 2, 1
  //      第二次 for   (4),5,    3, 2, 1 ---> (3),(4),5,     2, 1


         //int[] arr = { 44, 3, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
         //int[] arr = { 44, 3, 38, 5, 47, 15};
        int[] arr={10,6,9,3,5};

        //未排序区间
        for(int m = 1;m <= arr.length-1;m++){
            // 临时变量存储 相对的 定值
            int value = arr[m];

            // 已排序区间
            // 当前元素和 前面元素依次比较
            int n =m-1 ;
            for(; n >= 0 ;n--){
                // value 未排序的当前元素；arr[n] 已排区间元素
                if( arr[n] > value){
                    // 将前面元素 大于 当前元素的 下标 右移
                    arr[n+1] = arr[n] ;

                }else{
                    //  当前元素 开始大于 有序区间的 值
                    break;
                }

            }

            // 寻找插入的位置
            arr[n+1] = value  ;

        }



        System.out.println(arr) ;
        System.out.println(arr) ;

    }






}
