package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/dept")
@Controller
public class DeptController {

    @Autowired
    public IDeptService iDeptService;

    @RequestMapping
    public String dept(){
        return "/dept";
    }

    @RequestMapping(value = "/deptA")
    public String deptA(){
        return "/deptA";
    }

    @RequestMapping(value = "/deptQueryPage")
    @ResponseBody
    public Object deptQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Dept> iPage = iDeptService.selectDeptPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/deptPage")
    public String deptPage(){
        return "/deptPage";
    }

    @RequestMapping(value = "/deptAdd")
    @ResponseBody
    public Object deptAdd(Dept dept){
        try {
            int i = iDeptService.addDept(dept);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryDeptById")
    public String queryDeptById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Dept dept = iDeptService.queryDeptById(id);
        model.addAttribute("obj",dept);
        return "/deptPage";
    }

    @RequestMapping(value = "/deptEdit")
    @ResponseBody
    public Object deptEdit(Dept dept){
        try {
            int i = iDeptService.editDept(dept);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delDeptById")
    @ResponseBody
    public Object delDeptById(Integer id){
        try {
            int i = iDeptService.delDeptById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }


}
