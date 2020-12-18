package com.example.springboot.controller.Redis;

import com.example.springboot.model.Student;
import com.example.springboot.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @ClassName RedisController
 * @Author zhaofu
 * @Date 2019/8/27
 * @Version V1.0
 * <p>
 * 所依赖util
 * RedisConfig
 * RedisUtil
 * 启动不成功----本地没有下载 redis导致连接不到
 **/
@Controller
@Slf4j
public class RedisController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/redisTest")
    public String redisTest() {
        try {
            Student student = new Student();
            student.setName("专诸");
            student.setAge(18);
            log.info("Redis启动日志------------------" + student.toString());
            redisUtil.set("s", student.getName());
            redisUtil.set("s","555",1000 * 50);
            String s1 = redisUtil.get("s").toString();
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("错误==============" + e);
        }
        return "启动成功";
    }
}
