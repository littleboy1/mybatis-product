package com.lzq.mybatis.objectfactory;

import com.lzq.mybatis.bean.Dept;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class DeptObjectFactory extends DefaultObjectFactory {


    @Override
    public Object create(Class type) {

        if (Dept.class == type){

            Dept dept = (Dept) super.create(type);

            dept.setCountry("China");

            return dept;
        }else {
            return super.create(type);
        }
    }
}
