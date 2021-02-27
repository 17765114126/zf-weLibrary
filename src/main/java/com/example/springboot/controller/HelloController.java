package com.example.springboot.controller;

import com.example.springboot.model.sys.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Author zhaofu
 * @Date 2019/8/5
 * @Version V1.0
 **/
@Controller
@Slf4j
@Component
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        String s = "Hello Spring Boot!==++++++==========+++++++++++++++++++========+我自===gasolene";
        SysUser student = new SysUser();
        student.setUsername("执行Contriller类    Student.name+小熊");
        student.setMobile("17765114126");
        log.info("打印日志" + student.toString());
        model.addAttribute("s", s);
        model.addAttribute("student", student);
        return "/error/404";
    }

}
