package com.zth.dianping.common;

/**
 * Author: 3zZ.
 * Date: 2019/12/14 1:31 上午
 */
public class BusinessException extends Exception {
    private CommonError commonError;
    public BusinessException(EmBusinessError emBusinessError){
        super();
        this.commonError = new CommonError(emBusinessError);
    }
    public BusinessException(EmBusinessError emBusinessError, String errMsg){
        super();
        this.commonError = new CommonError(emBusinessError);
        this.commonError.setErrMsg(errMsg);
    }

    public CommonError getCommonError() {
        return commonError;
    }

    public void setCommonError(CommonError commonError) {
        this.commonError = commonError;
    }
}
