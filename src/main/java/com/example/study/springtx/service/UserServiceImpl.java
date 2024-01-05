package com.example.study.springtx.service;

import com.example.study.springtx.db.dataobject.UserDO;
import com.example.study.springtx.db.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @Author : xlx
 * @Description :
 * @Date: 2023/9/27
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int testRequired(UserDO userDO) {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        userMapper.insert(userDO);
        return userDO.getId();

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public int testSupported(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public int testRequiredNew(UserDO userDO) {
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        return userMapper.insert(userDO);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public int testNested(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public int testWithOutTX(UserDO userDO) {
        userMapper.insert(userDO);
        return userDO.getId();
    }

    @Override
    public UserDO queryById(Integer id) {
        return userMapper.selectById(id);
    }
}
