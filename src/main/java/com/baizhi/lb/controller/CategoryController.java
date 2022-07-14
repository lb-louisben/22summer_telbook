package com.baizhi.lb.controller;

import com.baizhi.lb.entity.Category;
import com.baizhi.lb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("cate")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("queryAllAjax")
    public List<Category> queryAllAjax(){
        List<Category> list = categoryService.queryAllCate();
        return list;
    }
}
