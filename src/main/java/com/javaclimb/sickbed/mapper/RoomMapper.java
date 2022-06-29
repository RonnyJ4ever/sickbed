package com.javaclimb.sickbed.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.entity.Room;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoomMapper extends BaseMapper<Room> {

    @Select("select * from room where (room_sex = (SELECT sex FROM patient WHERE name = #{name}) OR room_sex = '不限')and room_suit LIKE CONCAT('%',(SELECT body_mes FROM patient WHERE name = #{name}),'%')")
    public List<Room> betterRoom(int pageNum,int pageSize,@Param("name") String name);
}
