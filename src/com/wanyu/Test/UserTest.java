package com.wanyu.Test;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Created by wanyu3 on 2018/7/19.
 */
public class UserTest {
    public static void main(String[] args) {
        HashSet<User> hashSet = new HashSet<User>();
        HashMap<String,User> hashMap = new HashMap<String,User>();
        User u1 = new User("wanyu",111);
        User u2 = new User("wanyu",111);
        //hashSet在添加元素时先会判断是否存在相同的hashCode
        //如果没有相同的值就可以直接存进去 若有则调用equals与新元素比较 若不同则散列其他地址
        hashSet.add(u1);
        hashSet.add(u2);
        Iterator<User> it = hashSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        hashMap.put("1",u1);
        System.out.println(hashMap.get("1"));
        hashMap.put("1",u2);
        System.out.println(hashMap.get("1"));
    }
    @Test
    public void test(){
        int i = 0;
        while(i<5){
            i++;
            if(i == 2){
                continue;
            }
            System.out.println(1);
        }
    }
}
