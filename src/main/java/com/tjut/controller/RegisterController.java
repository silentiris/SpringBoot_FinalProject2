package com.tjut.controller;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.RegisterParam;
import com.tjut.pojo.dto.result.BlankResult;
import com.tjut.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Validated
@RestController
public class RegisterController {
    private RegisterService registerService;
    @Autowired
    public void setRegisterService(RegisterService registerService){
        this.registerService = registerService;
    }
    @PostMapping("/registration-information")
    public CommonResult<BlankResult> register(@Valid @RequestBody RegisterParam registerParam){
        return registerService.register(registerParam);
    }
}
