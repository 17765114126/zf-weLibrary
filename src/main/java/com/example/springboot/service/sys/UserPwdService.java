package com.example.springboot.service.sys;


import com.example.springboot.utils.Result;

public interface UserPwdService {
        Result updatePwd(String oldPwd, String newPwd);
        Result updateDefaultPwd(String mobile);
}
