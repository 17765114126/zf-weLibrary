package com.example.springboot.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName User
 * @Author zhaofu
 * @Date 2019/10/26
 * @Version V1.0
 * @Description: 注解@Component("user")用来装配你的Bean
 **/
@Component("user")
@Data
public class User {
    @Value("1")
    private Long id;
    @Value("user_name_1")
    private String userName;
    @Value("note_1")
    private String note;
}
