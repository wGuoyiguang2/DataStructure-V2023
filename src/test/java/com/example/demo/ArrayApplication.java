package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 数组：
 *     没思路的时候想想快慢双指针，或者对撞双指针
 *
 *
 * 待做的题目：
 *    jiOuShuFenLi2
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

    // 删除有序数组中的重复项
    /**
     * 功能描述 :
     *
     *   LeetCode26 给你⼀个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现⼀次 ，返回删除后数组
     *   的新⻓度。不要使⽤额外的数组空间，你必须在原地修改输⼊数组 并在使⽤ O(1) 额外空间的条件下完成
     *
     *
     *   示例1：
     * 输⼊：nums = [1,1,2]
     * 输出：2, nums = [1,2]
     * 解释：函数应该返回新的⻓度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新⻓度
     * 后⾯的元素。
     * 例⼦2：
     * 输⼊：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的⻓度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组
     * 中超出新⻓度后⾯的元素。
     *
     *   思路 ：
     *       是 有序数组 所以， slow 对应的值  和 fast 对应的值   比较大小
     *       定义两个指针
     *       慢指针 左边是符合要求的数据 部分，快指针 右边 是待处理的部分，
     *       直到 快指针 遍历完
     * @author guoyiguang
     * @date 2023/2/9
     * @param
     * @return
     */
    @Test
    public void deleteRepeatableElement(){

        //int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] array = new int[]{1,1,2};

        // 最终的结果
        //  0,1,2,3,4

        int  slow = 0 ;
        //int  fast = 0 ;

        for(int fast = 1 ; fast <=  array.length-1 ; fast++){

            // fast 值要 大于 slow的值 ，则 fast 的值 放在  slow 下一个 的位置， 然后 slow + 1;
            if(array[fast] >  array[slow]){
                //
                array[slow+1] = array[fast];
                slow++;
            }

        }


        System.out.println(slow);
        System.out.println(slow);


    }


    /**
     * *********************************************元素奇偶移动专题************************************************
     */

    /**
     * 功能描述 奇偶数分离
     *
     *
     *        LeetCode905，按奇偶排序数组。给定⼀个⾮负整数数组 A ，返回⼀个数组，在该数组中， A 的所有偶数元素之
     *        后跟着所有奇数元素。你可以返回满⾜此条件的任何数组作为答案。
     *
     *
     *        输⼊：[3,1,2,4]
     *       输出：[2,4,3,1]
     *       输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
     *
     *
     *
     *       思路： 对撞型双指针
     *            left 指针 判断出奇数 ，停止，right 指针 从右 开始 判断出 偶数 ，则替换这两个数
     *            直到 left 和 right 相交
     * @author guoyiguang
     * @date 2023/2/9
     * @param
     * @return
     */
    @Test
    public void jiOuShuFenLi(){

        // 对撞型双指针
         int[] array = new int[]{3,1,2,4};

         // 目标结果  2,4,3,1 （保证前偶后奇就行）

        // 定位左半部分  奇数
        int left = 0;

        // 定位右半部分  偶数
        int right = array.length-1;

        for(int i = 0;i<=array.length-1;i++){

            if(left<=right){
                if(array[left]%2==0){
                    left++;
                }else{
                    //
                    if(array[right]%2==0){
                        // 替换位置
                        int  tem = array[left];
                        array[left] = array[right] ;
                        array[right] = tem;
                        left++;

                    }else{
                        // 找 右半部分的 前一个 偶数
                        right--;
                    }
                }
            }

        }

        System.out.println(array);
        System.out.println(array);

    }


    // 承接上一题
    // 调整后的顺序仍与原始数组的顺序⼀致

    /**
     * 功能描述 奇偶数分离
     *
     *
     *        LeetCode905，按奇偶排序数组。给定⼀个⾮负整数数组 A ，返回⼀个数组，在该数组中， A 的所有偶数元素之
     *        后跟着所有奇数元素。你可以返回满⾜此条件的任何数组作为答案。
     *
     *
     *        输⼊：[3,1,2,4]
     *        输出：[2,4,3,1]  (和原顺序一样)
     *
     *
     *
     *
     *       思路： 对撞型双指针
     *            left 指针 判断出奇数 ，停止，right 指针 从右 开始 判断出 偶数 ，则替换这两个数
     *            直到 left 和 right 相交
     * @author guoyiguang  TODO 待做
     * @date 2023/2/9
     * @param
     * @return
     */
    @Test
    public void jiOuShuFenLi2(){

        //
        int[] array = new int[]{3,1,2,4};


    }


    /**
     *****************************************  数组轮转问题 **********************************
     */

    /**
     * 功能描述
     *
     *   LeetCode189.给你⼀个数组，将数组中的元素向右轮转 k 个位置，其中 k 是⾮负数。
     *
     *   例如：
     * 输⼊: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     *
     *  思路：
     *      分析目标结果 ：
     *      最后k个元素放到前面 k 个位置，原来的元素统一 右移动 k 个元素
     * @author guoyiguang
     * @date 2023/2/9
     * @param
     * @return
     */
    @Test
    public void rotate(){

        int[] array = new int[]{1,2,3,4,5,6,7};

        for(int k = 3 ;k>=1; k--){
            // [1,2,3,4,5,6,7]--->[7,1,2,3,4,5,6]
            // 储存 末尾 的 值，防止被覆盖掉
            int lastValue = array[array.length-1];

            // 用前面的值 覆盖 后面的值  (反向遍历) ： 凭的就是灵光一现（技巧性问题）
            for(int i = array.length-1;i>=1;i--){
                // [1,1,3,4,5,6,7]
                array[i] = array[i-1];
            }

            // 设置原始的末尾值 为 第一个元素值
            array[0] = lastValue;

        }

        System.out.println(array);
        System.out.println(array);

    }


    /**
     * 功能描述 :要求同上
     * @author guoyiguang
     * @date 2023/2/10
     * @param
     * @return
     */
    @Test
    public void rotateMethod2(){

        int[] array = new int[]{1,2,3,4,5,6,7};

        for(int k = 3 ;k>=1; k--){
            // [1,2,3,4,5,6,7]--->
            // [7,1,2,3,4,5,6]
            // 储存 末尾 的 值，防止被覆盖掉
            int lastValue = array[array.length-1];

            // 用前面的值 覆盖 后面的值  (正向遍历) ：
            for(int i = 1;i<=array.length-1;i++){
                // [ ,1,3,4,5,6,7]  后面的元素 往后 移动
                array[array.length-i] = array[array.length-i-1];
            }

            // 设置原始的末尾值 为 第一个元素值
            array[0] = lastValue;
        }

        System.out.println(array);
        System.out.println(array);

    }




    /**
     *  数组的区间专题
     *
     *  LeetCode228.给定⼀个⽆重复元素的有序整数数组nums。返回恰好覆盖数组中所有数字的最⼩有序区间范围列
     * 表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字x 。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     *
     *
     * 示例1：
     * 输⼊：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     * 示例2：
     * 输⼊：nums = [0,2,3,4,6,8,9]
     * 输出：["0","2->4","6","8->9"]
     * 解释：区间范围是：
     * [0,0] --> "0"
     * [2,4] --> "2->4"
     * [6,6] --> "6"
     * [8,9] --> "8->9"
     *
     *
     *   思路：快慢指针
     *        慢指针左边是符合要求的，快指针如果 发现数据不连续，则 将 慢指针和快指针对应的 值输出来
     *        然后 快慢指针 一起从 下一个 元素继续直到，fast 指针循环结束
     */
    @Test
    public void summaryRanges(){

        List<String>  result = new ArrayList<>();


       //int[] nums = new int[]{0,2,3,4,6,8,9};
       int[] nums = new int[]{0,1,2,4,5,7};

       int slow = 0;

       // 0,   2,3,4,    6,     8,9
       for(int fast = 0;fast <= nums.length-1 ;fast++){
            // 最后一个元素特殊处理
           if(fast ==  nums.length-1){

               if(fast > slow){
                   if(nums[fast] >  (nums[fast-1]+1)){

                       //输出 两个
                       StringBuilder sb = new StringBuilder();
                       sb.append(nums[slow]);
                       sb.append("--->");
                       sb.append(nums[fast-1]);

                       result.add(sb.toString());

                       StringBuilder sb2 = new StringBuilder();
                       sb2.append(nums[fast]);

                       result.add(sb2.toString());

                   }else{
                       StringBuilder sb = new StringBuilder();
                       sb.append(nums[slow]);
                       sb.append("--->");
                       sb.append(nums[fast]);
                       result.add(sb.toString());

                   }
               }else if (fast == slow){
                   StringBuilder sb = new StringBuilder();
                   sb.append(nums[slow]);
                   sb.append("--->");
                   sb.append(nums[slow]);
                   result.add(sb.toString());
               }


           }else{
               if(nums[fast+1] >  (nums[fast]+1)){
                   StringBuilder sb = new StringBuilder();
                   sb.append(nums[slow]);
                   sb.append("--->");
                   sb.append(nums[fast]);
                   // slow 跳到  fast+1 位置上
                   slow=fast+1;

                   result.add(sb.toString());
               }
           }


       }

        System.out.println(result);
        System.out.println(result);

    }

    /**
     *  * * * * * * * * * * * ** * *  *  出现次数专题  * * * * * * * * * * * * * * * * *  * ** * * *
     */

    /**
     * 功能描述
     *           输⼊如下所示的⼀个⻓度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组⻓度的
     *           ⼀半，因此输出2，如果不存在则输出0。
     *
     *
     *           思路：快慢指针 貌似不行
     *                hash  集合貌似可以
     * @author guoyiguang
     * @date 2023/2/10
     * @param
     * @return
     */
    @Test
    public void  moreThanHalfNum(){

        int[] array = new int[]{1,2,3,2,2,2,5,4,2};

        int half = array.length/2;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i <= array.length-1 ; i++){

            if(map.containsKey(array[i])){

                map.put(array[i],map.get(array[i])+1);

            }else{
                map.put(array[i],1);
            }


            if(map.get(array[i]) >=  half){

                System.out.println(array[i]);

            }

        }

    }

















}
