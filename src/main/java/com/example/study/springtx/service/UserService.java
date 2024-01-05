package com.example.study.springtx.service;

import com.example.study.springtx.db.dataobject.UserDO;

public interface UserService {

    int testRequired(UserDO userDO);

    int testSupported(UserDO userDO);

    int testRequiredNew(UserDO userDO);

    int testNested(UserDO userDO);

    int testWithOutTX(UserDO userDO);

    UserDO queryById(Integer id);
}
