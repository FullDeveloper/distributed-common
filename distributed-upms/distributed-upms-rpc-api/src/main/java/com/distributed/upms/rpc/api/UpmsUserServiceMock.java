package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsUserMapper;
import com.distributed.upms.dao.model.UpmsUser;
import com.distributed.upms.dao.model.UpmsUserExample;

/**
* 降低实现UpmsUserService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        return null;
    }
}
