package com.distributed.cms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.cms.dao.mapper.CmsCategoryMapper;
import com.distributed.cms.dao.model.CmsCategory;
import com.distributed.cms.dao.model.CmsCategoryExample;
import com.distributed.cms.rpc.api.CmsCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsCategoryServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/5
* @Description:
*/
@Service
@Transactional
@BaseService
public class CmsCategoryServiceImpl extends BaseServiceImpl<CmsCategoryMapper, CmsCategory, CmsCategoryExample> implements CmsCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsCategoryServiceImpl.class);

    @Autowired
    CmsCategoryMapper cmsCategoryMapper;

}