package com.lp.springdemo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

/**
 *  构建JSON字符串的类，支持连缀调用
 */
public class JsonBuilder {

    private static Map<String, Object> map = null;

    public JsonBuilder() {
        release();
    }

    public void init() {
        map = new HashMap<>();
    }

    public void release() {
        map = null;
    }

    public JsonBuilder put(String key, Object value) {
        if (map == null) {
            init();
        }
        map.put(key, value);
        return this;
    }

    public String toJson() throws JsonProcessingException {
        String jsonStr = JsonUtil.MapToJson(map);
        release();
        return jsonStr;
    }
}
