package com.distributed.upms.common.constant;

import com.distributed.common.base.BaseResult;

/**
 * @Author: 周润斌
 * @Date: create in 上午 9:47 2018/1/4 0004
 * @Description:
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
