package com.tjut.util.convertUtil;

import com.tjut.pojo.dto.result.GetUserInfoResult;
import com.tjut.pojo.dto.result.Student;
import com.tjut.pojo.dto.result.WillResult;
import com.tjut.pojo.po.RegisterPo;
import com.tjut.pojo.po.UserPo;
import com.tjut.pojo.po.WillPo;

import java.util.ArrayList;
import java.util.List;

public class ResultConvertUtil {
    public static GetUserInfoResult getUserInfoResultConvert(UserPo userPo){
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        getUserInfoResult.setUsername(userPo.getUsername());
        getUserInfoResult.setRole(userPo.getRole());
        return getUserInfoResult;
    }
    public static Student studentConvert(RegisterPo registerPo){
        Student student = new Student();
        student.setStudentID(registerPo.getStudentID());
        student.setName(registerPo.getName());
        student.setQq(registerPo.getQq());
        student.setPhone(registerPo.getPhone());
        student.setMajor(registerPo.getMajor());
        student.setClassName(registerPo.getClassName());
        student.setDispensing(registerPo.isDispensing());
        return student;
    }
    public static List<WillResult> WillPoConvertToList(List<WillPo> willPos){
        List<WillResult> willResults = new ArrayList<>();
        for(WillPo willPo:willPos){
            WillResult willResult = new WillResult();
            willResult.setOrganization(willPo.getOrganization());
            willResult.setDepartment(willPo.getDepartment());
            willResult.setReason(willPo.getReason());
            willResults.add(willResult);
        }
        return willResults;
    }
}
