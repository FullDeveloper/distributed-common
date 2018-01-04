package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsUserRoleMapper;
import com.distributed.upms.dao.model.UpmsUserRole;
import com.distributed.upms.dao.model.UpmsUserRoleExample;

/**
* 降低实现UpmsUserRoleService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

}
