package com.zth.dianping.service.impl;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.common.EmBusinessError;
import com.zth.dianping.dal.SellerModelMapper;
import com.zth.dianping.model.SellerModel;
import com.zth.dianping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Date: 2020/5/14 2:09 下午
 *
 * @author 3zZ.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerModelMapper sellerModelMapper;


    /**
     * 创建卖家
     *
     * @param sellerModel 卖家模型
     * @return 卖家模型
     */
    @Override
    @Transactional
    public SellerModel create(SellerModel sellerModel) {
        sellerModel.setCreatedAt(new Date());
        sellerModel.setUpdatedAt(new Date());
        sellerModel.setRemarkScore(new BigDecimal(0));
        sellerModel.setDisabledFlag(0);
        sellerModelMapper.insertSelective(sellerModel);
        return get(sellerModel.getId());
    }

    /**
     * 获取卖家
     *
     * @param id 卖家id
     * @return 卖家模型
     */
    @Override
    public SellerModel get(Integer id) {
        return sellerModelMapper.selectByPrimaryKey(id);
    }

    /**
     * 选取所有的卖家
     *
     * @return 所有商家集合
     */
    @Override
    public List<SellerModel> selectAll() {
        return sellerModelMapper.selectAll();
    }

    /**
     * 改变商家状态
     *
     * @param id           商家id
     * @param disabledFlag flag
     * @return 是否改变成功
     * @throws BusinessException 改变失败抛出异常
     */
    @Override
    public SellerModel changeStatus(Integer id, Integer disabledFlag) throws BusinessException {
        SellerModel sellerModel = get(id);
        if (sellerModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisabledFlag(disabledFlag);
        sellerModelMapper.updateByPrimaryKeySelective(sellerModel);
        return sellerModel;
    }
}
