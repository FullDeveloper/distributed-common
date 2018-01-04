package com.distributed.upms.rpc.api;

import com.distributed.common.base.BaseServiceMock;
import com.distributed.upms.dao.mapper.UpmsLogMapper;
import com.distributed.upms.dao.model.UpmsLog;
import com.distributed.upms.dao.model.UpmsLogExample;

/**
* 降低实现UpmsLogService接口
* @Author: 周润斌
* @Date: 2018/1/4
* @Description:
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
