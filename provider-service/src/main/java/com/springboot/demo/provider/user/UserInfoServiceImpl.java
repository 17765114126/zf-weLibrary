package com.springboot.demo.provider.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.base.api.UserInfoService;
import com.demo.base.pojo.UserInfoDTO;
import com.demo.base.pojo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Service//将服务发布出去
@Component//放在容器中
public class UserInfoServiceImpl implements UserInfoService {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public UserInfoVO getUserInfo(UserInfoDTO dto) {

        UserInfoVO vo = new UserInfoVO();
        vo.setId(dto.getId());
        vo.setAge(dto.getAge());
        vo.setName(dto.getName());
        vo.setAddress("西湖");
        return vo;
    }

    @Override
    public UserInfoVO getUserInfoById(Long id) {
        UserInfoVO vo = new UserInfoVO();
        vo.setId(id);
        vo.setAge(20);
        vo.setName("小明");
        vo.setAddress("茅家埠");
        return vo;
    }
}
