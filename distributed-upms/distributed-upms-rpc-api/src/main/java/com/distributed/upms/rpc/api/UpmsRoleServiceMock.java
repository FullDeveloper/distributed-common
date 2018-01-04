package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsRoleMapper;
import com.distributed.upms.dao.model.UpmsRole;
import com.distributed.upms.dao.model.UpmsRoleExample;

/**
* 降低实现UpmsRoleService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsRoleServiceMock extends BaseServiceMock<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

}
