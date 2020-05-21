package com.zth.dianping.common;

import com.zth.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Date: 2020/5/13 5:36 下午
 *
 * @author 3zZ.
 */
@Aspect
@Configuration
public class ControllerAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Around("execution(* com.zth.dianping.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if (adminPermission == null) {
            // 公共方法
            return joinPoint.proceed();
        }
        // 判断当前管理员是否登录
        String email = (String) request.getSession().getAttribute(AdminController.CURRENT_ADMIN_SESSION);
        if (null == email) {
            if (adminPermission.produceType().equals("text/html")) {
                response.sendRedirect("/admin/admin/loginpage");
                return null;
            } else {
                CommonError commonError = new CommonError(EmBusinessError.ADMIN_SHOULD_LOGIN);
                return CommonRes.create(commonError, "fail");
            }
        } else {
            return joinPoint.proceed();
        }
    }
}
