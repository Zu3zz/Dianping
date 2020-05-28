package com.zth.dianping.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zth.dianping.common.AdminPermission;
import com.zth.dianping.common.BusinessException;
import com.zth.dianping.common.CommonUtil;
import com.zth.dianping.common.EmBusinessError;
import com.zth.dianping.model.CategoryModel;
import com.zth.dianping.request.CategoryCreateReq;
import com.zth.dianping.request.PageQuery;
import com.zth.dianping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Date: 2020/5/28 4:24 下午
 *
 * @author 3zZ.
 */
@Controller("/admin/category")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 品类列表
     *
     * @param pageQuery 分页参数
     * @return MVC视图解析器
     */
    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(PageQuery pageQuery) {
        PageHelper.startPage(pageQuery.getPage(), pageQuery.getSize());
        List<CategoryModel> categoryModelList = categoryService.selectAll();
        PageInfo<CategoryModel> categoryModelPageInfo = new PageInfo<>(categoryModelList);
        ModelAndView modelAndView = new ModelAndView("/admin/category/index.html");
        modelAndView.addObject("data", categoryModelPageInfo);
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/createpage")
    @AdminPermission
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/category/create.html");
        modelAndView.addObject("CONTROLLER_NAME", "category");
        modelAndView.addObject("ACTION_NAME", "create");
        return modelAndView;
    }

    @PostMapping(value = "/create")
    @AdminPermission
    public String create(@Valid CategoryCreateReq categoryCreateReq, BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        CategoryModel cateGoryModel = new CategoryModel();
        cateGoryModel.setName(categoryCreateReq.getName());
        cateGoryModel.setIconUrl(categoryCreateReq.getIconUrl());
        cateGoryModel.setSort(categoryCreateReq.getSort());

        categoryService.create(cateGoryModel);
        return "redirect:/admin/category/index";
    }

}
