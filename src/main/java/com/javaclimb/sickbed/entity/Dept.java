package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "dept")
public class Dept implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private Integer deptNum;

    private String deptName;

}