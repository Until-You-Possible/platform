package com.wanggang.platform.req;


import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

public class EbookReq extends PageReq {
    private Long id;

    @NotNull(message = "name can not be empty")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}