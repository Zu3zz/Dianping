package com.zth.dianping.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Author: 3zZ.
 * Date: 2019/12/16 8:31 下午
 */
public class CommonUtil {
    public static String processErrorString(BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError:bindingResult.getFieldErrors()){
            sb.append(fieldError.getDefaultMessage()+", ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
