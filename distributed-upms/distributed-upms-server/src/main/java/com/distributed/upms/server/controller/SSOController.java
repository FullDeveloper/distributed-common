package com.distributed.upms.server.controller;

import com.distributed.common.base.BaseController;
import com.distributed.common.util.PropertiesFileUtil;
import com.distributed.common.util.RedisUtil;
import com.distributed.upms.client.shiro.session.UpmsSession;
import com.distributed.upms.client.shiro.session.UpmsSessionDao;
import com.distributed.upms.common.constant.UpmsResult;
import com.distributed.upms.common.constant.UpmsResultConstant;
import com.distributed.upms.dao.model.UpmsSystem;
import com.distributed.upms.rpc.api.UpmsSystemService;
import com.distributed.upms.rpc.api.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: 周润斌
 * @Date: create in 上午 15:28 2018/1/3 0003
 * @Description:
 */

@Controller
@RequestMapping(value = "/sso")
@Api(value = "单点登录管理",description = "单点登录管理")
public class SSOController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(SSOController.class);

    //全局会话KEY
    private final static String DISTRIBUTED_UPMS_SERVER_SESSION_ID = "distributed-upms-server-session-id";
    //全局会话列表
    private final static String DISTRIBUTED_UPMS_SERVER_SESSION_IDS = "distributed-upms-server-session-ids";
    //code key
    private final static String DISTRIBUTED_UPMS_SERVER_CODE = "distributed-upms-server-code";

    @Autowired
    UpmsSessionDao upmsSessionDao;

    @Autowired
    UpmsSystemService upmsSystemService;

    @Autowired
    UpmsUserService upmsUserService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest  request){

        return "/sso/login.jsp";
    }


    @ApiOperation(value = "登陆")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        if (StringUtils.isBlank(username)) {
            return new UpmsResult(UpmsResultConstant.EMPTY_USERNAME, "帐号不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return new UpmsResult(UpmsResultConstant.EMPTY_PASSWORD, "密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        // 判断是否已登录，如果已登录，则回跳，防止重复登录
        String hasCode = RedisUtil.get(DISTRIBUTED_UPMS_SERVER_SESSION_ID + "_" + sessionId);
        // code校验值
        if (StringUtils.isBlank(hasCode)) {
            // 使用shiro认证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try {
                if (BooleanUtils.toBoolean(rememberMe)) {
                    usernamePasswordToken.setRememberMe(true);
                } else {
                    usernamePasswordToken.setRememberMe(false);
                }
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                return new UpmsResult(UpmsResultConstant.INVALID_USERNAME, "帐号不存在！");
            } catch (IncorrectCredentialsException e) {
                return new UpmsResult(UpmsResultConstant.INVALID_PASSWORD, "密码错误！");
            } catch (LockedAccountException e) {
                return new UpmsResult(UpmsResultConstant.INVALID_ACCOUNT, "帐号已锁定！");
            }
            // 更新session状态
            upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);

            // 默认验证帐号密码正确，创建code
            String code = UUID.randomUUID().toString();
            // 全局会话的code
            RedisUtil.set(DISTRIBUTED_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
            // code校验值
            RedisUtil.set(DISTRIBUTED_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);
        }
        // 回跳登录前地址
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(backurl)) {
            UpmsSystem upmsSystem = upmsSystemService.selectUpmsSystemByName(PropertiesFileUtil.getInstance().get("app.name"));
            backurl = null == upmsSystem ? "/" : upmsSystem.getBasepath();
            return new UpmsResult(UpmsResultConstant.SUCCESS, backurl);
        } else {
            return new UpmsResult(UpmsResultConstant.SUCCESS, backurl);
        }
    }

}
