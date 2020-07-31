package com.lp.springdemo.controller;

import com.lp.springdemo.model.JsonModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/json")
public class JsonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/testModel")
    public JsonModel testModel(@RequestBody JsonModel model){
        return model;
    }


}
