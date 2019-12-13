package com.zth.dianping.service.impl;

import com.zth.dianping.dal.UserModelMapper;
import com.zth.dianping.model.UserModel;
import com.zth.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: 3zZ.
 * Date: 2019/12/11 1:38 下午
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }
}
