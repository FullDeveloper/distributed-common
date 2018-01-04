package com.distributed.upms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.distributed.upms.dao.model.UpmsUserOrganization;
import com.distributed.upms.dao.model.UpmsUserOrganizationExample;
import com.distributed.upms.rpc.api.UpmsUserOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsUserOrganizationServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
@Service
@Transactional
@BaseService
public class UpmsUserOrganizationServiceImpl extends BaseServiceImpl<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsUserOrganizationServiceImpl.class);

    @Autowired
    UpmsUserOrganizationMapper upmsUserOrganizationMapper;

}