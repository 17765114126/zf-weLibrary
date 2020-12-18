package com.example.springboot.config.Shiro.exception;


import com.example.springboot.utils.ResultCodeEnum;
//提交代码
/**
 * @author chen
 * @create 2020-12-01
 **/
public class BizException extends RuntimeException {

    protected Integer code;

    public BizException() {
        super();
    }

    public BizException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public BizException(String msg, Throwable throwable, Integer code) {
        super(msg, throwable);
        this.code = code;
    }

    public BizException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMsg(), null);
        this.code = resultCodeEnum.getCode();
    }

    public BizException(Integer code, String msg) {
        super(msg, null);
        this.code = code;
    }

    public Integer code() {
        return code;
    }
}
