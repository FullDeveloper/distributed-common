package com.distributed.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:15 2018/1/4 0004
 * @Description: 初始化继承BaseService的service
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
