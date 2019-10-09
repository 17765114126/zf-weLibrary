package com.example.springboot.model;

import lombok.Data;
import java.io.Serializable;

/**
* @Date: 2019/9/26
* @Author: zhaofu
* @Description: 学生类
**/
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 3577522325645247161L;
    private String name;
    private Integer age;
}
