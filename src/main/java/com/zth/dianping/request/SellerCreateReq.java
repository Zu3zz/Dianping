package com.zth.dianping.request;

import javax.validation.constraints.NotBlank;

/**
 * Date: 2019/12/16 8:17 下午
 * @author 3zz
 */
public class SellerCreateReq {
    @NotBlank(message = "商户名不能为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
