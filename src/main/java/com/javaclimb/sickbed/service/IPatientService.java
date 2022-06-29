package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Patient;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface IPatientService extends IService<Patient> {

    public IPage<Patient> selectPatientPage(int pageNum,int pageSize,String param);
    //增加
    public int addPatient(Patient patient);
    //修改
    public int editPatient(Patient patient);
    //查找byid
    public Patient queryPatientById(Integer id);
    //删除byid
    public int delPatientById(Integer id);
    //查询所有病人
    public List<Patient> queryPatientList();

    public IPage<Patient> selPatByBelongHome(int pageNum, int pageSize,String belongHome);

    public List<Patient> apply();

    public int update(@Param("id") int id);

}
