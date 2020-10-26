package com.example.springboot.Config.Shiro.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {

//    @Resource
//    private SuBusinessMapper businessMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //权限配置
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        SysUser userInfo = (SysUser) principals.getPrimaryPrincipal();
//        for (SysRole role : userInfo.getRoles()) {
//            authorizationInfo.addRole(role.getName());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getName());
//            }
//        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
//        String mobile = (String) token.getPrincipal();
//        List<SuBusiness> businessesList = businessMapper.selectList(new QueryWrapper<SuBusiness>().lambda().eq(SuBusiness::getMobile, mobile));
//        if (businessesList == null) {
//            return null;
//        }
//        if (businessesList.get(0).getStatus() != 1) { //账户禁用
//            throw new LockedAccountException();
//        }
//        SuBusiness business = businessesList.get(0);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                business, //用户名
//                business.getLoginPwd(), //密码
//                ByteSource.Util.bytes(sysUser.getSalt()),//salt=username+salt
//                getName()  //realm name
        );

        return authenticationInfo;
    }

}
