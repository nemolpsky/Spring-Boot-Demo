package com.lp.springdemo.model;

import cn.hutool.json.JSONUtil;

import javax.validation.constraints.NotNull;

public class UserModel {

    public interface findGroup{}

    private int age;
    @NotNull(groups = findGroup.class,message = "用户名不允许为空")
    private String userName;
    private int gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
