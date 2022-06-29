package com.javaclimb.sickbed.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Patient;
import com.javaclimb.sickbed.mapper.PatientMapper;
import com.javaclimb.sickbed.service.IPatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class PatientImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

    @Autowired
    public PatientMapper patientMapper;


    @Override
    public IPage<Patient> selectPatientPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Patient> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<Patient> page = new Page<>(pageNum, pageSize);
        return patientMapper.selectPage(page, queryWrapper);
    }

    @Override
    public int addPatient(Patient patient) {
        return patientMapper.insert(patient);
    }

    @Override
    public int editPatient(Patient patient) {
        return patientMapper.updateById(patient);
    }

    @Override
    public Patient queryPatientById(Integer id) {
        return patientMapper.selectById(id);
    }

    @Override
    public int delPatientById(Integer id) {
        return patientMapper.deleteById(id);
    }

    @Override
    public List<Patient> queryPatientList() {
        return patientMapper.selectList(null);
    }

    @Override
    public IPage<Patient> selPatByBelongHome(int pageNum, int pageSize, String belongHome) {
        QueryWrapper<Patient> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("belong_home", belongHome);
        Page<Patient> page = new Page<>(pageNum, pageSize);
        return patientMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<Patient> apply() {
        return patientMapper.apply();
    }

    @Override
    public int update(int id) {
        patientMapper.update(id);
        return 1;
    }


}

