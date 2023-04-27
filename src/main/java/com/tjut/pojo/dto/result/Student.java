package com.tjut.pojo.dto.result;

import com.tjut.pojo.dto.param.paramObjects.WillParam;
import com.tjut.pojo.po.WillPo;
import lombok.Data;

import java.util.List;
@Data
public class Student {
    private String studentID;
    private String name;
    private String qq;
    private String phone;
    private String major;
    private String className;
    private List<WillResult> wills;
    private boolean isDispensing;
}
