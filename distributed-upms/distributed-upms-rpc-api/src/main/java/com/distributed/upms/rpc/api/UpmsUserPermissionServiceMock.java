package com.distributed.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsUserPermissionMapper;
import com.distributed.upms.dao.model.UpmsUserPermission;
import com.distributed.upms.dao.model.UpmsUserPermissionExample;

/**
* 降低实现UpmsUserPermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

    @Override
    public int permission(JSONArray datas, int id) {
        return 0;
    }
}
