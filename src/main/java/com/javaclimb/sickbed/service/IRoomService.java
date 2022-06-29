package com.javaclimb.sickbed.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.sickbed.entity.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoomService extends IService<Room> {

    public IPage<Room> selectRoomPage(int pageNum, int pageSize, String param);

    //增加
    public int addRoom(Room room);

    //修改
    public int editRoom(Room room);

    //查找byid
    public Room queryRoomById(Integer id);

    //删除byid
    public int delRoomById(Integer id);

    public List<Room> betterRoom(int pageNum,int pageSize,@Param("name") String name);

}
