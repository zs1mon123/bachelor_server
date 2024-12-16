package com.one.boot.common.annotation;

import com.one.boot.common.enums.LogModuleEnum;
import com.one.boot.common.enums.LogModuleEnum;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author maintell
 * @since 2024/6/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {

    String value() default "";

    LogModuleEnum module()  ;


}