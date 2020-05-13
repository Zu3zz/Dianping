package com.zth.dianping.common;

/**
 * Date: 2019/12/11 6:14 下午
 * @author 3zz
 */
public class CommonRes {
    /**
     * 表明读经过请求的返回处理结果，"success"或"fail"
     */
    private String status;

    /**
     * 若status=success时，表明对应的返回的json类数据
     * 若status=fail时，则data内将使用通用的错误码对应的格式
     */
    private Object data;

    /**
     * 定义一个通用的创建返回对象的方法
     * @param result 返回结果对象
     * @return 通用返回
     */
    public static CommonRes create(Object result){
        return CommonRes.create(result,"success");
    }

    public static CommonRes create(Object result, String status){
        CommonRes commonRes = new CommonRes();
        commonRes.setStatus(status);
        commonRes.setData(result);
        return commonRes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
