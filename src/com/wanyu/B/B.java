package com.wanyu.B;

/**
 * Created by wanyu3 on 2018/4/26.
 */
public class B {
    public static void main(String[] args) {
        StringBuffer str=new StringBuffer("We Are Happy");
        System.out.println(str);
        replaceSpace(str);
        System.out.println(str);
    }
    public static String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                int k=i;
                str.replace(k,k+1,"%20");
            }
        }
        return String.valueOf(str);
    }
}
