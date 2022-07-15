package com.baizhi.lb.controller;

import com.baizhi.lb.entity.Category;
import com.baizhi.lb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类
     * @param model model 传参数 forward 给要展示的网页
     * @return 地址
     *
     * 最近在写控制器代码时，请求结束后需要将请求转发到另一个控制器的url里去，
     * 但是return "forward:/这里是方法"却不奏效，处理完之后不报错，不跳转，在浏览器显示return的字符串。
     *
     * 观察之后发现方法体上加了注释 @ResponseBody 注释。在这个注释下，forward和redict均不被认为是请求转发和重定向的特殊字符，
     * 而是作为字符串在请求响应的body内返回
     */
    @RequestMapping("queryAll")
    public String queryAll(Model model){
        List<Category> categories = categoryService.queryAllCate();
        model.addAttribute("list", categories);
        return "forward:/category/index.jsp";
    }

    /**
     * 异步加载所有分组名称
     * @return 分组名称list集合
     */
    @ResponseBody
    @RequestMapping("queryAllAjax")
    public List<Category> queryAllAjax(){
        return categoryService.queryAllCate();
    }

    @RequestMapping("reg")
    public String reg(String categoryName){
        categoryService.addOneCategory(categoryName);
        return "redirect:/category/queryAll";
    }
}
