package com.distributed.cms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.cms.dao.mapper.CmsMenuMapper;
import com.distributed.cms.dao.model.CmsMenu;
import com.distributed.cms.dao.model.CmsMenuExample;
import com.distributed.cms.rpc.api.CmsMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsMenuServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/5
* @Description:
*/
@Service
@Transactional
@BaseService
public class CmsMenuServiceImpl extends BaseServiceImpl<CmsMenuMapper, CmsMenu, CmsMenuExample> implements CmsMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsMenuServiceImpl.class);

    @Autowired
    CmsMenuMapper cmsMenuMapper;

}