package com.tjut.service;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.RegisterParam;
import com.tjut.pojo.dto.result.BlankResult;

public interface RegisterService {
    CommonResult<BlankResult> register(RegisterParam registerParam);
}
