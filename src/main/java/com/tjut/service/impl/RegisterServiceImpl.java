package com.tjut.service.impl;

import com.tjut.dao.RegisterDao;
import com.tjut.dao.WillDao;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.RegisterParam;
import com.tjut.pojo.dto.param.paramObjects.WillParam;
import com.tjut.pojo.dto.result.BlankResult;
import com.tjut.service.RegisterService;
import com.tjut.util.convertUtil.ParamConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private RegisterDao registerDao;
    private WillDao willDao;
    @Autowired
    public void setRegisterDao(RegisterDao registerDao){this.registerDao = registerDao;}
    @Autowired
    public void setWillDao(WillDao willDao){this.willDao = willDao;}
    @Override
    public CommonResult<BlankResult> register(RegisterParam registerParam) {
        registerDao.insert(ParamConvertUtil.RegisterParamConvert(registerParam));
        for(WillParam willParam:registerParam.getWills()){
            willDao.insert(ParamConvertUtil.WillParamConvert(registerParam,willParam));
        }
        return CommonResult.success("好的");
    }
}
