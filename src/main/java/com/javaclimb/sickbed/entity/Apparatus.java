package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "apparatus")
public class Apparatus implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private String apparatusNum;//器械代号

    private String apparatusName;

    private String apparatusPrice;

    private String apparatusQuantity; //器械库存数量

    private String apparatusRen;//器械备注





}
