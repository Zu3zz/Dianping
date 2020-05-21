package com.zth.dianping.controller.admin;

import com.github.pagehelper.util.StringUtil;
import com.zth.dianping.common.AdminPermission;
import com.zth.dianping.common.BusinessException;
import com.zth.dianping.common.CommonUtil;
import com.zth.dianping.common.EmBusinessError;
import com.zth.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 2020/5/13 5:44 下午
 *
 * @author 3zZ.
 */
@Controller("/admin/admin")
@RequestMapping("/admin/admin")
public class AdminController {
    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String encrptyPassord;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;

    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");
        modelAndView.addObject("userCount",userService.countAllUser());
        modelAndView.addObject("CONTROLLER_NAME","admin");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage(){
        return new ModelAndView("/admin/admin/login");
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "email")String email,
                        @RequestParam(name = "password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名密码不能为空");
        }
        if(email.equals(this.email) && CommonUtil.encodeByMd5(password).equals(this.encrptyPassord)){
            // 登录成功
            request.getSession().setAttribute(CURRENT_ADMIN_SESSION, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "用户名密码错误");
        }
    }
}
