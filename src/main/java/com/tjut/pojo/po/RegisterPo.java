package com.tjut.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("register")
public class RegisterPo {
    @TableField(value = "student_id")
    private String studentID;
    private String name;
    private String qq;
    private String phone;
    private String major;
    @TableField(value = "class_name")
    private String className;
    @TableField(value = "isdispensing")
    private boolean isDispensing;
}
