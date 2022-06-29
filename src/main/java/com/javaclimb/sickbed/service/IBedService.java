package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Bed;
import com.javaclimb.sickbed.entity.Dept;
import com.javaclimb.sickbed.entity.Patient;

import java.util.List;

public interface IBedService extends IService<Bed> {

    public IPage<Bed> selectBedPage(int pageNum, int pageSize, String param);
    //增加
    public int addBed(Bed bed);
    //修改
    public int editBed(Bed bed);
    //查找byid
    public Bed queryBedById(Integer id);
    //删除byid
    public int delBedById(Integer id);


}
