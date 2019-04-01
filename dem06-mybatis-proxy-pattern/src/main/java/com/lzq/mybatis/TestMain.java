package com.lzq.mybatis;

public class TestMain {

    public static void main(String[] args) {

    // Person person = new Person(); 该种创建方式是不会产生任何行为的,脱离了代理模式
    //对当前所有具有当前行为（实现了当前接口的实现类）的类进行监控，牵一发而动全身
        BaseService build = ProxyFactory.build(Dog.class);

        build.eat();

        build.wc();

    }
}
