package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsOrganizationMapper;
import com.distributed.upms.dao.model.UpmsOrganization;
import com.distributed.upms.dao.model.UpmsOrganizationExample;

/**
* 降低实现UpmsOrganizationService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsOrganizationServiceMock extends BaseServiceMock<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

}
