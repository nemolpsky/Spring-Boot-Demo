package com.lp.springdemo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lp.springdemo.utils.JsonUtil;

import java.util.Date;

public class TargetModel {
    private int f1;
    private double f2;
    private float f3;
    private String f4;
    private Date f5;
    private Integer f6;
    private Double f7;
    private Float f8;

    public TargetModel(int f1, double f2, float f3, String f4, Date f5, Integer f6, Double f7, Float f8) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;
        this.f7 = f7;
        this.f8 = f8;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public double getF2() {
        return f2;
    }

    public void setF2(double f2) {
        this.f2 = f2;
    }

    public float getF3() {
        return f3;
    }

    public void setF3(float f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public Date getF5() {
        return f5;
    }

    public void setF5(Date f5) {
        this.f5 = f5;
    }

    public Integer getF6() {
        return f6;
    }

    public void setF6(Integer f6) {
        this.f6 = f6;
    }

    public Double getF7() {
        return f7;
    }

    public void setF7(Double f7) {
        this.f7 = f7;
    }

    public Float getF8() {
        return f8;
    }

    public void setF8(Float f8) {
        this.f8 = f8;
    }

    @Override
    public String toString() {
        try {
            return JsonUtil.ObjectToJson(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
