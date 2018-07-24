package com.wanyu.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by wanyu3 on 2018/4/26.
 * 从尾到头打印链表
 */
public class C {
    public class ListNode{
        int val;
        ListNode previous = null;
        ListNode(int val){
            this.val=val;
        }
    }
    ListNode node=null;
    public void init(int val){ //初始化
         node=new ListNode(val);
    }
    public void addNode(int val){
        ListNode newNode=new ListNode(val);
        newNode.previous = node; //在尾部添加
        node = newNode;
    }
    @Test
    public void test(){
        init(1);
        addNode(2);
        addNode(3);
        addNode(4);
//        System.out.println(printListFromTailToHead(node));
        List<Integer> list = printListFromTailToHead(node);
        for(int i = list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stack<Integer> stack=new Stack<Integer>();
        while(listNode!=null){
            stack.push(listNode.val);//1 2 3 4
            listNode=listNode.previous;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    /**
     * 反转 也可直接头插
     */
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        while(listNode != null){
//           list.add(listNode.val);
//            listNode = listNode.next;
//          }
//        Collections.reverse(list);//使用Collections的reverse方法，直接将list反转
//        return list;
//    }
    /**
     * 递归简洁版本
     * @param listNode
     * @return
     */
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        if(listNode!=null){
//           this.printListFromTailToHead(listNode.next);
//            arrayList.add(listNode.val);
//            }
//        return arrayList;
//        }
}
