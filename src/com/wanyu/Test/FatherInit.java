package com.wanyu.Test;

/**
 * Created by wanyu3 on 2018/8/3.
 */
public class FatherInit {
    public static void main(String[] args) {

        //通过数组定义引用类 不会初始化此类
        Father father[] = new Father[10];

        //通过子类引用父类的静态变量 不会初始化子类
        //但若子类也存在相同的静态变量 则会初始化子类 （调用一个类的静态变量或静态方法时 会初始化此类）
        //初始化子类时 若有父类 则会先初始化父类
        System.out.println(Son.value);

        //引用类的常量 不会初始化此类
        System.out.println(Son.HELLO);
    }
}
