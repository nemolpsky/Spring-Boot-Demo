package com.lp.springdemo.controller;

import com.google.common.base.Preconditions;
import com.lp.springdemo.exception.OperationException;
import com.lp.springdemo.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String testIndex(){
        return "this is test index";
    }


    @RequestMapping("/findUser")
    public String findUser(@RequestBody UserModel model){
        return model.toString();
    }

    @RequestMapping("/findUserByAge")
    public void findUserByAge(@RequestBody UserModel model){
        int num = model.getAge() / 0;
    }

    @RequestMapping("/testException")
    public void testException() throws OperationException {
        throw new OperationException("00-0001","test exception");
    }

    @RequestMapping("/testAssert")
    public void testAssert() throws OperationException {
        int i = 0;
        Preconditions.checkArgument(i>1,"testAssert error");
    }
}
