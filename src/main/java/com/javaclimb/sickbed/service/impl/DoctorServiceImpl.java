package com.javaclimb.sickbed.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.mapper.DoctorMapper;
import com.javaclimb.sickbed.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {

    @Autowired
    public DoctorMapper doctorMapper;

    @Override
    public IPage<Doctor> selectDoctorPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("doc_name" ,param);
        }
        Page<Doctor> page = new Page<>(pageNum,pageSize);
        return doctorMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addDoctor(Doctor doctor) {
        return doctorMapper.insert(doctor);
    }

    @Override
    public int editDoctor(Doctor doctor) {
        return doctorMapper.updateById(doctor);
    }
    @Override
    public Doctor queryDoctorById(Integer id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public int delDoctorById(Integer id) {
        return doctorMapper.deleteById(id);
    }

    @Override
    public List<Doctor> queryDoctorList() {
        return null;
    }

    @Override
    public IPage<Doctor> selDocByBelongHome(int pageNum, int pageSize,String docBelong) {
        QueryWrapper<Doctor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("doc_belong",docBelong);
        Page<Doctor> page = new Page<>(pageNum,pageSize);
        return doctorMapper.selectPage(page,queryWrapper);
    }
}
