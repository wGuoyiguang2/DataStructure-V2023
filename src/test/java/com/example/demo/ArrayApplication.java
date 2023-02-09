package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 数组
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
     * <p>
     * leetcode35：给定⼀个排序数组和⼀个⽬标值，在数组中找到⽬标值，并返回其索引。
     * 如果⽬标值不存在于数组中，返回它将会被按顺序插⼊的位置。
     * <p>
     * <p>
     * TODO
     * ⼆分查找
     * 以后凡是提到在单调序列中查找的情况，我们应该⻢上想到是否能⽤⼆分来提⾼查找效率
     * <p>
     * <p>
     * <p>
     * 示例 1 ：
     * 输⼊ : nums = [1,3,5,6], target = 5
     * 存在 5，并且在索引为2的位置，所以输出: 2
     * 示例2 ：
     * 输⼊: nums = [1,3,5,6], target = 2
     * 不存在2，2插⼊之后在索引为1的位置，所以输出 : 1
     *
     * @param
     * @return
     * @author guoyiguang
     * @date 2023/2/8
     */
    @Test
    public void factorial() {


    }


    /**
     ****************************************************** 数组合并专题 *********************************************
     */

    /**
     * 功能描述
     * LeetCode88：给你两个按⾮递减顺序 排列的整数数组 nums1 和 nums2，另有两
     * 个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数⽬。请你合并 nums2 到 nums1 中，使合并后的数组同
     * 样按 ⾮递减顺序 排列。
     * 注意：最终合并后数组不应由函数返回，⽽是存储在数组 nums1 中。为了应对这种情况，nums1 的初始⻓度为
     * m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 应忽略。nums2 的⻓度为 n 。
     * <p>
     * 思路一：⼀种简单的⽅法是先将B直接合并到A的后⾯，然后再对A排序（一般面试官不太喜欢这种写法）
     * 思路二：依次比较两个 数组的较大值 ，较大的那个值作为 原来数组的最大，然后 倒数第二大
     * <p>
     * 从后向前插⼊，A和B的元素数量是固定的，所以排序后最远位置⼀定是A和B元素都最⼤的那个，
     * 依次类推，每次都找最⼤的那个从后向前填就可以了（其实也是可以用递归的）
     * <p>
     * <p>
     * 例⼦ 1 ：
     * 输⼊：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：合并 [1,2,3] 和 [2,5,6] 的结果是 [1,2,2,3,5,6]
     *
     * @param
     * @return
     * @author guoyiguang
     * @date 2023/2/8
     */
    @Test
    public void combineSortedArray() {

        //int[] nums1 = new int[]{1,2, 3, 0, 0, 0};
        int[] nums1 = new int[]{1, 2, 3, 0, 0};
        int m = 3;

        //int[] nums2 =new int[]{2,5,6};
        int[] nums2 = new int[]{2, 5};
        //int  n = 3;
        int n = 2;


        // 思路： 定义三个变量：nums1Index ,nums2Index 是后面 下标 ,从后向前插入
        // 不开辟新的空间，直接在 nums1 上操作
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int nums1LastIndex = nums1.length - 1;
        while (nums1Index >= 0 && nums2Index >= 0) {
            //
            if (nums1[nums1Index] >= nums2[nums2Index]) {
                nums1[nums1LastIndex] = nums1[nums1Index];
                nums1Index--;
                nums1LastIndex--;

            } else {
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
     * <p>
     * 合并n个有序数组:：
     * 如果是n个⻓度⼀样的数组合并成⼀个(TODO 多个数组可以联想到 二维数组，多个长度一样的数组 联想到二维数组 里 数组的 length 一样)
     * <p>
     * 三种基本的思路，⼀种是先将数组全部拼接到⼀个数组中，然后再排序。第⼆种⽅式是不断进⾏两两
     * 要有序合并，第三种⽅式是使⽤堆排序。第⼆种⽅式不断两两合并就是归并的思想，我们到学习归并排序时再看这
     * 个问题。第三种我们在学习完堆之后再详细解释。这⾥只看第⼀种，新建⼀个N*L的数组，将原始数组拼接存放在
     * 这个⼤数组中，再调⽤Arrays.sort()进⾏排序
     *
     * @param
     * @return
     * @author guoyiguang
     * @date 2023/2/8
     */
    @Test
    public void mergeSameArrays() {


        int n = 2;
        int[][] array = new int[n][];

        int[] arrayOne = new int[]{1, 2};
        array[0] = arrayOne;
        int[] arrayTwo = new int[]{3, 4};
        array[1] = arrayTwo;
        // 思路： 先将数组全部拼接到⼀个数组中，然后再排序

        // 遍历二维数组，将二维数组的元素 都扔到一个 一维数组里，最后 对新的一维数组进行排序
        int[] newArray = new int[2 * n];

        int newArrayIndex = 0;

        for (int a = 0; a <= array.length - 1; a++) {

            int[] ints = array[a];
            for (int b = 0; b <= ints.length - 1; b++) {
                newArray[newArrayIndex] = ints[b];
                // 新一维数组下标增加 1
                newArrayIndex++;
            }

        }


        //排序⼀下
        Arrays.sort(newArray);

        System.out.println(newArray);
        System.out.println(newArray);

    }

    /**
     * 功能描述:
     * 字符串替换空格问题
     * <p>
     * <p>
     * 请实现⼀个函数，将⼀个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字
     * 符串为We%20Are%20Happy
     * <p>
     * 思路：循环字符串，获取每一个字符，当字符等于 空格时候 ，进行替换
     *
     * @param
     * @return
     * @author guoyiguang
     * @date 2023/2/8
     */
    @Test
    public void replaceString() {

        String str = "We Are Happy";

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

        //87
        //101
        //32
        //65
        //114
        //101
        //32
        //72
        //97
        //112
        //112
        //121
        for (byte b : bytes) {
            System.out.println(b);
        }

        char[] chars = str.toCharArray();


        //W
        //e
        //
        //A
        //r
        //e
        //
        //H
        //a
        //p
        //p
        //y
        for (char b : chars) {
            System.out.println(b);
        }



        String result = "";
        for (int i = 0; i <= str.length() - 1; i++) {

            char c = str.charAt(i);
            if(c == ' '){
                result=result+"%20";
            }else{
                result=result+c;
            }
        }

        System.out.println(result);
        System.out.println(result);

    }


    /**
     *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *删除元素专题 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    /**
     *  * * *   * * * * *原地移除所有数值等于 val 的元素* * * * * *  * * * * * * * * * * * * * * *
     *
     *
     */


    /**
     * 功能描述
     *        7.给你⼀个数组 nums 和⼀个值 val，你需要原地移除所有数值等于 val 的元素，并返回移除后数组的
     *          新⻓度。
     *          要求：不要使⽤额外的数组空间，你必须仅使⽤ O(1) 额外空间并原地修改输⼊数组。元素的顺序可以改变。你不
     *          需要考虑数组中超出新⻓度后⾯的元素。
     *
     *
     *          例⼦ 1:
     *          输⼊：nums = [3,2,2,3], val = 3
     *          输出：2, nums = [2,2]
     *
     *         例⼦ 2：
     *         输⼊：nums = [0,1,2,2,3,0,4,2], val = 2
     *         输出：5, nums = [0,1,4,0,3]
     *
     * @author
     * @date
     * @param
     * @return
     */
    @Test
    public void  originalProducingAreaDeleteValInArrayMethod1(){

//         快慢双指针： 整体思想:
//        定义两个指针slow和fast，初始值都是0。然后slow 和fast 一起移动，slow 遇到目标值就停止移动，fast继续移动，fast 遇到 非目标值 ，则用此目标值去 替换slow
//        处的值，然后slow++ , 遇到 slow 处的值为目标值 则停止
//     总之：    Slow之前的位置都是有效部分，fast表示当前要访问的元素。


       //  [3,2,2,3], val = 3

        //   3,     2,      2,      3
        //  slow
        //  fast

        //   3,     2,      2,      3          --->  2,     3,      2,      3
        //  slow                                           slow
        //        fast                                     fast


        //   2,     3,      2,      3          --->  2,     3,      2,      3   --->   2,     2,      3,      3
        //        slow                                     slow                                      slow
        //                 fast                                    fast                              fast

        // 停止条件 ：一般 fast 遍历完之后 ，slow 下标前面的数据都是目标值


        int[] array = new int[]{3,2,2,3};

        int slow = 0;
        //int fast = 0;

        int value = 3;

        for( int  fast = 0; fast<= array.length-1 ; fast++){

            //  slow 指针是用来标识 目标值的
            if(array[slow]!=value){
                slow++;
            }

            // fast 的和 slow的换位置  , 随后 slow ++
            if(fast > slow &&  array[fast]!=value){
                //
                int tem = array[slow];
                array[slow]  = array[fast];
                array[fast] =  tem;
                slow++;
            }

        }


        // slow 最后下标对应的元素也是不符合要求的元素
        System.out.println(slow);
        System.out.println(array);
        System.out.println(array);



    }




    @Test
    public void  originalProducingAreaDeleteValInArrayMethod2(){

//         对撞双指针： 整体思想:
//        定义两个指针left和right，初始值left = 0 , right = length-1。
//        然后 left  右移动 ,left 遇到目标值就停止移动， right 开始 左移动，，right 遇到 非目标值 ，则用此目标值去 替换left
//        处的值，然后left++ , right 停止， 遇到 left 处的值为目标值 则停止 ，终止条件 left  = right
//     总之：    left之前的位置都是有效部分，right 右侧是 目标值部分


        //  [3,2,2,3], val = 3

        //   3,     2,      2,      3
        //  left                  right
        //

        //   3,     2,      2,      3          --->  2,    2 ,      3,      3
        //  left                                           left
        //                 right                                   right


        //      2,     2,      3,      3
        //                   left
        //                   right

        // 停止条件 ：left = right


        //int[] array = new int[]{3,2,2,3};

        int[] array = new int[]{0,1,2,2,3,0,4,2};

        int  left = 0;
        int right = array.length-1;

        // int value = 3;
        int value = 2;

        for( int  i = 0; i <= array.length-1   ; i++){


            if(left <= right){
                //  left 指针是用来标识 目标值的
                if(array[left]!=value){
                    left++;
                }else{
                    // 开始走right 指针
                    if( array[right]!=value){
                        //
                        int tem = array[left];
                        array[left]  = array[right];
                        array[right] =  tem;
                        right--;
                    }else{
                        right--;
                    }
                }
            }


        }


        // slow 最后下标对应的元素也是不符合要求的元素
        System.out.println(left);
        System.out.println(array);
        System.out.println(array);



    }









}
