package com.example.springboot.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
* @Date: 2019/9/26
* @Author: zhaofu
* @Description: 学生类
**/
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 3577522325645247161L;
    @Value("昴")
    private String name = "昴";
    @Value("23")
    private Integer age = 23;
}
