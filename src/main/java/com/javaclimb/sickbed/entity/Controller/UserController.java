package com.javaclimb.sickbed.entity.Controller;

import com.javaclimb.sickbed.common.ResultMap;

import com.javaclimb.sickbed.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {

    @Autowired
    public IUserService iUserService;

    @RequestMapping(value = "/login")
    public String login(){
        return "/login";
    }

    /*
    * 判断用户登录
    * */
    @RequestMapping(value = "/tologin")
    @ResponseBody
    public Object tologin(String username,String password){
        if (username==null||password==null){
            return ResultMap.getHashMap("用户名或密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            return ResultMap.getHashMap("用户名不存在","4");
        }catch (IncorrectCredentialsException e){
            return ResultMap.getHashMap("密码错误","3");
        }
        return ResultMap.getHashMap("验证成功","1");
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/doctorIndex")
    public String doctorIndex(){
        return "/doctorIndex";
    }

}
