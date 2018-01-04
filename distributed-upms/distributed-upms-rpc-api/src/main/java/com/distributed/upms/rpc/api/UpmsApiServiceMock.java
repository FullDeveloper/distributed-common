package com.distributed.upms.rpc.api;

import com.distributed.upms.dao.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: 周润斌
 * @Date: create in 上午 11:22 2018/1/4 0004
 * @Description:
 */
public class UpmsApiServiceMock implements UpmsApiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsApiServiceMock.class);

    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsPermissionByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsPermissionByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsRoleByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsRoleByUpmsUserIdByCache");
        return null;
    }

    @Override
    public List<UpmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(Integer upmsRoleId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsRolePermisstionByUpmsRoleId");
        return null;
    }

    @Override
    public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsUserPermissionByUpmsUserId");
        return null;
    }

    @Override
    public List<UpmsSystem> selectUpmsSystemByExample(UpmsSystemExample upmsSystemExample) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsSystemByExample");
        return null;
    }

    @Override
    public List<UpmsOrganization> selectUpmsOrganizationByExample(UpmsOrganizationExample upmsOrganizationExample) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsOrganizationByExample");
        return null;
    }

    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        LOGGER.info("UpmsApiServiceMock => selectUpmsUserByUsername");
        return null;
    }

    @Override
    public int insertUpmsLogSelective(UpmsLog record) {
        LOGGER.info("UpmsApiServiceMock => insertSelective");
        return 0;
    }
}
