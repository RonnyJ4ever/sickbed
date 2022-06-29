package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Bed;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.service.IBedService;
import com.javaclimb.sickbed.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/bed")
@Controller
public class BedController {

    @Autowired
    public IBedService iBedService;

    @RequestMapping
    public String bed(){
        return "/bed";
    }

    @RequestMapping(value = "/bedA")
    public String bedA(){
        return "/bedA";
    }

    @RequestMapping(value = "/bedQueryPage")
    @ResponseBody
    public Object deptQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Bed> iPage = iBedService.selectBedPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/bedPage")
    public String bedPage(){
        return "/bedPage";
    }

    @RequestMapping(value = "/bedAdd")
    @ResponseBody
    public Object bedAdd(Bed bed){
        try {
            int i = iBedService.addBed(bed);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryBedById")
    public String queryBedById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Bed bed = iBedService.queryBedById(id);
        model.addAttribute("obj",bed);
        return "/bedPage";
    }

    @RequestMapping(value = "/bedEdit")
    @ResponseBody
    public Object bedEdit(Bed bed){
        try {
            int i = iBedService.editBed(bed);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delBedById")
    @ResponseBody
    public Object delBedById(Integer id){
        try {
            int i = iBedService.delBedById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
