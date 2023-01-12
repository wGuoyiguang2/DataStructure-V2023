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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        deleteElementToLink(myNode1,myNode1);




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
     * @author guoyiguang
     * @date 2023/1/12
     * @param
     * @return
     */
    @Test
    public void insertElementToLink() {

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




    }


    /**
     *   TODO :  第一个和最后一个需要处理
     * 功能描述：  链表 删除 一个元素
     *
     *
     *
     * 思路：假如链表 A---> B ---> C , 要删除 B 元素
     *     先在链表找到B元素的前置元素A和后置元素c
     *     然后 A.next(C) ,B.next(null)
     *     最后
     *       A ---> C
     *          B
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
        preposition.setNext(postposition);
        deleteNode.setNext(null);

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


}
