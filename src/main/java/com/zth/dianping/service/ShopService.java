package com.zth.dianping.service;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/5/28 10:54 下午
 *
 * @author 3zZ.
 */
public interface ShopService {
    /**
     * 创建shop
     *
     * @param shopModel 商铺模型
     * @return 返回商铺模型
     * @throws BusinessException 通用异常
     */
    ShopModel create(ShopModel shopModel) throws BusinessException;

    /**
     * 通过主键获取商铺模型
     *
     * @param id 主键
     * @return 返回商铺模型
     */
    ShopModel get(Integer id);

    /**
     * 拿出所有的商铺信息
     *
     * @return 返回商铺信息列表
     */
    List<ShopModel> selectAll();

    /**
     * 根据经纬度做数据库中的简单推荐
     * @param longitude 经度
     * @param latitude 纬度
     * @return 返回满足条件的数据库店铺集合
     */
    List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude);

    /**
     * 通过标签选择分组
     * @param keyword 关键字
     * @param categoryId 分组id
     * @param tags 分组标签
     * @return 返回map的数组
     */
    List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags);

    /**
     * 计算所有的商铺的总数
     * @return 返回商铺数量
     */
    Integer countAllShop();

    /**
     * 搜索特定的商铺
     * @param longitude 经度
     * @param latitude 纬度
     * @param keyword 关键词
     * @param orderby 排序
     * @param categoryId 种类id
     * @param tags 标签
     * @return 返回满足条件的商铺列表
     */
    List<ShopModel> search(BigDecimal longitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags);
}