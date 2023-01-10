package com.example.demo;

import com.example.demo.entity.tree.TreeNode;
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
     * 功能描述 : 前序遍历（首先输出自己）：(先输出自己，然后输出左右节点)
     *
     *        2
     *
     *   1        3
     *
     *               4
     *
     *****************************************************
     *              3
     *
     *         1           4
     *
     *             2   5        6   --->    3  1 2  4 5 6
     * @author guoyiguang
     * @date 2023/1/9
     * @param
     * @return
     */
    public void preOrder(TreeNode root){

        //   终止条件： 根节点为null 或者左 节点或者 右节点为 null
        if(null == root){
            return ;
        }

        // ① 输出自己
        System.out.println("-----------------------------前序 start----------------------");
        System.out.println(root.getData());
        System.out.println("-----------------------------前序 end----------------------");


        // 二 重复逻辑

        // ① 输出左节点
        preOrder(root.getLeft());
        // ② 输出右节点
        preOrder(root.getRight());

    }


    /**
     * 功能描述 : 中序遍历（中间输出自己）：(先输出左节点，然后输出自己，最后输出右节点 )
     *
     *
     *     2
     *
     * 1        3
     *
     ***************************************************************************
     *
     *         3
     *
     *   1          4
     *
     *      2     5    6   --->    1  2  3   5  4 6
     *
     * @author guoyiguang
     * @date 2023/1/9
     * @param
     * @return
     */
    public void inOrder(TreeNode root){


        // 终止条件
        if(null == root){
            return ;
        }


        // 打印左节点
        inOrder(root.getLeft());

        // 打印自己
        System.out.println("--------------------------------中序  start -----------------------------");
        System.out.println(root.getData());
        System.out.println("--------------------------------中序  end -----------------------------");


        // 打印右节点
        inOrder(root.getRight());


    }

    /**
     * 功能描述 : 后序遍历（最后输出自己）：(先输出左节点，然后输出右节点，最后输出自己 )
     *
     *            1
     *
     *        2        3       --->  2  3  1
     *
     *********************************************************************************
     *
     *                3
     *
     *          1          4
     *
     *             2     5    6   --->    2 1   5  4  6  3
     * @author guoyiguang
     * @date 2023/1/9
     * @param
     * @return
     */
    public void afterOrder(TreeNode root){


        // 终止条件
        if(null == root){
            return ;
        }


        // 打印左节点
        inOrder(root.getLeft());

        // 打印右节点
        inOrder(root.getRight());

        // 打印自己
        System.out.println("--------------------------------后序  start -----------------------------");
        System.out.println(root.getData());
        System.out.println("--------------------------------后序  end -----------------------------");


    }
























}
