package com.tjut.service;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.GetRegistrationInfoResult;
import com.tjut.pojo.dto.result.GetUserInfoResult;

public interface SelectService {
    CommonResult<GetUserInfoResult> getUserInfo(String authorization);
    CommonResult<GetRegistrationInfoResult> getRegistrationInfo(Integer pageNum,Integer pageSize,String keyword);
}
