package com.wanyu.B;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by wanyu3 on 2018/7/12.
 * 双栈实现队列
 */
public class E {
    @Test
    public void test(){
        push(1);
        push(2);
        push(3);// 1 2 3
        System.out.println(pop());// 1
        System.out.println(pop());// 2
        push(4); // 3 4
        System.out.println(pop());// 3
        push(5);// 4 5
        System.out.println(pop()); // 4
        System.out.println(pop()); // 5
    }
    Stack<Integer> stack1 = new Stack<Integer>();// 1 2 3 4 5
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);// 1 2 3
    }
    public int pop() {
        if(stack2.isEmpty()){//为空时再进元素
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();//没弹完则继续弹
    }
}
