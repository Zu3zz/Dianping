package com.zth.dianping.dal;

import com.zth.dianping.model.SellerModel;

import java.util.List;

/**
 * Date: 2020/5/14 2:38 下午
 *
 * @author 3zZ.
 */
public interface SellerModelMapper {

    /**
     * 通过主键删除
     *
     * @param id 卖家主键
     * @return 是否删除成功
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入卖家记录
     *
     * @param record 卖家记录
     * @return 返回是否插入成功
     */
    int insert(SellerModel record);

    /**
     * 选择全部
     *
     * @return 所有卖家集合
     */
    List<SellerModel> selectAll();

    /**
     * 选择固定对象插入
     *
     * @param record 用户对象
     * @return 是否插入成功
     */
    int insertSelective(SellerModel record);

    /**
     * 通过主键选取
     *
     * @param id 卖家id
     * @return 卖家模型
     */
    SellerModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Fri Jul 19 12:00:18 CST 2019
     */
    int updateByPrimaryKeySelective(SellerModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table seller
     *
     * @mbg.generated Fri Jul 19 12:00:18 CST 2019
     */
    int updateByPrimaryKey(SellerModel record);

    Integer countAllSeller();
}
