package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 *   数组
 *
 *
 * @author guoyiguang
 * @description $
 * @date 2023/2/8$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayApplication {


    /**
     * 功能描述
     *
     *   leetcode35：给定⼀个排序数组和⼀个⽬标值，在数组中找到⽬标值，并返回其索引。
     *   如果⽬标值不存在于数组中，返回它将会被按顺序插⼊的位置。
     *
     *
     *   TODO
     *          ⼆分查找
     *          以后凡是提到在单调序列中查找的情况，我们应该⻢上想到是否能⽤⼆分来提⾼查找效率
     *
     *
     *
     *   示例 1 ：
     *   输⼊ : nums = [1,3,5,6], target = 5
     *   存在 5，并且在索引为2的位置，所以输出: 2
     *   示例2 ：
     *    输⼊: nums = [1,3,5,6], target = 2
     *    不存在2，2插⼊之后在索引为1的位置，所以输出 : 1
     *
     * @author guoyiguang
     * @date 2023/2/8
     * @param
     * @return
     */
    @Test
    public void factorial(){





    }



    /**
     ****************************************************** 数组合并专题 *********************************************
     */

    /**
     * 功能描述
     *    LeetCode88：给你两个按⾮递减顺序 排列的整数数组 nums1 和 nums2，另有两
     *     个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数⽬。请你合并 nums2 到 nums1 中，使合并后的数组同
     *     样按 ⾮递减顺序 排列。
     *     注意：最终合并后数组不应由函数返回，⽽是存储在数组 nums1 中。为了应对这种情况，nums1 的初始⻓度为
     *     m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 应忽略。nums2 的⻓度为 n 。
     *
     *     思路一：⼀种简单的⽅法是先将B直接合并到A的后⾯，然后再对A排序（一般面试官不太喜欢这种写法）
     *     思路二：依次比较两个 数组的较大值 ，较大的那个值作为 原来数组的最大，然后 倒数第二大
     *
     *           从后向前插⼊，A和B的元素数量是固定的，所以排序后最远位置⼀定是A和B元素都最⼤的那个，
     *            依次类推，每次都找最⼤的那个从后向前填就可以了（其实也是可以用递归的）
     *
     *
     *            例⼦ 1 ：
     *            输⼊：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     *            输出：[1,2,2,3,5,6]
     *            解释：合并 [1,2,3] 和 [2,5,6] 的结果是 [1,2,2,3,5,6]
     *
     *
     * @author guoyiguang
     * @date 2023/2/8
     * @param
     * @return
     */
    @Test
    public void combineSortedArray(){

        //int[] nums1 = new int[]{1,2, 3, 0, 0, 0};
        int[] nums1 = new int[]{1,2, 3, 0, 0};
        int  m = 3;

        //int[] nums2 =new int[]{2,5,6};
         int[] nums2 =new int[]{2,5};
        //int  n = 3;
        int  n = 2;


        // 思路： 定义三个变量：nums1Index ,nums2Index 是后面 下标 ,从后向前插入
        // 不开辟新的空间，直接在 nums1 上操作
        int nums1Index = m-1;
        int nums2Index = n-1;
        int nums1LastIndex = nums1.length-1;
        while(nums1Index >= 0 && nums2Index >= 0){
            //
            if(nums1[nums1Index]>=nums2[nums2Index]){
                nums1[nums1LastIndex] = nums1[nums1Index];
                nums1Index--;
                nums1LastIndex--;

            }else{
                nums1[nums1LastIndex] = nums2[nums2Index];
                nums2Index--;
                nums1LastIndex--;
            }
        }

        System.out.println(nums1);
        System.out.println(nums1);

    }


    /**
     * 功能描述
     *
     *        合并n个有序数组:：
     *        如果是n个⻓度⼀样的数组合并成⼀个(TODO 多个数组可以联想到 二维数组，多个长度一样的数组 联想到二维数组 里 数组的 length 一样)
     *
     *  三种基本的思路，⼀种是先将数组全部拼接到⼀个数组中，然后再排序。第⼆种⽅式是不断进⾏两两
     * 要有序合并，第三种⽅式是使⽤堆排序。第⼆种⽅式不断两两合并就是归并的思想，我们到学习归并排序时再看这
     * 个问题。第三种我们在学习完堆之后再详细解释。这⾥只看第⼀种，新建⼀个N*L的数组，将原始数组拼接存放在
     * 这个⼤数组中，再调⽤Arrays.sort()进⾏排序
     *
     * @author guoyiguang
     * @date 2023/2/8
     * @param
     * @return
     */
    @Test
    public void mergeSameArrays(){


        int n = 2;
        int[][] array = new  int[n][];

        int[] arrayOne = new  int[] { 1,2};
        array[0] = arrayOne;
        int[] arrayTwo = new  int[] { 3,4};
        array[1] = arrayTwo;
        // 思路： 先将数组全部拼接到⼀个数组中，然后再排序

        // 遍历二维数组，将二维数组的元素 都扔到一个 一维数组里，最后 对新的一维数组进行排序
        int[] newArray = new  int[2*n];

        int newArrayIndex = 0;

        for(int a = 0;a<=array.length-1;a++){

            int[] ints = array[a];
            for(int b = 0;b<=ints.length-1;b++){
                newArray[newArrayIndex] =   ints[b];
                // 新一维数组下标增加 1
                newArrayIndex++;
            }

        }


        //排序⼀下
        Arrays.sort(newArray);

        System.out.println(newArray);
        System.out.println(newArray);

    }




}
