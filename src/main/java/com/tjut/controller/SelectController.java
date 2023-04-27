package com.tjut.controller;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.GetRegistrationInfoResult;
import com.tjut.pojo.dto.result.GetUserInfoResult;
import com.tjut.service.SelectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Validated
@RestController
public class SelectController {
    private SelectService selectService;
    @Autowired
    public void setSelectService(SelectService selectService){this.selectService = selectService;}
    @GetMapping("/user/info")
    public CommonResult<GetUserInfoResult> getUserInfo(@RequestHeader("Authorization") String authorization){
        return selectService.getUserInfo(authorization);
    }
    @GetMapping("/registration-information")
    public CommonResult<GetRegistrationInfoResult> getRegistrationInfo(@Positive(message = "页码必须为正整数")Integer pageNum,
                                                                       @Positive(message = "页面大小必须为正整数")Integer pageSize,
                                                                       String keyword){
        return selectService.getRegistrationInfo(pageNum,pageSize,keyword);
    }
}
