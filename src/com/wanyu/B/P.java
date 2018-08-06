package com.wanyu.B;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by wanyu3 on 2018/7/20.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class P {
    @Test
    public void test(){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(arr);
    }
    public void printMatrix(int [][] matrix) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        int num = m * n;
        int i = 0;
        int j = 0;
        int k = 1;
        int l = 1;
        boolean flag = true;
        while(num > 0){
            if(flag){
                System.out.print(matrix[i][j]);
                num--;
                j = j + k;
                if(j == n-1){
                    flag = !flag;
                }
            }else {
                System.out.print(matrix[i][j]);
                num--;
                i = i + l;
                if(i == m-1){
                    flag = !flag;
                    k = -k;
                    l = -l;
                }
            }
        }

    }
}
