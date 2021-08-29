package com.wanggang.platform.controller;

import com.wanggang.platform.domain.Category;
import com.wanggang.platform.req.CategoryReq;
import com.wanggang.platform.req.EbookReq;
import com.wanggang.platform.resp.CategoryResp;
import com.wanggang.platform.resp.CommonResp;
import com.wanggang.platform.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryServices categoryServices;

    // 增 删 改 查询
    // category的数据类型

    // 查询 => 返回结果 list  list的中的结构统一结构 commonResp
    @GetMapping("/list")
    public CommonResp<List<CategoryResp>> list(CategoryResp req) {
        CommonResp<List<CategoryResp>> commonResp = new CommonResp<>();
        List<CategoryResp> list = categoryServices.list(req);
        commonResp.setContent(list);
        return  commonResp;
    }

    @PostMapping("/save")
    public CommonResp save(@Valid @RequestBody CategoryReq req) {
        CommonResp commonResp = new CommonResp<>();
        categoryServices.save(req);
        return commonResp;
    }

    @PostMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id) {
        CommonResp commonResp = new CommonResp<>();
        categoryServices.delete(id);
        return commonResp;
    }

}
