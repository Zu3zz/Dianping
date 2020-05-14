package com.zth.dianping.service;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 2019/12/11 1:20 下午
 * @author 3zz
 */
public interface UserService {
    /**
     * 获得特定用户
     * @param id 用户id
     * @return 用户模型
     */
    UserModel getUser(Integer id);

    /**
     * 用户注册
     * @param registerUser 注册信息
     * @return 是否注册成功
     * @throws BusinessException 通用模型异常
     * @throws UnsupportedEncodingException 编码异常
     * @throws NoSuchAlgorithmException 加密错误异常
     */
    UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 登录
     * @param telphone 手机号
     * @param password 密码
     * @return 是否登录成功
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws BusinessException
     */
    UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;

    /**
     * 计算所有用户数量
     * @return 用户总数
     */
    Integer countAllUser();
}
