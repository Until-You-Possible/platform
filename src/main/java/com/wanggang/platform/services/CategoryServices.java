package com.wanggang.platform.services;

import com.wanggang.platform.domain.Category;
import com.wanggang.platform.domain.CategoryExample;
import com.wanggang.platform.mapper.CategoryMapper;
import com.wanggang.platform.req.CategoryReq;
import com.wanggang.platform.resp.CategoryResp;
import com.wanggang.platform.resp.CommonResp;
import com.wanggang.platform.util.CopyUtil;
import com.wanggang.platform.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.rmi.CORBA.Util;
import java.util.List;


@Service
public class CategoryServices {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SnowFlake snowFlake;

    public List<CategoryResp> list(CategoryResp req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        return CopyUtil.copyList(categories, CategoryResp.class);

    }

    // save
    public void save(CategoryReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        // 不存在就新增
        // 反之就更新
        if (!ObjectUtils.isEmpty(category.getId())) {
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }



    // delete
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }


}
