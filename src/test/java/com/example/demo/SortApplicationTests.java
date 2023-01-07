package com.example.demo;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;


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
        //insertSort();

        // 选择排序
        // selectionSort();

        // 合并有序数组
       // mergeSortArrayTest();


        // 归并排序  TODO 目前的写法有问题
       // mergeSort();

        // 快速排序(用到了双指针算法，不需要开辟新的内存空间)
//        int[] array = {11,4,8,2,10 };
//        int[] ints = quickSort(array, 0, 4);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(ints));


        // 折半查找(二分查找) ：前提：数据是已经提前排好顺序的

        int[] arraybinarySearch = {1,3,5,7,9,10 };
//        int binarySearchIndex = binarySearch(arraybinarySearch, 0, 6, 10);
//        System.out.println(binarySearchIndex);


        // 非递归 折半查找
        int binarySearchNoRecursionInt = binarySearchNoRecursion(arraybinarySearch, 10);
        System.out.println(binarySearchNoRecursionInt);


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
                // 定义一个临时变量 存放 较大值(数组内两个元素互换位置一般需要引入一个临时变量)
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
     *
     *    目标：
     *
     *        将未排序里的元素 在 已排序区间里找到对应的位置，即 只需要找到 已排序区间 下标 为 n 的元素 小于 目标值，
     *         那么目标值的下标为  n +1 , 转化为 找 下标 n 即可
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

            // 寻找插入的位置（数组的插入代码）
            arr[n+1] = value  ;

        }



        System.out.println(arr) ;
        System.out.println(arr) ;

    }



    /**
     * 功能描述 ： 选择排序
     *      选择 未排序区间最小的值扔到 已排序区间左边（左一，左二等）
     *
     *  思想：选择排序也是划分为已排序区间和未排序区间
     *       每次从未排序区间中找到最小的元素，将其放到已排序区间的末尾
     *
     * 描述：
     *       在一个长度为 N 的无序数组中，第一次遍历 n-1 个数找到最小的和第一个数交换。
     *       第二次从下一个数开始遍历 n-2个数，找到最小的数和第二个数交换。
     *       重复以上操作直到第 n-1 次遍历最小的数和第 n-1 个数交换，排序完成。
     *
     *
     * @author guoyiguang
     * @date 2023/1/3
     * @param
     * @return
     */
    public  void selectionSort(){

         // int[] arr = {44, 3, 38,5};
//      第一次 for 循环：    44,3,38,5   --->   找出 3 放到已排区间里 （已排序：3    ；未排 ,44,38,5  ）
//      第二次 for 循环：    3,  44,38,5  ---> 找出 5 放到已排区间里     5  （已排序：3,5   ；未排 44,38    ）
//      第三次 for 循环：    3,5 38,44,      ---> 找出 38 放到已排区间里  （已排序：3,5，38， ；未排  44 ）  需要循环  n-1次



        int[] arr = {6, 5, 4,3,2,1};

        //已排序区间
        for(int m = 0 ;m <=arr.length-1;m++){
            //  m 的位置存放 未排序区间的最小值,所以 遍历 数组获取 未排序区间的最小值
            int min = arr[m];
            int n1=m ;
            for(int n = m; n <=arr.length-1 ;n++ ){
                if(min > arr[n]){
                    min = arr[n];
                    n1 = n;
                }
            }



            // {5,6}
            // 互换位置
            // 之前的A位置
            arr[n1] =  arr[m];

            //  已排序区间 插入最大值A
            arr[m] = min;



    }

        System.out.println("--------------------start------------------");
        Arrays.toString(arr);
        System.out.println("--------------------end------------------");
    }




    /**
     *
     * 功能描述：合并两个有序序列
     *        将两个有序的数组合并 成一个有序的大数组(归并排序中合并的思想)
     *
     *        思路 ：
     *             将 aArray 和   bArray 数组的元素两个两个比较，选出最小的
     *             同时最小值 所在数组的下标右移动一个，继续比较
     *
     *          int[] aArray = {1, 3, 5,7,9,11};
     *          int[] bArray = {2, 4, 6,8,10};
     *
     *          aArray 的  1 和  bArray的 2 比较 ，1 小 ，右移动1位，3和2比较，2小， bArray 下标移动一位，4 和 3 比较
     *
     *          值小的 所在数组下标 要+1 ,继续比较，整个过程中，注意下标越界问题
     *
     * @author guoyiguang
     * @date 2023/1/3
     * @param
     * @return
     */
    public  void mergeSortArrayTest(){

         int[] aArray = {1, 3, 5,7,9,11}; // 11
         int[] bArray = {2, 4, 6,8,10};

        int[] combineArray = new int[aArray.length+bArray.length];

        // a 数组下标变量
        int aIndex = 0;

        // b 数组下标变量
        int bIndex = 0;


        for(int i = 0 ;i <=(aArray.length+bArray.length-1) ;i++){

            // aArray 中  a 和   bArray 中 b 下标的最小值

            //  aArray 数组和  bArray 数组 里元素 都没有 用尽
            if(aIndex <= aArray.length-1 &&  bIndex <= bArray.length-1){
                if(aArray[aIndex] < bArray[bIndex]){
                    combineArray[i] =  aArray[aIndex];
                    aIndex++;
                }else{
                    combineArray[i] =  bArray[bIndex];
                    bIndex++;
                }
                //  aArray 数组 没有耗尽， bArray 耗尽
            }else if(aIndex <= aArray.length-1 &&  bIndex > bArray.length-1){
                combineArray[i] =  aArray[aIndex];
                aIndex++;

                //  aArray 数组  耗尽， bArray 没有耗尽
            }else if(aIndex > aArray.length-1 &&  bIndex <= bArray.length-1){
                combineArray[i] =  bArray[bIndex];
                bIndex++;
            }else{
                // 同时耗尽，不管
            }


        }


        System.out.println("--------------------start------------------");
        Arrays.toString(combineArray);
        System.out.println("--------------------end------------------");
    }



    /**
     * 功能描述 : 归并排序
     *          分治思想和递归
     *
     *
     *          分支思想：
     *          将一个数组一分为二（具体分几次不清楚，但是 分成 数组里元素只有一个，是 重复性的计算可以考虑递归），
     *          将这两个数组分别排序，
     *          最后将结果合并
     *
     * @author guoyiguang
     * @date 2023/1/5
     * @param
     * @return
     */
    public void  mergeSort(){
        int[] array = { 44, 3, 38,5};
        splitArray(array);

    }


    /**
     * 功能描述 : 有问题 ， 待看
     * @author guoyiguang
     * @date 2023/1/6
     * @param
     * @return
     */
    public int[] splitArray(int[] array){
//        if(array.length == 1 ){
//            return  array ;
//        }
//        //   array 最少两个元素
//        int  middle  =  (array.length-1)/2;
//
//        //  int mid = (start + end) / 2  ;
//
//
//
//
//        // 未排序的左部分
//        int [] left =Arrays.copyOfRange(array, 0 , middle );
//        // 未排序的右部分
//        int [] right =Arrays.copyOfRange(array, middle, array.length );
//        System.out.println("a");
//
//        // 拆分左半部分
//        left = splitArray(left);
//
//        // 拆分右半部分
//        right = splitArray(right);
//
//        int[] ints = mergeArray(left, right);
//        System.out.println("--------------------start------------------");
//        Arrays.toString(ints);
//        System.out.println("--------------------end------------------");


    //    return ints;
        return null;


    }


    public int[]  mergeArray(int[] aArray,int[] bArray){
        int[] combineArray = new int[aArray.length+bArray.length];

        // a 数组下标变量
        int aIndex = 0;

        // b 数组下标变量
        int bIndex = 0;


        for(int i = 0 ;i <=(aArray.length+bArray.length-1) ;i++){

            // aArray 中  a 和   bArray 中 b 下标的最小值

            //  aArray 数组和  bArray 数组 里元素 都没有 用尽
            if(aIndex <= aArray.length-1 &&  bIndex <= bArray.length-1){
                if(aArray[aIndex] < bArray[bIndex]){
                    combineArray[i] =  aArray[aIndex];
                    aIndex++;
                }else{
                    combineArray[i] =  bArray[bIndex];
                    bIndex++;
                }
                //  aArray 数组 没有耗尽， bArray 耗尽
            }else if(aIndex <= aArray.length-1 &&  bIndex > bArray.length-1){
                combineArray[i] =  aArray[aIndex];
                aIndex++;

                //  aArray 数组  耗尽， bArray 没有耗尽
            }else if(aIndex > aArray.length-1 &&  bIndex <= bArray.length-1){
                combineArray[i] =  bArray[bIndex];
                bIndex++;
            }else{
                // 同时耗尽，不管
            }


        }

        return combineArray ;

    }


    /**
     * 功能描述 : 快速排序(重复性操作 且有终止条件就可以考虑用 递归)
     *
     * 用到了：双指针算法（不需要开辟额外空间）
     *       难点： 两个元素之间互换位置（用了双指针算法）
     *
     * @author guoyiguang
     * @date 2023/1/6
     * @param
     * @return
     */
    public int[]  quickSort(int[] array ,int  start ,int end){
        //                11,4,8,2,10     以 8 为分区点
        //                11,4,   8,   2,10

        //                2,4,   8,   11,10

        //  i 从 4 开始向右移动 ,同时 j 从 10 开始向左移动，i 小于8 的就继续右移动 ， j 大于 8 继续左移动

        //  当 i 大于 8 停止，j 小于 8 j也停止，然后这两个元素  互换位置

        if(start == end ){
            return array;
        }


        int middle = (start+end)/2 ;


        int middleValue = array[middle];

        // middle  = 3
        //   3,4  value 11 ,10
        for(int i = start ; i <= middle ; i++){
            if(array[i] >= middleValue){
                //
                for (int j = end ; j >= middle ; j--){
                    if(array[j] < middleValue){
                        // 数组两元素交换位置
                        int tem  =  array[i] ;
                        array[i] = array[j];
                        array[j] = tem ;
                    }
                }
            }
        }


       // 左边
        quickSort(array,start,middle);
        // 右边
        quickSort(array,middle+1,end);

        return array;





    }

    /**
     * 功能描述 : 二分查找(折半查找)
     *
     *   应用：查找某个数据是否存在于数组，但是如果 直接for 循环遍历，时间复杂度  是 O(n)
     *        但是如果是 二分查找的话，时间复杂度是  O(logn)
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */


    /**
     * 功能描述 : 递归实现 二分查找法
     *                 重复操作：每次将子区间折半
     *                 终止条件：待折半区间 长度为1（或者只有一个元素终止递归）
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */
    public int  binarySearch(int[] array ,int  start ,int end,int target){

        // target = 3
        //  1,3,5,7,9


        // 递归终止条件  ①
        if(start == end ){
            // 和目标值 target 比较，一样，则返回下标，否则返回 -1
            if(array[start] == target){
                return start;
            }
            return -1;
        }

        //  递归终止条件  ②
        int middle = (start+end)/2;
        // 刚好等于目标值
        if(array[middle] == target){
            return middle;
            // 中间值比目标值大，取数组 左边重新折半
        }else if(array[middle] > target){
            // target = 3 ,start = 0;middle-1 = end = 1
            // 错误写法 ①①：
            // binarySearch( array ,  start ,middle-1, target);
            // 正确写法 是要加 return 的
          return   binarySearch( array ,  start ,middle-1, target);
            // 中间值比目标值小，取数组 右边重新折半
        }else{
            // target = 3 ,start = middle+1 = 1; end = 1
            // 错误写法 ①②：
            // binarySearch( array ,  middle+1 ,end, target);
            // 正确写法： 需要加个 return
            return   binarySearch( array ,  middle+1 ,end, target);
        }

        // 错误写法：
        // 错误原因：  上面①① 和 ①② 是没有 return 关键字的，假如 程序找到了 target 然后  return start，这个
        //          binarySearch( array ,  start ,middle-1, target)
        //          or binarySearch( array ,  middle+1 ,end, target)
        //          只是代表 这两个语句是执行完了，但是 走到最后  还有 下面的语句 return -1 没有走，于是程序就走了
        //          return -1
        // return  -1;


    }



    /**
     * 功能描述: 非递归二分查找
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */
    public int binarySearchNoRecursion(int[] array,int target){
        // 1,3 ,5 ,7,9

        int low = 0;
        int middle = ( array.length-1)/2;
        int max = array.length-1;

        //有终止条件且不知道循环几次可以考虑  while 循环
        while(low <= max){
            // 终止条件
            if(array[middle] == target){
                // 结束 while 循环
                return middle;
            }else if (array[middle] > target){
                // target 在  middle 左边
                max = middle-1;
                middle = (low+max)/2;
            }else{
                low = middle+1;
                middle = (low+max)/2;
            }

        }

        return -1;

    }







    /**
     * 功能描述 : 线性排序 ：桶排序，计数排序和基数排序（时间复杂度 都是 O(n)）
     *
     * 之所以能做到线性的时间复杂度，主要是因为它们都不是基于比较的排序算法，排序的过程不涉及元素之间的比较操作。
     * @author guoyiguang
     * @date 2023/1/7
     * @param
     * @return
     */

}
