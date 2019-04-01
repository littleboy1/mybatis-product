package com.lzq.mybatis.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private Integer empNo;

    private String ename;

    private String job;

    private String sal;

    private Date hireDate;

    private int workAge;

    public Employee() {
    }

    public Employee(Date hireDate) {
        this.hireDate = hireDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        this.workAge = Integer.valueOf(sdf.format(new Date()))-Integer.valueOf(sdf.format(hireDate));

    }

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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal='" + sal + '\'' +
                ", hireDate=" + hireDate +
                ", workAge=" + workAge +
                '}';
    }
}
