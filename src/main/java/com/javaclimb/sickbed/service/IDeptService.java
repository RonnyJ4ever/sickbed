package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Dept;

import java.util.List;

public interface IDeptService extends IService<Dept> {

    public IPage<Dept> selectDeptPage(int pageNum, int pageSize, String param);
    //增加
    public int addDept(Dept dept);
    //修改
    public int editDept(Dept dept);
    //查找byid
    public Dept queryDeptById(Integer id);
    //删除byid
    public int delDeptById(Integer id);
    //查询所有科室
    public List<Dept> queryDeptList();

}
