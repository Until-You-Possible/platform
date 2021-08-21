package com.wanggang.platform.services;

import com.wanggang.platform.domain.Ebook;
import com.wanggang.platform.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookServices {

    @Resource
    private EbookMapper ebookMapper;

    public List<Ebook> list() {
        return  ebookMapper.selectByExample(null);
    }
    // service 调用 mapper查询数据
    // service 供controller调用
}
