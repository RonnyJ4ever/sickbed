package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "bed")
public class Bed implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;//病房编号

    private String bedNum;//病床号

    private String bedRoomid;//所在房间编号

    private Integer bedPatientid;//病床病人编号

    private String bedGender; //病床男女属性

    private String bedRank;//病床等级





}
