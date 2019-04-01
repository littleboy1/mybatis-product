package com.lzq.mybatis;
/*具体的实现类*/
public class Person implements BaseService {
    @Override
    public void eat() { // 代理模式只关心主要业务
        System.out.println("-------使用筷子吃饭-----");
    }

    @Override
    public void wc() {
        System.out.println("*************测试地球的重力是否存在**************");
    }
}
