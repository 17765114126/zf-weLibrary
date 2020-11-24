package com.example.springboot.Controller;

import com.example.springboot.Config.自定义注解.MyLog;
import com.example.springboot.model.Student;
import com.example.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HelloController
 * @Author zhaofu
 * @Date 2019/8/5
 * @Version V1.0
 **/
@RestController
@Slf4j
@Component
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
//        System.out.println(user.getUserName());
        String s = "Hello Spring Boot!==++++++==========+++++++++++++++++++========+我自===gasolene";
        Student student = new Student();
        student.setName("执行Contriller类    Student.name+小熊");
        student.setAge(18);
        log.info("打印日志" + student.toString());
        model.addAttribute("s", s);
        model.addAttribute("student", student);
        return "views/hello";
    }
    /**
    * @Date: 2019/10/18
    * @Author: zhaofu
    * @Description: 自定义切面注解
    **/
    @MyLog(value = "student",method = Student.class)
    @RequestMapping("/helloAop")
    public String Aop(Student student,Model model) {
        student.setName("123456");
        student.setAge(18);
        model.addAttribute("student", student);
        return "views/hello";
    }

//    @Resource
//    private JavaMailSender mailSender;
//
//    @RequestMapping("/sendSimpleMail")
//    public void sendSimpleMail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("17765114126@163.com");
//        message.setTo("17765114126@163.com");
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//
//        mailSender.send(message);
//    }
}
