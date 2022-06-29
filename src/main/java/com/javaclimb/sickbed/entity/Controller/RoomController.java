package com.javaclimb.sickbed.entity.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.sickbed.common.ResultMap;
import com.javaclimb.sickbed.entity.Room;
import com.javaclimb.sickbed.service.IRoomService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping(value = "/room")
@Controller
public class RoomController {

    @Autowired
    public IRoomService iRoomService;

    @RequestMapping
    public String room(){
        return "/room";
    }

    @RequestMapping(value = "/roomA")
    public String roomA(){
        return "/roomA";
    }

    @RequestMapping(value = "/roomQueryPage")
    @ResponseBody
    public Object roomQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        try {
            IPage<Room> iPage = iRoomService.selectRoomPage(pageNum,pageSize,param);
            return ResultMap.getHashMapMysqlIpage(iPage);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/roomPage")
    public String roomPage(){
        return "/roomPage";
    }

    @RequestMapping(value = "/roomPageA")
    public String roomPageA(){
        return "/roomPageA";
    }

    @RequestMapping(value = "/roomAdd")
    @ResponseBody
    public Object roomAdd(Room room){
        try {
            int i = iRoomService.addRoom(room);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/queryRoomById")
    public String queryroomById(@RequestParam(name = "id",required = true)Integer id, Model model){
        Room room = iRoomService.queryRoomById(id);
        model.addAttribute("obj",room);
        return "/roomPage";
    }

    @RequestMapping(value = "/roomEdit")
    @ResponseBody
    public Object deptEdit(Room room){
        try {
            int i = iRoomService.editRoom(room);
            return ResultMap.getHashMapSave(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "/delRoomById")
    @ResponseBody
    public Object delRoomById(Integer id){
        try {
            int i = iRoomService.delRoomById(id);
            return ResultMap.getHashMapDel(i);
        }catch (Exception e){
            return ResultMap.getHashMapException(e);
        }
    }

    @RequestMapping(value = "betterRoom")
    public String betterRoom(){
        return "/roomPageA";
    }

    @RequestMapping(value = "betterRoomA")
    @ResponseBody
    public JSONArray betterRoomA(@RequestParam(defaultValue = "1")int pageNum, @RequestParam(defaultValue = "10")int pageSize,@RequestParam(name = "name",required = true) String name){
        List<Room> rooms = iRoomService.betterRoom(pageNum,pageSize,name);
        JSONArray jsonArray = JSONArray.fromObject(rooms);
        return jsonArray;
    }
}
