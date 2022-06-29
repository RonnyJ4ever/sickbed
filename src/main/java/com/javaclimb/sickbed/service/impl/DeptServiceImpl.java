package com.javaclimb.sickbed.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.mapper.DeptMapper;
import com.javaclimb.sickbed.mapper.DoctorMapper;
import com.javaclimb.sickbed.service.IDeptService;
import com.javaclimb.sickbed.service.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    public DeptMapper deptMapper;

    @Override
    public IPage<Dept> selectDeptPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("dept_name" ,param);
        }
        Page<Dept> page = new Page<>(pageNum,pageSize);
        return deptMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int editDept(Dept dept) {
        return deptMapper.updateById(dept);
    }

    @Override
    public Dept queryDeptById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public int delDeptById(Integer id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public List<Dept> queryDeptList() {
        return null;
    }
}
