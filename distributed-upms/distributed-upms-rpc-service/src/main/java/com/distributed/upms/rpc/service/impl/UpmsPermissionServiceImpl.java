package com.distributed.upms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.upms.dao.mapper.UpmsPermissionMapper;
import com.distributed.upms.dao.model.UpmsPermission;
import com.distributed.upms.dao.model.UpmsPermissionExample;
import com.distributed.upms.rpc.api.UpmsPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsPermissionServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
@Service
@Transactional
@BaseService
public class UpmsPermissionServiceImpl extends BaseServiceImpl<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsPermissionServiceImpl.class);

    @Autowired
    UpmsPermissionMapper upmsPermissionMapper;

}