package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tjut.dao.UserDao;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.LoginParam;
import com.tjut.pojo.po.UserPo;
import com.tjut.service.LoginService;
import com.tjut.util.jwtUtil.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public CommonResult<String> login(LoginParam loginParam) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",loginParam.getUsername());
        UserPo userPo=userDao.selectOne(queryWrapper);
        if(null==userPo){
            return CommonResult.fail("用户不存在");
        }else {
            if (!userPo.getPassword().equals(loginParam.getPassword()))return CommonResult.fail("密码错误");
        }
        String token = JwtUtils.sign(userPo);
        return CommonResult.success("对的",token);
    }
}
