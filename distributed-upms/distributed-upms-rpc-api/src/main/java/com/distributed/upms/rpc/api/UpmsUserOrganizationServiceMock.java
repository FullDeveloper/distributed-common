package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.distributed.upms.dao.model.UpmsUserOrganization;
import com.distributed.upms.dao.model.UpmsUserOrganizationExample;

/**
* 降低实现UpmsUserOrganizationService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

}
