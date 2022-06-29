package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Apparatus;

import java.util.List;

public interface IApparatusService extends IService<Apparatus> {
    public IPage<Apparatus> selectApparatusPage(int pageNum, int pageSize, String param);
    //增加
    public int addApparatus(Apparatus apparatus);
    //修改
    public int editApparatus(Apparatus apparatus);
    //查找byid
    public Apparatus queryApparatusById(Integer id);
    //删除byid
    public int delApparatusById(Integer id);
    //查询所有药品信息
    public List<Apparatus> queryApparatusList();

}
