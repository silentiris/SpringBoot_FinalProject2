package com.tjut.pojo.dto.param;

import com.tjut.pojo.dto.param.paramObjects.WillParam;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RegisterParam {
    @NotNull(message = "学号不能为空")
    private String studentID;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "qq不能为空")
    private String qq;
    @NotNull(message = "手机号不能为空")
    private String phone;
    @NotNull(message = "专业信息不能为空")
    private String major;
    @NotNull(message = "班级不能为空")
    private String className;
    @NotNull(message = "志愿不能为空")
    private List<WillParam> wills;
    @NotNull(message = "是否同意调剂不能为空")
    private boolean isDispensing;
}
