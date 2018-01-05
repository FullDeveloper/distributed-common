package com.distributed.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsUserPermission;
import com.distributed.upms.dao.model.UpmsUserPermissionExample;

/**
* UpmsUserPermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsUserPermissionService extends BaseService<UpmsUserPermission, UpmsUserPermissionExample> {

    /**
     * 用户权限
     * @param datas 权限数据
     * @param id 用户id
     * @return
     */
    int permission(JSONArray datas, int id);

}