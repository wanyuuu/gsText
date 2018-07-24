package com.wanyu.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wanyu3 on 2018/7/13.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。。
 */
public class L {
    @Test
    public void test(){
        int arr[] = {1,4,6,5,6,7,9,10}; // 1 5 7 9 4 6 6 10
        reOrderArray(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public void reOrderArray(int [] array) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<array.length;i++){
            if(array[i]%2!=0){
                list.add(array[i]);
            }
        }
        for (int i = 0;i<array.length;i++){
            if(array[i]%2==0){
                list.add(array[i]);
            }
        }
      Object arr[] =  list.toArray();
        for(int i = 0;i<arr.length;i++){
            array[i] = (int)arr[i];
        }
    }
}
