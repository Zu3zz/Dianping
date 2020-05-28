package com.zth.dianping.service;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.model.CategoryModel;

import java.util.List;

/**
 * Date: 2020/5/28 3:37 下午
 *
 * @author 3zZ.
 */
public interface CategoryService {
    /**
     * 新建商品类别
     * @param categoryModel 商品模型
     * @return 返回新建好的商品类型名称
     * @throws BusinessException 通用异常
     */
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    /**
     * 根据id获取对应的商品类型
     * @param id 商品id
     * @return 商品模型
     */
    CategoryModel get(Integer id);

    /**
     * 选择所有的商品
     * @return 返回所有商品的集合
     */
    List<CategoryModel> selectAll();

    /**
     * 计算所有商品的总个数
     * @return 商品总个数
     */
    Integer countAllCategory();
}
