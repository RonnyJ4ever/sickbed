package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//支持lombok
@Data
@TableName(value = "patient")
public class Patient implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private Date inTime;

    private String belongHome;

    private String bodyMes;

    private String MainDoc;

    private String homeNum;

    private String bedNum;

    private String applyBed;

    private String apply;



}
