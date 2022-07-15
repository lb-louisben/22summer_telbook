package com.baizhi.lb.service;

import com.baizhi.lb.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * service: 查找所有分组名称
     * @return list 集合
     */
    List<Category> queryAllCate();

    /**
     * 新增一个名为 categoryName 的分组
     * @param categoryName 新分组的名字
     */
    void addOneCategory(String categoryName);
}
