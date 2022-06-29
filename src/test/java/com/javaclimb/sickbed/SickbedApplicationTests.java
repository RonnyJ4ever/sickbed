package com.javaclimb.sickbed;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javaclimb.sickbed.entity.Doctor;
import com.javaclimb.sickbed.entity.Patient;
import com.javaclimb.sickbed.entity.Room;
import com.javaclimb.sickbed.entity.User;
import com.javaclimb.sickbed.mapper.DoctorMapper;
import com.javaclimb.sickbed.mapper.PatientMapper;
import com.javaclimb.sickbed.mapper.RoomMapper;
import com.javaclimb.sickbed.service.IPatientService;
import com.javaclimb.sickbed.service.IRoomService;
import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.test.context.AnnotatedClassFinder;
import org.springframework.stereotype.Service;
import com.javaclimb.sickbed.service.IUserService;
import com.javaclimb.sickbed.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
class SickbedApplicationTests {

//    @Autowired
//    public PatientMapper patientMapper;

    @Autowired
    public IRoomService iRoomService;


    @Test
    void contextLoads() {
        List<Room> rooms = iRoomService.betterRoom(1,10,"小李");
        System.out.println(rooms);
        JSONArray jsonArray = JSONArray.fromObject(rooms);
        System.out.println(jsonArray);

//        System.out.println(iRoomService.betterRoom("小李"));
    }

}
