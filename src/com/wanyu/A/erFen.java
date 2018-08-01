package com.wanyu.A;

import java.util.Arrays;

/**
 * Created by wanyu3 on 2018/8/1.
 */
public class erFen {
    public static void main(String[] args) {
        int arr []={1,2,3,4,5,6,7,8};
        System.out.println(select(arr,9,0,arr.length));
    }
    public static int select(int arr[],int a,int start,int length){
        int low = start;
        int high = length-1;
        while(low <= high){
            int mid = (low+high)/2;
            int midVal = arr[mid];
            if(a > midVal){
                low = mid + 1;
            }else if(a < midVal){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
