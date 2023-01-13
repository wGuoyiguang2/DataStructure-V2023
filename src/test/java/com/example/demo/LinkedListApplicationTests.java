package com.example.demo;


//
//import com.example.demo.entity.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDate;

import com.example.demo.entity.ListNode;
import com.example.demo.entity.link.MyNode;
import org.apache.tomcat.jni.Mmap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LinkedListApplicationTests {




    /**
     * 功能描述：  链表 删除 一个元素
     * @author guoyiguang
     * @date 2023/1/12
     * @param
     * @return
     */
    @Test
    public void  linkTest() {

        MyNode myNode1 = new MyNode();
        myNode1.setValue("myNode1");
        MyNode myNode2 = new MyNode();
        myNode2.setValue("myNode2");
        MyNode myNode3 = new MyNode();
        myNode3.setValue("myNode3");

        MyNode myNode4 = new MyNode();
        myNode4.setValue("myNode4");

        //  形成链
        myNode1.setNext(myNode2);
        myNode2.setNext(myNode3);
        myNode3.setNext(myNode4);

        //deleteElementToLink(myNode1,myNode4);

        // 插入元素

        MyNode insertNode = new MyNode();
        insertNode.setValue("myNode5_insert");
        // 首位插入
        //insertElementToLink(myNode1,null,myNode2,insertNode);
        //尾结点插入
        //insertElementToLink(myNode1,myNode4,null,insertNode);
        // 2 和 3 中间插入
        insertElementToLink(myNode1,myNode2,myNode3,insertNode);







    }


    @Test
    public void  interviewTest() {

        MyNode myNode1 = new MyNode();
        myNode1.setValue("myNode1");
        MyNode myNode2 = new MyNode();
        myNode2.setValue("myNode2");
        MyNode myNode3 = new MyNode();
        myNode3.setValue("myNode3");

        MyNode myNode4 = new MyNode();
        myNode4.setValue("myNode4");

        //  形成链
        myNode1.setNext(myNode2);
        myNode2.setNext(myNode3);
        myNode3.setNext(myNode4);


        MyNode myNode1Second = new MyNode();
        myNode1Second.setValue("myNode1_Second");
        myNode1Second.setNext(myNode4);

        // 两个链表找出第一个一样的node
        //MyNode myNode = chooseFirstCommonNodeV1(myNode1,myNode1Second);
        MyNode myNode = chooseFirstCommonNodeV2(myNode1,myNode1Second);
        System.out.println(myNode);


    }





    /**
     *  遍历一个链表
     *
     */
    @Test
    public void ergodic() {

        MyNode myNode1 = new MyNode();
        myNode1.setValue("myNode1");
        MyNode myNode2 = new MyNode();
        myNode2.setValue("myNode2");
        MyNode myNode3 = new MyNode();
        myNode3.setValue("myNode3");

       //  形成链
        myNode1.setNext(myNode2);
        myNode2.setNext(myNode3);
        // 这一步可以省去不写
        myNode3.setNext(null);

        // 在 myNode2 和  myNode3 直接插入 myNode4
        MyNode myNode4 = new MyNode();
        myNode4.setValue("myNode4");

        myNode2.setNext(myNode4);

        myNode4.setNext(myNode3);



        // 遍历一个链表
        // myNode1 ---> myNode2 --->  myNode4 --->  myNode3

        //  tem
        MyNode tem = myNode1;
        // 不知道循环几次，但是知道 终止条件
        while(tem != null){
            System.out.println(tem);
            tem  = tem.getNext();
        }

        //  不知道循环几次，但是知道 终止条件(等效  于  while)
        System.out.println("for 循环  遍历  链表");
        MyNode temFor = myNode1;
        for(;;){
            if(null != temFor){
                System.out.println(temFor);
                temFor  = temFor.getNext();
            }else{
                //break;
                // 也可以替换 return
                return ;
            }

        }


    }

    /**
     * 功能描述：  链表插入一个元素
     *
     *          A---> B--->  C
     *          ① A 前面插入 D   (D.setNext(A))
     *          ② A 和  B 之间插入D (A.setNext(D) ;D.setNext(B) )
     *          ③ C 后插入 D （c.next(D)）
     *
     * @author guoyiguang
     * @date 2023/1/12
     * @param
     * @return
     */
    public void insertElementToLink(MyNode firstNode,MyNode preNode,MyNode postNode,MyNode insertNode) {
        // 首位插入
        if(null == preNode){
            insertNode.setNext(firstNode);
            //  firstNode 引用指向 堆 的  insertNode 对象
            firstNode = insertNode;
            // 中间插入
        }else if(null != preNode && null!= postNode ){
            preNode.setNext(insertNode);
            insertNode.setNext(postNode);
            // 末尾插入
        }else if(null == postNode){
            // 找出 尾结点
            MyNode tem = firstNode ;
            MyNode lastNode = firstNode ;
            while(tem != null){
                if(null == tem.getNext()){
                    lastNode = tem;
                    // 终止循环
                    break;
                }
                tem = tem.getNext();

            }

            lastNode.setNext(insertNode);
            // 可以不写
            insertNode.setNext(null);


        }



        // 遍历  链表
        MyNode  tem2 =  firstNode;
        System.out.println("遍历插入元素后的链表");
        while(null != tem2){
            System.out.println(tem2);
            //   tem  指向  tem 的 next 对象
            tem2 = tem2.getNext();//  tem.getNext() 这个引用 指向 堆的一个对象Object1 ，此条语句是将 tem 这个引用 指向 Object1

        }








    }


    /**
     *
     * 功能描述：  链表 删除 一个元素
     *
     *
     *
     * 思路：假如链表 A---> B ---> C ,
     *      ① 要删除 B 元素
     *     先在链表找到B元素的前置元素A和后置元素c
     *     然后 A.next(C) ,B.next(null)
     *     最后
     *       A ---> C
     *          B
     *     ② 要删除 A 元素
     *        A.next(null)
     *        首节点变成B TODO 怎么让B变成首节点 (只需要将 firstNode 引用指向 堆 的 B 对象)
     *
     *      ③ 要删除 C 元素
     *        B.next(null)
     *
     *
     * @author guoyiguang
     * @date 2023/1/12
     * @param
     * @return
     */
    public void deleteElementToLink(MyNode firstNode,MyNode  deleteNode) {

        // 设置临时变量存储 前置节点
        MyNode  preposition = firstNode ;
        // 设置临时变量存储 后置节点
        MyNode  postposition =  firstNode ;



        // A---> B ---> C
        // 遍历链表 查找 前置节点，目标节点和后置节点
        MyNode  tem =  firstNode;
        while(null != tem){
            if(tem == deleteNode){
                postposition = tem.getNext();
                // 赋值成功，结束循环
                break ;
                // return 不但结束循环，而且也跳出方法体 （这儿不可以用return ）
            }else{
                //  preposition 指向 tem 指向的对象（在堆里）
                preposition = tem;
            }
            //   tem  指向  tem 的 next 对象
            tem = tem.getNext();

        }
        System.out.println(preposition);
        System.out.println(postposition);
        System.out.println("--");

        // 改变 引用
        if(preposition == firstNode){
            // 说明删除的是 firstNode
            deleteNode.setNext(null);
            // 将（堆）第二个 node  指向 secondNode
            firstNode = postposition ;

            // 删除的是最后一个元素(next 是 null 就是最后一个)
        }else if(null == deleteNode.getNext()){
            preposition.setNext(postposition);
        } else{
            preposition.setNext(postposition);
            deleteNode.setNext(null);
        }


        // 遍历链表
        MyNode  tem2 =  firstNode;
        System.out.println("遍历删除元素后的链表");
        while(null != tem2){
            System.out.println(tem2);
            // A--->  B --->  C --->   D
            //
            //   tem  指向  tem 的 next 对象
            tem2 = tem2.getNext();//  tem.getNext() 这个引用 指向 堆的一个对象Object1 ，此条语句是将 tem 这个引用 指向 Object1

        }











    }



    @Test
    public void reverseListTest() {

        //
        ListNode lastNode = new ListNode(3, null);

        ListNode twoNode = new ListNode();
        ListNode headNode = new ListNode(1, twoNode);
        twoNode.setData(2);
        twoNode.setNext(lastNode);


        // 遍历链表

        ListNode next = headNode.getNext();
        System.out.println(headNode.getData());

        while(null != next) {
            System.out.println(next.getData());
            // 获取下一个
            next = next.getNext();
        }

        System.out.println("翻转后的结果");

        // 翻转
        ListNode reverseHeadNode = reverseList(headNode);

        ListNode next1 = reverseHeadNode.getNext();
        System.out.println(reverseHeadNode.getData());

        while(null != next1) {
            System.out.println(next1.getData());
            // 获取下一个
            next1 = next1.getNext();
        }
    }


    public ListNode  reverseList(ListNode head){
        if (null == head) {
            return null;
        }

        // 前置节点
        ListNode prev = head;
        // 当前节点
        ListNode current = head.getNext();

        // 单链表，翻转后 翻转前的头结点的 变成尾结点，所以他的 next 设置为  null
        prev.setNext(null);

        // current 为 null ，结束循环（while 循环在不知道循环几次的情况下用）
        while(null != current){
            // 后置节点
            ListNode next = current.getNext();
            // 翻转：设置当前节点的 next 节点为  prev 节点（注意：prev 节点是要动态变 的）
            current.setNext(prev);
            // current 节点成为  下一次的 prev 节点
            prev = current;
            // next 节点成为  current节点
            current = next;
        }

        // 返回翻转后的 头节点
        return prev;

    }




    /**
     ***************************************************高频面试题 start**********************************************
     */


    /**
     *
     * 功能描述：  两个链表找出 第一个公共节点
     *          链表① ：A  B  C  D  E  F
     *
     *          链表② ：G  H  C  D  E  F
     *          考察点：链表的遍历
     *          难度系数： 2星
     *          思路：依次遍历 链表① ，然后  在 链表② 找到 和  链表① 一样的元素，然后返回
     * @author guoyiguang
     * @date 2023/1/12
     * @param
     * @return
     */
    // 此方法时间复杂度高，不推荐
    public MyNode chooseFirstCommonNodeV1(MyNode firstNode1,MyNode firstNode2){

        // 返回
        if(null == firstNode1 || null == firstNode2){
            return null;
        }

        MyNode temFirst = firstNode1;
        while(temFirst != null){

            MyNode temSecond = firstNode2;
            while(temSecond != null){
                if(temFirst == temSecond){
                    return temFirst;
                }
                temSecond = temSecond.getNext();
            }
            // firstNode1 链表 的下一个节点
            temFirst = temFirst.getNext();
        }

        return null;





    }


    // HashMap or 其他集合：思路： 将一个链表的 元素放到 一个map（其他集合里也行），遍历另一个链表，如果 元素在集合里，返回这个元素即可
    public MyNode chooseFirstCommonNodeV2(MyNode firstNode1,MyNode firstNode2){

        // 返回
        if(null == firstNode1 || null == firstNode2){
            return null;
        }
        Map firstLinkedMap = new HashMap();

        MyNode temFirst = firstNode1;
        while(temFirst != null){
            firstLinkedMap.put(temFirst,temFirst);
            // firstNode1 链表 的下一个节点
            temFirst = temFirst.getNext();
        }

        MyNode temSecond = firstNode2;
        while(temSecond != null){
            //  也可以用  Set ，ArrayList集合  ，然后contains 判断一下，但是  时间复杂度不如 map
            if(firstLinkedMap.containsKey(temSecond)){
                 return temSecond;
            }
            // firstNode2 链表 的下一个节点
            temSecond = temSecond.getNext();
        }

        return null;





    }


    /**
     * 功能描述: 合并两个有序链表
     * LeetCode21 将两个升序链表合并为⼀个新的升序链表并返回，新链表是通过拼接给定的两个链表的所有节点组成的。

     *  链表A ： 1  3  5 7
     *
     *  链表B ： 2  4  6 8
     *
     *  思路①：链表 A 和  链表 B 的各个元素比较，最小值 是 新链表 的下一个节点，继续遍历，直到 遍历完（时间复杂度高）
     *  思路②：栈/队列  将 链表A 和  链表B 分别放到 两个 队列里，然后  同时出队，两个元素比较  ，最小值 是 新链表 的下一个节点，继续出队列
     *  思路③：就是将⼀个链表结点拆下来，逐个合并到另外⼀个对应位置上去（本质还是链表的插入）
     *
     * @author guoyiguang
     * @date 2023/1/13
     * @param
     * @return
     */
    public MyNode combineSortedLink(MyNode firstNode1,MyNode firstNode2){
       // TODO



        return null;

    }



    /**
     ***************************************************高频面试题 end**********************************************
     */



}
