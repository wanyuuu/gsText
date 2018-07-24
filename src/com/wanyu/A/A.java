package com.wanyu.A;

import org.junit.Test;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by wanyu3 on 2018/4/26.
 */
public class A {
    @Test
    public void test(){
        String text="1234435465";
        int msg=Integer.valueOf(text);
        System.out.println(msg);
    }
    static BitSet bitSet=new BitSet(10240);
    @Test
    public void test1(){
       boolean flag= bitSet.get(0);
        System.out.println(flag);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(0,true);
        System.out.println(bitSet.isEmpty());// 每一位都为0返回true
        System.out.println(bitSet.size());
        System.out.println(bitSet);
    }
    @Test
    public void test3(){
        String str="i.jsf.jd.com";
        String ars[]=str.split(":",-1);
        System.out.println(ars[0]);
        System.out.println(ars[1]);
    }
    @Test
    public void test4(){
        String str = "wanyu";
        String str2 = new String("wanyu");
        System.out.println(str.intern() == str2);// false
        System.out.println(str2.intern() == str);//true
        System.out.println(str.intern() == str);//true
        System.out.println(str2.intern() == str2);//false
        String name = "wan"+new String("yu");
        String name2 = "wanyu";
        String name3 = new String ("wan")+new String("yu");
        System.out.println(name == name2);//false
        System.out.println(name2 == name3);//false
        System.out.println(name == name3);//false
        HashMap map = new HashMap<>();
    }
}
