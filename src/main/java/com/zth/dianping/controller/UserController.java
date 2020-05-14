package com.zth.dianping.controller;

import com.zth.dianping.common.*;
import com.zth.dianping.model.UserModel;
import com.zth.dianping.request.LoginReq;
import com.zth.dianping.request.RegisterReq;
import com.zth.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.EmbeddedFrame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 2019/12/11 1:20 下午
 * @author 3zz
 */
@Controller("/user")
@RequestMapping("/user")
public class UserController {
    public static final String CURRENT_USER_SESSION = "currentUserSession";
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        String username = "3zz";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name", username);
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if(userModel == null){
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        }
        return CommonRes.create(userModel);
    }

    @RequestMapping("/register")
    @ResponseBody
    public CommonRes register(@Valid @RequestBody RegisterReq registerReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        UserModel registerUser = new UserModel();
        registerUser.setTelphone(registerReq.getTelphone());
        registerUser.setPassword(registerReq.getPassword());
        registerUser.setNickName(registerReq.getNickName());
        registerUser.setGender(registerReq.getGender());

        UserModel resUserModel = userService.register(registerUser);

        return CommonRes.create(resUserModel);
    }
    @RequestMapping("/login")
    @ResponseBody
    public CommonRes login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException{
        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getTelphone(), loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);

        return CommonRes.create(userModel);
    }
    @RequestMapping("/logout")
    @ResponseBody
    public CommonRes logout(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException{
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);
    }

    /**
     * 获取当前用户信息
     * @return 通用返回结果
     */
    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonRes getCurrentUser(){
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userModel);
    }
}
