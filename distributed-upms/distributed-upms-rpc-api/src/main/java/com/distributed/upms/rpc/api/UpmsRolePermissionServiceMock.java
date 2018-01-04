package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsRolePermissionMapper;
import com.distributed.upms.dao.model.UpmsRolePermission;
import com.distributed.upms.dao.model.UpmsRolePermissionExample;

/**
* 降低实现UpmsRolePermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

}
