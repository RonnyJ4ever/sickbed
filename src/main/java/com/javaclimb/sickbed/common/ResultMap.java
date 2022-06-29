package com.javaclimb.sickbed.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/*
* 给前端返回的json格式数据
*
*/
@Controller
public class ResultMap {

    /*
    登陆返回结果
    */
    public static HashMap<String,Object> getHashMap(String msg,String code){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg",msg);
        resultMap.put("code",code);
        if ("1".equals(code)){
            resultMap.put("icon",1);
        }else {
            resultMap.put("icon",2);
        }
        resultMap.put("icon",1);
        return resultMap;
    }

    /*
    * 分页查询返回结果
    */
    public static HashMap<String ,Object> getHashMapMysqlIpage(IPage<?> object){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.getTotal());
        resultMap.put("data",object.getRecords());
        return resultMap;

    }
    /*
    * 异常处理返回项
    * */
    public static HashMap<String ,Object> getHashMapException(Exception e){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",e.getMessage());
        return resultMap;

    }

    /*
    * 添加成功的返回格式
    */

    public static HashMap<String ,Object> getHashMapSave(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if (i==0){
            resultMap.put("msg","保存失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","保存成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;

    }

    /*
    *  删除成功的统一返回格式
    */
    public static HashMap<String ,Object> getHashMapDel(int i){
        HashMap<String,Object> resultMap = new HashMap<>();
        if (i==0){
            resultMap.put("msg","删除失败");
            resultMap.put("code",1);
            resultMap.put("icon",5);
            resultMap.put("anim",6);
        }else {
            resultMap.put("msg","删除成功");
            resultMap.put("code",0);
            resultMap.put("icon",1);
            resultMap.put("anim",4);
        }
        return resultMap;

    }

    public static HashMap<String ,Object> getHashMapMysqlList(List<?> object){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",object.stream().count());
        resultMap.put("data",object.stream());
        return resultMap;

    }



}
