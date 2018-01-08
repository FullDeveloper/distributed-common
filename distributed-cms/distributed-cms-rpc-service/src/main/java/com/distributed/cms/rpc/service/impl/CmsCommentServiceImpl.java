package com.distributed.cms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.cms.dao.mapper.CmsCommentMapper;
import com.distributed.cms.dao.model.CmsComment;
import com.distributed.cms.dao.model.CmsCommentExample;
import com.distributed.cms.rpc.api.CmsCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* CmsCommentServiceImpl接口
* @Author: 周润斌
* @Date: 2018/1/5
* @Description:
*/
@Service
@Transactional
@BaseService
public class CmsCommentServiceImpl extends BaseServiceImpl<CmsCommentMapper, CmsComment, CmsCommentExample> implements CmsCommentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsCommentServiceImpl.class);

    @Autowired
    CmsCommentMapper cmsCommentMapper;

}