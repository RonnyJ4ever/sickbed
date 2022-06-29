package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Patient;
import com.javaclimb.sickbed.service.IPatientService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    public IPatientService iPatientService;

    @RequestMapping
    public String patient(){
        return "/patient";
    }

    @RequestMapping(value = "/patientA")
    public String patientA(){
        return "/patientA";
    }

    @RequestMapping(value = "/patientC")
    public String patientC(){
        return "/patientC";
    }

    @RequestMapping(value = "/patientQueryPage")
    @ResponseBody
    public Object patientQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Patient> iPage = iPatientService.selectPatientPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/patientPage")
    public String patientPage(){
        return "/patientPage";
    }

    @RequestMapping(value = "/patientPageA")
    public String patientPageA(){
        return "/patientPageA";
    }

    @RequestMapping(value = "/patientPageB")
    public String patientPageB(){
        return "/patientPageB";
    }

    @RequestMapping(value = "/patientPageC")
    public String patientPageC(){
        return "/patientPageC";
    }

    @RequestMapping(value = "/patientAdd")
    @ResponseBody
    public Object patientAdd(Patient patient){
        try {
            patient.setInTime(new Date());
            int i = iPatientService.addPatient(patient);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryPatientById")
    public String queryPatientById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Patient patient = iPatientService.queryPatientById(id);
        model.addAttribute("obj",patient);
        return "/patientPage";
    }

    @RequestMapping(value = "/queryPatientByIdB")
    public String queryPatientByIdB(@RequestParam(name = "id",required = true)Integer id, Model model){
        Patient patient = iPatientService.queryPatientById(id);
        model.addAttribute("obj",patient);
        return "/patientPageB";
    }

    @RequestMapping(value = "/queryPatientByIdC")
    public String queryPatientByIdC(@RequestParam(name = "id",required = true)Integer id, Model model){
        Patient patient = iPatientService.queryPatientById(id);
        model.addAttribute("obj",patient);
        return "/patientPageC";
    }

    @RequestMapping(value = "/queryPatientByBelongHome")
    public String queryDoctorByName(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize,@RequestParam(name = "belongHome",required = true)String belongHome){
        IPage<Patient> patient =iPatientService.selPatByBelongHome(pageNum,pageSize,belongHome);
        return "/patientPageA";
    }

    @RequestMapping(value = "/queryPatientByBelongHomeA")
    @ResponseBody
    public Object queryDoctorByNameA(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize,@RequestParam(name = "belongHome",required = true)String belongHome){
        IPage<Patient> patient =iPatientService.selPatByBelongHome(pageNum,pageSize,belongHome);
        return ResultMap.getHashMapMysqlIpage(patient);
    }

    @RequestMapping(value = "/patientEdit")
    @ResponseBody
    public Object patientEdit(Patient patient){
        try {
            int i = iPatientService.editPatient(patient);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delPatientById")
    @ResponseBody
    public Object delPatientById(Integer id){
        try {
            int i = iPatientService.delPatientById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/apply")
    @ResponseBody
    public Object apply(){
        List<Patient> patients = iPatientService.apply();
        JSONArray jsonArray = JSONArray.fromObject(patients);
        return jsonArray;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@RequestParam(name = "id",required = true)int id){
        try {
            int i = iPatientService.update(id);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }
}
