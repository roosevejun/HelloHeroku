package com.tongtu.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:13-7-30 下午3:04
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Documented
@Target({METHOD, FIELD, TYPE})
@Retention(RUNTIME)
public @interface ChinaMeaning {
    /**
     * 描述
     */
    String meaning() default "中文描述";
}
