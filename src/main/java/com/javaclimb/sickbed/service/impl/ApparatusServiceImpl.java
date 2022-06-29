package com.javaclimb.sickbed.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Apparatus;
import com.javaclimb.sickbed.mapper.ApparatusMapper;
import com.javaclimb.sickbed.service.IApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApparatusServiceImpl extends ServiceImpl<ApparatusMapper, Apparatus> implements IApparatusService {

    @Autowired
    public ApparatusMapper apparatusMapper;


    @Override
    public IPage<Apparatus> selectApparatusPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Apparatus> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("apparatus_name" ,param);
        }
        Page<Apparatus> page = new Page<>(pageNum,pageSize);
        return apparatusMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addApparatus(Apparatus apparatus) {
        return apparatusMapper.insert(apparatus);
    }

    @Override
    public int editApparatus(Apparatus apparatus) {
        return apparatusMapper.updateById(apparatus);
    }

    @Override
    public Apparatus queryApparatusById(Integer id) {
        return apparatusMapper.selectById(id);
    }

    @Override
    public int delApparatusById(Integer id) {
        return apparatusMapper.deleteById(id);
    }

    @Override
    public List<Apparatus> queryApparatusList() {
        return null;
    }
}
