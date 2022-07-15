package com.baizhi.lb.dao;

import com.baizhi.lb.entity.Category;

import java.util.List;

public interface CategoryDao {
    /**
     * 查找所有分组，返回 list 类型
     * @return list
     */
    List<Category> selectAllCate();

    /**
     * 新增一个分组
     * @param categoryName 分组名称
     */
    void insertOneCate(String categoryName);
}
