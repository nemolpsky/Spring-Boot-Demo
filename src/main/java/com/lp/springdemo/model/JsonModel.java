package com.lp.springdemo.model;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

// 将该对象转为json时忽略所有为空的字段
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonModel {

    private int age;

    // 字段转为json时重命名
    @JsonProperty("userName")
    private String name;

    private Double money1;

    private Long id1;

    private double money2;

    private long id2;

    public JsonModel() {
    }

    public JsonModel(int age, String name, Double money1, Long id1, double money2, long id2) {
        this.age = age;
        this.name = name;
        this.money1 = money1;
        this.id1 = id1;
        this.money2 = money2;
        this.id2 = id2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney1() {
        return money1;
    }

    public void setMoney1(Double money1) {
        this.money1 = money1;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public double getMoney2() {
        return money2;
    }

    public void setMoney2(double money2) {
        this.money2 = money2;
    }

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
