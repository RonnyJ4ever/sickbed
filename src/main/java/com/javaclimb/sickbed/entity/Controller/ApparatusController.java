package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Apparatus;
import com.javaclimb.sickbed.service.IApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/apparatus")
@Controller
public class ApparatusController {

    @Autowired
    public IApparatusService iApparatusService;

    @RequestMapping
    public String appartus(){
        return "/apparatus";
    }

    @RequestMapping(value = "/apparatusA")
    public String apparatusA(){
        return "/apparatusA";
    }

    @RequestMapping(value = "/apparatusQueryPage")
    @ResponseBody
    public Object apparatusQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Apparatus> iPage = iApparatusService.selectApparatusPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/apparatusPage")
    public String apparatusPage(){
        return "/apparatusPage";
    }

    @RequestMapping(value = "/apparatusAdd")
    @ResponseBody
    public Object apparatusAdd(Apparatus apparatus){
        try {
            int i = iApparatusService.addApparatus(apparatus);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryApparatusById")
    public String queryApparatusById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Apparatus apparatus = iApparatusService.queryApparatusById(id);
        model.addAttribute("obj",apparatus);
        return "/apparatusPage";
    }

    @RequestMapping(value = "/apparatusEdit")
    @ResponseBody
    public Object apparatusEdit(Apparatus apparatus){
        try {
            int i = iApparatusService.editApparatus(apparatus);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delApparatusById")
    @ResponseBody
    public Object delApparatusById(Integer id){
        try {
            int i = iApparatusService.delApparatusById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
