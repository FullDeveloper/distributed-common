package com.distributed.upms.rpc.service.impl;

import com.distributed.common.annotation.BaseService;
import com.distributed.common.base.BaseServiceImpl;
import com.distributed.upms.dao.mapper.UpmsUserOrganizationMapper;
import com.distributed.upms.dao.model.UpmsUserOrganization;
import com.distributed.upms.dao.model.UpmsUserOrganizationExample;
import com.distributed.upms.rpc.api.UpmsUserOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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

    @Override
    public int organization(String[] organizationIds, int id) {
        int result = 0;
        // 删除旧记录
        UpmsUserOrganizationExample upmsUserOrganizationExample = new UpmsUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        upmsUserOrganizationMapper.deleteByExample(upmsUserOrganizationExample);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(NumberUtils.toInt(organizationId));
                result = upmsUserOrganizationMapper.insertSelective(upmsUserOrganization);
            }
        }
        return result;
    }

}