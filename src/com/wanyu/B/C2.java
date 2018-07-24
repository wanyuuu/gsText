package com.wanyu.B;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by wanyu3 on 2018/7/12.
 */
public class C2 {
    public class ListNode{
        int val;
        ListNode previous ;
        public ListNode(int val){
            this.val = val;
        }
    }
    ListNode node = null;
    public void init(int val){
        node = new ListNode(val);
    }
    public void addNode(int val){
        ListNode newNode = new ListNode(val);
        newNode.previous = node;
        node = newNode;
    }
    @Test
    public void test(){
        init(1);
        addNode(2);
        addNode(3);
        addNode(4);
        List<Integer> list = printNodeTailFromHead(node);
        for (int i = list.size()-1;i>=0;i--){
            System.out.println(list.get(i));
        }
    }
    public ArrayList<Integer> printNodeTailFromHead(ListNode node){
        Stack<ListNode> stack = new Stack<ListNode>();
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        while (node != null){
            stack.add(node); // 4 3 2 1
            node = node.previous;
        }
        while(!stack.isEmpty()){
            nodeList.add(stack.pop().val);// 1 2 3 4
        }
        return nodeList;
    }
}
