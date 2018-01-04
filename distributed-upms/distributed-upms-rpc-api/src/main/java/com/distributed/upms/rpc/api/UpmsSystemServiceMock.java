package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsSystemMapper;
import com.distributed.upms.dao.model.UpmsSystem;
import com.distributed.upms.dao.model.UpmsSystemExample;

/**
* 降低实现UpmsSystemService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

    @Override
    public UpmsSystem selectUpmsSystemByName(String name) {
        return null;
    }
}
