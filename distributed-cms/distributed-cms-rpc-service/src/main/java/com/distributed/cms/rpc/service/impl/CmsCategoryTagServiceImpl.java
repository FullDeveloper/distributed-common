package com.distributed.cms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.cms.dao.mapper.CmsCategoryTagMapper;
import com.distributed.cms.dao.model.CmsCategoryTag;
import com.distributed.cms.dao.model.CmsCategoryTagExample;
import com.distributed.cms.rpc.api.CmsCategoryTagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsCategoryTagServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/5
* @Description:
*/
@Service
@Transactional
@BaseService
public class CmsCategoryTagServiceImpl extends BaseServiceImpl<CmsCategoryTagMapper, CmsCategoryTag, CmsCategoryTagExample> implements CmsCategoryTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsCategoryTagServiceImpl.class);

    @Autowired
    CmsCategoryTagMapper cmsCategoryTagMapper;

}