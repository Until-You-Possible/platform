package com.wanggang.platform.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanggang.platform.domain.Ebook;
import com.wanggang.platform.domain.EbookExample;
import com.wanggang.platform.mapper.EbookMapper;
import com.wanggang.platform.req.EbookReq;
import com.wanggang.platform.req.EbookSaveReq;
import com.wanggang.platform.resp.EbookResp;
import com.wanggang.platform.util.CopyUtil;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookServices {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        // 创建where查询条件
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> pageInfo = new PageInfo<>(ebooks);
        return CopyUtil.copyList(ebooks, EbookResp.class);
    }
    // service 调用 mapper查询数据
    // service 供controller调用

    public void save (EbookReq req) {
        Ebook ebook  = CopyUtil.copy(req, Ebook.class);
        // 新增或者更新
        if (ObjectUtils.isEmpty(req.getId())) {
            // 新增
            ebookMapper.insert(ebook);
        } else {
            // 更新
            ebookMapper.updateByPrimaryKey(ebook);

        }
    }
}
