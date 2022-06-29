package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "room")
public class Room implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private String roomNum;//病房号

    private String roomJudge;//病房状况

    private String roomSuit;//病房所适应症状病人

    private String roomSex;//病房适应什么性别的病人

    private Integer roomMax;//病房中最大病床数

    private Integer roomFree;//病房中最大病床数



}
