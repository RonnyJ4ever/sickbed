package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "potion")
public class Potion implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")

    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private String potionNum;//药品代号

    private String potionName;

    private String potionPrice;

    private String potionQuantity; //药品库存数量

    private String potionRen;//药品备注





}
