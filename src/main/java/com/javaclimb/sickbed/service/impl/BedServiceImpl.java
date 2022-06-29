package com.javaclimb.sickbed.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Bed;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.entity.Patient;
import com.javaclimb.sickbed.mapper.BedMapper;
import com.javaclimb.sickbed.mapper.DeptMapper;
import com.javaclimb.sickbed.mapper.UserMapper;
import com.javaclimb.sickbed.service.IBedService;
import com.javaclimb.sickbed.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements IBedService {

    @Autowired
    public BedMapper bedMapper;

    @Override
    public IPage<Bed> selectBedPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Bed> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("bed_num" ,param);
        }
        Page<Bed> page = new Page<>(pageNum,pageSize);
        return bedMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addBed(Bed bed) {
        return bedMapper.insert(bed);
    }

    @Override
    public int editBed(Bed bed) {
        return bedMapper.updateById(bed);
    }

    @Override
    public Bed queryBedById(Integer id) {
        return bedMapper.selectById(id);
    }

    @Override
    public int delBedById(Integer id) {
        return bedMapper.deleteById(id);
    }





}
