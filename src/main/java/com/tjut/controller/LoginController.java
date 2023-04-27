package com.tjut.controller;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.LoginParam;
import com.tjut.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Validated
@RestController
public class LoginController {
    private LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public CommonResult<String> login(@Valid @RequestBody LoginParam loginParam){
        return loginService.login(loginParam);
    }
}
