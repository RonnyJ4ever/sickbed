package com.javaclimb.sickbed.config;

import com.javaclimb.sickbed.entity.User;
import com.javaclimb.sickbed.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
/*
* 权限认证
* */

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /*
    * 登录认证
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User querUser = new User();
        querUser.setUsername(username);
        //根据用户名查询用户是否存在
        User user = userService.queryUserByusername(querUser);
        if (user==null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
