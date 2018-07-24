package com.wanyu.B;

/**
 * Created by wanyu3 on 2018/4/26.
 */
public class A {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5},
                        {6,7,8,9,10},
                        {11,12,13,14,15},
                        {16,17,18,19,20}
        };
        System.out.println(Find(5,arr));
    }
    public static boolean Find(int target, int [][] array) {
        int i=array.length; //4
        int j=array[0].length; //5
        int m=0,n=j-1;
        while(m<i&&n>=0){
            if(array[m][n]>target){
                n--;
            } else if(array[m][n]<target){
                m++;
            } else {
                return true;
            }
        }
        return false;
    }
}
