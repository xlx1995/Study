package com.example.study.springtx.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.springtx.db.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/27
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
