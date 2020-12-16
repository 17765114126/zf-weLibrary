package com.example.springboot.controller.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.model.Person;

/**
 * @ClassName Test
 * @Author zhaofu
 * @Date 2020/7/31
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {
        Person msg = new Person();
        msg.setAge(10);
        msg.setName("张三");
        msg.setSex("nan");
//        SyjOrderMO syjOrderMO = new SyjOrderMO();
//        syjOrderMO.setSellerBusinessId(883);
//        msg.setSyjOrderMO(syjOrderMO);
        //对象转Json字符串
        String string1 = JSON.toJSONString(msg);

        //Json字符串转对象
        Person ps = JSON.parseObject(string1, Person.class);
        Person psOne = JSONObject.parseObject(string1, Person.class);
        System.out.println(ps);
        System.out.println(psOne);
    }

}
