package com.javaclimb.sickbed.entity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String ToString(){
        return "大家好!!!";
    }
}
