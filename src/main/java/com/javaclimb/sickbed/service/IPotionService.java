package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Potion;

import java.util.List;

public interface IPotionService extends IService<Potion> {
    public IPage<Potion> selectPotionPage(int pageNum, int pageSize, String param);
    //增加
    public int addPotion(Potion potion);
    //修改
    public int editPotion(Potion potion);
    //查找byid
    public Potion queryPotionById(Integer id);
    //删除byid
    public int delPotionById(Integer id);
    //查询所有药品信息
    public List<Potion> queryDoctorList();

}
