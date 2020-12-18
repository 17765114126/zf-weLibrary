package com.example.springboot.config.Shiro.security;

import com.example.springboot.model.sys.SysPermission;
import com.example.springboot.model.sys.SysRole;
import com.example.springboot.model.sys.SysUser;
import com.example.springboot.service.sys.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //权限配置
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userInfo = (SysUser) principals.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoles()) {
            authorizationInfo.addRole(role.getName());
            for (SysPermission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getName());
            }
        }
        return authorizationInfo;
    }

    /**主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。  */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String mobile = (String) token.getPrincipal();
        SysUser sysUser = sysUserService.getUserByMobile(mobile);
        if (sysUser == null) {
            return null;
        }
        //账户禁用
        if (sysUser.getStatus() == 2) {
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                sysUser,
                //密码
                sysUser.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(sysUser.getSalt()),
                //realm name
                getName()
        );

        return authenticationInfo;
    }

}
