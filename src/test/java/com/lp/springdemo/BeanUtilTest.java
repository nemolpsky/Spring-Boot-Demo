package com.lp.springdemo;

import com.lp.springdemo.model.SourceModel;
import com.lp.springdemo.model.TargetModel;
import com.lp.springdemo.utils.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class BeanUtilTest {

    public static void main(String[] args) {
        SourceModel s1 = new SourceModel(0,0,0,"ss",new Date(),0,0D,0F);
        TargetModel t1 = new TargetModel(1,1,1,"tt",new Date(),1,1D,1F);
        BeanUtil.copyPropertiesIgnoreZero(s1,t1);
        System.out.println(t1);
        System.out.println("------------------------------------------------");
        SourceModel s2 = new SourceModel(4,2,5,null,null,null,null,null);
        TargetModel t2 = new TargetModel(1,1,1,"tt",new Date(),1,1D,1F);
        BeanUtil.copyPropertiesIgnoreNull(s2,t2);
        System.out.println(t2);
        System.out.println("------------------------------------------------");
        SourceModel s3 = new SourceModel(0,0,0,"",new Date(),0,0D,0F);
        TargetModel t3 = new TargetModel(1,1,1,"tt",new Date(),1,1D,1F);
        BeanUtil.copyPropertiesIgnoreEmpty(s3,t3);
        System.out.println(t3);
        System.out.println("------------------------------------------------");
        SourceModel s4 = new SourceModel(0,0,0,null,null,null,null,null);
        TargetModel t4 = new TargetModel(1,1,1,"tt",new Date(),1,1D,1F);
        BeanUtils.copyProperties(s4, t4);
        System.out.println(t4);
    }
}
