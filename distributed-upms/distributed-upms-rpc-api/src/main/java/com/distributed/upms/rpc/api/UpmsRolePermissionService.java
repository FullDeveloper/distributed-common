package com.distributed.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsRolePermission;
import com.distributed.upms.dao.model.UpmsRolePermissionExample;

/**
* UpmsRolePermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsRolePermissionService extends BaseService<UpmsRolePermission, UpmsRolePermissionExample> {

    /**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermission(JSONArray datas, int id);

}