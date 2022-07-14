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

    @Override
    public List<Category> queryAllCate() {
        return categoryDao.selectAllCate();
    }
}
