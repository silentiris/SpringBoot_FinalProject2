package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.dao.RegisterDao;
import com.tjut.dao.UserDao;
import com.tjut.dao.WillDao;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.GetRegistrationInfoResult;
import com.tjut.pojo.dto.result.GetUserInfoResult;
import com.tjut.pojo.dto.result.Student;
import com.tjut.pojo.po.RegisterPo;
import com.tjut.pojo.po.UserPo;
import com.tjut.pojo.po.WillPo;
import com.tjut.service.SelectService;
import com.tjut.util.convertUtil.ResultConvertUtil;
import com.tjut.util.jwtUtil.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectServiceImpl implements SelectService {
    private UserDao userDao;
    private RegisterDao registerDao;
    private WillDao willDao;

    @Autowired
    public void setUserDao(UserDao userDao){this.userDao = userDao;}
    @Autowired
    public void setRegisterDao(RegisterDao registerDao){this.registerDao = registerDao;}
    @Autowired
    public void setWillDao(WillDao willDao){this.willDao = willDao;}
    @Override
    public CommonResult<GetUserInfoResult> getUserInfo(String authorization) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", JwtUtils.getUserNameByToken(authorization));
        UserPo userPo = userDao.selectOne(queryWrapper);
        if(null==userPo){
            return CommonResult.fail("未找到用户");
        }else {
            return CommonResult.success("对的",ResultConvertUtil.getUserInfoResultConvert(userPo));
        }
    }

    @Override
    public CommonResult<GetRegistrationInfoResult> getRegistrationInfo(Integer pageNum, Integer pageSize, String keyword) {
        QueryWrapper<RegisterPo> queryWrapper = new QueryWrapper<>();
        if(null==pageNum) pageNum = 1;
        if(null==pageSize) pageSize = 10;
        if(null!=keyword) queryWrapper.like("name",keyword);
        IPage<RegisterPo> page=new Page<>(pageNum,pageSize);
        List<RegisterPo> registerPos=registerDao.selectPage(page,queryWrapper).getRecords();
        List<Student> students = new ArrayList<>();
        for(RegisterPo registerPo:registerPos){
            Student student = ResultConvertUtil.studentConvert(registerPo);
            QueryWrapper<WillPo> qw = new QueryWrapper<>();
            qw.eq("student_id",registerPo.getStudentID());
            student.setWills(ResultConvertUtil.WillPoConvertToList(willDao.selectList(qw)));
            students.add(student);
        }
        if(page.getTotal() == 0){
            return CommonResult.fail("未查询到此人");
        }else{
            GetRegistrationInfoResult getRegistrationInfoResult = new GetRegistrationInfoResult((int)page.getTotal(),students);
            return CommonResult.success("对的",getRegistrationInfoResult);
        }
    }
}
