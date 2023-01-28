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
import org.springframework.util.StringUtils;

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
        //insertElementToLink(myNode1,myNode2,myNode3,insertNode);


        //deleteAndInsertList();

        //rotate();
       // delNodeByValue();

       // getLastNumNode();

        deleteDuplicateNode();







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


        MyNode myNode5_ = new MyNode();
        myNode5_.setValue("myNode5");
        myNode5_.setNext(null);

        // 两个链表找出第一个一样的node
        //MyNode myNode = chooseFirstCommonNodeV1(myNode1,myNode1Second);
//        MyNode myNode = chooseFirstCommonNodeV2(myNode1,myNode1Second);
//        System.out.println(myNode);

        // 合并两个有序的链表
        MyNode myNode =  combineSortedLink(myNode1,myNode5_);
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
     *  思路②：栈/队列  将 链表A 和  链表B 分别放到 两个 队列里，然后  同时出队，两个元素比较  ，最小值 是 新链表 的下一个节点(往链表 尾部插入节点)，继续出队列
     *  思路③：就是将⼀个链表结点拆下来，逐个合并到另外⼀个对应位置上去（本质还是链表的插入）
     *
     * @author guoyiguang
     * @date 2023/1/13
     * @param
     * @return
     */
    public MyNode combineSortedLink(MyNode firstNode1,MyNode firstNode2){
        // 思路②实现：

        MyNode temFirst = firstNode1;
        // 将  firstNode1 元素放到 队列里
        Queue<MyNode> queueFirst = new LinkedList<>();
        while(temFirst != null){
            queueFirst.add(temFirst);
            // firstNode1 链表 的下一个节点
            temFirst = temFirst.getNext();
        }


        MyNode temSecond = firstNode2;
        // 将  firstNode1 元素放到 队列里
        Queue<MyNode> queueSecond = new LinkedList();
        while(temSecond != null){
            queueSecond.add(temSecond);
            // firstNode1 链表 的下一个节点
            temSecond = temSecond.getNext();
        }


        MyNode firstNode = null;

        // 将出队列的 元素 放到新的队列里
        MyNode queueFirstNode = queueFirst.poll();
        MyNode queueSecondNode = queueSecond.poll();

        // 不知道循环几次，但是知道终止条件
        //  queue 已经为 空，但是 还有出队列的元素咩有处理
        while(!queueFirst.isEmpty() || !queueSecond.isEmpty()  ||  queueFirstNode != null ||  queueSecondNode != null ){

            if(queueFirstNode != null && queueSecondNode != null){

                if(queueFirstNode.getValue().compareTo(queueSecondNode.getValue()) <=0){
                    if(null == firstNode){
                        firstNode = queueFirstNode;
                    }else{
                        //  firstNode 节点 尾结点 插入 新的节点
                        insertNewNodeInTail(firstNode,queueFirstNode);
                    }

                    queueFirstNode = queueFirst.poll();
                }else{
                    if(null == firstNode){
                        firstNode = queueSecondNode;
                    }else{
                        //  firstNode 节点 尾结点 插入 新的节点
                        insertNewNodeInTail(firstNode,queueSecondNode);
                    }

                    queueSecondNode = queueSecond.poll();

                }

            }else if(queueFirstNode == null && queueSecondNode != null){

                insertNewNodeInTail(firstNode,queueSecondNode);
                queueSecondNode = queueSecond.poll();


            }else if(queueFirstNode != null && queueSecondNode == null){
                insertNewNodeInTail(firstNode,queueFirstNode);
                queueFirstNode = queueFirst.poll();

            }

        }


        return firstNode;

    }

    public void  insertNewNodeInTail(MyNode firstNode,MyNode insertNode){
        MyNode tem = firstNode ;
        MyNode lastNode = firstNode ;
        while(tem != null){
            // 找到 旧 尾结点
            if(null == tem.getNext()){
                lastNode = tem;
                // 终止循环
                break;
            }
            tem = tem.getNext();

        }

        // 旧尾结点 尾部插入 新节点
        lastNode.setNext(insertNode);
        // 设置尾结点(这一步很重要： 因为尾结点的标识就是 next  is null)
        insertNode.setNext(null);
    }


    /**
     * 功能描述 : 合并K个链表
     *    先将前两个合并，
     *    之后再将后⾯的逐步合 并进来，这样的的好处是只要将两个合并的写清楚，
     *    合并K个就容易很多
     * @author guoyiguang
     * @date 2023/1/28
     * @param
     * @return
     */
    public MyNode mergeKLists(MyNode[] lists) {
        MyNode res = null;
        for (MyNode list: lists) {
             res = combineSortedLink(res, list);
        }
        return res;
    }

    /**
     * 功能描述
     * LeetCode1669：
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中下标从a到b的 节点删除，并将list2 接在被删除节点的位置。
     *  node1 ---> （node2 ---> node3  ---> ） node4
     *         node5   node6
     *         操作 ： 需要将  node1 的next 设置为  node5  ，  node6 的 next 设置为 node4
     *
     *          操作： 首先找出 node1 和 node4(下标b 节点的next 节点) ，然后 找出  list2  的 首节点  node5 和 尾结点 node6
     * @author guoyiguang
     * @date 2023/1/28
     * @param
     * @return
     */
    public void  deleteAndInsertList(){
        MyNode firstNode  = new MyNode();
        firstNode.setValue("node1");

        MyNode firstNode2  = new MyNode();
        firstNode2.setValue("node2");

        MyNode firstNode3  = new MyNode();
        firstNode3.setValue("node3");

        firstNode.setNext(firstNode2);
        firstNode2.setNext(firstNode3);


        MyNode secondNode = new MyNode();
        secondNode.setValue("node4");

        MyNode secondNode5 = new MyNode();
        secondNode5.setValue("node5");

        secondNode.setNext(secondNode5);

        // 删除 list1 中下标从a到b的 元素，并 找出 a 的前一节点 和  b的 后一节点
        MyNode firstNodePre = null;
        MyNode firstNodeAfter = null;

        int i = 0;
        // 模拟
        int a = 0;
        int b = 1;
        MyNode temFirst = firstNode;
        while(null != temFirst){
            if(i < a){
                firstNodePre = temFirst;
            }
            if(i  >  b){
                firstNodeAfter = temFirst.getNext();
                break;
            }

            i++;
            temFirst = temFirst.getNext();
        }

        // 找出 secondNode 的首节点和尾结点
        MyNode secondNodeHead = secondNode;
        MyNode secondNodeTail = null;

        MyNode temSecond =  secondNode;
        while(temSecond != null){
            if(null == temSecond.getNext()){
                //   = 号右边可以理解为 堆内存，左边可以理解为 栈内存
                secondNodeTail =  temSecond;
            }

            temSecond = temSecond.getNext();
        }

        // 将  list2  的节点 插入 到  list1  里
        if(firstNodePre != null){
            firstNodePre.setNext(secondNodeHead);
        }else{
            firstNode.setNext(secondNodeHead);
        }
        secondNodeTail.setNext(firstNodeAfter);
        System.out.println(firstNode);
        System.out.println(firstNode);



    }



    /**
     ***************************************************高频面试题 end**********************************************
     */



    /**
     *************************************************** 双指针 专题**********************************************
     */

    /**
     * 功能描述 ：
     *
     *    LeetCode876 给定⼀个头结点为 head 的⾮空单链表，返回链表的中间结点。如果有两个中间结点，则返回第⼆个中间结点
     *
     *    示例1
     *     输⼊：[1,2,3,4,5]
     *     输出：此列表中的结点 3
     *     示例2：
     *    输⼊：[1,2,3,4,5,6]
     *    输出：此列表中的结点 4
     *
     *    思路：
     *    这个问题⽤经典的快慢指针可以轻松搞定，⽤两个指针 slow 与 fast ⼀起遍历链表(一般遍历 链表只需要一个指针 )。
     *     slow ⼀次⾛⼀步， fast⼀次⾛两步。那么当 fast 到达链表的末尾时， slow 必然位于中间
     *
     * @author guoyiguang
     * @date 2023/1/28
     * @param
     * @return
     */
     public void   middleNode(MyNode  firstNode){
         MyNode result = null;
         MyNode temSlowNode = firstNode;
         MyNode temQuickNode = firstNode;
         while(null != temQuickNode && null != temQuickNode.getNext()){
             if(null == temQuickNode.getNext()){
                 result = temSlowNode;
             }

             temSlowNode = temSlowNode.getNext();
             if(null != temQuickNode.getNext()){
                 temQuickNode = temQuickNode.getNext().getNext();
             }


         }




     }


     /**
      * 功能描述  找倒数第k个元素（双指针法）
      *   示例1：
      *   输⼊：head = [1,2,3,4,5], n = 2
      *   输出：[4,5]
      *   思路： 定义 两个指针 fastNode ，slowNode
      *         fastNode 先走 k 个位置，然后 fastNode ，slowNode  一起走，当  链表 遍历完 ， slowNode 所在位置刚好就是 目标节点位置
      * @author guoyiguang
      * @date 2023/1/29
      * @param
      * @return
      */
     public void getLastNumNode(){
         MyNode firstNode= new MyNode();
         firstNode.setValue("1");

         MyNode firstNode2= new MyNode();
         firstNode2.setValue("2");


         MyNode firstNode3= new MyNode();
         firstNode3.setValue("3");


         MyNode firstNode4= new MyNode();
         firstNode4.setValue("4");


         MyNode firstNode5= new MyNode();
         firstNode5.setValue("5");
         //
         firstNode.setNext(firstNode2);
         firstNode2.setNext(firstNode3);
         firstNode3.setNext(firstNode4);
         firstNode4.setNext(firstNode5);



         int k = 2;


         MyNode fastNode= firstNode;
         MyNode slowNode= firstNode;

         for(int i =1 ;i<=k;i++){
             fastNode = fastNode.getNext();
         }



         // 遍历链表(从fastNode 处开始遍历)
         MyNode temNode= fastNode;
         while(null != temNode){
             slowNode = slowNode.getNext();
             temNode = temNode.getNext();

         }

         // [4,5]
         System.out.println(slowNode);
         System.out.println(slowNode);


     }


     /**
      * 功能描述 :  旋转链表
      *
      * Leetcode61.先看题⽬要求：给你⼀个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
      *
      * 示例1:
      * 输⼊：head = [1,2,3,4,5], k = 2
      * 输出：[4,5,1,2,3]
      *
      * 思路：  先找到  k 的位置，将 数组分成  1,2,3 和  4,5 然后 这两个链表 合并
      *
      *
      * @author guoyiguang
      * @date 2023/1/28
      * @param
      * @return
      */

     public void rotate(){

         MyNode firstNode = new MyNode();
         firstNode.setValue("node1");

         MyNode firstNode2 = new MyNode();
         firstNode2.setValue("node2");

         MyNode firstNode3 = new MyNode();
         firstNode3.setValue("node3");

         MyNode firstNode4 = new MyNode();
         firstNode4.setValue("node4");

         MyNode firstNode5 = new MyNode();
         firstNode5.setValue("node5");


         firstNode.setNext(firstNode2);
         firstNode2.setNext(firstNode3);
         firstNode3.setNext(firstNode4);
         firstNode4.setNext(firstNode5);



          //示例1 :
          //输⼊ ：head = [1,2,3,4,5], k = 2
          //输出 ：[4,5,1,2,3]

         // 分成两个 链表( 将 3 的  next 设为 null)， 需要 找出 第二个 链表的 首节点 和 第二个链表的尾结点(原链表的尾结点)
         int k = 2 ;

         MyNode secondLinkHead = firstNode;
         MyNode secondLinkTail = firstNode;

         MyNode temSizeNode = firstNode ;
         int size = 0;
         while(temSizeNode != null){
             size++;
             secondLinkTail = temSizeNode ;
             temSizeNode = temSizeNode.getNext();

         }

          // 选出 size - k 个元素 ，切割 链表
         int index = 0;
         MyNode splitNode = firstNode ;
         while(splitNode != null){
             index++;
             if(size - k == index){
                 secondLinkHead = splitNode.getNext();
                 // 设为 尾结点
                 splitNode.setNext(null);
             }
             splitNode = splitNode.getNext();
         }

         //示例1 :
         //输⼊ ：head = [1,2,3,4,5], k = 2
         //输出 ：[4,5,1,2,3]

         secondLinkTail.setNext(firstNode);

         System.out.println(secondLinkHead);
         System.out.println(secondLinkHead);


     }

     /**
      * 功能描述 :  如何判断 是否有环  TODO 五星（重要）
      *
      *     判断是否有环，最容易的⽅法是使⽤Hash，遍历的时候将元素放⼊到map中，如果有环⼀定会发⽣碰撞。发⽣碰
      * 撞的位置也就是⼊⼝的位置，因此这个题so easy。如果在⼯程中，我们这么做就OK了，
      * @author guoyiguang
      * @date 2023/1/28
      * @param
      * @return
      */
     public MyNode detectCycle(MyNode head) {
         MyNode pos = head;
         Set<MyNode> visited = new HashSet<MyNode>();
         while (pos != null) {
             if (visited.contains(pos)) {
                 // 用 return 结束  while 循环
                 return pos ;
             } else {
                 visited.add(pos);
             }
             pos = pos.getNext();
         }
         return null;
     }



    /**
     ********************************************** 删除链表 元素 专题 **********************************************
     *
     */


    /**
     * 功能描述 :
     *  LeetCode 203：
     *  给你⼀个链表的头节点 head 和⼀个整数 val ，请你删除链表中所有满⾜ Node.val == val 的节点，并返回新的头节点
     *
     * 示例1：
     *         输⼊：head = [1,2,6,3,4,5,6], val = 6
     *         输出：[1,2,3,4,5]
     *         思路：遍历 链表，找出val = 6 的 node ， 并找出此 node 的前驱结点NodePre和后驱节点 nodeAfter ，然后 NodePre.setNext(nodeAfter)
     * @author guoyiguang
     * @date 2023/1/29
     * @param
     * @return
     */
    public void delNodeByValue(){
        MyNode firstNode = new MyNode();
        firstNode.setValue("1");


        MyNode firstNode2 = new MyNode();
        firstNode2.setValue("2");


        MyNode firstNode3 = new MyNode();
        firstNode3.setValue("6");


        MyNode firstNode4 = new MyNode();
        firstNode4.setValue("3");


        MyNode firstNode5 = new MyNode();
        firstNode5.setValue("4");


        MyNode firstNode6 = new MyNode();
        firstNode6.setValue("5");



        MyNode firstNode7 = new MyNode();
        firstNode7.setValue("6");

        //
        firstNode.setNext(firstNode2);
        firstNode2.setNext(firstNode3);
        firstNode3.setNext(firstNode4);
        firstNode4.setNext(firstNode5);
        firstNode5.setNext(firstNode6);
        firstNode6.setNext(firstNode7);

        String val = "1";



        MyNode dummyHead = new MyNode() ; // 设置虚拟节点
        dummyHead.setNext(firstNode);     // 将虚拟节点置于 头结点前面



        // 头节点 的 前驱结点和后驱节点
        MyNode nodePre = dummyHead;
        MyNode nodeAfter = firstNode.getNext() ;

        // =  右边 理解为 堆， = 左边理解为 栈
        MyNode temNode = dummyHead ;
        while(temNode != null){
            if(!StringUtils.isEmpty(temNode.getValue()) && temNode.getValue().equals(val)){
                nodePre.setNext(nodeAfter);
            }
            // 遍历当前节点 ： 实际 是要准备  下一个 node  的前驱结点和后驱节点

            // 设置 nodePre
            nodePre = temNode;

            // 设置 nodeAfter
            if(null != temNode.getNext()){
                // 下一个节点的后驱节点 两个 next，temNode.getNext() 代表下一个节点
                nodeAfter = temNode.getNext().getNext();
            }else{
                nodeAfter = null;
            }

            temNode = temNode.getNext();
        }

        // 返回头结点
        System.out.println(dummyHead.getNext());
        System.out.println(dummyHead.getNext());

    }

    /**
     * 功能描述 ： 删除重复元素
     * LeetCode 83 存在⼀个按升序排列的链表，请你删除所有重复的元素，使每个元素只出现⼀次。
     *
     *  示例1：
     *  输⼊：head = [1,1,2,3,3]
     *  输出：[1,2,3]
     *
     *  思路： 判断重复，用hash，将元素放到set里面
     *        然后改变节点的指向
     * @author guoyiguang
     * @date 2023/1/29
     * @param
     * @return
     */
    public void deleteDuplicateNode(){

        MyNode firstNode = new MyNode();
        firstNode.setValue("1");

        MyNode firstNode2 = new MyNode();
        firstNode2.setValue("1");


        MyNode firstNode3 = new MyNode();
        firstNode3.setValue("2");

        MyNode firstNode4 = new MyNode();
        firstNode4.setValue("3");


        MyNode firstNode5 = new MyNode();
        firstNode5.setValue("3");

        firstNode.setNext(firstNode2);
        firstNode2.setNext(firstNode3);
        firstNode3.setNext(firstNode4);
        firstNode4.setNext(firstNode5);

        Set<String> set = new HashSet<>();



        // 头结点 的  前驱结点和后驱节点
        MyNode dummyNode = new MyNode();  // 虚拟节点 ，最后返回 头结点，return dummyNode.getNext();
        dummyNode.setNext(firstNode);
        MyNode preNode = dummyNode;
        MyNode afterNode = firstNode.getNext();


        MyNode temNode = dummyNode;
        // [1,1,2,3,3]
        while(null != temNode){
            if(!StringUtils.isEmpty(temNode.getValue()) && set.contains(temNode.getValue())){
                // 删除节点
                preNode.setNext(afterNode);

            }else if(!StringUtils.isEmpty(temNode.getValue())){
                // set 没包含
                set.add(temNode.getValue());
            }


            // 设置下一个节点的相关节点

            // 设置前驱结点
            preNode = temNode;

            // 下一个节点
            temNode = temNode.getNext();

            // 设置后驱结点
            if(null != temNode){
                afterNode = temNode.getNext();
            }else{
                afterNode = null;
            }



        }

        // 返回头结点
        System.out.println(dummyNode.getNext());
        System.out.println(dummyNode.getNext());


    }






    /**
     **********************************************  链表 反转 专题 **********************************************
     *
     */

}
