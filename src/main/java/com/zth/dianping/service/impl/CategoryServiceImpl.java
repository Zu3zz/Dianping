package com.zth.dianping.service.impl;

import com.zth.dianping.common.BusinessException;
import com.zth.dianping.common.EmBusinessError;
import com.zth.dianping.dal.CategoryModelMapper;
import com.zth.dianping.model.CategoryModel;
import com.zth.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Date: 2020/5/28 4:12 下午
 *
 * @author 3zZ.
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryModelMapper categoryModelMapper;

    /**
     * 新建商品类别
     *
     * @param categoryModel 商品模型
     * @return 返回新建好的商品类型名称
     * @throws BusinessException 通用异常
     */
    @Override
    @Transactional
    public CategoryModel create(CategoryModel categoryModel) throws BusinessException {
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());
        try {
            categoryModelMapper.insertSelective(categoryModel);
        } catch (DuplicateKeyException ex){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return get(categoryModel.getId());
    }

    /**
     * 根据id获取对应的商品类型
     *
     * @param id 商品id
     * @return 商品模型
     */
    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    /**
     * 选择所有的商品
     *
     * @return 返回所有商品的集合
     */
    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    /**
     * 计算所有商品的总个数
     *
     * @return 商品总个数
     */
    @Override
    public Integer countAllCategory() {
        return null;
    }
}
