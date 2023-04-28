package com.tjut.pojo.dto.param.paramObjects;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WillParam {
    @NotNull(message = "组织名不能为空")
    private String organization;
    @NotNull(message = "部门不能为空")
    private String department;
    @NotNull(message = "原因不能为空")
    private String reason;
}
