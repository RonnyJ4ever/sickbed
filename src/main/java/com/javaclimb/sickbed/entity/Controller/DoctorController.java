package com.javaclimb.sickbed.entity.Controller;



import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping(value = "/doctor")
@Controller
public class DoctorController {


    @Autowired
    public IDoctorService iDoctorService;

    @RequestMapping
    public String doctor(){
        return "/doctor";
    }

    @RequestMapping(value = "/doctorA")
    public String doctorA(){
        return "/doctorA";
    }


    @RequestMapping(value = "/doctorQueryPage")
    @ResponseBody
    public Object doctorQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Doctor> iPage = iDoctorService.selectDoctorPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/doctorPage")
    public String doctorPage(){
        return "/doctorPage";
    }

    @RequestMapping(value = "/doctorPageA")
    public String doctorPageA(){
        return "/doctorPageA";
    }

    @RequestMapping(value = "/doctorAdd")
    @ResponseBody
    public Object doctorAdd(Doctor doctor){
        try {
            int i = iDoctorService.addDoctor(doctor);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryDoctorById")
    public String queryDoctorById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Doctor doctor = iDoctorService.queryDoctorById(id);
        model.addAttribute("obj",doctor);
        return "/doctorPage";
    }

    @RequestMapping(value = "/queryDoctorByName")
    public String queryDoctorByName(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize,@RequestParam(name = "docBelong",required = true)String docBelong ){
        IPage<Doctor> doctor = iDoctorService.selDocByBelongHome(pageNum,pageSize,docBelong);
        return "/doctorPageA";
    }

    @RequestMapping(value = "/queryDoctorByNameA")
    @ResponseBody
    public Object queryDoctorByNameA(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize,@RequestParam(name = "docBelong",required = true)String docBelong){
        IPage<Doctor> doctor = iDoctorService.selDocByBelongHome(pageNum,pageSize,docBelong);
        return ResultMap.getHashMapMysqlIpage(doctor);
    }

    @RequestMapping(value = "/doctorEdit")
    @ResponseBody
    public Object doctorEdit(Doctor doctor){
        try {
            int i = iDoctorService.editDoctor(doctor);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delDoctorById")
    @ResponseBody
    public Object delDoctorById(Integer id){
        try {
            int i = iDoctorService.delDoctorById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
