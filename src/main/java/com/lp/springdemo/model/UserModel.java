package com.lp.springdemo.model;

import cn.hutool.json.JSONUtil;

public class UserModel {
    private int age;
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
