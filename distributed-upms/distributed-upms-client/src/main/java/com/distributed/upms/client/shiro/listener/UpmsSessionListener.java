package com.distributed.upms.client.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: 周润斌
 * @Date: create in 上午 10:28 2018/1/4 0004
 * @Description:
 */
public class UpmsSessionListener implements SessionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsSessionListener.class);

    @Override
    public void onStart(Session session) {
        LOGGER.debug("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        LOGGER.debug("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        LOGGER.debug("会话过期：" + session.getId());
    }

}
