package com.tjut.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tjut.pojo.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPo> {

}