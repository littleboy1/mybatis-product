package com.lzq.mybatis.bean;

public class Dept {

    private Integer deptNo;

    private boolean flag;

    private String dName;

    private String loc;


    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", flag=" + flag +
                ", dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
