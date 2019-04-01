package com.lzq.mybatis.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private Integer empNo;

    private String ename;

    private String job;

    private String sal;

    private Dept dept;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal='" + sal + '\'' +
                ", dept=" + dept +
                '}';
    }
}
