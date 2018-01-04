package com.distributed.upms.client.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 周润斌
 * @Date: create in 上午 17:35 2018/1/2 0002
 * @Description:
 */
public class UpmsSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        UpmsSession session = new UpmsSession();
        if (null != sessionContext && sessionContext instanceof WebSessionContext) {
            WebSessionContext webSessionContext = (WebSessionContext) sessionContext;
            HttpServletRequest request = (HttpServletRequest) webSessionContext.getServletRequest();
            if (null != request) {
                session.setHost(request.getRemoteAddr());
                session.setUserAgent(request.getHeader("User-Agent"));
            }
        }
        return session;
    }
}
