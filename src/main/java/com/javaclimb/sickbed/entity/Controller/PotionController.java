package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.entity.Potion;
import com.javaclimb.sickbed.service.IDeptService;
import com.javaclimb.sickbed.service.IPotionService;
import org.omg.CORBA.INV_POLICY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/potion")
@Controller
public class PotionController {

    @Autowired
    public IPotionService iPotionService;

    @RequestMapping
    public String potion(){
        return "/potion";
    }

    @RequestMapping(value = "/potionA")
    public String potionA(){
        return "/potionA";
    }

    @RequestMapping(value = "/potionQueryPage")
    @ResponseBody
    public Object potionQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Potion> iPage = iPotionService.selectPotionPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/potionPage")
    public String potionPage(){
        return "/potionPage";
    }

    @RequestMapping(value = "/potionAdd")
    @ResponseBody
    public Object potionAdd(Potion potion){
        try {
            int i = iPotionService.addPotion(potion);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryPotionById")
    public String queryPotionById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Potion potion = iPotionService.queryPotionById(id);
        model.addAttribute("obj",potion);
        return "/potionPage";
    }

    @RequestMapping(value = "/potionEdit")
    @ResponseBody
    public Object potionEdit(Potion potion){
        try {
            int i = iPotionService.editPotion(potion);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delPotionById")
    @ResponseBody
    public Object delPotionById(Integer id){
        try {
            int i = iPotionService.delPotionById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
