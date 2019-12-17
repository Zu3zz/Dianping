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
        StringBuilder stringBuilder = new StringBuilder();
        for (FieldError fieldError:bindingResult.getFieldErrors()){
            stringBuilder.append(fieldError.getDefaultMessage()+", ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}
