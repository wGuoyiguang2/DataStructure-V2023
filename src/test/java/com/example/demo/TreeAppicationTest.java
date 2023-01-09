package com.example.demo;

import com.example.demo.entity.tree.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 *
 *  树节点的定义
 * @author guoyiguang
 *
 *  下如何表示（或存储）一棵二叉树
 *
 *    存储一棵二叉树一般有两种方法：
 *
 *       一种是基于指针（或引用）的链式存储方式，
 *       另一种是基于数组的顺序存储方式。
 *
 *
 *     如何遍历二叉树（将二叉树的所有节点遍历输出）？
 *      经典方法有三种
 *      ① 前序遍历
 *      ② 中序遍历
 *      ③ 后序遍历
 *      （前序、中序和后序指的是节点与它的左右子树节点遍历输出的先后顺序）
 *
 * @description $
 * @date 2023/1/9$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeAppicationTest {



    /**
     *
     *
     *
     *
     */

    @Test
    public void treeTest() {

        //TreeNode tree = getTree();
        TreeNode tree = getTreeV2();
        preOrder(tree);

        //inOrder(tree);

        //afterOrder(tree);


    }


    public TreeNode getTree(){

        TreeNode root = new TreeNode();

        root.setData(1);

        TreeNode left = new TreeNode();
        left.setData(2);

        TreeNode right = new TreeNode();
        right.setData(3);

        // 定义关系
        root.setLeft(left);
        root.setRight(right);


        return root;
    }





    /**
     * 功能描述:
     *
     *
     *                       3
     *
     *                 1          4
     *
     *                   2     5    6
     * @author guoyiguang
     * @date 2023/1/9
     * @param
     * @return
     */
    public TreeNode getTreeV2(){

        TreeNode root = new TreeNode();

        root.setData(3);

        TreeNode threeLeft = new TreeNode();
        threeLeft.setData(1);

        TreeNode threeRight = new TreeNode();
        threeRight.setData(4);

        TreeNode oneRight = new TreeNode();
        oneRight.setData(2);

        TreeNode fourLeft = new TreeNode();
        fourLeft.setData(5);


        TreeNode fourRight = new TreeNode();
        fourRight.setData(6);

        // 定义关系
        root.setLeft(threeLeft);
        root.setRight(threeRight);


        threeLeft.setRight(oneRight);

        threeRight.setLeft(fourLeft);

        threeRight.setRight(fourRight);

        return root;
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
