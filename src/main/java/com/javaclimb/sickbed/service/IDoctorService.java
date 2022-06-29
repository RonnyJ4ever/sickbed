package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Patient;

import java.util.List;

public interface IDoctorService extends IService<Doctor> {
    public IPage<Doctor> selectDoctorPage(int pageNum, int pageSize, String param);
    //增加
    public int addDoctor(Doctor doctor);
    //修改
    public int editDoctor(Doctor doctor);
    //查找byid
    public Doctor queryDoctorById(Integer id);
    //删除byid
    public int delDoctorById(Integer id);
    //查询所有医生
    public List<Doctor> queryDoctorList();

    public IPage<Doctor> selDocByBelongHome(int pageNum, int pageSize,String docBelong);
}
