package com.wanggang.platform.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CopyUtil {

    public static <T> T copy(Object source, Class<T> tClass) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            obj = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    public static <T> List<T> copyList(List source, Class<T> tClass) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)){
            for (Object c: source) {
                T obj = copy(c, tClass);
                target.add(obj);
            }
        }
        return target;
    }


}
