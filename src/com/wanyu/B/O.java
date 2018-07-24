package com.wanyu.B;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wanyu3 on 2018/7/20.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class O {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){

        }
        public ListNode(int val){
            this.val = val;
        }
    }
    ListNode head = null;
    ListNode currentNode = null;
    public void add(int val){
        if(head == null){
            head = new ListNode(val);
            currentNode = head;
        }else {
            currentNode.next = new ListNode(val);
            currentNode = currentNode.next;
        }
    }
    @Test
    public void test(){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);
        list1.next.next.next.next = new ListNode(9);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        ListNode list = Merge(list1,list2);
        while(list!=null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        head.next = null;
        //用来保存头结点
        ListNode root = head;
        while(list1 != null&& list2 != null){
            if(list1.val<list2.val){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){//没走完的直接连接
            head.next = list1;
        }
        if(list2 !=null){
            head.next = list2;
        }
        return root.next;
    }
}
