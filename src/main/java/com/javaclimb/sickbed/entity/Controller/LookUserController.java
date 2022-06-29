package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Apparatus;
import com.javaclimb.sickbed.entity.User;
import com.javaclimb.sickbed.service.IApparatusService;
import com.javaclimb.sickbed.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/user")
@Controller
public class LookUserController {

    @Autowired
    public IUserService iUserServicel;

    @RequestMapping
    public String user(){
        return "/user";
    }


    @RequestMapping(value = "/userA")
    public String userA(){
        return "/userA";
    }

    @RequestMapping(value = "/userQueryPage")
    @ResponseBody
    public Object userQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<User> iPage = iUserServicel.selectUserPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/userPage")
    public String userPage(){
        return "/userPage";
    }

    @RequestMapping(value = "/userAdd")
    @ResponseBody
    public Object userAdd(User user){
        try {
            int i = iUserServicel.addUser(user);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryUserById")
    public String queryUserById(@RequestParam(name = "id",required = true)Integer id, Model model){
        User user = iUserServicel.queryUserById(id);
        model.addAttribute("obj",user);
        return "/userPage";
    }

    @RequestMapping(value = "/userEdit")
    @ResponseBody
    public Object userEdit(User user){
        try {
            int i = iUserServicel.editUser(user);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delUserById")
    @ResponseBody
    public Object delUserById(Integer id){
        try {
            int i = iUserServicel.delUserById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
