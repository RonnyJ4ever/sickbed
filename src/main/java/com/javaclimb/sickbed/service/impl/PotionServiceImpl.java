package com.javaclimb.sickbed.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Potion;
import com.javaclimb.sickbed.mapper.DoctorMapper;
import com.javaclimb.sickbed.mapper.PotionMapper;
import com.javaclimb.sickbed.service.IDoctorService;
import com.javaclimb.sickbed.service.IPotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotionServiceImpl extends ServiceImpl<PotionMapper, Potion> implements IPotionService {

    @Autowired
    public PotionMapper potionMapper;


    @Override
    public IPage<Potion> selectPotionPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Potion> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)){
            queryWrapper.like("potion_name" ,param);
        }
        Page<Potion> page = new Page<>(pageNum,pageSize);
        return potionMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addPotion(Potion potion) {
        return potionMapper.insert(potion);
    }

    @Override
    public int editPotion(Potion potion) {
        return potionMapper.updateById(potion);
    }

    @Override
    public Potion queryPotionById(Integer id) {
        return potionMapper.selectById(id);
    }

    @Override
    public int delPotionById(Integer id) {
        return potionMapper.deleteById(id);
    }

    @Override
    public List<Potion> queryDoctorList() {
        return null;
    }
}
