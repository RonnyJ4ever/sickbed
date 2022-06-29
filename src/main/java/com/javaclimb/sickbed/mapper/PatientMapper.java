package com.javaclimb.sickbed.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javaclimb.sickbed.entity.Patient;
import com.javaclimb.sickbed.entity.Room;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PatientMapper extends BaseMapper<Patient> {

    @Select("SELECT * FROM patient WHERE apply_status = 1")
    public List<Patient> apply();

    @Select("UPDATE patient SET home_num = apply,bed_num=apply_bed,apply=null,apply_bed=null WHERE id = #{id}")
    public void update(@Param("id") int id);

}
