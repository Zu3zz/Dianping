package com.zth.dianping.service;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.model.SellerModel;

import java.util.List;

/**
 * Date: 2020/5/14 2:09 下午
 *
 * @author 3zZ.
 */
public interface SellerService {
    /**
     * 创建卖家
     *
     * @param sellerModel 卖家模型
     * @return 卖家模型
     */
    SellerModel create(SellerModel sellerModel);

    /**
     * 获取卖家
     *
     * @param id 卖家id
     * @return 卖家模型
     */
    SellerModel get(Integer id);

    /**
     * 选取所有的卖家
     *
     * @return 所有商家集合
     */
    List<SellerModel> selectAll();

    /**
     * 改变商家状态
     *
     * @param id           商家id
     * @param disabledFlag flag
     * @return 是否改变成功
     * @throws BusinessException 改变失败抛出异常
     */
    SellerModel changeStatus(Integer id, Integer disabledFlag) throws BusinessException;
}
