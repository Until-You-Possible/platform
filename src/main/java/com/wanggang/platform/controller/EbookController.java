package com.wanggang.platform.controller;


import com.wanggang.platform.domain.Ebook;
import com.wanggang.platform.req.EbookReq;
import com.wanggang.platform.resp.CommonResp;
import com.wanggang.platform.resp.EbookResp;
import com.wanggang.platform.services.EbookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private EbookServices ebookServices;

    @GetMapping("/list")
    public CommonResp<List<EbookResp>> list(EbookReq req) {
        CommonResp<List<EbookResp>> commonResp = new CommonResp<>();
        List<EbookResp> list = ebookServices.list(req);
        commonResp.setContent(list);
        return commonResp;
    }

}
