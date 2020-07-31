package com.lp.springdemo;

import cn.hutool.core.map.MapUtil;
import com.lp.springdemo.model.JsonModel;
import com.lp.springdemo.utils.JsonUtil;

import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    public static void main(String[] args) throws Exception{
        JsonModel model = new JsonModel(1,"name",1.5788D,1L,2.9977D,2L);
        String json = JsonUtil.ObjectToJson(model);
        System.out.println(json);
        System.out.println("------------------------------------------------");
        System.out.println(JsonUtil.JsonToObject(json,model.getClass()));
        System.out.println("------------------------------------------------");
        System.out.println(JsonUtil.JsonToMap(json));
        System.out.println("------------------------------------------------");
        Map<String,Object> map = new HashMap<>();
        MapUtil.builder(map)
                .put("age",1)
                .put("money1",1.55687D)
                .put("id1",1L)
                .put("userName","name");
        System.out.println(JsonUtil.MapToJson(map));
        System.out.println("------------------------------------------------");
        String jsonStr =
                JsonUtil.builderJson()
                .put("k1",1)
                .put("k2",2)
                .put("k3",3)
                .put("k4",4)
                .toJson();
        System.out.println(jsonStr);
        System.out.println("------------------------------------------------");
        String jsonStr1 = JsonUtil.builderJson()
                .put("k11",1)
                .put("k22",2)
                .put("k33",3)
                .put("k44",4)
                .toJson();
        System.out.println(jsonStr1);
    }
}
