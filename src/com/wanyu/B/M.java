package com.wanyu.B;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wanyu3 on 2018/7/13.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class M {
    public class ListNode{
        int val;
        ListNode next = null;
        public ListNode(int val){
            this.val = val;
        }
    }
    @Test
    public void test(){
        this.addHead(1);
        this.addHead(2);
        this.addHead(3);
        this.addHead(4);
        this.addHead(5);
        this.addHead(6);
        System.out.println(FindKthToTail(head,4).val);
    }
    ListNode head = null;
    ListNode currentNode = null;
    public void addHead(int val){
        if(head == null){
            head = new ListNode(val);
            currentNode = head;
        }else {
            currentNode.next = new ListNode(val);
            currentNode = currentNode.next;
        }
    }
    public ListNode FindKthToTail(ListNode head, int k) {
        int i = 0;
        ListNode p = head;
        ListNode q = head;
        for(;p!=null;i++){
            if(i>=k){ // p先走 当p走到第k个节点时 q开始走 当p走完 q为倒数第k个
                q = q.next;
            }
            p = p.next;
        }
        return i<k?null:q;
    }
}
