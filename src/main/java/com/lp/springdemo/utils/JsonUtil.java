package com.lp.springdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    /**
     *  对象转JSON
     * @param object
     * @return JSON字符串
     * @throws JsonProcessingException
     */
    public static String ObjectToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }


    /**
     *  JSON转对象
     * @param jsonStr JSON字符串
     * @param clazz 对象类字节码
     * @return
     * @throws JsonProcessingException
     */
    public static  <T> T JsonToObject(String jsonStr,Class<T> clazz) throws JsonProcessingException {
        return  objectMapper.readValue(jsonStr,clazz);
    }

    /**
     *  JSON转List
     * @param jsonStr  JSON字符串
     * @param object 所转换的对象
     * @param <T> 对象类型
     * @return
     * @throws JsonProcessingException
     */
    public static  <T> List<T> JsonToList(String jsonStr, T object) throws JsonProcessingException{
        return objectMapper.readValue(jsonStr, new TypeReference<List<T>>() {});
    }

    /**
     *  JSON转Map
     * @param jsonStr JSON字符串
     * @return
     */
    public static  Map<String,Object> JsonToMap(String jsonStr) throws JsonProcessingException {
        return objectMapper.readValue(jsonStr, new TypeReference<Map<String,Object>>() {});
    }

    /**
     * Map转JSON
     * @param map
     * @return
     * @throws JsonProcessingException
     */
    public static String MapToJson(Map<String,Object> map) throws JsonProcessingException{
        return objectMapper.writeValueAsString(map);
    }


    /**
     *  创建JSON字符串
     * @return
     */
    public static JsonBuilder builderJson(){
        return new JsonBuilder();
    }

}
