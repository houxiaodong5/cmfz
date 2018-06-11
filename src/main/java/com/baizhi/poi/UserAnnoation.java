package com.baizhi.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2018/6/5.
 */
//注解使用位置,成员变量
@Target(ElementType.FIELD)
//注解使用时机  运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnoation {
    public String name();
}
