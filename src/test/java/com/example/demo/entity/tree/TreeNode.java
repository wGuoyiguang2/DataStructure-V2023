package com.example.demo.entity.tree;

import lombok.Data;

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
@Data
public class TreeNode {



    private int data;

    //左节点
    private TreeNode left;

    //右节点
    private TreeNode right;




}
