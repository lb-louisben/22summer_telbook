package com.baizhi.lb.service.impl;

import com.baizhi.lb.dao.CategoryDao;
import com.baizhi.lb.entity.Category;
import com.baizhi.lb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    /**
     * 查找所有分组名称
     *
     * @return list 集合
     */
    @Override
    public List<Category> queryAllCate() {
            return categoryDao.selectAllCate();
    }

    /**
     * 新增一个名为 categoryName 的分组
     *
     * @param categoryName 新分组的名字
     */
    @Override
    @Transactional
    public void addOneCategory(String categoryName) {
        categoryDao.insertOneCate(categoryName);
    }
}
