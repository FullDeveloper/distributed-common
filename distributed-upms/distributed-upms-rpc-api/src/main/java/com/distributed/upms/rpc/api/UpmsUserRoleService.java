package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseService;
import com.distributed.upms.dao.model.UpmsUserRole;
import com.distributed.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {

    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, int id);


}