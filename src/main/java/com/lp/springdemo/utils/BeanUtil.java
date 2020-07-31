package com.lp.springdemo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class BeanUtil {

    // 操作类型
    public static final int IS_NULL = 1;
    public static final int IS_EMPTY = 2;
    public static final int IS_ZERO = 3;
    public static final int ALL = 4;

//    public static <T> void setInitValue(T t, Long userId, String userName, Date date) {
//        final BeanWrapper wrapper = new BeanWrapperImpl(t);
//        if (wrapper.isWritableProperty("isValid")) {
//            wrapper.setPropertyValue("isValid", ConstantsPublic.IS_VALID_YES);
//        }
//        if (!StringUtil.isNull(userId)) {
//            if (wrapper.isWritableProperty("createUserId")) {
//                wrapper.setPropertyValue("createUserId", userId);
//            }
//            if (wrapper.isWritableProperty("modifyUserId")) {
//                wrapper.setPropertyValue("modifyUserId", userId);
//            }
//        }
//
//        if (!StringUtil.isNull(userName)) {
//            if (wrapper.isWritableProperty("createBy")) {
//                wrapper.setPropertyValue("createBy", userName);
//            }
//            if (wrapper.isWritableProperty("modifyBy")) {
//                wrapper.setPropertyValue("modifyBy", userName);
//            }
//        }
//
//        if (!StringUtil.isNull(date)) {
//            if (wrapper.isWritableProperty("createTime")) {
//                wrapper.setPropertyValue("createTime", date);
//            }
//            if (wrapper.isWritableProperty("modifyTime")) {
//                wrapper.setPropertyValue("modifyTime", date);
//            }
//        }
//        return t;
//    }

    /***
     *  拷贝属性，忽略null字段
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreNull(Object source,Object target){
        String[] emptyArr = getSpecifiedProperties(source, IS_NULL);
        BeanUtils.copyProperties(source,target,emptyArr);
    }

    /***
     *  拷贝属性，忽略null和空字段
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreEmpty(Object source,Object target){
        String[] emptyArr = getSpecifiedProperties(source, IS_EMPTY);
        BeanUtils.copyProperties(source,target,emptyArr);
    }

    /***
     *  拷贝属性，忽略数值为0的字段，支持基本类型和包装类
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreZero(Object source,Object target){
        String[] emptyArr = getSpecifiedProperties(source, IS_ZERO);
        BeanUtils.copyProperties(source,target,emptyArr);
    }

    /***
     *  拷贝属性，上述三种忽略方式的汇总
     * @param source 源对象
     * @param target 目标对象
     */
    public static void copyPropertiesIgnoreAll(Object source,Object target){
        String[] emptyArr = getSpecifiedProperties(source, ALL);
        BeanUtils.copyProperties(source,target,emptyArr);
    }


    /**
     *  获取指定类型的字段集合
     * @param object 操作对象
     * @param type 操作类型 1：null值 2：空和null值 3：0值
     * @return
     */
    public static String[] getSpecifiedProperties(Object object,Integer type){
        String[] emptyArr = new String[]{};
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);
        PropertyDescriptor[] properties = beanWrapper.getPropertyDescriptors();
        if (ObjectUtils.isEmpty(properties)){
            return emptyArr;
        }

        Set<String> emptySet = new HashSet<>(properties.length);
        for(PropertyDescriptor property:properties){
            Object value = beanWrapper.getPropertyValue(property.getName());
            if (type.equals(IS_NULL)){
                getNullProperties(emptySet,value,property);
            }else if(type.equals(IS_EMPTY)){
                getEmptyStringProperties(emptySet,value,property);
                getNullProperties(emptySet,value,property);
            }else if(type.equals(IS_ZERO)){
                getZeroProperties(emptySet,value,property);
            }else if(type.equals(ALL)){
                getNullProperties(emptySet,value,property);
                getEmptyStringProperties(emptySet,value,property);
                getZeroProperties(emptySet,value,property);
            }
        }

        if (ObjectUtils.isEmpty(emptySet)){
            return emptyArr;
        }

        emptyArr = new String[emptySet.size()];
        return emptySet.toArray(emptyArr);
    }

    /**
     *  判断是否0值
     * @param emptySet 存放集合
     * @param value 字段值
     * @param property 字段对象
     */
    public static void getZeroProperties(Set<String> emptySet,Object value,PropertyDescriptor property){
        boolean isZero = false;
        String typeStr = property.getPropertyType().toString();
        if (value != null ) {
            if (typeStr.contains("int") || typeStr.contains("Integer")){
                if ((int)value==0){
                    isZero = true;
                }
            }else if(typeStr.contains("long") || typeStr.contains("Long")){
                if ((long)value==0){
                    isZero = true;
                }
            }else if(typeStr.contains("double") || typeStr.contains("Double")){
                if ((double)value==0){
                    isZero = true;
                }
            }else if(typeStr.contains("float") || typeStr.contains("Float")){
                if ((float)value==0){
                    isZero = true;
                }
            }
            else if(typeStr.contains("short") || typeStr.contains("Short")){
                if ((float)value==0){
                    isZero = true;
                }
            }
            if (isZero) {
                emptySet.add(property.getName());
            }
        }
    }

    /**
     *  判断是否null值和空值
     * @param emptySet 存放集合
     * @param value 字段值
     * @param property 字段对象
     */
    public static void getEmptyStringProperties(Set<String> emptySet,Object value,PropertyDescriptor property){
        if (value != null && property.getPropertyType().toString().contains("String")) {
            emptySet.add(property.getName());
        }
    }

    /**
     *  判断是否null值
     * @param emptySet 存放集合
     * @param value 字段值
     * @param property 字段对象
     */
    public static void getNullProperties(Set<String> emptySet,Object value,PropertyDescriptor property){
        if (value == null) {
            emptySet.add(property.getName());
        }
    }
}
