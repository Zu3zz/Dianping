package com.zth.dianping.service.impl;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.common.EmBusinessError;
import com.zth.dianping.dal.ShopModelMapper;
import com.zth.dianping.model.CategoryModel;
import com.zth.dianping.model.SellerModel;
import com.zth.dianping.model.ShopModel;
import com.zth.dianping.service.CategoryService;
import com.zth.dianping.service.SellerService;
import com.zth.dianping.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/5/29 12:07 上午
 *
 * @author 3zZ.
 */
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopModelMapper shopModelMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SellerService sellerService;

    /**
     * 创建shop
     *
     * @param shopModel 商铺模型
     * @return 返回商铺模型
     * @throws BusinessException 通用异常
     */
    @Override
    @Transactional
    public ShopModel create(ShopModel shopModel) throws BusinessException {
        shopModel.setCreatedAt(new Date());
        shopModel.setUpdatedAt(new Date());

        // 检验商家是否存在
        SellerModel sellerModel = sellerService.get(shopModel.getSellerId());
        if (sellerModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商户不存在");
        }
        if (sellerModel.getDisabledFlag() == 1) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "商户已禁用");
        }
        // 检验类目
        CategoryModel categoryModel = categoryService.get(shopModel.getCategoryId());
        if (categoryModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "类目不存在");
        }
        shopModelMapper.insertSelective(shopModel);

        return get(shopModel.getId());
    }

    /**
     * 通过主键获取商铺模型
     *
     * @param id 主键
     * @return 返回商铺模型
     */
    @Override
    public ShopModel get(Integer id) {
        ShopModel shopModel = shopModelMapper.selectByPrimaryKey(id);
        if (shopModel == null) {
            throw null;
        }
        shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        return shopModel;
    }

    /**
     * 拿出所有的商铺信息
     *
     * @return 返回商铺信息列表
     */
    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModelList = shopModelMapper.selectAll();
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }

    /**
     * 通过标签选择分组
     *
     * @param keyword    关键字
     * @param categoryId 分组id
     * @param tags       分组标签
     * @return 返回map的数组
     */
    @Override
    public List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags) {
        return shopModelMapper.searchGroupByTags(keyword, categoryId, tags);
    }

    /**
     * 计算所有的商铺的总数
     *
     * @return 返回商铺数量
     */
    @Override
    public Integer countAllShop() {
        return shopModelMapper.countAllShop();
    }

    /**
     * 搜索特定的商铺
     *
     * @param longitude  经度
     * @param latitude   纬度
     * @param keyword    关键词
     * @param orderby    排序
     * @param categoryId 种类id
     * @param tags       标签
     * @return 返回满足条件的商铺列表
     */
    @Override
    public List<ShopModel> search(BigDecimal longitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags) {
        List<ShopModel> shopModelList = shopModelMapper.search(longitude, latitude, keyword, orderby, categoryId, tags);
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }
}
