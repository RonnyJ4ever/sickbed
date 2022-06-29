package com.javaclimb.sickbed.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.sickbed.entity.Room;
import com.javaclimb.sickbed.mapper.RoomMapper;
import com.javaclimb.sickbed.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements IRoomService {

    @Autowired
    public RoomMapper roomMapper;

    @Override
    public IPage<Room> selectRoomPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("room_num", param);
        }
        Page<Room> page = new Page<>(pageNum, pageSize);
        return roomMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addRoom(Room room) {
        return roomMapper.insert(room);
    }

    @Override
    public int editRoom(Room room) {
        return roomMapper.updateById(room);
    }

    @Override
    public Room queryRoomById(Integer id) {
        return roomMapper.selectById(id);
    }

    @Override
    public int delRoomById(Integer id) {
        return roomMapper.deleteById(id);
    }

    @Override
    public List<Room> betterRoom(int pageNum, int pageSize, String name) {
        return roomMapper.betterRoom(pageNum,pageSize,name);
    }

}
