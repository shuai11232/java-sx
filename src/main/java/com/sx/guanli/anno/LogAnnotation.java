package com.sx.guanli.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    /**
     * 操作类型
     */
    String operationType() default "";

    /**
     * 操作描述
     */
    String operationDesc() default "";
}
