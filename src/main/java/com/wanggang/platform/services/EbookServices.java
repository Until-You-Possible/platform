package com.wanggang.platform.services;

import com.wanggang.platform.domain.Ebook;
import com.wanggang.platform.domain.EbookExample;
import com.wanggang.platform.mapper.EbookMapper;
import com.wanggang.platform.req.EbookReq;
import com.wanggang.platform.resp.EbookResp;
import com.wanggang.platform.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);
        return CopyUtil.copyList(ebooks, EbookResp.class);
    }
    // service 调用 mapper查询数据
    // service 供controller调用
}
