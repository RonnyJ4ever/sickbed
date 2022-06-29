package com.javaclimb.sickbed.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//支持lombok
@Data
@TableName(value = "user")
public class User implements Serializable {
    //Serializable支持序列化
    @TableField(value = "id")
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Integer role;

}
