package com.wanyu.B;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wanyu3 on 2018/7/17.
 * 反转链表 输出新表头
 */
public class N {
    public class ListNode{
        int val;
        ListNode next;
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
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);
        this.add(5);
        this.add(6);
        System.out.println(ReverseList(head).val);
    }
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        if(head == null){
            return null;
        }
        while(head != null){// 1 2 3 4 5 6
            next = head.next; //用来保存当前节点的next
            head.next = pre;  //让当前节点指向pre
            pre = head;//后移
            head = next;
        }
        return pre;
    }
}
