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
     *  
     */
    @Test
    public void testLocalDateTime() {

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


        MyNode tem = myNode1;
        while(tem.getNext() == null){
            System.out.println(tem);
            tem  = tem.getNext();
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
