package com.tjut.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("will")
public class WillPo {
    @TableField(value = "student_id")
    private String studentID;
    private String organization;
    private String department;
    private String reason;
}
