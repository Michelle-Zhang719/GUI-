package com.cskaoyan.javase.swing.manager.stage8.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 该注解 进行名字长度的限制 默认名字长度为2-5之间
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface NameLimit {
    // 最小长度
    int minLength() default 2;

    // 最大长度
    int maxLength() default 5;

}
