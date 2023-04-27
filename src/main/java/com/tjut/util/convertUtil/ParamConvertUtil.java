package com.tjut.util.convertUtil;

import com.tjut.pojo.dto.param.RegisterParam;
import com.tjut.pojo.dto.param.paramObjects.WillParam;
import com.tjut.pojo.po.RegisterPo;
import com.tjut.pojo.po.UserPo;
import com.tjut.pojo.po.WillPo;

public class ParamConvertUtil {
    public static RegisterPo RegisterParamConvert(RegisterParam registerParam){
        RegisterPo registerPo = new RegisterPo();
        registerPo.setStudentID(registerParam.getStudentID());
        registerPo.setName(registerParam.getName());
        registerPo.setQq(registerParam.getQq());
        registerPo.setPhone(registerParam.getPhone());
        registerPo.setMajor(registerParam.getMajor());
        registerPo.setClassName(registerParam.getClassName());
        return registerPo;
    }
    public static WillPo WillParamConvert(RegisterParam registerParam,WillParam willParam){
        WillPo willPo = new WillPo();
        willPo.setStudentID(registerParam.getStudentID());
        willPo.setOrganization(willParam.getOrganization());
        willPo.setDepartment(willParam.getDepartment());
        willPo.setReason(willParam.getReason());
        return willPo;
    }
}
