package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsSystem;
import com.distributed.upms.dao.model.UpmsSystemExample;

/**
* UpmsSystemService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsSystemService extends BaseService<UpmsSystem, UpmsSystemExample> {

    /**
     * 根据name获取UpmsSystem
     * @param name
     * @return
     */
    UpmsSystem selectUpmsSystemByName(String name);

}