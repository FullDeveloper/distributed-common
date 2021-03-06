package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsUserOrganization;
import com.distributed.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {

    /**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, int id);


}