package com.distributed.upms.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsPermission;
import com.distributed.upms.dao.model.UpmsPermissionExample;

/**
* UpmsPermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsPermissionService extends BaseService<UpmsPermission, UpmsPermissionExample> {

    JSONArray getTreeByRoleId(Integer roleId);

    JSONArray getTreeByUserId(Integer usereId, Byte type);

}