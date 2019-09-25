package com.example.springboot.Controller;

import com.example.springboot.model.Student;
import lombok.extern.slf4j.Slf4j;
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
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        String s = "Hello Spring Boot!==++++++==========+++++++++++++++++++========+我自===gasolene";
        Student student = new Student();
        student.setName("执行Contriller类    Student.name+小熊");
        student.setAge(18);
        log.info("打印日志" + student.toString());
        model.addAttribute("s", s);
        model.addAttribute("student", student);
        return "views/hello";
    }

}
