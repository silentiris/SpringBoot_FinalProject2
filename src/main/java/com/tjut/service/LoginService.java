package com.tjut.service;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.LoginParam;

public interface LoginService {
    CommonResult<String> login(LoginParam loginParam);
}
