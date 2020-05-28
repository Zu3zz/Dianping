package com.zth.dianping.controller;

import com.zth.dianping.common.CommonRes;
import com.zth.dianping.model.CategoryModel;
import com.zth.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Date: 2020/5/28 8:40 下午
 *
 * @author 3zZ.
 */
@Controller("/category")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("/list")
    public CommonRes list() {
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        return CommonRes.create(categoryModelList);
    }
}
