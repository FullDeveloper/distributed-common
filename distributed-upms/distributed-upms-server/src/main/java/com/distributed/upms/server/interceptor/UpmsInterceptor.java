package com.distributed.upms.server.interceptor;

import com.distributed.common.util.PropertiesFileUtil;
import com.distributed.upms.dao.model.UpmsUser;
import com.distributed.upms.rpc.api.UpmsApiService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: 周润斌
 * @Date: create in 上午 15:26 2018/1/3 0003
 * @Description:
 */
public class UpmsInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsInterceptor.class);
    private static final String DISTRIBUTED_OSS_ALIYUN_OSS_POLICY = PropertiesFileUtil.getInstance("distributed-oss-client").get("distributed.oss.aliyun.oss.policy");

    @Autowired
    UpmsApiService upmsApiService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        request.setAttribute("ZHENG_OSS_ALIYUN_OSS_POLICY", DISTRIBUTED_OSS_ALIYUN_OSS_POLICY);
        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            return true;
        }
        // 登录信息
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        request.setAttribute("upmsUser", upmsUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
