package com.zth.dianping.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Date: 2020/5/13 5:05 下午
 *
 * @author 3zZ.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {
    String produceType() default "text/html";
}
