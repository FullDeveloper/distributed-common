package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsPermissionMapper;
import com.distributed.upms.dao.model.UpmsPermission;
import com.distributed.upms.dao.model.UpmsPermissionExample;

/**
* 降低实现UpmsPermissionService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

}
