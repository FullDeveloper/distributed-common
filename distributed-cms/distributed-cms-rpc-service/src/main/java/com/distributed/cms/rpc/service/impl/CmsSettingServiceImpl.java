package com.distributed.cms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.cms.dao.mapper.CmsSettingMapper;
import com.distributed.cms.dao.model.CmsSetting;
import com.distributed.cms.dao.model.CmsSettingExample;
import com.distributed.cms.rpc.api.CmsSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsSettingServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/5
* @Description:
*/
@Service
@Transactional
@BaseService
public class CmsSettingServiceImpl extends BaseServiceImpl<CmsSettingMapper, CmsSetting, CmsSettingExample> implements CmsSettingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsSettingServiceImpl.class);

    @Autowired
    CmsSettingMapper cmsSettingMapper;

}